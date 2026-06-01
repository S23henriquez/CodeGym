package com.exemple.codegym

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.exemple.codegym.data.UserRepository
import com.exemple.codegym.databinding.ActivityRegisterBinding
import com.google.firebase.auth.FirebaseAuthUserCollisionException
import com.google.firebase.auth.FirebaseAuthWeakPasswordException
import kotlinx.coroutines.launch

class RegisterActivity : BaseActivity() {

    private lateinit var binding: ActivityRegisterBinding // Vinculación del layout de registro
    private val repo = UserRepository() // Repositorio para crear cuenta

    // Inicializa la pantalla de registro: infla el layout y configura los botones.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupButtons()
    }

    // Configura los listeners de los botones: Registrarse e Ir a Login.
    private fun setupButtons() {
        binding.btnRegister.setOnClickListener { attemptRegister() } // Al pulsar, intenta registrarse
        binding.btnGoLogin.setOnClickListener { finish() } // Al pulsar, vuelve a Login
    }

    // Intenta registrar un nuevo usuario: valida datos y llama al repositorio.
    private fun attemptRegister() {
        val name = binding.etName.text.toString().trim()
        val email = binding.etEmail.text.toString().trim()
        val password = binding.etPassword.text.toString()
        val confirm = binding.etConfirmPassword.text.toString()

        // Validaciones de entrada
        if (name.isEmpty()) { binding.etName.error = "Introduce tu nombre"; return }
        if (email.isEmpty()) { binding.etEmail.error = "Introduce tu email"; return }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            binding.etEmail.error = "Email no válido"; return
        }
        if (password.length < 6) { // Si es muy corta
            binding.etPassword.error = "Mínimo 6 caracteres"; return
        }
        if (password != confirm) { // Si no coinciden las contraseñas
            binding.etConfirmPassword.error = "Las contraseñas no coinciden"; return
        }

        setLoading(true) // Muestra estado de carga
        lifecycleScope.launch {
            val result = repo.registerUser(name, email, password)
            setLoading(false)
            result.fold(
                onSuccess = { // Si el registro fue exitoso
                    // Tras registro, va a seleccionar lenguaje
                    Toast.makeText(
                        this@RegisterActivity,
                        "¡Cuenta creada! Vamos a personalizar tu experiencia",
                        Toast.LENGTH_SHORT
                    ).show()
                    startActivity(Intent(this@RegisterActivity, LanguageSelectActivity::class.java))
                    finishAffinity()
                },
                // Si el registro falla mostrara un error
                onFailure = { e ->
                    val msg = when (e) {
                        is FirebaseAuthUserCollisionException -> "Este email ya está registrado"
                        is FirebaseAuthWeakPasswordException -> "La contraseña es muy débil"
                        else -> "Error: ${e.message}"
                    }
                    Toast.makeText(this@RegisterActivity, msg, Toast.LENGTH_LONG).show()
                }
            )
        }
    }

    // Actualiza el estado visual del botón durante el registro: desactiva y muestra progreso.
    private fun setLoading(loading: Boolean) {
        binding.btnRegister.isEnabled = !loading
        binding.progressRegister.visibility = if (loading) View.VISIBLE else View.GONE
    }
}