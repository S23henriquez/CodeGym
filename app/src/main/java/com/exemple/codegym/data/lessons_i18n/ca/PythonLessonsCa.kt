package com.exemple.codegym.data.lessons_i18n.ca

import com.exemple.codegym.models.ExerciseType
import com.exemple.codegym.models.Lesson
import com.exemple.codegym.models.LessonExercise

object PythonLessonsCa {

    val lessons: List<Lesson> = listOf(

        // ============ UNITAT 1: FONAMENTS ============

        Lesson(
            id = "py_1_1",
            language = "Python",
            unitNumber = 1,
            title = "Introducció i Print",
            theoryText = """
                Python és un llenguatge de programació molt fàcil de llegir.
                
                🔹 Les variables no necessiten un tipus declarat (tipat dinàmic).
                🔹 Els blocs de codi es defineixen per sagnat (espais), no { }.
                🔹 print() s'utilitza per mostrar text a la pantalla.
            """.trimIndent(),
            codeExample = """
                # Això és un comentari
                nom = "Ana"
                edat = 25
                print("Hola", nom)
                
                # Format de text (f-strings)
                print(f"Tinc {edat} anys")
            """.trimIndent(),
            xpReward = 20,
            exercises = listOf(
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "Com es mostra 'Hola' a Python?",
                    "", listOf("console.log('Hola')", "System.out.print('Hola')", "print('Hola')", "echo 'Hola'"), 2,
                    "A Python, utilitzem print() per imprimir text a la consola.")
            )
        )
    )
}
