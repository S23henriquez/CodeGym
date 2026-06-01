package com.exemple.codegym.data.lessons_i18n.fr

import com.exemple.codegym.models.ExerciseType
import com.exemple.codegym.models.Lesson
import com.exemple.codegym.models.LessonExercise

object PythonLessonsFr {
    val lessons: List<Lesson> = listOf(
        // ============ UNITÉ 1 : BASES DE PYTHON ============
        Lesson(
            id = "py_1_1",
            language = "Python",
            unitNumber = 1,
            title = "Introduction et Print",
            theoryText = """
                Python est un langage de programmation très facile à lire.
                
                🔹 Les variables n'ont pas besoin d'un type déclaré (typage dynamique).
                🔹 Les blocs de code sont définis par l'indentation (espaces), pas avec des { }.
                🔹 print() s'utilise pour afficher du texte à l'écran.
            """.trimIndent(),
            codeExample = """
                # Ceci est un commentaire
                nom = "Ana"
                age = 25
                print("Bonjour", nom)
                
                # Formatage de texte (f-strings)
                print(f"J'ai {age} ans")
            """.trimIndent(),
            xpReward = 20,
            exercises = listOf(
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "Comment affiche-t-on 'Bonjour' en Python ?",
                    "", listOf("console.log('Bonjour')", "System.out.print('Bonjour')", "print('Bonjour')", "echo 'Bonjour'"), 2,
                    "En Python on utilise print() pour afficher le texte à la console."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Complétez le code pour afficher la variable :",
                    "x = 10\n???(x)",
                    listOf("print", "echo", "show", "log"), 0,
                    "print est la fonction pour afficher les valeurs à l'écran."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "Comment les blocs de code sont-ils définis en Python ?",
                    "", listOf("Accolades {}", "Parenthèses ()", "Indentation (espaces)", "Balises <>"), 2,
                    "Python utilise l'indentation (normalement 4 espaces) au lieu des accolades."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "Que va afficher ce code ?",
                    "print(2 + 3)",
                    listOf("2 + 3", "5", "Erreur", "23"), 1,
                    "Python évalue les opérations mathématiques au sein du print(). 2 + 3 = 5."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Complétez avec une f-string :",
                    "nom = 'Luis'\nprint(???\"Bonjour {nom}\")",
                    listOf("f", "F", "format", "s"), 0,
                    "Les f-strings (avec un 'f' devant) autorisent des variables à l'intérieur des accolades {}.")
            )
        ),

