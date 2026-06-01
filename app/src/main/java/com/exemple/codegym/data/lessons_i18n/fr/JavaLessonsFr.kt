package com.exemple.codegym.data.lessons_i18n.fr

import com.exemple.codegym.models.ExerciseType
import com.exemple.codegym.models.Lesson
import com.exemple.codegym.models.LessonExercise

object JavaLessonsFr {

    val lessons: List<Lesson> = listOf(

        // ============ UNIT 1: BASIC JAVA ============

        Lesson(
            id = "java_1_1",
            language = "Java",
            unitNumber = 1,
            title = "Types Primitifs",
            theoryText = """
                En Java vous DEVEZ déclarer le type de chaque variable.
                
                🔹 Types numériques : int, long, double, float
                🔹 Texte/caractère : char (caractère unique), String (suite de texte)
                🔹 Booléen : boolean (true/false)
                
                ⚠️ Chaque instruction doit se terminer par un point-virgule ;
            """.trimIndent(),
            codeExample = """
                int age = 25;
                double taille = 1.65;
                String nom = "Ana";
                char initiale = 'A';
                boolean estEtudiant = true;
                
                System.out.println(nom);
            """.trimIndent(),
            xpReward = 20,
            exercises = listOf(
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "Quelle est la bonne façon de déclarer un entier ?",
                    "", listOf("integer x = 5", "int x = 5;", "var x = 5", "x = 5"), 1,
                    "Java utilise 'int' et termine toujours les instructions par un point-virgule."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Complétez pour stocker du texte :",
                    "??? salutation = \"Bonjour\";",
                    listOf("string", "String", "char", "texte"), 1,
                    "En Java, String s'écrit avec un S majuscule. C'est une classe, pas une primitive."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "Quel type utiliseriez-vous pour stocker 1.75 ?",
                    "", listOf("int", "double", "String", "boolean"), 1,
                    "double est le type le plus courant pour les nombres décimaux en Java."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "Que manque-t-il à la fin ?\nint x = 5",
                    "", listOf("Rien, c'est correct", "Point-virgule ;", "Accolade }", "Virgule ,"), 1,
                    "Chaque instruction en Java se termine par ; (point-virgule)."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Déclarez un char avec la lettre Z :",
                    "char lettre = ???;",
                    listOf("\"Z\"", "'Z'", "Z", "<Z>"), 1,
                    "En Java, les char utilisent des guillemets simples ' ', les String utilisent des guillemets doubles \" \".")
            )
        ),

