package com.exemple.codegym

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.content.ContextCompat
import androidx.lifecycle.lifecycleScope
import com.exemple.codegym.data.UserRepository
import com.exemple.codegym.databinding.ActivitySettingsBinding
import com.exemple.codegym.utils.LocaleHelper
import com.google.android.material.card.MaterialCardView
import kotlinx.coroutines.launch

class SettingsActivity : BaseActivity() {

    private lateinit var binding: ActivitySettingsBinding

    // Obtiene el perfil desde Firebase para mostrar nombre, email y tema guardado; permite cambiar tema e idioma, y cerrar sesión.
    private val repo = UserRepository()
    private var currentTheme = "DARK"

    // Inicializa la pantalla: carga datos, configura botones y aplica tema guardado.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySettingsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Configuración de la activity
        loadUserInfo()
        setupBack()
        setupThemeButtons()
        setupLanguageButtons()
        setupLogout()

        val savedTheme = getSharedPreferences("theme_prefs", MODE_PRIVATE)
            .getString("theme", "DARK")
        when (savedTheme) {
            "DARK" -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            "LIGHT" -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            "COLORBLIND" -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        }
    }

    // Carga la información del usuario desde Firebase: nombre, email y tema.
    private fun loadUserInfo() {
        val uid = repo.currentUid()
        if (uid == null) {
            goToLogin()
            return
        }

        // Ejecuta en corrutina para no bloquear la UI mientras se obtiene el perfil
        lifecycleScope.launch {
            // Obtiene el perfil desde Firebase
            val result = repo.getProfile(uid)
            result.fold(
                onSuccess = { profile -> // Si se obtuvo correctamente
                    binding.tvSettingsName.text  = profile.name.ifEmpty { "Usuario" }
                    binding.tvSettingsEmail.text = profile.email
                    currentTheme = profile.theme
                    refreshThemeSelection()
                },
                onFailure = { e -> // Si falla la carga
                    if (e !is kotlinx.coroutines.CancellationException) {
                        // Cargar tema local si Firebase falla
                        val savedTheme = getSharedPreferences("theme_prefs", MODE_PRIVATE)
                            .getString("theme", "DARK") ?: "DARK"
                        currentTheme = savedTheme
                        refreshThemeSelection()
                    }
                }
            )
        }
    }

    // Configura los listeners de los botones de tema (Oscuro y Claro).
    private fun setupThemeButtons() {
        binding.cardThemeDark.setOnClickListener        { selectTheme("DARK") }
        binding.cardThemeLight.setOnClickListener       { selectTheme("LIGHT") }
    }

    // Selecciona un tema: lo guarda localmente, aplica el estilo y lo sincroniza con Firebase.
    private fun selectTheme(theme: String) {
        // Primero guardar localmente
        getSharedPreferences("theme_prefs", MODE_PRIVATE)
            .edit().putString("theme", theme).apply()

        // Aplicar modo visual
        when (theme) { // Según el tema
            "DARK" -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            "LIGHT" -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        }

        // Guardar en Firebase en segundo plano sin bloquear
        val uid = repo.currentUid()
        if (uid != null) { // Si hay usuario
            lifecycleScope.launch {
                // Intenta guardar sin fallar la experiencia del usuario si hay error de red
                try { repo.saveTheme(uid, theme) } catch (e: Exception) { }
            }
        }

        currentTheme = theme
        recreate()
    }

    // Actualiza la visualización de los botones de tema según cual está seleccionado.
    private fun refreshThemeSelection() {
        listOf(
            Triple(binding.cardThemeDark, binding.checkThemeDark, "DARK"),
            Triple(binding.cardThemeLight, binding.checkThemeLight, "LIGHT")
        ).forEach { (card, check, theme) ->
            if (theme == currentTheme) { // Si es el tema actual
                card.strokeColor = ContextCompat.getColor(this, R.color.red_primary)
                card.strokeWidth = (3 * resources.displayMetrics.density).toInt()
                check.text = "●"
                check.setTextColor(ContextCompat.getColor(this, R.color.red_primary))
            } else { // Si no es el tema actual
                card.strokeColor = ContextCompat.getColor(this, R.color.border)
                card.strokeWidth = (1 * resources.displayMetrics.density).toInt()
                check.text = "○"
                check.setTextColor(ContextCompat.getColor(this, R.color.text_dim))
            }
        }
    }

    // Crea dinámicamente las tarjetas de cada idioma soportado para seleccionar.
    private fun setupLanguageButtons() {
        val container = binding.languagesContainer
        val currentLang = LocaleHelper.getSavedLanguage(this)
        val density = resources.displayMetrics.density

        LocaleHelper.SUPPORTED_LANGUAGES.forEach { lang ->
            val card = createLanguageCard(lang, isSelected = lang.code == currentLang)
            card.setOnClickListener { selectLanguage(lang.code) }
            container.addView(card)
        }
    }

    // Crea una tarjeta de idioma con diseño, icono y estado de selección.
    private fun createLanguageCard(
        lang: LocaleHelper.Language,
        isSelected: Boolean
    ): MaterialCardView {
        val density = resources.displayMetrics.density

        // Card principal
        val card = MaterialCardView(this).apply {
            layoutParams = LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            ).apply {
                bottomMargin = (8 * density).toInt()
            }
            radius = 12 * density
            cardElevation = 0f
            setCardBackgroundColor(ContextCompat.getColor(context, R.color.surface2))
            strokeColor = if (isSelected)
                ContextCompat.getColor(context, R.color.red_primary)
            else
                ContextCompat.getColor(context, R.color.border)
            strokeWidth = if (isSelected) (3 * density).toInt() else (1 * density).toInt()
            isClickable = true
            isFocusable = true
        }

        // Layout interno horizontal
        val ll = LinearLayout(this).apply {
            orientation = LinearLayout.HORIZONTAL
            gravity = android.view.Gravity.CENTER_VERTICAL
            setPadding((16 * density).toInt(), (16 * density).toInt(), (16 * density).toInt(), (16 * density).toInt())
        }

        // Bandera del idioma
        val tvFlag = TextView(this).apply {
            text = lang.flag // Emoji de bandera
            textSize = 24f
            layoutParams = LinearLayout.LayoutParams(
                (40 * density).toInt(),
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
        }

        // Nombre del idioma
        val tvName = TextView(this).apply {
            text = lang.name
            textSize = 16f
            setTypeface(typeface, android.graphics.Typeface.BOLD)
            setTextColor(ContextCompat.getColor(context, R.color.text_primary))
            layoutParams = LinearLayout.LayoutParams(
                0,
                ViewGroup.LayoutParams.WRAP_CONTENT,
                1f
            ).apply { marginStart = (12 * density).toInt() }
        }

        // Checkbox visual
        val tvCheck = TextView(this).apply {
            text = if (isSelected) "●" else "○"
            textSize = 20f
            setTextColor(
                if (isSelected) ContextCompat.getColor(context, R.color.red_primary)
                else ContextCompat.getColor(context, R.color.text_dim)
            )
        }

        ll.addView(tvFlag)
        ll.addView(tvName)
        ll.addView(tvCheck)
        card.addView(ll)

        return card
    }

    // Cambia el idioma de la app: guarda la selección, recrea UI e inicia MainActivity.
    private fun selectLanguage(languageCode: String) {
        LocaleHelper.setLanguage(this, languageCode) // Guarda idioma seleccionado
        recreate() // Recrea para aplicar idioma
        val intent = Intent(this, MainActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
        }
        startActivity(intent)
        finish()
    }

    // Configura el botón de logout: muestra diálogo de confirmación antes de cerrar sesión.
    private fun setupLogout() {
        binding.btnLogout.setOnClickListener { // Al pulsar logout
            AlertDialog.Builder(this)
                .setTitle(getString(R.string.logout_confirm_title))
                .setMessage(getString(R.string.logout_confirm_msg))
                .setPositiveButton(getString(R.string.logout_yes)) { _, _ ->
                    repo.logout()
                    goToLogin()
                }
                .setNegativeButton(getString(R.string.cancel), null)
                .show()
        }
    }

    // Configura el botón atrás para cerrar la actividad.
    private fun setupBack() {
        binding.btnBack.setOnClickListener { finish() }
    }

    // Redirige a LoginActivity y limpia la pila de actividades.
    private fun goToLogin() {
        val intent = Intent(this, LoginActivity::class.java)
            .apply { flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK } // Limpia todo
        startActivity(intent)
        finish()
    }

    // Cuando recreamos para cambiar idioma, refrescar contenedor de idiomas en onResume.
    override fun onResume() {
        super.onResume()
        binding.languagesContainer.removeAllViews()
        setupLanguageButtons()
    }
}

