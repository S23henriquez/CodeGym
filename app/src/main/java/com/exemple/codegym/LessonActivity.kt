package com.exemple.codegym

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.lifecycle.lifecycleScope
import com.exemple.codegym.data.LessonRepository
import com.exemple.codegym.data.UserRepository
import com.exemple.codegym.databinding.ActivityLessonBinding
import com.exemple.codegym.models.Lesson
import com.exemple.codegym.models.LessonExercise
import com.exemple.codegym.utils.LocaleHelper
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.FullScreenContentCallback
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.AdError
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback
import com.google.android.gms.ads.rewarded.RewardedAd
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback
import kotlinx.coroutines.launch

class LessonActivity : BaseActivity() {

    companion object {

        const val EXTRA_LANGUAGE  = "language"
        const val EXTRA_LESSON_ID = "lesson_id"

        //Cantidad de Vidas se usa en la app
        private const val MAX_HEARTS = 3
    }

    private lateinit var binding: ActivityLessonBinding
    private val repo = UserRepository() // Repositorio para guardar progreso

    private lateinit var lesson: Lesson // Lección actual
    private var heartsLeft = MAX_HEARTS // Vidas restantes
    private var alreadyAnswered = false // Flag para evitar seleccionar opción dos veces
    private var activeExercises = mutableListOf<LessonExercise>() // Lista de ejercicios activos (se añaden más si falla)
    private var currentExerciseIndex = -1 // Índice del ejercicio actual
    private var totalExercisesThisRun = 0 // Total de ejercicios en esta ronda
    private var interstitialAd: InterstitialAd? = null // Anuncio intersticial (entre teoría y ejercicios)
    private var rewardedAd: RewardedAd? = null // Anuncio con recompensa (vidas adicionales)

    // Inicializa la actividad: carga la lección, configura anuncios y muestra teoría.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLessonBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtiene parámetros de la intención y carga la lección
        val language = intent.getStringExtra(EXTRA_LANGUAGE) ?: "Python"
        val lessonId = intent.getStringExtra(EXTRA_LESSON_ID) ?: ""
        val appLang = LocaleHelper.getSavedLanguage(this)

        val foundLesson = LessonRepository.getLessonById(language, lessonId, appLang)
        if (foundLesson == null) {
            Toast.makeText(this, getString(R.string.lesson_not_found), Toast.LENGTH_SHORT).show()
            finish()
            return
        }

