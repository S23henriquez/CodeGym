package com.exemple.codegym.data.lessons_i18n.en

import com.exemple.codegym.models.ExerciseType
import com.exemple.codegym.models.Lesson
import com.exemple.codegym.models.LessonExercise

object JavaLessonsEn {

    val lessons: List<Lesson> = listOf(

        // ============ UNIT 1: BASIC JAVA ============

        Lesson(
            id = "java_1_1",
            language = "Java",
            unitNumber = 1,
            title = "Primitive Types",
            theoryText = """
                In Java you MUST declare the type of every variable.
                
                🔹 Numeric types: int, long, double, float
                🔹 Text/character: char (single char), String (text sequence)
                🔹 Boolean: boolean (true/false)
                
                ⚠️ Every statement must end with a semicolon ;
            """.trimIndent(),
            codeExample = """
                int age = 25;
                double height = 1.65;
                String name = "Ana";
                char initial = 'A';
                boolean isStudent = true;
                
                System.out.println(name);
            """.trimIndent(),
            xpReward = 20,
            exercises = listOf(
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "What is the correct way to declare an integer?",
                    "", listOf("integer x = 5", "int x = 5;", "var x = 5", "x = 5"), 1,
                    "Java uses 'int' and always ends statements with a semicolon."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Complete to store text:",
                    "??? greeting = \"Hello\";",
                    listOf("string", "String", "char", "text"), 1,
                    "In Java, String is written with a capital S. It is a class, not a primitive."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "What type would you use to store 1.75?",
                    "", listOf("int", "double", "String", "boolean"), 1,
                    "double is the most common type for decimals in Java."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "What is missing at the end?\nint x = 5",
                    "", listOf("Nothing, it's fine", "Semicolon ;", "Brace }", "Comma ,"), 1,
                    "Every statement in Java ends with ; (semicolon)."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Declare a char with the letter Z:",
                    "char letter = ???;",
                    listOf("\"Z\"", "'Z'", "Z", "<Z>"), 1,
                    "In Java, chars use single quotes ' ', Strings use double quotes \" \".")
            )
        ),

