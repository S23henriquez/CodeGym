package com.exemple.codegym.data.lessons_i18n.en

import android.R.attr.name
import com.exemple.codegym.models.ExerciseType
import com.exemple.codegym.models.Lesson
import com.exemple.codegym.models.LessonExercise

object KotlinLessonsEn {

    val lessons: List<Lesson> = listOf(

        // ============ UNIT 1: BASIC KOTLIN ============

        Lesson(
            id = "kt_1_1",
            language = "Kotlin",
            unitNumber = 1,
            title = "val vs var",
            theoryText = """
                In Kotlin there are 2 main ways to declare variables:
                
                🔹 val: IMMUTABLE variable (constant). Once assigned, it cannot be changed.
                🔹 var: mutable variable (can be changed).
                
                💡 Use val whenever possible, use var only when you NEED to change the value.
            """.trimIndent(),
            codeExample = """
                val name = "Ana"      // Cannot be reassigned
                var age = 25          // Can be reassigned
                
                age = 26              // ✅ OK
                // name = "Luis"      // ❌ ERROR
            """.trimIndent(),
            xpReward = 20,
            exercises = listOf(
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "Which one allows changing the value later?",
                    "", listOf("val x = 5", "var x = 5", "const x = 5", "let x = 5"), 1,
                    "var is mutable, val is immutable."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Declare an immutable PI constant:",
                    "??? PI = 3.14159",
                    listOf("var", "val", "let", "const"), 1,
                    "val is used for immutable constants in Kotlin."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "Is it ALWAYS necessary to declare the type in Kotlin?",
                    "", listOf("Yes, always", "No, it infers it from the value", "Only for Ints", "Only for Strings"), 1,
                    "Kotlin infers the type from the value you assign. val x = 5 → Int."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Declare x explicitly as an Int:",
                    "val x: ??? = 10",
                    listOf("int", "Int", "Integer", "Number"), 1,
                    "In Kotlin, the type Int starts with a capital 'I'."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "Does this compile?\nval x = 5\nx = 10",
                    "", listOf("Yes, x is now 10", "No, val is immutable", "Only at runtime", "Yes but gives a warning"), 1,
                    "val cannot be reassigned. You would need to use var.")
            )
        ),

