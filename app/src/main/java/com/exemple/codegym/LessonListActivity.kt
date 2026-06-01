package com.exemple.codegym

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.exemple.codegym.adapters.LessonListAdapter
import com.exemple.codegym.data.LessonRepository
import com.exemple.codegym.data.UserRepository
import com.exemple.codegym.databinding.ActivityLessonListBinding
import com.exemple.codegym.utils.LocaleHelper
import kotlinx.coroutines.launch

class LessonListActivity : BaseActivity() {

    companion object {
        const val EXTRA_LANGUAGE = "language" // Clave para pasar el lenguaje seleccionado entre actividades
    }

    private lateinit var binding: ActivityLessonListBinding // Vinculación del layout
    private val repo = UserRepository() // Repositorio para acceder a datos de usuario
    private var appLang: String = LocaleHelper.DEFAULT_LANGUAGE // Idioma de la interfaz

    // Inicializa la pantalla: obtiene el lenguaje, carga lecciones y configura el botón atrás.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLessonListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val language = intent.getStringExtra(EXTRA_LANGUAGE) ?: "Python" // Obtiene el lenguaje o "Python" por defecto
        appLang = LocaleHelper.getSavedLanguage(this) // Obtiene el idioma guardado de la app
        binding.tvLessonListTitle.text = "Lecciones · $language" // Muestra el título con el lenguaje

        setupBack() // Configura botón atrás
        loadLessons(language) // Carga las lecciones del lenguaje
    }

    // Recarga las lecciones al volver a la pantalla para actualizar el estado (verificar lecciones completadas).
    override fun onResume() {
        super.onResume()
        val language = intent.getStringExtra(EXTRA_LANGUAGE) ?: "Python"
        appLang = LocaleHelper.getSavedLanguage(this)
        loadLessons(language)
    }

    // Obtiene las lecciones del lenguaje y las muestra; si no hay, muestra mensaje vacío.
    private fun loadLessons(language: String) {
        val lessons = LessonRepository.getLessons(language, appLang) // Obtiene lista de lecciones

        if (lessons.isEmpty()) { // Si no hay lecciones
            // Muestra mensaje "Sin lecciones"
            binding.tvEmpty.visibility    = View.VISIBLE
            // Oculta el RecyclerView
            binding.rvLessons.visibility  = View.GONE
            binding.tvEmpty.text = "Sin lecciones"
            return
        }

        binding.tvEmpty.visibility   = View.GONE
        binding.rvLessons.visibility = View.VISIBLE

        // Cargar lecciones completadas del usuario para marcar cuál ya finalizó
        val uid = repo.currentUid() // Obtiene el ID del usuario
        if (uid == null) { // Si no hay usuario autenticado
            renderList(lessons, emptySet()) // Muestra todas las lecciones sin marcar completadas
            return
        }

        lifecycleScope.launch { // Ejecuta en corrutina
            val result = repo.getProfile(uid) // Obtiene el perfil del usuario
            val completed = result.getOrNull()?.completedLessons?.toSet() ?: emptySet() // Convierte la lista de completadas a Set
            renderList(lessons, completed) // Muestra lecciones con las completadas marcadas
        }
    }

    // Configura el adaptador del RecyclerView con las lecciones y callback para abrir cada una.
    private fun renderList(lessons: List<com.exemple.codegym.models.Lesson>, completedIds: Set<String>) {
        // Disposición vertical
        binding.rvLessons.layoutManager = LinearLayoutManager(this)
        binding.rvLessons.adapter = LessonListAdapter(lessons, completedIds) { lesson ->
            val intent = Intent(this, LessonActivity::class.java).apply {
                putExtra(LessonActivity.EXTRA_LANGUAGE, lesson.language)
                putExtra(LessonActivity.EXTRA_LESSON_ID, lesson.id)
            }
            startActivity(intent)
        }
    }

    // Configura el botón atrás para cerrar la actividad.
    private fun setupBack() {
        binding.btnBack.setOnClickListener { finish() }
    }
}