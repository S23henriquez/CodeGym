package com.exemple.codegym.utils

import android.content.Context
import android.content.SharedPreferences
import android.content.ContextWrapper
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.os.LocaleListCompat
import java.util.Locale

/**
 * Gestor de idioma de la app. Permite cambiar el idioma sin reinstalar.
 *
 * Idiomas soportados:
 *  - "es" → Español (default)
 *  - "en" → Inglés
 *  - "ca" → Catalán
 *  - "fr" → Francés

 */
object LocaleHelper {

    private const val PREFS_NAME = "app_locale_prefs"
    private const val KEY_LANGUAGE = "selected_language"
    const val DEFAULT_LANGUAGE = "es"

    /** Lista de idiomas soportados con su nombre nativo */
    val SUPPORTED_LANGUAGES = listOf(
        Language("es", "Español", "🇪🇸"),
        Language("en", "English", "🇬🇧"),
        Language("ca", "Català", "🏴")
    )

    data class Language(val code: String, val name: String, val flag: String)

    fun applySavedLanguage(context: Context) {
        setApplicationLocale(getSavedLanguage(context))
    }

    fun wrap(context: Context): ContextWrapper {
        val languageCode = getSavedLanguage(context)
        val locale = Locale.forLanguageTag(languageCode)
        Locale.setDefault(locale)

        val configuration = context.resources.configuration
        configuration.setLocale(locale)
        configuration.setLayoutDirection(locale)

        return ContextWrapper(context.createConfigurationContext(configuration))
    }

    fun setLanguage(context: Context, languageCode: String) {
        prefs(context).edit().putString(KEY_LANGUAGE, languageCode).apply()
        setApplicationLocale(languageCode)
    }

    fun getSavedLanguage(context: Context): String =
        prefs(context).getString(KEY_LANGUAGE, DEFAULT_LANGUAGE) ?: DEFAULT_LANGUAGE

    private fun setApplicationLocale(languageCode: String) {
        AppCompatDelegate.setApplicationLocales(LocaleListCompat.forLanguageTags(languageCode))
    }

    private fun prefs(context: Context): SharedPreferences =
        context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
}