        Lesson(
            id = "kt_1_2",
            language = "Kotlin",
            unitNumber = 1,
            title = "Null Safety",
            theoryText = """
                Kotlin prevents famous NullPointerExceptions at compile time.
                
                🔹 By default variables CANNOT be null
                🔹 ? at the end of the type allows null: String?
                🔹 ?. accesses safely
                🔹 ?: Elvis operator: default value if it is null
                🔹 !! forces non-null (dangerous, can crash)
            """.trimIndent(),
            codeExample = """
                var name: String = "Ana"
                // name = null               // ❌ ERROR
                
                var nickname: String? = "Anita"
                nickname = null               // ✅ OK
                
                val len = nickname?.length ?: 0   // 0 if null
            """.trimIndent(),
            xpReward = 30,
            exercises = listOf(
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "Which of these CAN be null?",
                    "", listOf("val x: Int = 5", "var y: String = \"\"", "var z: String? = null", "val w: Boolean = true"), 2,
                    "The ? after the type (String?) indicates it can be null."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Print 'no name' if name is null:",
                    "val name: String? = null\nprintln(name ??? \"no name\")",
                    listOf("?:", "?.", "!!", "??"), 0,
                    "?: is the Elvis operator: uses the right value if the left is null."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "What does name?.length do if name is null?",
                    "", listOf("Returns 0", "Throws NullPointerException", "Returns null", "Fails to compile"), 2,
                    "?. returns null if the receiver is null. It DOES NOT crash, this is a safe call."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "What is !! used for?",
                    "", listOf("Negate boolean", "Force non-null (can crash)", "Compare", "Comment"), 1,
                    "!! casts a nullable type to a non-null type. If it was null, it throws a NullPointerException."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Mark the type as nullable:",
                    "var nickname: String??? = null",
                    listOf("?", "!", "$", "@"), 0,
                    "The ? after the type makes it nullable: String? can be null or a String.")
            )
        ),

        Lesson(
            id = "kt_1_3",
            language = "Kotlin",
            unitNumber = 1,
            title = "String Templates",
            theoryText = """
                Kotlin has an elegant way to interpolate variables into strings.
                
                🔹 ${'$'}variable: inserts a simple variable
                🔹 ${'$'}{expression}: inserts an expression
                🔹 Works inside "..." (not in '...')
                🔹 More readable than Java's +
            """.trimIndent(),
            codeExample = """
                val name = "Ana"
                val age = 25
                
                println("Hello ${'$'}name")              // Hello Ana
                println("You are ${'$'}age years old")   // You are 25 years old
                println("Next year: ${'$'}{age+1}")      // 26
            """.trimIndent(),
            xpReward = 25,
            exercises = listOf(
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "What is printed?\nval x = 5\nprintln(\"x is \$x\")",
                    "", listOf("x is 5", "x is \$x", "5", "Error"), 0,
                    "\$x interpolates the value of x → 'x is 5'."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Print double the value of n using a string template:",
                    "val n = 4\nprintln(\"Double: \${'$'}???\")",
                    listOf("n*2", "{n*2}", "n*2}", "{n*2"), 1,
                    "For expressions, \${...} is used. Only \$n works for simple variables."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "How do you concatenate strings in Kotlin?",
                    "", listOf("Only with +", "Only with templates", "With + AND with templates", "With concat()"), 2,
                    "You can use + (\"Hello \" + name) or templates (\"Hello \$name\")."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "What does this print?\nval p = \"World\"\nprintln(\"Hello, \$p!\")",
                    "", listOf("Hello, World!", "Hello, \$p!", "Hello, p!", "Error"), 0,
                    "\$p is substituted by the value 'World'."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Create a message with the length of the name:",
                    "val n = \"Ana\"\nval msg = \"Has \${'$'}??? letters\"",
                    listOf("n.length", "{n.length}", "n.size", "len(n)"), 1,
                    "To call properties like .length you need \${} around the expression.")
            )
        ),

        // ============ UNIT 2: CONTROL FLOW ============

        Lesson(
            id = "kt_2_1",
            language = "Kotlin",
            unitNumber = 2,
            title = "if and when",
            theoryText = """
                Kotlin has if/else just like Java, but also the powerful when keyword.
                
                🔹 if can RETURN a value (it is an expression)
                🔹 when is like switch but more powerful
                🔹 when supports ranges (in 1..10), types (is String), etc.
            """.trimIndent(),
            codeExample = """
                val age = 18
                
                // if as an expression
                val msg = if (age >= 18) "Adult" else "Minor"
                
                // when
                val grade = 7
                val text = when {
                    grade >= 9 -> "Excellent"
                    grade >= 7 -> "Good"
                    grade >= 5 -> "Pass"
                    else       -> "Fail"
                }
            """.trimIndent(),
            xpReward = 30,
            exercises = listOf(
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "What is Kotlin's equivalent of a switch statement?",
                    "", listOf("case", "switch", "when", "match"), 2,
                    "when is the improved switch in Kotlin."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Assign 'greater' if x>0 and 'smaller' if not:",
                    "val r = ??? (x > 0) \"greater\" else \"smaller\"",
                    listOf("when", "if", "switch", "case"), 1,
                    "if can be used as an expression that returns a value."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "What symbol separates the condition from the result in a when statement?",
                    "", listOf(":", "->", "=>", "="), 1,
                    "Kotlin uses -> (arrow) to separate condition and body in when."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "What acts as the 'default' case in a when statement?",
                    "", listOf("default", "else", "other", "any"), 1,
                    "else is used if none of the previous conditions matched."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Check if the number is between 1 and 10:",
                    "when (x) {\n    ??? 1..10 -> println(\"Yes\")\n}",
                    listOf("in", "on", "is", "between"), 0,
                    "The keyword 'in' is used to check if a value is inside a range (like 1..10).")
            )
        ),

        Lesson(
            id = "kt_2_2",
            language = "Kotlin",
            unitNumber = 2,
            title = "for and ranges",
            theoryText = """
                Loops in Kotlin are mainly done via for and ranges.
                
                🔹 for (i in 1..5) → iterates from 1 to 5 inclusive
                🔹 until → does not include the last number (1 until 5)
                🔹 downTo → goes backwards (5 downTo 1)
                🔹 step → jumps (1..10 step 2)
            """.trimIndent(),
            codeExample = """
                // 1, 2, 3
                for (i in 1..3) println(i)
                
                // 0, 1, 2 (Excludes 3, useful for indices)
                for (i in 0 until 3) println(i)
                
                // 10, 8, 6, 4, 2
                for (i in 10 downTo 1 step 2) println(i)
            """.trimIndent(),
            xpReward = 30,
            exercises = listOf(
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "How many times does for(i in 1..3) iterate?",
                    "", listOf("2", "3", "4", "Error"), 1,
                    "The .. operator creates an inclusive range. It iterates for 1, 2, and 3."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Iterate to 5 but NOT including 5:",
                    "for (i in 0 ??? 5) { }",
                    listOf("until", "to", "..", "downTo"), 0,
                    "until is used to create a range that excludes the upper limit."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "How do you loop backwards from 5 to 1?",
                    "", listOf("5..1", "1..5 down", "5 downTo 1", "5 reverse 1"), 2,
                    "downTo is the keyword to make decreasing ranges."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "What does step 2 do in a loop?",
                    "", listOf("Ends after 2 steps", "Jumps by 2", "Adds 2 to the total", "Ignores 2"), 1,
                    "step specifies the increment amount between elements in the progression."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Loop items in a list:",
                    "val list = listOf(\"A\", \"B\")\nfor (item ??? list) { }",
                    listOf(":", "in", "of", "from"), 1,
                    "The keyword 'in' is used both for ranges and to iterate over collections.")
            )
        ),

        // ============ UNIT 3: FUNCTIONS ============

        Lesson(
            id = "kt_3_1",
            language = "Kotlin",
            unitNumber = 3,
            title = "Functions",
            theoryText = """
                Functions are declared with fun.
                
                🔹 fun name(param: Type): ReturnType { ... }
                🔹 If it doesn't return anything, you can omit Unit (like void)
                🔹 Default values: fun greet(name: String = "Guest")
                🔹 Named arguments: greet(name = "Ana")
            """.trimIndent(),
            codeExample = """
                fun add(a: Int, b: Int): Int {
                    return a + b
                }
                
                // Single expression function
                fun double(x: Int) = x * 2
                
                fun greet(name: String = "User") {
                    println("Hello \$name")
                }
            """.trimIndent(),
            xpReward = 35,
            exercises = listOf(
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "Which keyword declares a function in Kotlin?",
                    "", listOf("function", "def", "fun", "void"), 2,
                    "In Kotlin, functions are declared using 'fun'."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Declare the return type as String:",
                    "fun getName()??? String { return \"Ana\" }",
                    listOf("->", ":", "as", "="), 1,
                    "The return type is specified after a colon (:)."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "If a function doesn’t return anything, what is its explicit return type in Kotlin?",
                    "", listOf("void", "null", "Unit", "Empty"), 2,
                    "Unit is Kotlin's equivalent of Java's void. It can be omitted."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "Can you assign a default value to a parameter?",
                    "", listOf("No, never", "Yes, using =", "Only for Ints", "Yes, using default:"), 1,
                    "Yes, like this: fun f(x: Int = 0)"),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Create a single-expression function:",
                    "fun square(x: Int) ??? x * x",
                    listOf(":", "->", "=", "return"), 2,
                    "If the function is a single expression, you can use = and omit braces/return.")
            )
        ),

        // ============ UNIT 4: OOP ============

        Lesson(
            id = "kt_4_1",
            language = "Kotlin",
            unitNumber = 4,
            title = "Classes and Data Classes",
            theoryText = """
                Kotlin heavily simplifies Object Oriented Programming.
                
                🔹 class User(val name: String, var age: Int) -> creates class, constructor and properties in 1 line.
                🔹 data class: automatically generates equals(), hashCode(), toString() and copy(). Perfect for storing info.
            """.trimIndent(),
            codeExample = """
                class Person(val name: String) {
                    fun sayHi() = "Hello, I'm \$name"
                }
                
                // Super powerful: data class
                data class User(val id: Int, val name: String)
                
                val u1 = User(1, "Ana")
                val u2 = u1.copy(name = "Maria") // clones but changes name
            """.trimIndent(),
            xpReward = 40,
            exercises = listOf(
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "How do you define the primary constructor in Kotlin?",
                    "", listOf("Inside a constructor() block", "Next to the class name", "It doesn't exist", "With init{}"), 1,
                    "It goes in the class header: class Person(val name: String)"),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Create an informational class that auto-generates equals() and toString():",
                    "??? class Product(val id: String)",
                    listOf("data", "info", "struct", "model"), 0,
                    "data class is used in Kotlin to represent objects that only store data."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "What does the copy() method of a data class do?",
                    "", listOf("Inherits the class", "Creates a new copy modifying some values", "Prints the object", "Nothing"), 1,
                    "copy() clones the object allowing you to alter some of its properties on the fly."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "Do I need to use 'new' to create an object in Kotlin?",
                    "", listOf("Yes, always", "No, 'new' does not exist in Kotlin", "Only for data classes", "Only if it is null"), 1,
                    "In Kotlin you just call the constructor directly: val p = Person()"),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Add an initialization block (runs when creating the object):",
                    "class Car { \n  ??? {\n    println(\"Created!\")\n  }\n}",
                    listOf("start", "init", "create", "constructor"), 1,
                    "The init { ... } block executes during object construction.")
            )
        ),

        Lesson(
            id = "kt_4_2",
            language = "Kotlin",
            unitNumber = 4,
            title = "Inheritance and Interfaces",
            theoryText = """
                By default, classes in Kotlin are final (they cannot be inherited).
                
                🔹 You must use the word 'open' to allow inheritance
                🔹 Use : to inherit or implement
                🔹 override is a mandatory keyword, not an annotation like in Java
            """.trimIndent(),
            codeExample = """
                open class Animal {
                    open fun sound() = "..."
                }
                
                class Dog : Animal() {
                    // MUST use override keyword
                    override fun sound() = "Woof"
                }
                
                interface Healthy {
                    fun greet(): String
                }
                
                class Persona : Healthy {
                    override fun greet() = "Hello"
                }
            """.trimIndent(),
            xpReward = 40,
            exercises = listOf(
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "By default, classes in Kotlin are...",
                    "", listOf("abstract", "open", "final (not inheritable)", "public"), 2,
                    "By default they are final. You need to add 'open' to make them inheritable."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Allow this class to be inherited:",
                    "??? class Vehicle",
                    listOf("public", "open", "abstract", "final"), 1,
                    "open makes a class inheritable in Kotlin."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "Which keyword indicates that you are overriding a method?",
                    "", listOf("super", "override", "extends", "implements"), 1,
                    "override before the method indicates it overwrites a parent class method."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "Can a Kotlin class inherit from multiple classes?",
                    "", listOf("Yes, unlimited", "Yes, up to 2", "No, only from ONE class", "Only if they are data classes"), 2,
                    "Only single class inheritance. But it can implement MULTIPLE interfaces."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Implement the Singer interface:",
                    "interface Singer { fun sing() }\nclass Artist ??? Singer {\n  override fun sing() = \"♪\"\n}",
                    listOf("extends", ":", "implements", "with"), 1,
                    "In Kotlin, : is used for both inheritance and implementing interfaces.")
            )
        ),

        // ============ UNIT 5: ADVANCED ============

        Lesson(
            id = "kt_5_1",
            language = "Kotlin",
            unitNumber = 5,
            title = "Collection Functions",
            theoryText = """
                Kotlin has an extremely powerful functional API for collections.
                
                🔹 .filter { }: filter elements
                🔹 .map { }: transform each element
                🔹 .forEach { }: execute operation
                🔹 .sumOf { }: sum values
                🔹 Chainable: nums.filter{...}.map{...}.sum()
            """.trimIndent(),
            codeExample = """
                val nums = listOf(1, 2, 3, 4, 5)
                
                val evens = nums.filter { it % 2 == 0 }
                // [2, 4]
                
                val doubles = nums.map { it * 2 }
                // [2, 4, 6, 8, 10]
                
                val sumEvens = nums
                    .filter { it % 2 == 0 }
                    .sumOf { it }
                // 6 (2+4)
            """.trimIndent(),
            xpReward = 45,
            exercises = listOf(
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "What does .filter { it > 5 } do?",
                    "", listOf("Deletes elements > 5", "Returns only those > 5", "Sums those > 5", "Counts those > 5"), 1,
                    "filter returns a new list containing elements that match the given predicate."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Multiply each number by 10:",
                    "val l = listOf(1,2,3)\nval r = l.???{ it * 10 }",
                    listOf("filter", "map", "forEach", "fold"), 1,
                    "map transforms each element by applying the given lambda."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "What is 'it' inside a single-parameter lambda?",
                    "", listOf("A reserved word", "Implicit parameter name", "Iterator", "The index"), 1,
                    "When a lambda has a single parameter, Kotlin implicitly calls it 'it'."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "What does listOf(1,2,3).sum() return?",
                    "", listOf("3", "6", "[1,2,3]", "Error"), 1,
                    ".sum() adds all elements: 1+2+3 = 6."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Count how many numbers are greater than 10:",
                    "val l = listOf(5,12,8,15)\nval c = l.???{ it > 10 }",
                    listOf("filter", "count", "any", "all"), 1,
                    "count() with a predicate returns how many elements match the condition.")
            )
        ),

        Lesson(
            id = "kt_5_2",
            language = "Kotlin",
            unitNumber = 5,
            title = "Coroutines (suspend)",
            theoryText = """
                Coroutines allow executing asynchronous code in a SEQUENTIAL and readable way.
                
                🔹 suspend fun: function that can be paused
                🔹 Can only be called from another suspend function or a scope
                🔹 launch { }: starts a new coroutine (fire-and-forget)
                🔹 async { } + .await(): for tasks returning a result
                🔹 They replace callbacks and promises
            """.trimIndent(),
            codeExample = """
                suspend fun loadData(): String {
                    delay(1000)   // wait 1 sec without blocking thread
                    return "Data OK"
                }
                
                // Call from a scope
                lifecycleScope.launch {
                    val data = loadData()  // suspended without blocking
                    println(data)
                }
            """.trimIndent(),
            xpReward = 50,
            exercises = listOf(
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "Which modifier turns a function into a suspendable one?",
                    "", listOf("async", "suspend", "await", "coroutine"), 1,
                    "The modifier 'suspend' marks a function as suspendable."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Define a suspend function:",
                    "??? fun load(): String { delay(500); return \"OK\" }",
                    listOf("async", "await", "suspend", "launch"), 2,
                    "suspend comes before fun to make it suspendable."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "From where can a suspend function be called?",
                    "", listOf("From anywhere", "Only from another suspend or a coroutine scope", "Only from main()", "Only from lambdas"), 1,
                    "suspend functions can only be invoked from another suspend context or scope (launch/async)."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "What does launch { } do?",
                    "", listOf("Creates a thread", "Starts a un-returning coroutine", "Waits for a result", "Blocks main thread"), 1,
                    "launch starts a fire-and-forget coroutine. For a result, async/await is used."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Pause the coroutine for 2 seconds:",
                    "suspend fun wait() { ???(2000) }",
                    listOf("sleep", "delay", "wait", "pause"), 1,
                    "delay() is the suspendable equivalent to Thread.sleep, it doesn't block the thread.")
            )
        )
    )
}
