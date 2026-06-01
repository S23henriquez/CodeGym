package com.exemple.codegym.data.lessons_i18n.ca

import com.exemple.codegym.models.ExerciseType
import com.exemple.codegym.models.Lesson
import com.exemple.codegym.models.LessonExercise

object JavaLessonsCa {

    val lessons: List<Lesson> = listOf(

        // ============ UNITAT 1: JAVA BÀSIC ============

        Lesson(
            id = "java_1_1",
            language = "Java",
            unitNumber = 1,
            title = "Tipus Primitius",
            theoryText = """
                A Java HAS de declarar el tipus de cada variable.
                
                🔹 Tipus numèrics: int, long, double, float
                🔹 Text/caràcter: char (caràcter únic), String (seqüència de text)
                🔹 Booleà: boolean (true/false)
                
                ⚠️ Cada instrucció ha d'acabar amb un punt i coma ;
            """.trimIndent(),
            codeExample = """
                int edat = 25;
                double alcada = 1.65;
                String nom = "Ana";
                char inicial = 'A';
                boolean esEstudiant = true;
                
                System.out.println(nom);
            """.trimIndent(),
            xpReward = 20,
            exercises = listOf(
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "Quina és la forma correcta de declarar un enter?",
                    "", listOf("integer x = 5", "int x = 5;", "var x = 5", "x = 5"), 1,
                    "Java utilitza 'int' i sempre acaba les declaracions amb un punt i coma.")
            )
        )
    )
}