        // Guarda la lección actual y prepara la lección
        lesson = foundLesson
        initializeLessonRun()
        setupBackButton()
        MobileAds.initialize(this)
        loadInterstitialAd()
        loadRewardedAd()
    }

    // Carga un anuncio intersticial que se mostrará antes de los ejercicios.
    // Se demuestra la teoría después de que se cierre el anuncio.
    private fun loadInterstitialAd() {

        //Para pausar los anuncios si Jaime llega a ver la app
        //return

        // Construye solicitud de anuncio
        val adRequest = AdRequest.Builder().build()
        InterstitialAd.load(
            this,

            // ID del anuncio de prueba
            "ca-app-pub-3940256099942544/1033173712",
            adRequest,

            object : InterstitialAdLoadCallback() {
                override fun onAdLoaded(ad: InterstitialAd) {
                    // Si se cargó exitosamente
                    interstitialAd = ad
                    // Muestra el anuncio tan pronto se carga
                    showInterstitialAd()
                }

                override fun onAdFailedToLoad(error: LoadAdError) {
                    interstitialAd = null
                    // Si falla, continúa directamente a la teoría
                    showTheory()
                }
            }
        )
    }

    // Carga un anuncio con recompensa que otorga vidas adicionales si el usuario lo ve.
    private fun loadRewardedAd() {
        // Construye solicitud de anuncio
        val adRequest = AdRequest.Builder().build()
        com.google.android.gms.ads.rewarded.RewardedAd.load(
            this,
            "ca-app-pub-3940256099942544/5224354917",
            adRequest,
            object : RewardedAdLoadCallback() {

                override fun onAdLoaded(ad: RewardedAd) {
                    rewardedAd = ad
                }

                override fun onAdFailedToLoad(error: LoadAdError) {
                    rewardedAd = null
                }
            }
        )
    }

    // Muestra el anuncio intersticial; si falla, continúa directo a la teoría.
    private fun showInterstitialAd() {
        val ad = interstitialAd
        if (ad == null) {
            showTheory()
            return
        }

        ad.fullScreenContentCallback = object : FullScreenContentCallback() {
            override fun onAdDismissedFullScreenContent() {
                interstitialAd = null
                showTheory()
            }

            override fun onAdFailedToShowFullScreenContent(adError: com.google.android.gms.ads.AdError) {
                interstitialAd = null
                showTheory()
            }
        }


        // Muestra el anuncio
        ad.show(this)
    }

   //------------------LECIONES----------------


    // Inicializa una nueva ronda de lección: reinicia vidas, mezcla ejercicios.
    private fun initializeLessonRun() {
        heartsLeft = MAX_HEARTS // Reinicia vidas
        activeExercises = lesson.exercises.shuffled().take(10).toMutableList() // Toma 10 ejercicios aleatorios
        totalExercisesThisRun = activeExercises.size // Registra el total
        currentExerciseIndex = -1 // Inicia sin ejercicio

        binding.layoutGameOver.root.visibility = View.GONE // Oculta pantalla de fin
        updateHearts() // Actualiza visualización de vidas
    }

    // Muestra la teoría de la lección: texto, ejemplo de código y botón para empezar ejercicios.
    private fun showTheory() {
        currentExerciseIndex = -1 // Sin ejercicio aún
        updateHearts()

        binding.tvQuestionType.text  = getString(R.string.theory) // Etiqueta "Teoría"
        binding.tvQuestionTitle.text = lesson.title // Título de la lección
        binding.tvQuestionSub.text   = "${lesson.language} · Unidad ${lesson.unitNumber}" // Metadatos
        binding.tvCodeSnippet.text = """ // Muestra teoría con ejemplo
            ${lesson.theoryText}
            
            ─── Ejemplo ───
            ${lesson.codeExample}
         """.trimIndent()


        // Oculta todas las opciones
        listOf(binding.optionA, binding.optionB, binding.optionC, binding.optionD)
            .forEach { it.visibility = View.GONE }

        // Oculta banner de resultado
        binding.resultBanner.visibility = View.GONE

        // Muestra botón "Continuar" para empezar ejercicios
        binding.btnContinue.visibility = View.VISIBLE
        binding.btnContinue.text = getString(R.string.start_exercises)
        // Al pulsar, muestra primer ejercicio
        binding.btnContinue.setOnClickListener { showNextExercise() }
    }

    // Avanza al siguiente ejercicio; si no hay más, finaliza la lección como exitosa.
    private fun showNextExercise() {
        currentExerciseIndex++

        if (currentExerciseIndex >= activeExercises.size) {
            finishLesson(success = true)
            return
        }

        // Obtiene el ejercicio actual
        val ex = activeExercises[currentExerciseIndex]
        // Permite responder
        alreadyAnswered = false

        binding.tvQuestionType.text = if (ex.type == com.exemple.codegym.models.ExerciseType.FILL_BLANK) // Tipo de ejercicio
            getString(R.string.complete_code)
        else
            getString(R.string.question)
        binding.tvQuestionTitle.text = ex.question // Pregunta
        binding.tvQuestionSub.text = "Ejercicio ${currentExerciseIndex + 1} de $totalExercisesThisRun" // Progreso

        if (ex.codeSnippet.isNotEmpty()) { // Si hay código en el ejercicio
            binding.tvCodeSnippet.visibility = View.VISIBLE
            binding.tvCodeSnippet.text = ex.codeSnippet // Muestra código
        } else {
            binding.tvCodeSnippet.visibility = View.GONE // Oculta si no hay
         }

        setupOptions(ex) // Configura las opciones de respuesta
        binding.resultBanner.visibility = View.GONE // Oculta resultado anterior
        binding.btnContinue.visibility = View.GONE // Oculta botón hasta responder
    }

    // Configura las tarjetas de opciones (A, B, C, D) y sus listeners.
    private fun setupOptions(ex: LessonExercise) {
        val cards = listOf(binding.optionA, binding.optionB, binding.optionC, binding.optionD) // Tarjetas
        val letters = listOf(binding.tvOptionLetterA, binding.tvOptionLetterB, binding.tvOptionLetterC, binding.tvOptionLetterD) // Letras (A, B, C, D)
        val texts = listOf(binding.tvOptionTextA, binding.tvOptionTextB, binding.tvOptionTextC, binding.tvOptionTextD) // Textos de opciones
        val labels = listOf("A", "B", "C", "D")

        cards.forEachIndexed { i, card ->
            // Para cada tarjeta de opción mostrar tarjeta letra y asignara el texto
            if (i < ex.options.size) {
                card.visibility = View.VISIBLE
                letters[i].text = labels[i]
                texts[i].text = ex.options[i]
                card.setCardBackgroundColor(ContextCompat.getColor(this, R.color.surface2))
                card.strokeColor = ContextCompat.getColor(this, R.color.border)
                card.strokeWidth = 2
                card.setOnClickListener { onOptionSelected(i, ex) }
            } else {
                card.visibility = View.GONE // Oculta si no hay opción
            }
        }
    }

    // Procesa la selección de una opción: verifica si es correcta y actualiza el estado.
    // Evita responder dos veces y maneja vidas, ejercicios adicionales y resaltado de respuestas.
    private fun onOptionSelected(index: Int, ex: LessonExercise) {
        if (alreadyAnswered) return
        alreadyAnswered = true

        // Comprueba si es correcta la opción seleccionada
        val isCorrect = index == ex.correctIndex

        // Si es incorrecta, pierde una vida y añade un ejercicio extra para compensar el fallo, si hay más disponibles.
        if (!isCorrect) {
            heartsLeft--
            updateHearts()

            // Añade ejercicio extra para compensar el fallo, si hay más ejercicios disponibles
            val newExtraExercise = lesson.exercises.shuffled().firstOrNull { it != ex } ?: ex
            activeExercises.add(newExtraExercise)
            totalExercisesThisRun++

            // Resalta rojo la respuesta incorrecta y verde la correcta
            highlightOption(index, correct = false)
            highlightOption(ex.correctIndex, correct = true)
        } else {
            highlightOption(index, correct = true) // Resalta verde
        }

        showResult(isCorrect, ex.explanation) // Muestra resultado y explicación

        if (heartsLeft <= 0) { // Si se acaban las vidas
            showGameOver()
        }
    }

    // Muestra la pantalla de fin del juego con opciones de reintentar, salir o ver anuncio.
    private fun showGameOver() {
        binding.resultBanner.visibility = View.GONE
        binding.btnContinue.visibility = View.GONE
        binding.layoutGameOver.root.visibility = View.VISIBLE // Muestra pantalla de fin

        binding.layoutGameOver.btnRetry.setOnClickListener { // Botón reintentar
            initializeLessonRun()
            showTheory()
        }

        binding.layoutGameOver.btnQuit.setOnClickListener { // Botón salir
            finish()
        }

        // Botón anuncio con recompensa: otorga 1 vida si se ve el anuncio
        val btnWatchAd = binding.layoutGameOver.btnWatchAd
        if (rewardedAd != null) { // Si hay anuncio disponible
            btnWatchAd.visibility = View.VISIBLE
            btnWatchAd.text = "Ver anuncio por 1 vida ❤️"
            btnWatchAd.setOnClickListener { showRewardedAd() }
        } else {
            btnWatchAd.visibility = View.GONE
        }
    }

    // Muestra el anuncio con recompensa; si lo ve, otorga 1 vida y continúa.
    private fun showRewardedAd() {
        val ad = rewardedAd // Obtiene el anuncio
        if (ad == null) { // Si no está disponible
            Toast.makeText(this, getString(R.string.ad_not_available), Toast.LENGTH_SHORT).show()
            return
        }

        ad.fullScreenContentCallback = object : FullScreenContentCallback() { // Callbacks del anuncio
            override fun onAdDismissedFullScreenContent() { // Cuando se cierra
                rewardedAd = null
                // Si sigue sin vidas después de cerrar, vuelve a mostrar pantalla de fin
                if (heartsLeft <= 0) showGameOver()
            }

            override fun onAdFailedToShowFullScreenContent(error: AdError) { // Si falla
                rewardedAd = null
                if (heartsLeft <= 0) showGameOver()
            }
        }

        ad.show(this) { rewardItem -> // Muestra el anuncio y procesa recompensa
            // Otorga 1 vida cuando se completa el anuncio
            heartsLeft = 1
            updateHearts()
            binding.layoutGameOver.root.visibility = View.GONE // Oculta pantalla de fin
            showNextExercise() // Continúa con el siguiente ejercicio
            loadRewardedAd() // Carga otro anuncio
        }
    }

    // Resalta una opción con color de correcto (verde) o incorrecto (rojo).
    private fun highlightOption(index: Int, correct: Boolean) {
        val cards = listOf(binding.optionA, binding.optionB, binding.optionC, binding.optionD)
        val bgRes     = if (correct) R.color.green_correct_bg else R.color.red_wrong_bg // Fondo según resultado
        val strokeRes = if (correct) R.color.green_correct    else R.color.red_wrong // Borde según resultado
        cards[index].setCardBackgroundColor(ContextCompat.getColor(this, bgRes))
        cards[index].strokeColor = ContextCompat.getColor(this, strokeRes)
        cards[index].strokeWidth = 4
    }

    // Muestra el resultado (correcto/incorrecto) con explicación y botón para continuar.
    private fun showResult(correct: Boolean, explanation: String) {
        binding.resultBanner.visibility = View.VISIBLE // Muestra banner

        if (correct) { // Si es correcta
            binding.resultBanner.setCardBackgroundColor(ContextCompat.getColor(this, R.color.green_correct_bg))
            binding.tvResultIcon.text = "✅"
            binding.tvResultText.text = getString(R.string.correct)
        } else { // Si es incorrecta
            binding.resultBanner.setCardBackgroundColor(ContextCompat.getColor(this, R.color.red_wrong_bg))
            binding.tvResultIcon.text = "❌"
            binding.tvResultText.text = getString(R.string.incorrect)
        }
        binding.tvResultExplanation.text = explanation // Muestra explicación
        binding.btnContinue.visibility = View.VISIBLE

        if (heartsLeft > 0) { // Si aún tiene vidas
            binding.btnContinue.text = // Cambia texto según si es el último ejercicio
                if (currentExerciseIndex == activeExercises.size - 1) getString(R.string.finish_lesson)
                else getString(R.string.next_exercise)
            binding.btnContinue.setOnClickListener { showNextExercise() } // Continúa al siguiente
        }
    }

    // Finaliza la lección: guarda progreso, calcula XP y muestra mensajes.
    private fun finishLesson(success: Boolean) {
        if (!success) { // Si falló (sin vidas)
            Toast.makeText(this, getString(R.string.no_hearts), Toast.LENGTH_LONG).show()
            finish()
            return
        }

        val uid = repo.currentUid() // Obtiene el ID del usuario
        if (uid == null) { // Si sesión expiró
            Toast.makeText(this, "Session expired", Toast.LENGTH_SHORT).show()
            finish()
            return
        }

        val bonus = if (heartsLeft == MAX_HEARTS) 10 else 0 // Bonus si con todas las vidas
        val totalXp = lesson.xpReward + bonus // XP total
        binding.btnContinue.isEnabled = false

        lifecycleScope.launch { // Ejecuta en corrutina
            val result = repo.completeLesson(uid, lesson.id, totalXp) // Guarda finalización
            result.fold(
                onSuccess = { completion -> // Si se guardó correctamente
                    val msg = if (bonus > 0) // Mensaje según si completó perfecto
                        getString(R.string.lesson_perfect)
                    else
                        getString(R.string.lesson_completed)
                    Toast.makeText(this@LessonActivity, msg, Toast.LENGTH_LONG).show()

                    finish()
                },
                onFailure = { e -> // Si hubo error
                    Toast.makeText(this@LessonActivity, "Error guardando: ${e.message}", Toast.LENGTH_LONG).show()
                    binding.btnContinue.isEnabled = true
                }
            )
        }
    }

    // Actualiza la visualización de vidas (corazones llenos y vacíos).
    private fun updateHearts() {
        val full  = "♥".repeat(heartsLeft) // Corazones llenos
        val empty = "♡".repeat(MAX_HEARTS - heartsLeft) // Corazones vacíos
        binding.tvHearts.text = "$full$empty"
    }

    // Configura el botón atrás para cerrar la actividad.
    private fun setupBackButton() {
        binding.btnBack.setOnClickListener { finish() }
    }

}