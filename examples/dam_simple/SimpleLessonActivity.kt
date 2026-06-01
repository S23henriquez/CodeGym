package com.exemple.codegym.examples

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

// Ejemplo sencillo y comentado de Activity para un estudiante de DAM.
// Muestra una lista de lecciones (texto simple) y responde al clic mostrando un Toast.
class SimpleLessonActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_simple_lesson)

        // Referencia al RecyclerView (fila simple definida en XML)
        val rv = findViewById<RecyclerView>(R.id.rvSimpleLessons)
        rv.layoutManager = LinearLayoutManager(this)

        // Datos de ejemplo: una lista simple de títulos de lección
        val lessons = listOf(
            "Introducción a Python",
            "Variables y tipos",
            "Condicionales",
            "Bucles",
            "Funciones"
        )

        // Adapter simple con un callback para el clic en cada fila
        rv.adapter = SimpleLessonListAdapter(lessons) { title ->
            // Acciones sencillas: mostrar un mensaje corto
            Toast.makeText(this, "Has abierto: $title", Toast.LENGTH_SHORT).show()
        }
    }
}
