package com.exemple.codegym.data.lessons

import com.exemple.codegym.models.ExerciseType
import com.exemple.codegym.models.Lesson
import com.exemple.codegym.models.LessonExercise

/**
 * Lecciones de Kotlin: 10 lecciones por unidades.
 */
object KotlinLessons {

    val lessons: List<Lesson> = listOf(

        // ============ UNIDAD 1: KOTLIN BÁSICO ============

        Lesson(
            id = "kt_1_1",
            language = "Kotlin",
            unitNumber = 1,
            title = "val vs var",
            theoryText = """
                En Kotlin tienes 2 formas de declarar variables:
                
                🔹 val: variable INMUTABLE (constante). Una vez asignada no se puede cambiar.
                🔹 var: variable mutable (puede cambiar).
                
                💡 Usa val siempre que puedas, var solo cuando NECESITES cambiar el valor.
            """.trimIndent(),
            codeExample = """
                val nombre = "Ana"      // No se puede reasignar
                var edad = 25           // Sí se puede reasignar
                
                edad = 26               // ✅ OK
                // nombre = "Luis"      // ❌ ERROR
            """.trimIndent(),
            xpReward = 20,
            exercises = listOf(
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "¿Cuál permite cambiar el valor después?",
                    "", listOf("val x = 5", "var x = 5", "const x = 5", "let x = 5"), 1,
                    "var es mutable, val es inmutable."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Declara una constante PI inmutable:",
                    "??? PI = 3.14159",
                    listOf("var", "val", "let", "const"), 1,
                    "val es para constantes inmutables en Kotlin."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "¿Es necesario declarar el tipo SIEMPRE en Kotlin?",
                    "", listOf("Sí, siempre", "No, lo infiere del valor", "Solo para Int", "Solo para String"), 1,
                    "Kotlin infiere el tipo del valor que asignas. val x = 5 → Int."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Declara x explícitamente como Int:",
                    "val x: ??? = 10",
                    listOf("int", "Int", "Integer", "Number"), 1,
                    "En Kotlin el tipo Int va con I mayúscula."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "¿Compila esto?\nval x = 5\nx = 10",
                    "", listOf("Sí, x ahora vale 10", "No, val es inmutable", "Solo en runtime", "Sí pero da warning"), 1,
                    "val no se puede reasignar. Habría que usar var.")
            )
        ),

