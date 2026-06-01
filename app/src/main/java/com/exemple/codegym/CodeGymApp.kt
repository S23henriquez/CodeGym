package com.exemple.codegym

import android.app.Application
import android.content.Context
import androidx.appcompat.app.AppCompatDelegate
import com.exemple.codegym.utils.LocaleHelper
import com.google.firebase.appcheck.BuildConfig
import com.google.firebase.appcheck.FirebaseAppCheck
import com.google.firebase.appcheck.debug.DebugAppCheckProviderFactory
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.ads.RequestConfiguration


// Clase Application: se ejecuta al iniciar la app, antes que cualquier Activity.
// Inicializa configuraciones globales: idioma, tema, publicidades y Firebase AppCheck.
class CodeGymApp : Application() {

    // Envuelve el contexto base con el idioma guardado para aplicarlo en toda la app.
    // Se llama antes de onCreate() para asegurar que el LocaleHelper esté activo desde el principio.
    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(LocaleHelper.wrap(base)) // Envuelve el contexto con el idioma guardado
    }

    // Inicializa configuraciones de la aplicación al arrancar:
    // - Aplica el idioma guardado
    // - Configura publicidades
    // - Establece Firebase AppCheck
    // - Aplica el tema (claro/oscuro)
    override fun onCreate() {
        super.onCreate()
        LocaleHelper.applySavedLanguage(this) // Aplica el idioma guardado en SharedPreferences
        MobileAds.initialize(this) // Inicializa Google Mobile Ads SDK

        // Configura dispositivos de prueba para Google AdMob

        // Identificara el emulador como dispositivo de prueba para evitar mostrar anuncios reales durante el desarrollo.
        val testDeviceIds = listOf("EMULATOR")
        val configuration = RequestConfiguration.Builder()
            // Establecera IDs de dispositivos de prueba para que AdMob sepa que no debe mostrar anuncios reales en esos dispositivos (útil durante el desarrollo)
            .setTestDeviceIds(testDeviceIds)
            .build()
        MobileAds.setRequestConfiguration(configuration) // Aplica la configuración

        // App Check en modo debug: permite usar versiones de desarrollo sin restricciones de Firebase
        // Solo se activa en compilaciones DEBUG (emulador/desarrollo)
        if (BuildConfig.DEBUG) { // Comprueba si es compilación de debug
            FirebaseAppCheck.getInstance().installAppCheckProviderFactory(
                DebugAppCheckProviderFactory.getInstance()
            )
        }

        // Aplica el tema guardado (claro u oscuro) a toda la aplicación
        // Accede a preferencias guardadas
        val savedTheme = getSharedPreferences("theme_prefs", MODE_PRIVATE)
            // Obtiene el tema; por defecto "DARK"
            .getString("theme", "DARK")
        when (savedTheme) { // Según el tema guardado
            "LIGHT" -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO) // Tema claro
            else -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES) // Tema oscuro (por defecto)
        }
    }


}