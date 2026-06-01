package com.exemple.codegym.data.lessons_i18n.ca

import com.exemple.codegym.models.ExerciseType
import com.exemple.codegym.models.Lesson
import com.exemple.codegym.models.LessonExercise

object KotlinLessonsCa {

    val lessons: List<Lesson> = listOf(

        // ============ UNITAT 1: KOTLIN BÀSIC ============

        Lesson(
            id = "kt_1_1",
            language = "Kotlin",
            unitNumber = 1,
            title = "val vs var",
            theoryText = """
                A Kotlin hi ha 2 formes principals de declarar variables:
                
                🔹 val: variable IMMUTABLE (constant). Un cop assignada, no es pot canviar.
                🔹 var: variable mutable (es pot canviar).
                
                💡 Utilitza val sempre que sigui possible, utilitza var només quan NECESSITIS canviar el valor.
            """.trimIndent(),
            codeExample = """
                val nom = "Ana"      // No es pot reassignar
                var edat = 25          // Es pot reassignar
                
                edat = 26              // ✅ OK
                // nom = "Luis"      // ❌ ERROR
            """.trimIndent(),
            xpReward = 20,
            exercises = listOf(
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "Quina permet canviar el valor més endavant?",
                    "", listOf("val x = 5", "var x = 5", "const x = 5", "let x = 5"), 1,
                    "var és mutable, val és immutable.")
            )
        )
    )
}