        Lesson(
            id = "java_1_2",
            language = "Java",
            unitNumber = 1,
            title = "System.out.println",
            theoryText = """
                Pour afficher dans la console en Java, on utilise System.out.println().
                
                🔹 println ajoute un saut de ligne à la fin
                🔹 print affiche sans saut de ligne
                🔹 printf permet un formatage de style C
                🔹 Les chaînes sont concaténées en utilisant +
            """.trimIndent(),
            codeExample = """
                System.out.println("Bonjour le monde");
                System.out.println("Age : " + 25);
                
                int a = 5, b = 3;
                System.out.println(a + " + " + b + " = " + (a + b));
                // 5 + 3 = 8
            """.trimIndent(),
            xpReward = 20,
            exercises = listOf(
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "Que va afficher System.out.println(\"5\" + 3); ?",
                    "", listOf("8", "53", "5+3", "Erreur"), 1,
                    "Puisque \"5\" est un String, + concatène : \"5\" + 3 = \"53\"."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Affichez la somme de a et b AVEC un saut de ligne :",
                    "int a=10, b=5;\nSystem.out.???(a + b);",
                    listOf("println", "print", "show", "write"), 0,
                    "println affiche et ajoute un saut de ligne."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "Que va afficher System.out.println(2 + 3 + \"x\"); ?",
                    "", listOf("5x", "23x", "2 + 3 + x", "Erreur"), 0,
                    "De gauche à droite : 2+3=5 (nombres), puis 5+\"x\" concatène → \"5x\"."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "Quelle est la différence entre print et println ?",
                    "", listOf("Aucune", "println ajoute un saut de ligne", "print est plus rapide", "println nécessite String"), 1,
                    "println = print + saut de ligne (\\n)."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Concaténez nom et age :",
                    "String n=\"Ana\";\nint e=25;\nSystem.out.println(n ??? \" a \" ??? e);",
                    listOf(",", "+", ".", "&"), 1,
                    "+ concatène les Strings (et convertit automatiquement les types primitifs en String).")
            )
        ),

        Lesson(
            id = "java_1_3",
            language = "Java",
            unitNumber = 1,
            title = "Opérateurs",
            theoryText = """
                Java fournit des opérateurs arithmétiques, de comparaison et logiques.
                
                🔹 Arithmétique : + - * / % (modulo)
                🔹 Comparaison : == != < > <= >=
                🔹 Logique : && (ET) || (OU) ! (NON)
                🔹 ++ et -- incrémentation/décrémentation
                🔹 += -= *= /= opérateurs combinés
            """.trimIndent(),
            codeExample = """
                int a = 10, b = 3;
                
                System.out.println(a / b);   // 3 (division entière)
                System.out.println(a % b);   // 1 (reste)
                System.out.println(a > b);   // true
                
                a++;            // a = 11
                a += 5;         // a = 16
                
                boolean ok = (a > 10) && (b < 5);  // true
            """.trimIndent(),
            xpReward = 25,
            exercises = listOf(
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "Que va afficher System.out.println(10 / 3); ?",
                    "", listOf("3.33", "3", "3.0", "4"), 1,
                    "La division entière entre entiers ignore les décimales : 10/3 = 3."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "Lequel est l'opérateur logique ET (AND) ?",
                    "", listOf("&", "&&", "and", "+"), 1,
                    "&& est le ET logique. & est le ET binaire."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Ajoutez 5 à la variable en utilisant un opérateur combiné :",
                    "int x = 10;\nx ??? 5;",
                    listOf("=+", "+=", "++", "=5+"), 1,
                    "+= est une affectation combinée. x += 5 équivaut à x = x + 5."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "Qu'est-ce qui est affiché ?\nint x = 5;\nx++;\nSystem.out.println(x);",
                    "", listOf("5", "6", "4", "Erreur"), 1,
                    "x++ incrémente x de 1. Il passe de 5 à 6."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Vérifiez si l'âge est EXACTEMENT 18 :",
                    "if (age ??? 18) { ... }",
                    listOf("=", "==", "===", "!="), 1,
                    "= est pour l'affectation. == évalue l'égalité. === n'est pas valide en Java.")
            )
        ),

        // ============ UNIT 2: CONTROL FLOW ============

        Lesson(
            id = "java_2_1",
            language = "Java",
            unitNumber = 2,
            title = "if, else if, else",
            theoryText = """
                Les conditions en Java doivent utiliser des parenthèses et des accolades.
                
                🔹 if (condition) { ... }
                🔹 else if (autre_condition) { ... }
                🔹 else { ... }
                🔹 Opérateur ternaire : condition ? valeurSiVrai : valeurSiFaux
            """.trimIndent(),
            codeExample = """
                int note = 7;
                
                if (note >= 9) {
                    System.out.println("Excellent");
                } else if (note >= 7) {
                    System.out.println("Bien");
                } else if (note >= 5) {
                    System.out.println("Passable");
                } else {
                    System.out.println("Échec");
                }
                
                // Ternaire
                String res = (note >= 5) ? "Passable" : "Échec";
            """.trimIndent(),
            xpReward = 25,
            exercises = listOf(
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "Qu'est-ce qui est affiché ?\nint x = 10;\nif (x > 5) System.out.println(\"A\");\nelse System.out.println(\"B\");",
                    "", listOf("A", "B", "AB", "Erreur"), 0,
                    "10 > 5 est vrai, donc le programme entre dans le if et affiche 'A'.")
            )
        )
    )
}
