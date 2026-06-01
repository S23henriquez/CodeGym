package com.exemple.codegym

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.provider.MediaStore
import android.util.Base64
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import androidx.lifecycle.lifecycleScope
import com.exemple.codegym.data.UserRepository
import com.exemple.codegym.data.LessonRepository
import com.exemple.codegym.databinding.ActivityProfileBinding
import com.exemple.codegym.models.UserLevel
import com.exemple.codegym.utils.LocaleHelper
import kotlinx.coroutines.launch
import java.io.ByteArrayOutputStream

class ProfileActivity : BaseActivity() {


    private lateinit var binding: ActivityProfileBinding
    private val repo = UserRepository()

    private val PICK_IMAGE = 1001
    private val PREFS_AVATAR = "avatar_prefs"
    private val KEY_AVATAR = "avatar_base64"

    // Inicializa la actividad del perfil: infla el layout y configura la navegación inferior.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupBottomNav()
    }

    // Recarga el perfil cuando se vuelve a la pantalla para mostrar datos actualizados.
    override fun onResume() {
        super.onResume()
        loadProfile()
    }

    // Carga el perfil del usuario: nombre, nivel, racha y progreso por lenguaje.
    private fun loadProfile() {

        // Muestra "Cargando..."
        binding.tvProfileName.text   = getString(R.string.loading_profile)
        binding.tvProfileHandle.text = ""

        val uid = repo.currentUid() ?: return

        lifecycleScope.launch {

            // Obtiene el perfil desde Firebase
            val result = repo.getProfile(uid)
            result.fold(
                // Si se obtuvo correctamente
                onSuccess = { profile ->
                    // Obtiene nombre o valor por defecto
                    val firstName = profile.name.ifEmpty { getString(R.string.user_default_name) }
                    binding.tvProfileName.text = firstName

                    // Muestra la inicial
                    binding.tvAvatarInitial.text = firstName.firstOrNull()?.uppercase() ?: "U"

                    // Crea un handle (@ + nombre sin espacios)
                    val handle = "@" + firstName.lowercase().replace(" ", "")
                    binding.tvProfileHandle.text = "$handle · ${getLocalizedLevel(profile.xp)}"
                    binding.tvStreakBadge.text = "🔥 ${profile.streak}"

                    // Configura el progreso por lenguaje
                    setupLanguageProgress(profile.completedLessons)
                    setupAvatar()
                },
                onFailure = { // Si falla la carga
                    binding.tvProfileName.text = getString(R.string.user_default_name)
                    setupAvatar()
                }
            )
        }
    }

    // Configura el progreso de lecciones completadas por cada lenguaje en una lista dinámica.
    private fun setupLanguageProgress(completedLessons: List<String>) {

        // Contenedor donde añadir filas
        val container = binding.layoutLanguageProgress
        container.removeAllViews()

        // Lista de lenguajes
        val languages = listOf("Python", "Java", "Kotlin", "C++", "SQL")

        // Obtiene el idioma de la app
        val appLang = LocaleHelper.getSavedLanguage(this)

        // Para cada lenguaje, calcula el progreso y crea una fila horizontal con el nombre y el porcentaje de lecciones completadas.
        languages.forEach { language ->
            val lessons = LessonRepository.getLessons(language, appLang)
            val lessonIds = lessons.map { it.id }.toSet()
            val completed = completedLessons.count { it in lessonIds }
            val total = lessons.size
            val percentage = if (total > 0) (completed * 100) / total else 0

            // Crea una fila horizontal compacta: "Language — completed/total"
            val row = android.widget.LinearLayout(this).apply {
                orientation = android.widget.LinearLayout.HORIZONTAL
                layoutParams = android.widget.LinearLayout.LayoutParams(
                    android.widget.LinearLayout.LayoutParams.MATCH_PARENT,
                    android.widget.LinearLayout.LayoutParams.WRAP_CONTENT
                ).apply { bottomMargin = 8 }
                setPadding(0, 6, 0, 6)
            }

            // Nombre del lenguaje
            val tvLangName = TextView(this).apply {
                text = language
                textSize = 14f
                setTextColor(resources.getColor(R.color.text_primary, null))
                layoutParams = android.widget.LinearLayout.LayoutParams(0, android.widget.LinearLayout.LayoutParams.WRAP_CONTENT, 1f)
            }


            // Texto de progreso "completadas/total"
            val tvCompact = TextView(this).apply {
                text = "$completed/$total"
                textSize = 13f
                setTextColor(resources.getColor(R.color.text_dim, null))
                layoutParams = android.widget.LinearLayout.LayoutParams(android.widget.LinearLayout.LayoutParams.WRAP_CONTENT, android.widget.LinearLayout.LayoutParams.WRAP_CONTENT)
            }

            // Añade nombre y progreso a la fila, luego la fila al contenedor
            row.addView(tvLangName)
            row.addView(tvCompact)
            container.addView(row)
        }
    }

    // Configura el avatar del usuario: carga el guardado o permite seleccionar uno nuevo.
    private fun setupAvatar() {
        val prefs = getSharedPreferences(PREFS_AVATAR, MODE_PRIVATE)
        val saved = prefs.getString(KEY_AVATAR, null)
        if (saved != null) {
            val bytes = Base64.decode(saved, Base64.DEFAULT)
            val bmp = BitmapFactory.decodeByteArray(bytes, 0, bytes.size)
            binding.ivAvatar.setImageBitmap(bmp)
            binding.ivAvatar.clipToOutline = true
            binding.tvAvatarInitial.visibility = View.GONE
        }

        // Al pulsar, permite seleccionar foto de la galería para actualizar el avatar.
        // Si no hay imagen guardada, también permite seleccionar una nueva.
        binding.ivAvatar.setOnClickListener {
            val intent = Intent(Intent.ACTION_PICK).apply { type = "image/*" }
            startActivityForResult(intent, PICK_IMAGE)
        }
    }

    // Procesa la imagen seleccionada de la galería: la redimensiona y guarda en Base64.
    @Suppress("DEPRECATION")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == PICK_IMAGE && resultCode == RESULT_OK) {
            val uri = data?.data ?: return
            @Suppress("DEPRECATION")
            val bmp = MediaStore.Images.Media.getBitmap(contentResolver, uri)
            val scaled = Bitmap.createScaledBitmap(bmp, 256, 256, true)
            val stream = ByteArrayOutputStream()
            scaled.compress(Bitmap.CompressFormat.JPEG, 80, stream)
            val encoded = Base64.encodeToString(stream.toByteArray(), Base64.DEFAULT)
            getSharedPreferences(PREFS_AVATAR, MODE_PRIVATE)
                .edit().putString(KEY_AVATAR, encoded).apply()
            binding.ivAvatar.setImageBitmap(scaled)
            binding.ivAvatar.clipToOutline = true
            binding.tvAvatarInitial.visibility = View.GONE
        }
    }

    // Traduce los puntos de experiencia a nivel localizado (Principiante, Intermedio o Avanzado).
    private fun getLocalizedLevel(points: Int): String {
        return when { // Según los puntos
            points >= UserLevel.AVANZADO.minScore -> getString(R.string.level_advanced) // Si >= mínimo avanzado
            points >= UserLevel.INTERMEDIO.minScore -> getString(R.string.level_intermediate) // Si >= mínimo intermedio
            else -> getString(R.string.level_beginner) // Si no, principiante
        }
    }

    // Configura la barra de navegación inferior con acceso a Inicio, Perfil y Configuración.
    private fun setupBottomNav() {
        binding.bottomNav.selectedItemId = R.id.nav_profile // Marca Perfil como activo
        binding.bottomNav.setOnItemSelectedListener { item -> // Listener para selecciones
            when (item.itemId) {
                R.id.nav_home -> { finish(); true } // Vuelve a Inicio
                R.id.nav_profile -> true // Permanece en Perfil
                R.id.nav_settings -> { // Abre Configuración
                    startActivity(Intent(this, SettingsActivity::class.java))
                    true
                }
                else -> false
            }
        }
    }

}