package com.exemple.codegym

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.exemple.codegym.adapters.LanguageAdapter
import com.exemple.codegym.data.LessonRepository
import com.exemple.codegym.data.UserRepository
import com.exemple.codegym.models.Language
import com.exemple.codegym.utils.LocaleHelper
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.coroutines.launch

class MainActivity : BaseActivity() {

    // Agrupa constantes de la actividad para usarlas en toda la clase.
    companion object {
        private const val REMINDER_PERMISSION_REQUEST_CODE = 2001 // Código para identificar la solicitud de permisos
    }

    private val repo = UserRepository() // Instancia del repositorio para acceder a datos de usuario

    // Lista inicial de lenguajes con iconos y estados deshabilitados; se actualiza al cargar datos del usuario.
    private var allLanguages = listOf(
        Language("Python", "🐍", 0, 0, isActive = false),
        Language("Java",   "☕", 0, 0, isActive = false),
        Language("Kotlin", "🤖", 0, 0, isActive = false),
        Language("C++",    "⚙️", 0, 0, isActive = false),
        Language("SQL",    "🗄️", 0, 0, isActive = false)
    )

    // Inicializa la pantalla principal: configura la navegación inferior y solicita permisos de notificación.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Configura la barra de navegación inferior
        setupBottomNav()
        requestNotificationPermissionIfNeeded()
    }

    // Recarga datos del usuario cada vez que se vuelve a la pantalla principal.
    override fun onResume() {
        super.onResume()
        // Obtiene el perfil actualizado del usuario
        loadUserData()
    }

    // Solicita permiso POST_NOTIFICATIONS si es necesario (Android 13+).
    // Esto permite mostrar notificaciones y recordatorios de lecciones.
    private fun requestNotificationPermissionIfNeeded() {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.TIRAMISU &&
            ContextCompat.checkSelfPermission(this, Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.POST_NOTIFICATIONS),
                REMINDER_PERMISSION_REQUEST_CODE
            )
        }
    }

    // Carga el perfil del usuario en sesión y configura la UI con sus datos.
    // Si no hay usuario autenticado, redirige a LoginActivity.

    private fun loadUserData() {

        // Obtiene el ID del usuario autenticado
        val uid = repo.currentUid()

        // Si no hay usuario, redirige al login
        if (uid == null) {
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
            return
        }

        lifecycleScope.launch { // Ejecuta en corrutina vinculada al ciclo de vida de la actividad

            val result = repo.getProfile(uid)
            result.fold(
                onSuccess = { profile ->

                    // Obtiene la primera letra del nombre o "U" por defecto
                    val initial = profile.name.firstOrNull()?.uppercase() ?: "U"

                    findViewById<TextView>(R.id.tvAvatarInitial).text = initial

                    // Referencia a la imagen del avatar
                    val ivAvatarMain = findViewById<ImageView>(R.id.ivAvatarMain)

                    // Accede a preferencias compartidas
                    val prefs = getSharedPreferences("avatar_prefs", MODE_PRIVATE)

                    val saved = prefs.getString("avatar_base64", null)

                    if (saved != null) {

                        // Decodifica de Base64 a array de bytes
                        val bytes = android.util.Base64.decode(saved, android.util.Base64.DEFAULT)

                        // Convierte bytes a imagen
                        val bmp = android.graphics.BitmapFactory.decodeByteArray(bytes, 0, bytes.size)

                        // Muestra la imagen
                        ivAvatarMain.setImageBitmap(bmp)
                        ivAvatarMain.clipToOutline = true

                        // Oculta la letra inicial ya que se muestra la imagen personalizada
                        findViewById<TextView>(R.id.tvAvatarInitial).visibility = android.view.View.GONE

                        // Al pulsar el avatar, abre el perfil para editar (cambiar imagen, nombre, etc.) y si no hay imagen, abre el perfil para editar avatar guardado
                        ivAvatarMain.setOnClickListener {
                            startActivity(Intent(this@MainActivity, ProfileActivity::class.java))
                        }

                    } else {
                        findViewById<TextView>(R.id.tvAvatarInitial).setOnClickListener {
                            startActivity(Intent(this@MainActivity, ProfileActivity::class.java))
                        }
                    }

                    // Extrae el primer nombre o "Usuario"
                    val firstName = profile.name.split(" ").firstOrNull()?.takeIf { it.isNotBlank() } ?: "Usuario"

                    // Muestra saludo personalizado
                    findViewById<TextView>(R.id.tvWelcomeSmall).text = getString(R.string.welcome_back, firstName)

                    // Título motivacional con el nombre
                    findViewById<TextView>(R.id.tvHeroTitle).text =
                        getString(R.string.hero_keep_learning, firstName)

                    // Obtiene el lenguaje activo del usuario
                    val activeLang = profile.selectedLanguage

                    // Obtiene el idioma de la app
                    val appLang = LocaleHelper.getSavedLanguage(this@MainActivity)

                    // Obtiene todas las lecciones del lenguaje activo
                    val lessons = LessonRepository.getLessons(activeLang, appLang)

                    //
                    val lessonIds = lessons.map { it.id }.toSet()

                    // Contamos lecciones completó en este lenguaje
                    val completedThisLang = profile.completedLessons.count { it in lessonIds }
                    findViewById<TextView>(R.id.tvHeroTitle).text =
                        getString(R.string.hero_keep_learning, firstName)

                    // Configura la lista de lenguajes marcando el activo
                    setupLanguageList(activeLang)
                },

                onFailure = { e -> // Si hubo error al obtener datos
                    // Ignora excepciones de cancelación
                    if (e !is kotlinx.coroutines.CancellationException) {

                        // Muestra error
                        Toast.makeText(this@MainActivity, getString(R.string.error_prefix, e.message.orEmpty()), Toast.LENGTH_LONG).show()
                    }
                    setupLanguageList("")
                }
            )
        }
    }

    // Configura la lista de lenguajes con el lenguaje activo marcado.
    // Al seleccionar un lenguaje, abre la pantalla de lecciones.
    private fun setupLanguageList(activeLanguage: String) {

        // Actualiza cada lenguaje marcando cuál es activo
        val updated = allLanguages.map { lang ->
            lang.copy(isActive = lang.name == activeLanguage)
        }
        val rv = findViewById<RecyclerView>(R.id.rvLanguages)

        // Crea adaptador con callback al seleccionar
        rv.adapter = LanguageAdapter(updated) { selected ->

            // Intent para abrir lista de lecciones
            val intent = Intent(this, LessonListActivity::class.java).apply {
                putExtra(LessonListActivity.EXTRA_LANGUAGE, selected.name)
            }
            startActivity(intent)
        }
        // Muestra lenguajes en una cuadrícula de 2 columnas (dos por fila)
        rv.layoutManager = GridLayoutManager(this, 2)
    }

    // Configura la barra de navegación inferior con tres opciones: Inicio, Perfil y Configuración.

    // Cada opción abre su respectiva actividad.
    private fun setupBottomNav() {
        val nav = findViewById<BottomNavigationView>(R.id.bottomNav)

        nav.selectedItemId = R.id.nav_home
        nav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home    -> true
                R.id.nav_profile -> {
                    startActivity(Intent(this, ProfileActivity::class.java))
                    true
                }
                R.id.nav_settings -> {
                    startActivity(Intent(this, SettingsActivity::class.java))
                    true
                }
                else -> false
            }
        }
    }
}