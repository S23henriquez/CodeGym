package com.exemple.codegym

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.exemple.codegym.data.UserRepository
import com.exemple.codegym.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.FirebaseAuthInvalidUserException
import kotlinx.coroutines.launch

class LoginActivity : BaseActivity() {

    private lateinit var binding: ActivityLoginBinding // Vinculación del layout de login
    private val repo = UserRepository() // Repositorio para autenticación

    // Inicializa la pantalla de login: infla el layout y configura los botones.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupButtons()
    }

    // Configura los listeners de los botones: Iniciar sesión y Ir a Registro.
    private fun setupButtons() {
        binding.btnLogin.setOnClickListener { attemptLogin() } // Al pulsar login, intenta autenticarse
        binding.btnGoRegister.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }
    }

    // Intenta autenticar al usuario: valida email y contraseña, luego llama al repositorio.
    private fun attemptLogin() {
        val email = binding.etEmail.text.toString().trim()
        val password = binding.etPassword.text.toString()

        // Validaciones de entrada
        if (email.isEmpty()) { // Si el campo está vacío
            binding.etEmail.error = "Introduce tu email"
            return
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) { // Si no es un email válido
            binding.etEmail.error = "Email no válido"
            return
        }
        if (password.isEmpty()) { // Si la contraseña está vacía
            binding.etPassword.error = "Introduce tu contraseña"
            return
        }

        setLoading(true) // Muestra estado de carga
        lifecycleScope.launch { // Ejecuta en corrutina

            // Intenta login en Firebase
            val result = repo.loginUser(email, password)
            result.fold(
                onSuccess = { uid -> // Si el login fue exitoso

                    // Tras login, comprueba si ya completó el test de nivel
                    val profileResult = repo.getProfile(uid)
                    setLoading(false)
                    profileResult.fold(
                        onSuccess = { profile -> // Si el perfil existe
                            val next = if (profile.hasCompletedTest) {
                                MainActivity::class.java
                            } else {
                                LanguageSelectActivity::class.java
                            }
                            startActivity(Intent(this@LoginActivity, next))
                            finish()
                        },
                        onFailure = { // Si no tiene perfil (fallo en registro anterior)
                            // Reset al flujo de selección de lenguaje
                            startActivity(Intent(this@LoginActivity, LanguageSelectActivity::class.java))
                            finish()
                        }
                    )
                },
                onFailure = { e -> // Si el login falló
                    setLoading(false)
                    val msg = when (e) { // Interpreta el tipo de error
                        is FirebaseAuthInvalidUserException -> "Este email no está registrado"
                        is FirebaseAuthInvalidCredentialsException -> "Email o contraseña incorrectos"
                        else -> "Error: ${e.message}"
                    }
                    Toast.makeText(this@LoginActivity, msg, Toast.LENGTH_LONG).show()
                }
            )
        }
    }

    // Actualiza el estado visual del botón durante el login: desactiva y cambia texto.
    private fun setLoading(loading: Boolean) {
        binding.btnLogin.isEnabled = !loading // Desactiva si está cargando
        binding.btnLogin.text = if (loading) "Entrando..." else "Iniciar sesión →" // Cambia texto
    }
}