        Lesson(
            id = "py_1_2",
            language = "Python",
            unitNumber = 1,
            title = "Opérations de Base",
            theoryText = """
                Python supporte les opérations mathématiques standards.
                
                🔹 + (addition), - (soustraction), * (multiplication)
                🔹 / (division décimale), // (division entière)
                🔹 % (modulo, le reste d'une division)
                🔹 ** (exponentiation, puissance)
            """.trimIndent(),
            codeExample = """
                print(10 / 3)   # 3.33333333...
                print(10 // 3)  # 3 (partie entière)
                print(10 % 3)   # 1 (le reste)
                print(2 ** 3)   # 8 (2 à la puissance 3)
            """.trimIndent(),
            xpReward = 25,
            exercises = listOf(
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "Quel est le résultat de 10 / 2 ?",
                    "", listOf("5", "5.0", "Erreur", "0"), 1,
                    "L'opérateur / retourne toujours un float (décimal) sur Python 3."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Calculez 5 puissance 2 :",
                    "resultat = 5 ??? 2",
                    listOf("**", "^", "*", "//"), 0,
                    "Python utilise ** pour la puissance. ^ sert à faire l'opération XOR (bit à bit)."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "Que fait l'opérateur modulo (%) ?",
                    "", listOf("Calcule le pourcentage", "Division entière", "Retourne le reste d'une division", "Multiplie"), 2,
                    "10 % 3 = 1 parce que 10 = 3*3 + 1."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "Que retourne l'expression 7 // 2 ?",
                    "", listOf("3.5", "3", "4", "Erreur"), 1,
                    "// exécute la division entière (retire la partie décimale). 7/2 = 3.5 -> 3."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Complétez pour obtenir le reste de la division 15 par 4 :",
                    "print(15 ??? 4)",
                    listOf("%", "/", "//", "*"), 0,
                    "L'opérateur % retourne le reste.")
            )
        ),

        // ============ UNITÉ 2 : FLUX DE CONTRÔLE ============

        Lesson(
            id = "py_2_1",
            language = "Python",
            unitNumber = 2,
            title = "Conditions (if-else)",
            theoryText = """
                Contrôlez le flux du code avec if, elif et else.
                
                🔹 Mettez deux points (:) à la fin de la condition
                🔹 Indentez le bloc du code
                🔹 and = les deux sont vrais
                🔹 or = un seul est vrai
                🔹 not = négation
            """.trimIndent(),
            codeExample = """
                age = 18
                if age >= 18:
                    print("Majeur")
                elif age >= 13:
                    print("Adolescent")
                else:
                    print("Enfant")
            """.trimIndent(),
            xpReward = 25,
            exercises = listOf(
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "Que manque-t-il pour faire tourner le 'if' ?",
                    "if x > 10\n    print('Majeur')",
                    listOf("Parenthèses à x > 10", "Deux points (:) à la fin", "Accolades {}", "Point-virgule (;)"), 1,
                    "Il est obligatoire d'avoir un deux-points (:) en fin de if."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Complétez pour écrire 'Réussi' si la note >= 5 :",
                    "note = 7\n??? note >= 5:\n    print('Réussi')",
                    listOf("if", "for", "while", "def"), 0,
                    "On utilise 'if' pour des conditions de branchement."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "Qu'est-ce que ce code va sortir ?",
                    "x = 0\nif x:\n    print('Oui')\nelse:\n    print('Non')",
                    listOf("Oui", "Non", "0", "Erreur"), 1,
                    "0 est évalué comme un False (Faux) en Python. Le flux bascule vers else."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "Quel est le bon opérateur d'égalité ?",
                    "", listOf("=", "==", "===", "!="), 1,
                    "= est pour assigner des variables. == vérifie l'égalité."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Complétez ce elif :",
                    "if age < 13:\n    print('enfant')\n??? age < 18:\n    print('adolescent')",
                    listOf("else", "elif", "if", "or"), 1,
                    "elif ajoute un branchement quand des intermédiaires sont sollicitées.")
            )
        ),

        Lesson(
            id = "py_2_2",
            language = "Python",
            unitNumber = 2,
            title = "Boucles for et while",
            theoryText = """
                Les boucles servent pour l'itération des actions :
                
                🔹 for : boucle par une séquence (liste, range...)
                🔹 while : recommence pendant que c'est vrai
                🔹 break : force l'arrêt
                🔹 continue : passe à l'itération suivante
                🔹 range(n) : génère 0, 1, 2, ..., n-1
            """.trimIndent(),
            codeExample = """
                # for avec une range
                for i in range(5):
                    print(i)        # 0,1,2,3,4
                
                # for dans une liste
                for fruit in ["pomme", "raisin"]:
                    print(fruit)
                
                # while
                compteur = 0
                while compteur < 3:
                    print(compteur)
                    compteur += 1
            """.trimIndent(),
            xpReward = 25,
            exercises = listOf(
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "Combien de fois est affiché 'bonjour' ?",
                    "for i in range(4):\n    print('bonjour')",
                    listOf("3", "4", "5", "0"), 1,
                    "range(4) passe 4 fois sur: 0,1,2,3."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Complète de 0 à 9 :",
                    "for i in ???(10):\n    print(i)",
                    listOf("range", "len", "list", "iter"), 0,
                    "range(10) correspond aux numéros: 0,1,2,...,9."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "Le but d'utiliser 'break' dans la boucle ?",
                    "", listOf("Aller au cycle suivant", "Arrêter complètement la boucle", "Restart", "Appel système"), 1,
                    "Le code break stoppe la boucle tout de suite."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "Quel est la dernière impression ?",
                    "i = 0\nwhile i < 3:\n    print(i)\n    i += 1",
                    listOf("0", "1", "2", "3"), 2,
                    "C'est: 0 puis 1 puis 2."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Rajoute une unité au compteur :",
                    "n = 0\nwhile n < 5:\n    n ??? 1",
                    listOf("=+", "+=", "++", "=1+"), 1,
                    "+= sert comme addition assignement.")
            )
        )
    )
}