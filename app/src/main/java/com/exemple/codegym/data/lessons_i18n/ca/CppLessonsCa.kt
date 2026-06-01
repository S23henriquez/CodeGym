package com.exemple.codegym.data.lessons_i18n.ca

import com.exemple.codegym.models.ExerciseType
import com.exemple.codegym.models.Lesson
import com.exemple.codegym.models.LessonExercise

object CppLessonsCa {

    val lessons: List<Lesson> = listOf(

        // ============ UNITAT 1: C++ BÀSIC ============

        Lesson(
            id = "cpp_1_1",
            language = "C++",
            unitNumber = 1,
            title = "std::cout",
            theoryText = """
                En C++, utilitzem std::cout per mostrar per consola.
                
                🔹 Utilitza l'operador << per enviar dades a cout
                🔹 std::endl (o "\n") s'utilitza per fer un salt de línia
                🔹 Has d'incloure la biblioteca <iostream>
                🔹 Cada instrucció acaba amb un ;
            """.trimIndent(),
            codeExample = """
                #include <iostream>
                
                int main() {
                    std::cout << "Hola món";
                    std::cout << "Edat: " << 25 << std::endl;
                    return 0;
                }
            """.trimIndent(),
            xpReward = 20,
            exercises = listOf(
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "Quin operador s'utilitza amb std::cout?",
                    "", listOf(">>", "<<", "==", "::"), 1,
                    "L'operador d'inserció << envia les dades a std::cout.")
            )
        )
    )
}