        Lesson(
            id = "java_1_2",
            language = "Java",
            unitNumber = 1,
            title = "System.out.println",
            theoryText = """
                To print to the console in Java, System.out.println() is used.
                
                🔹 println adds a line break at the end
                🔹 print outputs without a line break
                🔹 printf allows C-style formatting
                🔹 Strings are concatenated using +
            """.trimIndent(),
            codeExample = """
                System.out.println("Hello world");
                System.out.println("Age: " + 25);
                
                int a = 5, b = 3;
                System.out.println(a + " + " + b + " = " + (a + b));
                // 5 + 3 = 8
            """.trimIndent(),
            xpReward = 20,
            exercises = listOf(
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "What does System.out.println(\"5\" + 3); print?",
                    "", listOf("8", "53", "5+3", "Error"), 1,
                    "Since \"5\" is a String, + concatenates: \"5\" + 3 = \"53\"."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Print the sum of a and b WITH a line break:",
                    "int a=10, b=5;\nSystem.out.???(a + b);",
                    listOf("println", "print", "show", "write"), 0,
                    "println prints and adds a line break."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "What does System.out.println(2 + 3 + \"x\"); print?",
                    "", listOf("5x", "23x", "2 + 3 + x", "Error"), 0,
                    "From left to right: 2+3=5 (numbers), then 5+\"x\" concatenates → \"5x\"."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "What is the difference between print and println?",
                    "", listOf("None", "println adds a line break", "print is faster", "println requires String"), 1,
                    "println = print + line break (\\n)."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Concatenate name and age:",
                    "String n=\"Ana\";\nint e=25;\nSystem.out.println(n ??? \" is \" ??? e);",
                    listOf(",", "+", ".", "&"), 1,
                    "+ concatenates Strings (and automatically converts primitive types to String).")
            )
        ),

        Lesson(
            id = "java_1_3",
            language = "Java",
            unitNumber = 1,
            title = "Operators",
            theoryText = """
                Java provides arithmetic, comparison, and logical operators.
                
                🔹 Arithmetic: + - * / % (modulo)
                🔹 Comparison: == != < > <= >=
                🔹 Logical: && (AND) || (OR) ! (NOT)
                🔹 ++ and -- increment/decrement
                🔹 += -= *= /= compound operators
            """.trimIndent(),
            codeExample = """
                int a = 10, b = 3;
                
                System.out.println(a / b);   // 3 (integer division)
                System.out.println(a % b);   // 1 (remainder)
                System.out.println(a > b);   // true
                
                a++;            // a = 11
                a += 5;         // a = 16
                
                boolean ok = (a > 10) && (b < 5);  // true
            """.trimIndent(),
            xpReward = 25,
            exercises = listOf(
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "What does System.out.println(10 / 3); print?",
                    "", listOf("3.33", "3", "3.0", "4"), 1,
                    "Integer division between integers discards decimals: 10/3 = 3."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "Which is the logical AND operator?",
                    "", listOf("&", "&&", "and", "+"), 1,
                    "&& is the logical AND. & is the bitwise AND."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Add 5 to the variable using a compound operator:",
                    "int x = 10;\nx ??? 5;",
                    listOf("=+", "+=", "++", "=5+"), 1,
                    "+= is compound assignment. x += 5 is equivalent to x = x + 5."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "What is printed?\nint x = 5;\nx++;\nSystem.out.println(x);",
                    "", listOf("5", "6", "4", "Error"), 1,
                    "x++ increments x by 1. Changes from 5 to 6."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Check if age is EXACTLY 18:",
                    "if (age ??? 18) { ... }",
                    listOf("=", "==", "===", "!="), 1,
                    "= is assignment. == evaluates equality. === is not valid in Java.")
            )
        ),

        // ============ UNIT 2: CONTROL FLOW ============

        Lesson(
            id = "java_2_1",
            language = "Java",
            unitNumber = 2,
            title = "if, else if, else",
            theoryText = """
                Conditionals in Java must use parentheses and braces.
                
                🔹 if (condition) { ... }
                🔹 else if (other_condition) { ... }
                🔹 else { ... }
                🔹 Ternary operator: condition ? valueIfTrue : valueIfFalse
            """.trimIndent(),
            codeExample = """
                int grade = 7;
                
                if (grade >= 9) {
                    System.out.println("Excellent");
                } else if (grade >= 7) {
                    System.out.println("Good");
                } else if (grade >= 5) {
                    System.out.println("Pass");
                } else {
                    System.out.println("Fail");
                }
                
                // Ternary
                String res = (grade >= 5) ? "Pass" : "Fail";
            """.trimIndent(),
            xpReward = 25,
            exercises = listOf(
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "What is printed?\nint x = 10;\nif (x > 5) System.out.println(\"A\");\nelse System.out.println(\"B\");",
                    "", listOf("A", "B", "AB", "Error"), 0,
                    "10 > 5 is true, so it enters the if and prints 'A'."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Complete the ternary operator:",
                    "int age = 20;\nString r = (age >= 18) ??? \"adult\" : \"minor\";",
                    listOf(":", "?", ".", ","), 1,
                    "Syntax: condition ? valueIfTrue : valueIfFalse. The ? comes first."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "Do I ALWAYS need curly braces { } for an if?",
                    "", listOf("Yes, always", "No if it's only 1 statement", "Only in loops", "Never"), 1,
                    "If there is just 1 statement you can omit { }, but using them is best practice."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "Which keyword is used for 'in another case'?",
                    "", listOf("elif", "elseif", "else if", "default"), 2,
                    "Java uses 'else if' (with a space), not 'elif' like Python."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Print 'positive' if n > 0:",
                    "??? (n > 0) {\n    System.out.println(\"positive\");\n}",
                    listOf("when", "if", "case", "switch"), 1,
                    "if is the word for conditionals in Java.")
            )
        ),

        Lesson(
            id = "java_2_2",
            language = "Java",
            unitNumber = 2,
            title = "for and while loops",
            theoryText = """
                Java has 3 types of loops.
                
                🔹 for (init; condition; step) → structured repeat
                🔹 while (condition) → while condition is true
                🔹 do { } while (condition) → executes AT LEAST once
                🔹 for-each: for (Type x : collection) → iterates collections
                🔹 break exits loop, continue jumps to next iteration
            """.trimIndent(),
            codeExample = """
                // traditional for
                for (int i = 0; i < 5; i++) {
                    System.out.println(i);  // 0,1,2,3,4
                }
                
                // for-each
                int[] nums = {10, 20, 30};
                for (int n : nums) {
                    System.out.println(n);
                }
                
                // while
                int c = 0;
                while (c < 3) {
                    c++;
                }
            """.trimIndent(),
            xpReward = 30,
            exercises = listOf(
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "How many times does this print?\nfor (int i=1; i<=4; i++) System.out.println(\"x\");",
                    "", listOf("3", "4", "5", "1"), 1,
                    "i goes from 1 to 4 (included) → 4 iterations."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Complete the for-each loop:",
                    "int[] arr = {1,2,3};\nfor (int x ??? arr) {\n    System.out.println(x);\n}",
                    listOf(":", "in", ",", "of"), 0,
                    "The for-each in Java uses a : (colon) between the variable and the collection."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "Which loop ALWAYS executes at least once?",
                    "", listOf("for", "while", "do-while", "None"), 2,
                    "do-while runs the body FIRST, then evaluates the condition."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "What does 'continue' do?",
                    "", listOf("Exits the loop", "Jumps to the next iteration", "Restarts the loop", "Pauses"), 1,
                    "continue skips to the end of the body and re-evaluates the condition."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Exit the loop when i==5:",
                    "for (int i=0; i<10; i++) {\n    if (i == 5) ???;\n}",
                    listOf("continue", "break", "return", "exit"), 1,
                    "break exits the nearest loop immediately.")
            )
        ),

        // ============ UNIT 3: METHODS AND OOP ============

        Lesson(
            id = "java_3_1",
            language = "Java",
            unitNumber = 3,
            title = "Methods",
            theoryText = """
                Methods are functions within classes.
                
                🔹 modifier returnType name(parameters) { ... }
                🔹 void if it returns nothing
                🔹 return sends a value back (required if not void)
                🔹 static: belongs to the class, not to an instance
                🔹 public/private/protected: visibility
            """.trimIndent(),
            codeExample = """
                public class Calculator {
                    public static int add(int a, int b) {
                        return a + b;
                    }
                    
                    public void greet(String name) {
                        System.out.println("Hello " + name);
                    }
                }
                
                int total = Calculator.add(3, 5);  // 8
            """.trimIndent(),
            xpReward = 30,
            exercises = listOf(
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "What return type to use if it returns nothing?",
                    "", listOf("null", "void", "empty", "none"), 1,
                    "void indicates the method does not return a value."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Return the double of x:",
                    "public int doubleVal(int x) {\n    ??? x * 2;\n}",
                    listOf("print", "return", "yield", "give"), 1,
                    "return sends back the value to whoever called the method."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "What does 'static' do on a method?",
                    "", listOf("Makes it immutable", "Belongs to the CLASS, not instances", "Makes it faster", "Cannot be inherited"), 1,
                    "A static method is called as Class.method(), no object instance is needed."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "Which is NOT a visibility modifier?",
                    "", listOf("public", "private", "protected", "external"), 3,
                    "Java has public, private, protected, and package-private (no modifier)."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Define a public method with no return called greet:",
                    "public ??? greet() {\n    System.out.println(\"Hi\");\n}",
                    listOf("int", "void", "String", "static"), 1,
                    "void = returns nothing.")
            )
        ),

        Lesson(
            id = "java_3_2",
            language = "Java",
            unitNumber = 3,
            title = "Classes and Objects",
            theoryText = """
                A class is a blueprint for creating objects.
                
                🔹 class ClassName { ... }
                🔹 Attributes: variables of the class
                🔹 Constructor: a method exactly named as the class
                🔹 this. refers to the current object
                🔹 new ClassName() instantiates an object
            """.trimIndent(),
            codeExample = """
                public class Person {
                    private String name;
                    private int age;
                    
                    public Person(String name, int age) {
                        this.name = name;
                        this.age = age;
                    }
                    
                    public String sayHi() {
                        return "Hi, I am " + name;
                    }
                }
                
                Person p = new Person("Ana", 25);
                System.out.println(p.sayHi());
            """.trimIndent(),
            xpReward = 35,
            exercises = listOf(
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "How do you create a class instance?",
                    "", listOf("Person p = Person();", "Person p = new Person();", "Person p = create Person();", "var p = Person.new()"), 1,
                    "In Java, 'new' operator creates objects."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Assign the parameter to the object attribute:",
                    "public Person(String name) {\n    ???.name = name;\n}",
                    listOf("self", "this", "me", "obj"), 1,
                    "this refers to the current object. Used to distinguish attribute from parameter."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "What is a constructor?",
                    "", listOf("A static method", "A special method that sets up the object", "An attribute", "An interface"), 1,
                    "Constructor runs when the object is created. It shares the class name."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "Which visibility provides LEAST access?",
                    "", listOf("public", "protected", "package-private", "private"), 3,
                    "private: only accessible inside its own class. The most restrictive."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Call the sayHi method of the object p:",
                    "Person p = new Person(\"Ana\");\nString r = p???sayHi();",
                    listOf(",", ".", "->", "::"), 1,
                    "The dot . operator accesses methods and attributes.")
            )
        ),

        // ============ UNIT 4: COLLECTIONS ============

        Lesson(
            id = "java_4_1",
            language = "Java",
            unitNumber = 4,
            title = "ArrayList",
            theoryText = """
                ArrayList is a dynamic list (can resize).
                
                🔹 import java.util.ArrayList;
                🔹 ArrayList<Type> name = new ArrayList<>();
                🔹 .add(elem) appends
                🔹 .get(i) gets by index
                🔹 .remove(i) deletes by index
                🔹 .size() returns size
            """.trimIndent(),
            codeExample = """
                import java.util.ArrayList;
                
                ArrayList<String> fruits = new ArrayList<>();
                fruits.add("pear");
                fruits.add("grape");
                fruits.add("kiwi");
                
                System.out.println(fruits.get(0));   // pear
                System.out.println(fruits.size());   // 3
                
                fruits.remove(1);                     // removes "grape"
            """.trimIndent(),
            xpReward = 35,
            exercises = listOf(
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "Which method ADDS an element to an ArrayList?",
                    "", listOf("push()", "append()", "add()", "insert()"), 2,
                    "In Java, .add() is used to append to the end."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Create an ArrayList of Integers:",
                    "ArrayList<???> nums = new ArrayList<>();",
                    listOf("int", "Integer", "Number", "long"), 1,
                    "Generics in Java require OBJECT types, not primitive ones. Integer instead of int."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "What does list.get(0) return?",
                    "ArrayList<String> list = new ArrayList<>();\nlist.add(\"X\");\nlist.add(\"Y\");",
                    listOf("X", "Y", "[X,Y]", "Error"), 0,
                    "Indexes start at 0. .get(0) returns the first item, X."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "What's the size of the list?",
                    "ArrayList<Integer> l = new ArrayList<>();\nl.add(1);\nl.add(2);\nl.add(3);\nSystem.out.println(l.size());",
                    listOf("2", "3", "4", "Error"), 1,
                    ".size() returns the item count. 3 elements were added."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Delete the item at index 0:",
                    "list.???(0);",
                    listOf("delete", "pop", "remove", "clear"), 2,
                    ".remove(index) eliminates the item in that position.")
            )
        ),

        // ============ UNIT 5: ADVANCED ============

        Lesson(
            id = "java_5_1",
            language = "Java",
            unitNumber = 5,
            title = "Exceptions (try/catch)",
            theoryText = """
                Exceptions are runtime errors. try/catch handles them.
                
                🔹 try { ... } block that is risky
                🔹 catch (Type e) { ... } catches an error
                🔹 finally { ... } ALWAYS runs
                🔹 throw new TypeException("msg") throws manually
                🔹 throws inside signature indicates method can launch error
            """.trimIndent(),
            codeExample = """
                try {
                    int[] arr = {1, 2, 3};
                    System.out.println(arr[5]);  // out of range!
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("Invalid index");
                } catch (Exception e) {
                    System.out.println("Other error");
                } finally {
                    System.out.println("Cleanup final");
                }
            """.trimIndent(),
            xpReward = 45,
            exercises = listOf(
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "Which block CATCHES an exception?",
                    "", listOf("try", "catch", "throw", "finally"), 1,
                    "catch traps the exception launched inside try."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Manually throw an IllegalArgumentException:",
                    "if (age < 0) ??? new IllegalArgumentException(\"Invalid age\");",
                    listOf("raise", "throw", "catch", "send"), 1,
                    "throw launches an exception. throws (plural) is for method signature."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "Which block ALWAYS executes?",
                    "", listOf("try", "catch", "finally", "else"), 2,
                    "finally always runs, whether exception happens or not. Good to clear resources."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "Which exception does int[]{1,2}[5] throw?",
                    "", listOf("NullPointerException", "ArrayIndexOutOfBoundsException", "ClassCastException", "IOException"), 1,
                    "Accessing out of array's range sets ArrayIndexOutOfBoundsException."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Catch any generic exception type:",
                    "try { ... } catch (??? e) { ... }",
                    listOf("Error", "Throwable", "Exception", "Object"), 2,
                    "Exception is the common parent class. Catches all RuntimeException.")
            )
        ),

        Lesson(
            id = "java_5_2",
            language = "Java",
            unitNumber = 5,
            title = "Streams API",
            theoryText = """
                Streams (Java 8+) handle collections functionally.
                
                🔹 .stream() turns collection into a stream
                🔹 .filter(predicate) filters
                🔹 .map(function) transforms 
                🔹 .collect(...) builds output
                🔹 .count(), .sum(), .average() functions
            """.trimIndent(),
            codeExample = """
                import java.util.List;
                import java.util.stream.Collectors;
                
                List<Integer> nums = List.of(1, 2, 3, 4, 5);
                
                List<Integer> evens = nums.stream()
                    .filter(n -> n % 2 == 0)
                    .collect(Collectors.toList());
                // [2, 4]
                
                long howMany = nums.stream()
                    .filter(n -> n > 2)
                    .count();   // 3
            """.trimIndent(),
            xpReward = 50,
            exercises = listOf(
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "Which method FILTERS a stream?",
                    "", listOf(".select()", ".filter()", ".where()", ".find()"), 1,
                    ".filter(predicate) keeps items matching the condition."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Convert a List into a Stream:",
                    "List<Integer> l = List.of(1,2,3);\nl.???().forEach(System.out::println);",
                    listOf("stream", "iterator", "asStream", "open"), 0,
                    ".stream() is the standard call for Collections."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "What does .map(n -> n*2) do?",
                    "", listOf("Filters", "Transforms each item into its double", "Counts", "Sorts"), 1,
                    "map applies the function and returns a new transformed stream."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "What does nums.stream().count() return?",
                    "", listOf("The sum", "Element count", "The first", "The last"), 1,
                    ".count() returns how many items are in the stream (long)."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Collect the stream back to a list:",
                    "stream.collect(Collectors.???())",
                    listOf("toList", "toArray", "toMap", "toSet"), 0,
                    "Collectors.toList() is classic. Also in Java 16+ .toList() exists directly.")
            )
        )
    )
}