        Lesson(
            id = "kt_1_2",
            language = "Kotlin",
            unitNumber = 1,
            title = "Null Safety",
            theoryText = """
                Kotlin previene en compilación los famosos NullPointerException.
                
                🔹 Por defecto las variables NO pueden ser null
                🔹 ? al tipo permite null: String?
                🔹 ?. accede de forma segura
                🔹 ?: operador Elvis: valor por defecto si es null
                🔹 !! fuerza no-null (peligroso, puede crashear)
            """.trimIndent(),
            codeExample = """
                var nombre: String = "Ana"
                // nombre = null             // ❌ ERROR
                
                var apodo: String? = "Anita"
                apodo = null                  // ✅ OK
                
                val len = apodo?.length ?: 0   // 0 si null
            """.trimIndent(),
            xpReward = 30,
            exercises = listOf(
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "¿Cuál PUEDE ser null?",
                    "", listOf("val x: Int = 5", "var y: String = \"\"", "var z: String? = null", "val w: Boolean = true"), 2,
                    "El ? después del tipo (String?) marca que puede ser null."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Imprime 'sin nombre' si name es null:",
                    "val name: String? = null\nprintln(name ??? \"sin nombre\")",
                    listOf("?:", "?.", "!!", "??"), 0,
                    "?: es el operador Elvis: usa el valor derecho si el izquierdo es null."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "¿Qué hace nombre?.length si nombre es null?",
                    "", listOf("Devuelve 0", "Lanza NullPointerException", "Devuelve null", "No compila"), 2,
                    "?. devuelve null si el receptor es null. NO crashea, eso es safe call."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "¿Para qué sirve !!?",
                    "", listOf("Negar el booleano", "Forzar no-null (puede crashear)", "Comparar", "Comentario"), 1,
                    "!! convierte un tipo nullable a no-null. Si era null, lanza NullPointerException."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Marca el tipo como nullable:",
                    "var apodo: String??? = null",
                    listOf("?", "!", "$", "@"), 0,
                    "El ? después del tipo lo hace nullable: String? puede ser null o String.")
            )
        ),

        Lesson(
            id = "kt_1_3",
            language = "Kotlin",
            unitNumber = 1,
            title = "String Templates",
            theoryText = """
                Kotlin tiene una forma elegante de interpolar variables en strings.
                
                🔹 ${'$'}variable: inserta una variable simple
                🔹 ${'$'}{expresión}: inserta una expresión
                🔹 Funciona dentro de "..." (no en '...')
                🔹 Más legible que el + de Java
            """.trimIndent(),
            codeExample = """
                val nombre = "Ana"
                val edad = 25
                
                println("Hola ${'$'}nombre")              // Hola Ana
                println("Tienes ${'$'}edad años")         // Tienes 25 años
                println("El año que viene: ${'$'}{edad+1}") // 26
            """.trimIndent(),
            xpReward = 25,
            exercises = listOf(
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "¿Qué imprime?\nval x = 5\nprintln(\"x vale \$x\")",
                    "", listOf("x vale 5", "x vale \$x", "5", "Error"), 0,
                    "\$x interpola el valor de x → 'x vale 5'."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Imprime el doble de n usando string template:",
                    "val n = 4\nprintln(\"Doble: \${'$'}???\")",
                    listOf("n*2", "{n*2}", "n*2}", "{n*2"), 1,
                    "Para expresiones se usa \${...}. Solo \$n vale para variables simples."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "¿Cómo concatenas en Kotlin?",
                    "", listOf("Solo con +", "Solo con templates", "Con + Y con templates", "Con concat()"), 2,
                    "Puedes usar + (\"Hola \" + nombre) o templates (\"Hola \$nombre\")."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "¿Qué imprime?\nval p = \"Mundo\"\nprintln(\"Hola, \$p!\")",
                    "", listOf("Hola, Mundo!", "Hola, \$p!", "Hola, p!", "Error"), 0,
                    "\$p se sustituye por el valor 'Mundo'."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Crea un mensaje con la longitud del nombre:",
                    "val n = \"Ana\"\nval msg = \"Tiene \${'$'}??? letras\"",
                    listOf("n.length", "{n.length}", "n.size", "len(n)"), 1,
                    "Para llamar a propiedades como .length necesitas \${} alrededor.")
            )
        ),

        // ============ UNIDAD 2: CONTROL DE FLUJO ============

        Lesson(
            id = "kt_2_1",
            language = "Kotlin",
            unitNumber = 2,
            title = "if y when",
            theoryText = """
                Kotlin tiene if/else como Java pero también el potente when.
                
                🔹 if puede DEVOLVER valor (es una expresión)
                🔹 when es como switch pero más potente
                🔹 when admite rangos (in 1..10), tipos (is String), etc.
            """.trimIndent(),
            codeExample = """
                val edad = 18
                
                // if como expresión
                val mensaje = if (edad >= 18) "Adulto" else "Menor"
                
                // when
                val nota = 7
                val texto = when {
                    nota >= 9 -> "Sobresaliente"
                    nota >= 7 -> "Notable"
                    nota >= 5 -> "Aprobado"
                    else      -> "Suspenso"
                }
            """.trimIndent(),
            xpReward = 30,
            exercises = listOf(
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "¿Cuál es el equivalente Kotlin de switch?",
                    "", listOf("case", "switch", "when", "match"), 2,
                    "when es el switch mejorado de Kotlin."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Asigna 'mayor' si x>0 y 'menor' si no:",
                    "val r = ??? (x > 0) \"mayor\" else \"menor\"",
                    listOf("when", "if", "switch", "case"), 1,
                    "if puede usarse como expresión que devuelve un valor."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "¿Qué imprime?\nval n = 3\nval r = when(n) {\n  1->\"uno\"\n  2->\"dos\"\n  else->\"otro\"\n}\nprintln(r)",
                    "", listOf("uno", "dos", "otro", "Error"), 2,
                    "n es 3, no coincide con 1 ni 2, entra en else → 'otro'."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "¿Qué hace 'in 1..10' en when?",
                    "", listOf("Compara con la cadena \"1..10\"", "Comprueba si está en el rango 1 a 10", "Itera del 1 al 10", "Crea una lista"), 1,
                    "in 1..10 comprueba si el valor está entre 1 y 10 (inclusive)."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Comprueba si x es String:",
                    "when (x) {\n    ??? String -> println(\"texto\")\n}",
                    listOf("is", "as", "in", "type"), 0,
                    "is comprueba el tipo. También sirve para smart cast.")
            )
        ),

        Lesson(
            id = "kt_2_2",
            language = "Kotlin",
            unitNumber = 2,
            title = "Bucles y rangos",
            theoryText = """
                Kotlin tiene bucles for, while y rangos potentes.
                
                🔹 for (i in 1..10): rango cerrado [1,10]
                🔹 for (i in 1 until 10): semiabierto [1,10)
                🔹 for (i in 10 downTo 1): descendente
                🔹 for (i in 1..10 step 2): salto de 2
                🔹 for (item in lista): iterar lista
            """.trimIndent(),
            codeExample = """
                for (i in 1..3) print(i)        // 123
                for (i in 1 until 3) print(i)   // 12
                for (i in 3 downTo 1) print(i)  // 321
                for (i in 1..10 step 2) print(i) // 13579
                
                val nums = listOf(10, 20, 30)
                for (n in nums) println(n)
            """.trimIndent(),
            xpReward = 30,
            exercises = listOf(
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "¿Cuántas iteraciones hace for(i in 1..5)?",
                    "", listOf("4", "5", "6", "1"), 1,
                    ".. es rango inclusivo: 1,2,3,4,5 → 5 iteraciones."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Itera del 0 al 9 (sin incluir el 10):",
                    "for (i in 0 ??? 10) { println(i) }",
                    listOf("..", "until", "to", "downTo"), 1,
                    "until crea un rango semiabierto [0,10): incluye 0, no incluye 10."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "¿Qué imprime for (i in 5 downTo 1) print(i)?",
                    "", listOf("12345", "54321", "123450", "Error"), 1,
                    "downTo va en orden descendente: 5,4,3,2,1."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "¿Qué imprime for (i in 1..10 step 3) print(i)?",
                    "", listOf("1471", "147", "12345678910", "13579"), 1,
                    "step 3 salta de 3 en 3: 1,4,7 (10 no entra)."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Itera sobre cada elemento de la lista:",
                    "val l = listOf(1,2,3)\nfor (x ??? l) print(x)",
                    listOf("of", "in", "from", "at"), 1,
                    "for (x in lista) recorre cada elemento.")
            )
        ),

        // ============ UNIDAD 3: FUNCIONES ============

        Lesson(
            id = "kt_3_1",
            language = "Kotlin",
            unitNumber = 3,
            title = "Funciones y lambdas",
            theoryText = """
                Las funciones en Kotlin son potentes y concisas.
                
                🔹 fun nombre(parámetros): TipoRetorno
                🔹 Si solo es 1 expresión, puedes usar = en lugar de { return ... }
                🔹 Lambdas: { parámetro -> expresión }
                🔹 Parámetros con valor por defecto y named arguments
            """.trimIndent(),
            codeExample = """
                fun saludar(nombre: String): String {
                    return "Hola ${'$'}nombre"
                }
                
                // Forma corta (single expression)
                fun doble(x: Int): Int = x * 2
                
                // Con default
                fun greet(name: String = "Anónimo") = "Hola ${'$'}name"
                
                // Lambda
                val sumar = { a: Int, b: Int -> a + b }
                println(sumar(3, 5))   // 8
            """.trimIndent(),
            xpReward = 35,
            exercises = listOf(
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "¿Qué palabra define una función en Kotlin?",
                    "", listOf("def", "function", "fun", "func"), 2,
                    "Kotlin usa 'fun' (proviene de 'function')."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Define una función que devuelva el cuadrado:",
                    "fun cuadrado(x: Int): Int ??? x * x",
                    listOf(":", "=", "->", "return"), 1,
                    "Para single expression functions se usa = en lugar de cuerpo con {}."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "¿Qué devuelve una función con tipo de retorno Unit?",
                    "", listOf("0", "null", "Nada (void)", "Una cadena vacía"), 2,
                    "Unit equivale a void en Java: la función no devuelve nada."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Crea una lambda que multiplique por 3:",
                    "val triple = { n: Int ??? n * 3 }",
                    listOf(":", "=", "->", "=>"), 2,
                    "Las lambdas usan -> para separar parámetros del cuerpo."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "¿Qué imprime?\nfun saluda(n: String = \"Pepe\") = \"Hola \$n\"\nprintln(saluda())",
                    "", listOf("Hola", "Hola Pepe", "Error", "null"), 1,
                    "Sin argumentos, usa el valor por defecto 'Pepe'.")
            )
        ),

        // ============ UNIDAD 4: CLASES ============

        Lesson(
            id = "kt_4_1",
            language = "Kotlin",
            unitNumber = 4,
            title = "Clases y data classes",
            theoryText = """
                Kotlin simplifica enormemente la creación de clases.
                
                🔹 class Nombre(parámetros) crea constructor primario
                🔹 data class añade automáticamente equals(), hashCode(), toString(), copy()
                🔹 Las propiedades pueden ser val (inmutables) o var
                🔹 Los métodos van dentro de { }
            """.trimIndent(),
            codeExample = """
                // Clase normal
                class Persona(val nombre: String, var edad: Int) {
                    fun saludar() = "Hola, soy ${'$'}nombre"
                }
                
                // Data class (genera equals/hashCode/toString/copy)
                data class Punto(val x: Int, val y: Int)
                
                val p1 = Punto(1, 2)
                val p2 = p1.copy(y = 10)   // Punto(1, 10)
                println(p1 == Punto(1,2))  // true (gracias a equals)
            """.trimIndent(),
            xpReward = 40,
            exercises = listOf(
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "¿Qué genera AUTOMÁTICAMENTE una data class?",
                    "", listOf("Solo el constructor", "equals/hashCode/toString/copy", "Solo getters", "Nada extra"), 1,
                    "Las data class generan estos 4 métodos automáticamente, ahorrando muchísimo código."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Declara una data class Libro con título y páginas:",
                    "??? class Libro(val titulo: String, val paginas: Int)",
                    listOf("data", "class", "value", "static"), 0,
                    "El modificador 'data' antes de class la convierte en data class."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "¿Qué hace .copy() en una data class?",
                    "", listOf("Copia la referencia", "Crea una nueva instancia idéntica", "Borra el objeto", "Lo convierte a String"), 1,
                    ".copy() crea una nueva instancia. Puedes cambiar campos: p.copy(x = 5)."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "¿Cuántos parámetros mínimos necesita una data class?",
                    "", listOf("0", "1", "2", "Da igual"), 1,
                    "Una data class debe tener al menos 1 parámetro en su constructor primario."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Crea una instancia de Punto(3, 4):",
                    "data class Punto(val x: Int, val y: Int)\nval p = ???",
                    listOf("new Punto(3,4)", "Punto(3,4)", "Punto.new(3,4)", "Punto{3,4}"), 1,
                    "En Kotlin no se usa 'new'. Solo NombreClase(args).")
            )
        ),

        Lesson(
            id = "kt_4_2",
            language = "Kotlin",
            unitNumber = 4,
            title = "Herencia e interfaces",
            theoryText = """
                Por defecto las clases en Kotlin son FINAL (no heredables). Para permitir herencia hay que abrirlas con 'open'.
                
                🔹 open class: clase que se puede heredar
                🔹 : ClaseBase() para heredar
                🔹 override para sobreescribir métodos
                🔹 interface: contrato que pueden implementar varias clases
            """.trimIndent(),
            codeExample = """
                open class Animal(val nombre: String) {
                    open fun sonido() = "..."
                }
                
                class Perro(nombre: String) : Animal(nombre) {
                    override fun sonido() = "Guau"
                }
                
                interface Saludable {
                    fun saludar(): String
                }
                
                class Persona : Saludable {
                    override fun saludar() = "Hola"
                }
            """.trimIndent(),
            xpReward = 40,
            exercises = listOf(
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "Por defecto, las clases en Kotlin son...",
                    "", listOf("abstractas", "abiertas", "finales (no heredables)", "públicas"), 2,
                    "Por defecto son final. Hay que añadir 'open' para que se puedan heredar."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Permite que esta clase pueda heredarse:",
                    "??? class Vehiculo",
                    listOf("public", "open", "abstract", "final"), 1,
                    "open hace una clase heredable en Kotlin."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "¿Qué palabra clave indica que sobreescribes un método?",
                    "", listOf("super", "override", "extends", "implements"), 1,
                    "override antes del método indica que sobreescribe uno de la clase padre."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "¿Una clase Kotlin puede heredar de varias?",
                    "", listOf("Sí, ilimitadas", "Sí, hasta 2", "No, solo de UNA clase", "Solo si son data class"), 2,
                    "Solo herencia simple (1 clase). Pero puede implementar VARIAS interfaces."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Implementa la interfaz Cantante:",
                    "interface Cantante { fun cantar() }\nclass Artista ??? Cantante {\n  override fun cantar() = \"♪\"\n}",
                    listOf("extends", ":", "implements", "with"), 1,
                    "En Kotlin se usa : tanto para herencia como para implementar interfaces.")
            )
        ),

        // ============ UNIDAD 5: AVANZADO ============

        Lesson(
            id = "kt_5_1",
            language = "Kotlin",
            unitNumber = 5,
            title = "Funciones de colecciones",
            theoryText = """
                Kotlin tiene una API funcional súper poderosa para colecciones.
                
                🔹 .filter { }: filtrar elementos
                🔹 .map { }: transformar cada elemento
                🔹 .forEach { }: ejecutar acción
                🔹 .sumOf { }: sumar valores
                🔹 Encadenables: nums.filter{...}.map{...}.sum()
            """.trimIndent(),
            codeExample = """
                val nums = listOf(1, 2, 3, 4, 5)
                
                val pares = nums.filter { it % 2 == 0 }
                // [2, 4]
                
                val dobles = nums.map { it * 2 }
                // [2, 4, 6, 8, 10]
                
                val sumaPares = nums
                    .filter { it % 2 == 0 }
                    .sumOf { it }
                // 6 (2+4)
            """.trimIndent(),
            xpReward = 45,
            exercises = listOf(
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "¿Qué hace .filter { it > 5 }?",
                    "", listOf("Elimina elementos > 5", "Devuelve solo los > 5", "Suma los > 5", "Cuenta los > 5"), 1,
                    "filter devuelve una nueva lista con los elementos que cumplen la condición."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Multiplica cada número por 10:",
                    "val l = listOf(1,2,3)\nval r = l.???{ it * 10 }",
                    listOf("filter", "map", "forEach", "fold"), 1,
                    "map transforma cada elemento aplicando la lambda."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "¿Qué es 'it' dentro de una lambda de un solo parámetro?",
                    "", listOf("Una palabra reservada", "Nombre implícito del parámetro", "Iterador", "El índice"), 1,
                    "Cuando la lambda tiene un solo parámetro, Kotlin lo llama 'it' implícitamente."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "¿Qué devuelve listOf(1,2,3).sum()?",
                    "", listOf("3", "6", "[1,2,3]", "Error"), 1,
                    ".sum() suma todos los elementos: 1+2+3 = 6."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Cuenta cuántos números son mayores que 10:",
                    "val l = listOf(5,12,8,15)\nval c = l.???{ it > 10 }",
                    listOf("filter", "count", "any", "all"), 1,
                    "count() con condición devuelve cuántos cumplen el predicado.")
            )
        ),

        Lesson(
            id = "kt_5_2",
            language = "Kotlin",
            unitNumber = 5,
            title = "Corrutinas (suspend)",
            theoryText = """
                Las corrutinas permiten ejecutar código asíncrono de forma SECUENCIAL y legible.
                
                🔹 suspend fun: función que puede pausarse
                🔹 Solo se llaman desde otra suspend o desde un scope
                🔹 launch { }: inicia una corrutina (fire-and-forget)
                🔹 async { } + .await(): para tareas con resultado
                🔹 Reemplazan a callbacks y promises
            """.trimIndent(),
            codeExample = """
                suspend fun cargarDatos(): String {
                    delay(1000)   // espera 1 seg sin bloquear
                    return "Datos OK"
                }
                
                // Llamar desde un scope
                lifecycleScope.launch {
                    val datos = cargarDatos()  // sin bloquear
                    println(datos)
                }
            """.trimIndent(),
            xpReward = 50,
            exercises = listOf(
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "¿Qué modificador convierte una función en suspend?",
                    "", listOf("async", "suspend", "await", "coroutine"), 1,
                    "El modificador 'suspend' marca una función como suspendible."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Define una función suspend:",
                    "??? fun cargar(): String { delay(500); return \"OK\" }",
                    listOf("async", "await", "suspend", "launch"), 2,
                    "suspend va antes de fun para hacerla suspendible."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "¿Desde dónde se puede llamar una función suspend?",
                    "", listOf("Desde cualquier sitio", "Solo desde otra suspend o coroutine scope", "Solo desde main()", "Solo desde lambdas"), 1,
                    "Las suspend solo se pueden invocar desde otro contexto suspend o un scope (launch/async)."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "¿Qué hace launch { }?",
                    "", listOf("Crea un thread", "Inicia una corrutina sin retornar valor", "Espera un resultado", "Bloquea el main"), 1,
                    "launch inicia una corrutina fire-and-forget. Para resultado se usa async/await."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Pausa la corrutina 2 segundos:",
                    "suspend fun esperar() { ???(2000) }",
                    listOf("sleep", "delay", "wait", "pause"), 1,
                    "delay() es la versión suspendible de Thread.sleep, no bloquea el hilo.")
            )
        )
    )
}