package com.exemple.codegym

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.lifecycleScope
import com.exemple.codegym.data.UserRepository
import com.exemple.codegym.databinding.ActivityLanguageSelectBinding
import com.google.android.material.card.MaterialCardView
import kotlinx.coroutines.launch

class LanguageSelectActivity : BaseActivity() {

    private lateinit var binding: ActivityLanguageSelectBinding
    private var selectedLanguage: String? = null
    private val repo = UserRepository()

    // Mapa de cards para gestión más limpia y acceso rápido a cada tarjeta de lenguaje
    private lateinit var languageCards: Map<String, MaterialCardView>

    // Inicializa la pantalla: configura las tarjetas de lenguaje, botones y estado visual inicial.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLanguageSelectBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Crea un mapa asociando cada nombre de lenguaje con su tarjeta (card) correspondiente
        languageCards = mapOf(
            "Python" to binding.cardPython,
            "Java"   to binding.cardJava,
            "Kotlin" to binding.cardKotlin,
            "C++"    to binding.cardCpp,
            "SQL"    to binding.cardSql
        )

        setupCards()
        // Configura el botón "Continuar" con validación y navegación a la siguiente pantalla
        setupButtons()
        resetVisuals()
    }

    // Configura listeners en cada tarjeta para marcar un lenguaje como seleccionado.
    private fun setupCards() {
        languageCards.forEach { (lang, card) -> // Itera sobre cada lenguaje y su tarjeta
            card.setOnClickListener { // Al hacer clic en una tarjeta
                selectedLanguage = lang // Marca ese lenguaje como seleccionado
                refreshSelection() // Actualiza el aspecto visual
            }
        }
    }

    // Resetea visualmente todas las cards al estado "no seleccionado".
    // Se llama al inicio para mostrar el estado predeterminado sin estilos especiales.
    private fun resetVisuals() {
        languageCards.values.forEach { card -> // Itera sobre todas las tarjetas
            card.setCardBackgroundColor(ContextCompat.getColor(this, R.color.surface2)) // Fondo gris neutro
            card.strokeColor = ContextCompat.getColor(this, R.color.border) // Borde gris claro
            card.strokeWidth = dp(1) // Grosor mínimo del borde
            card.cardElevation = 0f // Elevación nula para efecto plano
        }
    }

    // Refresca el aspecto visual: la card seleccionada destaca con color y borde prominente,
    // las demás vuelven al estado normal. Habilita el botón "Continuar" cuando hay selección.
    private fun refreshSelection() {
        val selected = selectedLanguage // Variable local para referencia rápida

        languageCards.forEach { (lang, card) ->
            // Si es la tarjeta seleccionada
            if (lang == selected) {

                // CARD SELECCIONADA: fondo rojo con borde grueso y elevación para destacar
                card.setCardBackgroundColor(ContextCompat.getColor(this, R.color.red_card_bg))
                card.strokeColor = ContextCompat.getColor(this, R.color.red_primary)
                card.strokeWidth = dp(3)
                card.cardElevation = dp(8).toFloat()
            } else {

                // OTRAS CARDS: vuelven al estado por defecto sin resalte
                card.setCardBackgroundColor(ContextCompat.getColor(this, R.color.surface2))
                card.strokeColor = ContextCompat.getColor(this, R.color.border)
                card.strokeWidth = dp(1)
                card.cardElevation = 0f
            }
        }

        // Habilitar botón Continuar visualmente: opaco al 100% y con texto personalizado
        // Según el lenguaje seleccionado
        binding.btnContinue.isEnabled = true
        binding.btnContinue.alpha = 1f
        binding.btnContinue.text = "Aprender $selected →"
    }

    // Configura el botón "Continuar" con validación, guardado de datos y navegación.
    private fun setupButtons() {

        // Inicializa el botón atenuado para indicar que debe seleccionar primero un lenguaje
        binding.btnContinue.alpha = 0.5f
        binding.btnContinue.text = "Selecciona un lenguaje"


        binding.btnContinue.setOnClickListener {
            val lang = selectedLanguage
            if (lang == null) {
                Toast.makeText(this, "Elige un lenguaje para continuar", Toast.LENGTH_SHORT).show()
                // Cancela la operación
                return@setOnClickListener
            }

            val uid = repo.currentUid() // Obtiene el ID del usuario autenticado
            // Validamos el usuario que debe estar autenticado
            if (uid == null) {
                Toast.makeText(this, "Sesión expirada, vuelve a iniciar sesión", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, LoginActivity::class.java))
                finishAffinity()
                return@setOnClickListener
            }


            // Animación: inhabilita botón y cambia texto para feedback visual de carga
            binding.btnContinue.isEnabled = false
            binding.btnContinue.text = "Cargando..."


            // Ejecuta en corrutina vinculada al ciclo de vida
            lifecycleScope.launch {
                // Guarda el lenguaje seleccionado en Firebase para el perfil del usuario
                repo.saveSelectedLanguage(uid, lang)
                val intent = Intent(this@LanguageSelectActivity, LevelTestActivity::class.java).apply {
                    putExtra(LevelTestActivity.EXTRA_LANGUAGE, lang)
                }
                startActivity(intent)
                finish()
            }
        }
    }

    // Convierte píxeles independientes de densidad (dp) a píxeles físicos (px).
    // Esto asegura que los valores se vean igual en pantallas de diferentes densidades.
    private fun dp(value: Int): Int = (value * resources.displayMetrics.density).toInt()
}