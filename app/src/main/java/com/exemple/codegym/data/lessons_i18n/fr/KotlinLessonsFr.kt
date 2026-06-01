package com.exemple.codegym.data.lessons_i18n.fr

import com.exemple.codegym.models.ExerciseType
import com.exemple.codegym.models.Lesson
import com.exemple.codegym.models.LessonExercise

object KotlinLessonsFr {

    val lessons: List<Lesson> = listOf(

        // ============ UNIT 1: BASIC KOTLIN ============

        Lesson(
            id = "kt_1_1",
            language = "Kotlin",
            unitNumber = 1,
            title = "val vs var",
            theoryText = """
                En Kotlin, il y a 2 façons principales de déclarer des variables :
                
                🔹 val : variable IMMUABLE (constante). Une fois assignée, on ne peut pas la changer.
                🔹 var : variable mutable (peut être modifiée).
                
                💡 Utilisez val autant que possible, utilisez var uniquement quand vous AVEZ BESOIN de changer la valeur.
            """.trimIndent(),
            codeExample = """
                val nom = "Ana"      // Ne peut pas être réassignée
                var age = 25          // Peut être réassignée
                
                age = 26              // ✅ OK
                // nom = "Luis"      // ❌ ERREUR
            """.trimIndent(),
            xpReward = 20,
            exercises = listOf(
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "Lequel permet de changer la valeur plus tard ?",
                    "", listOf("val x = 5", "var x = 5", "const x = 5", "let x = 5"), 1,
                    "var est mutable, val est immuable."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Déclarez une constante immuable PI :",
                    "??? PI = 3.14159",
                    listOf("var", "val", "let", "const"), 1,
                    "val est utilisé pour les constantes immuables en Kotlin."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "Est-il TOUJOURS nécessaire de déclarer le type en Kotlin ?",
                    "", listOf("Oui, toujours", "Non, il le déduit de la valeur", "Seulement pour les Ints", "Seulement pour les Strings"), 1,
                    "Kotlin déduit le type de la valeur que vous assignez. val x = 5 → Int."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Déclarez x explicitement comme un Int :",
                    "val x: ??? = 10",
                    listOf("int", "Int", "Integer", "Number"), 1,
                    "En Kotlin, le type Int commence par un 'I' majuscule."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "Est-ce que cela compile ?\nval x = 5\nx = 10",
                    "", listOf("Oui, x devient 10", "Non, val est immuable", "Seulement à l'exécution", "Oui mais donne un avertissement"), 1,
                    "val ne peut pas être réassignée. Vous devrez utiliser var.")
            )
        ),

        Lesson(
            id = "kt_1_2",
            language = "Kotlin",
            unitNumber = 1,
            title = "Sécurité face aux Null",
            theoryText = """
                Kotlin empêche les célèbres NullPointerException à la compilation.
                
                🔹 Par défaut, les variables NE PEUVENT PAS être nulles
                🔹 Le ? à la fin du type autorise null : String?
                🔹 ?. accède de manière sécurisée
                🔹 ?: Opérateur Elvis : valeur par défaut s'il est null
                🔹 !! force non-null (dangereux, peut planter)
            """.trimIndent(),
            codeExample = """
                var nom: String = "Ana"
                // nom = null               // ❌ ERREUR
                
                var pseudo: String? = "Anita"
                pseudo = null               // ✅ OK
                
                val longueur = pseudo?.length ?: 0   // 0 si null
            """.trimIndent(),
            xpReward = 30,
            exercises = listOf(
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "Lequel de ceux-ci PEUT être null ?",
                    "", listOf("val x: Int = 5", "var y: String = \"\"", "var z: String? = null", "val w: Boolean = true"), 2,
                    "Le ? après le type (String?) indique qu'il peut être null."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Affichez 'pas de nom' si le nom est null :",
                    "val nom: String? = null\nprintln(nom ??? \"pas de nom\")",
                    listOf("?:", "?.", "!!", "??"), 0,
                    "?: est l'opérateur Elvis : utilise la valeur de droite si celle de gauche est null."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "Que fait nom?.length si le nom est null ?",
                    "", listOf("Retourne 0", "Lance NullPointerException", "Retourne null", "Échoue à compiler"), 2,
                    "?. retourne null si l'élément est null. Cela NE PLANTE PAS, c'est un appel sécurisé."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "À quoi sert !! ?",
                    "", listOf("Nier un booléen", "Forcer non-null (peut planter)", "Comparer", "Commenter"), 1,
                    "!! convertit un type nullable en type non-null. S'il était null, il lance une NullPointerException."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Marquez le type comme nullable :",
                    "var pseudo: String??? = null",
                    listOf("?", "!", "$", "@"), 0,
                    "Le ? après le type le rend nullable : String? peut être null ou un String.")
            )
        ),

        Lesson(
            id = "kt_1_3",
            language = "Kotlin",
            unitNumber = 1,
            title = "Outil de String (Templates)",
            theoryText = """
                Kotlin a un moyen élégant d'interpoler des variables dans les chaînes de caractères.
                
                🔹 ${'$'}variable : insère une variable simple
                🔹 ${'$'}{expression} : insère une expression complexe
                🔹 Fonctionne à l'intérieur de \"...\" (pas dans '...')
                🔹 Plus lisible que le + en Java
            """.trimIndent(),
            codeExample = """
                val nom = "Ana"
                val age = 25
                
                println("Bonjour ${'$'}nom")              // Bonjour Ana
                println("Tu as ${'$'}age ans")   // Tu as 25 ans
                println("L'an prochain : ${'$'}{age+1}")      // 26
            """.trimIndent(),
            xpReward = 25,
            exercises = listOf(
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "Qu'est-ce qui est affiché ?\nval x = 5\nprintln(\"x est \$x\")",
                    "", listOf("x est 5", "x est \$x", "5", "Erreur"), 0,
                    "\$x interpole la valeur de x → 'x est 5'."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Affichez le double de n en utilisant un template String :",
                    "val n = 4\nprintln(\"Double : \${'$'}???\")",
                    listOf("n*2", "{n*2}", "n*2}", "{n*2"), 1,
                    "Pour les expressions, on utilise \${...}. Seul \$n fonctionne pour les variables simples."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "Comment concaténer des chaînes en Kotlin ?",
                    "", listOf("Seulement avec +", "Seulement avec des templates", "Avec + ET avec des templates", "Avec concat()"), 2,
                    "Vous pouvez utiliser + (\"Bonjour \" + nom) ou des templates (\"Bonjour \$nom\")."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "Qu'est-ce qui est affiché ?\nval p = \"Monde\"\nprintln(\"Bonjour, \$p!\")",
                    "", listOf("Bonjour, Monde!", "Bonjour, \$p!", "Bonjour, p!", "Erreur"), 0,
                    "\$p est remplacé par la valeur 'Monde'.")
            )
        )
    )
}
