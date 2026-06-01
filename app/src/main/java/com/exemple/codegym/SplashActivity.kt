package com.exemple.codegym

import android.content.Intent
import android.os.Bundle
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.animation.OvershootInterpolator
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.exemple.codegym.data.UserRepository
import com.exemple.codegym.databinding.ActivitySplashBinding
import kotlinx.coroutines.launch

class SplashActivity : BaseActivity() {

    private lateinit var binding: ActivitySplashBinding // Vinculación del layout splash
    private val repo = UserRepository() // Repositorio para verificar autenticación

    // Inicializa la pantalla splash: infla el layout e inicia las animaciones.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        startAnimations()
    }

    // Orquesta las animaciones de la pantalla splash: logo, texto y barra de progreso.
    private fun startAnimations() {
        // 1. Icono rebota al aparecer
        binding.ivLogo.apply {
            alpha = 0f // Inicia invisible
            scaleX = 0.3f // Inicia pequeño
            scaleY = 0.3f
            animate()
                .alpha(1f).scaleX(1f).scaleY(1f) // Anima a visible y tamaño normal
                .setDuration(600).setStartDelay(200)
                .setInterpolator(OvershootInterpolator(1.5f)) // Interpolador de rebote
                .start()
        }

        // 2. "Code" entra desde la izquierda
        binding.tvCode.apply {
            alpha = 0f // Inicia invisible
            translationX = -80f // Desplazado a la izquierda
            animate()
                .alpha(1f).translationX(0f) // Anima a visible y posición normal
                .setDuration(500).setStartDelay(700)
                .setInterpolator(AccelerateDecelerateInterpolator()) // Interpolador suave
                .start()
        }

        // 3. "Gym" entra desde la derecha
        binding.tvGym.apply {
            alpha = 0f // Inicia invisible
            translationX = 80f // Desplazado a la derecha
            animate()
                .alpha(1f).translationX(0f) // Anima a visible y posición normal
                .setDuration(500).setStartDelay(700)
                .setInterpolator(AccelerateDecelerateInterpolator())
                .start()
        }

        // 4. Tagline sube con fade
        binding.tvTagline.apply {
            alpha = 0f // Inicia invisible
            translationY = 20f // Desplazado hacia abajo
            animate()
                .alpha(1f).translationY(0f) // Anima a visible y posición normal
                .setDuration(400).setStartDelay(1100)
                .setInterpolator(AccelerateDecelerateInterpolator())
                .start()
        }

        // 5. Barra de carga aparece
        binding.progressSplash.apply {
            alpha = 0f // Inicia invisible
            animate()
                .alpha(1f).setDuration(300).setStartDelay(1300) // Anima a visible
                .withEndAction { animateProgress() } // Al terminar, anima la barra
                .start()
        }

        // 6. Tras la animación, decide a dónde ir según estado del usuario (2.8 segundos)
        binding.root.postDelayed({ decideNextScreen() }, 2800)
    }

    // Determina la siguiente pantalla según el estado de autenticación y completitud del test.
    private fun decideNextScreen() {
        val uid = repo.currentUid()

        // Si no hay sesión te manda al Login asi de sencillo
        if (uid == null) {
            navigateTo(LoginActivity::class.java)
            return
        }

        // Hay sesión: comprobar si ya hizo el test de nivel
        lifecycleScope.launch { // Ejecuta en corrutina
            val result = repo.getProfile(uid) // Obtiene el perfil del usuario
            result.fold(
                onSuccess = { profile ->
                    // Si aún no completó test
                    if (!profile.hasCompletedTest) {
                        // No ha hecho el test lo dirige seleccionar lenguaje
                        navigateTo(LanguageSelectActivity::class.java)
                    } else {
                        // Todo completo → directo a pantalla principal
                        navigateTo(MainActivity::class.java)
                    }
                },
                onFailure = { // Si falla la carga
                    repo.logout()
                    navigateTo(LoginActivity::class.java)
                }
            )
        }
    }

    // Navega a una actividad con animación de fade y cierra splash.
    private fun navigateTo(activity: Class<*>) {
        startActivity(Intent(this, activity))

        // Animación fade para transición suave entre pantallas
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
        finish()
    }

    // Anima la barra de progreso de 0 a 100 durante 1.2 segundos.
    private fun animateProgress() {
        android.animation.ObjectAnimator.ofInt(
            // De 0 a 100
            binding.progressSplash, "progress", 0, 100
        ).apply {
            // Duración en ms
            duration = 1200
            interpolator = AccelerateDecelerateInterpolator()
        }.start()
    }
}