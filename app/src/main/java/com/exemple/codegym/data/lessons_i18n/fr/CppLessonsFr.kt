package com.exemple.codegym.data.lessons_i18n.fr

import com.exemple.codegym.models.ExerciseType
import com.exemple.codegym.models.Lesson
import com.exemple.codegym.models.LessonExercise

object CppLessonsFr {

    val lessons: List<Lesson> = listOf(

        // ============ UNIT 1: BASIC C++ ============

        Lesson(
            id = "cpp_1_1",
            language = "C++",
            unitNumber = 1,
            title = "std::cout",
            theoryText = """
                En C++, nous utilisons std::cout pour afficher sur la console.
                
                🔹 Utilisez l'opérateur << pour envoyer des données à cout
                🔹 std::endl (ou "\n") s'utilise pour faire un saut de ligne
                🔹 Vous devez inclure la bibliothèque <iostream>
                🔹 Chaque instruction se termine par un ;
            """.trimIndent(),
            codeExample = """
                #include <iostream>
                
                int main() {
                    std::cout << "Bonjour le monde";
                    std::cout << "Age : " << 25 << std::endl;
                    return 0;
                }
            """.trimIndent(),
            xpReward = 20,
            exercises = listOf(
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "Quel opérateur s'utilise avec std::cout ?",
                    "", listOf(">>", "<<", "==", "::"), 1,
                    "L'opérateur d'insertion << envoie les données vers std::cout."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Affichez le numéro 5 :",
                    "std::cout ??? 5;",
                    listOf("<<", ">>", "< <", "::"), 0,
                    "<< envoie la donnée '5' au flux de sortie."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "À quoi sert std::endl ?",
                    "", listOf("Terminer le programme", "Aller à la ligne", "Créer une variable", "Inclure un fichier"), 1,
                    "std::endl insère un saut de ligne (comme \n) et vide le flux (buffer)."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "Quelle librairie est nécessaire pour cout ?",
                    "", listOf("<stdio.h>", "<math>", "<iostream>", "<string>"), 2,
                    "<iostream> contient les définitions pour cout et cin.")
            )
        ),

        Lesson(
            id = "cpp_1_2",
            language = "C++",
            unitNumber = 1,
            title = "Types de Données",
            theoryText = """
                Le C++ demande de définir les types.
                
                🔹 int : entiers
                🔹 float / double : décimaux
                🔹 char : un caractère simple dans des guillemets simples 'a'
                🔹 std::string : séquences de texte dans des guillemets doubles "Bonjour" (nécessite <string>)
                🔹 bool : vrai/faux (true/false)
            """.trimIndent(),
            codeExample = """
                int vies = 3;
                double gravite = 9.81;
                char note = 'A';
                bool estActif = true;
                
                std::string nom = "Pacman";
            """.trimIndent(),
            xpReward = 20,
            exercises = listOf(
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "Lequel permet de stocker un caractère ?",
                    "", listOf("string", "char", "letter", "let"), 1,
                    "char stocke un caractère avec de simples guillemets."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Quel est le type le plus approprié pour stocker 3.14 ?",
                    "??? pi = 3.14;",
                    listOf("int", "double", "float", "char"), 1,
                    "double permet plus de précision que float sur C++.")
            )
        )
    )
}
