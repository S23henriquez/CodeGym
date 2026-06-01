package com.exemple.codegym.data.lessons

import com.exemple.codegym.models.ExerciseType
import com.exemple.codegym.models.Lesson
import com.exemple.codegym.models.LessonExercise

/**
 * Lecciones de Java: 10 lecciones por unidades.
 */
object JavaLessons {

    val lessons: List<Lesson> = listOf(

        // ============ UNIDAD 1: JAVA BÁSICO ============

        Lesson(
            id = "java_1_1",
            language = "Java",
            unitNumber = 1,
            title = "Tipos primitivos",
            theoryText = """
                En Java SÍ tienes que declarar el tipo de cada variable.
                
                🔹 Tipos numéricos: int, long, double, float
                🔹 Texto/carácter: char (un solo carácter), String (cadena)
                🔹 Booleano: boolean (true/false)
                
                ⚠️ Cada sentencia termina con punto y coma ;
            """.trimIndent(),
            codeExample = """
                int edad = 25;
                double altura = 1.65;
                String nombre = "Ana";
                char inicial = 'A';
                boolean esEstudiante = true;
                
                System.out.println(nombre);
            """.trimIndent(),
            xpReward = 20,
            exercises = listOf(
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "¿Cuál es la forma correcta de declarar un entero?",
                    "", listOf("integer x = 5", "int x = 5;", "var x = 5", "x = 5"), 1,
                    "En Java se usa 'int' y siempre se termina con punto y coma."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Completa para guardar texto:",
                    "??? saludo = \"Hola\";",
                    listOf("string", "String", "char", "text"), 1,
                    "En Java, String se escribe con S mayúscula. No es un primitivo, es una clase."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "¿Qué tipo usarías para guardar 1.75?",
                    "", listOf("int", "double", "String", "boolean"), 1,
                    "double es el tipo más usado para decimales en Java."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "¿Qué falta al final?\nint x = 5",
                    "", listOf("Nada, está bien", "Punto y coma ;", "Llave }", "Coma ,"), 1,
                    "Cada sentencia en Java termina con ; (punto y coma)."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Declara un char con la letra Z:",
                    "char letra = ???;",
                    listOf("\"Z\"", "'Z'", "Z", "<Z>"), 1,
                    "En Java los char van con comilla simple ' ', los String con doble \" \".")
            )
        ),

        Lesson(
            id = "java_1_2",
            language = "Java",
            unitNumber = 1,
            title = "System.out.println",
            theoryText = """
                Para imprimir en consola en Java se usa System.out.println().
                
                🔹 println añade salto de línea al final
                🔹 print imprime sin salto de línea
                🔹 printf permite formato como en C
                🔹 Se concatenan strings con +
            """.trimIndent(),
            codeExample = """
                System.out.println("Hola mundo");
                System.out.println("Edad: " + 25);
                
                int a = 5, b = 3;
                System.out.println(a + " + " + b + " = " + (a + b));
                // 5 + 3 = 8
            """.trimIndent(),
            xpReward = 20,
            exercises = listOf(
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "¿Qué imprime System.out.println(\"5\" + 3);?",
                    "", listOf("8", "53", "5+3", "Error"), 1,
                    "Como \"5\" es un String, el + concatena: \"5\" + 3 = \"53\"."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Imprime la suma de a y b CON salto de línea:",
                    "int a=10, b=5;\nSystem.out.???(a + b);",
                    listOf("println", "print", "show", "write"), 0,
                    "println imprime y añade salto de línea."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "¿Qué imprime System.out.println(2 + 3 + \"x\");?",
                    "", listOf("5x", "23x", "2 + 3 + x", "Error"), 0,
                    "De izquierda a derecha: 2+3=5 (números), luego 5+\"x\" concatena → \"5x\"."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "¿Cuál es la diferencia entre print y println?",
                    "", listOf("Ninguna", "println añade salto de línea", "print es más rápido", "println requiere String"), 1,
                    "println = print + salto de línea (\\n)."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Concatena nombre y edad:",
                    "String n=\"Ana\";\nint e=25;\nSystem.out.println(n ??? \" tiene \" ??? e);",
                    listOf(",", "+", ".", "&"), 1,
                    "+ concatena Strings (y convierte tipos primitivos a String automáticamente).")
            )
        ),

        Lesson(
            id = "java_1_3",
            language = "Java",
            unitNumber = 1,
            title = "Operadores",
            theoryText = """
                Java tiene operadores aritméticos, comparación y lógicos.
                
                🔹 Aritméticos: + - * / % (módulo)
                🔹 Comparación: == != < > <= >=
                🔹 Lógicos: && (AND) || (OR) ! (NOT)
                🔹 ++ y -- incrementan/decrementan
                🔹 += -= *= /= operadores compuestos
            """.trimIndent(),
            codeExample = """
                int a = 10, b = 3;
                
                System.out.println(a / b);   // 3 (división entera)
                System.out.println(a % b);   // 1 (resto)
                System.out.println(a > b);   // true
                
                a++;            // a = 11
                a += 5;         // a = 16
                
                boolean ok = (a > 10) && (b < 5);  // true
            """.trimIndent(),
            xpReward = 25,
            exercises = listOf(
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "¿Qué imprime System.out.println(10 / 3);?",
                    "", listOf("3.33", "3", "3.0", "4"), 1,
                    "División entera entre enteros descarta los decimales: 10/3 = 3."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "¿Cuál es el operador AND lógico?",
                    "", listOf("&", "&&", "and", "+"), 1,
                    "&& es el AND lógico. & es AND a nivel de bits."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Suma 5 a la variable usando operador compuesto:",
                    "int x = 10;\nx ??? 5;",
                    listOf("=+", "+=", "++", "=5+"), 1,
                    "+= es la asignación compuesta. x += 5 equivale a x = x + 5."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "¿Qué imprime?\nint x = 5;\nx++;\nSystem.out.println(x);",
                    "", listOf("5", "6", "4", "Error"), 1,
                    "x++ incrementa x en 1. De 5 pasa a 6."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Comprueba si edad es 18 EXACTAMENTE:",
                    "if (edad ??? 18) { ... }",
                    listOf("=", "==", "===", "!="), 1,
                    "= es asignación. == compara igualdad. === no existe en Java.")
            )
        ),

        // ============ UNIDAD 2: CONTROL DE FLUJO ============

        Lesson(
            id = "java_2_1",
            language = "Java",
            unitNumber = 2,
            title = "if, else if, else",
            theoryText = """
                Las condicionales en Java van con paréntesis y llaves obligatorias.
                
                🔹 if (condición) { ... }
                🔹 else if (otra) { ... }
                🔹 else { ... }
                🔹 Operador ternario: condición ? valorSi : valorNo
            """.trimIndent(),
            codeExample = """
                int nota = 7;
                
                if (nota >= 9) {
                    System.out.println("Sobresaliente");
                } else if (nota >= 7) {
                    System.out.println("Notable");
                } else if (nota >= 5) {
                    System.out.println("Aprobado");
                } else {
                    System.out.println("Suspenso");
                }
                
                // Ternario
                String res = (nota >= 5) ? "Aprobado" : "Suspenso";
            """.trimIndent(),
            xpReward = 25,
            exercises = listOf(
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "¿Qué imprime?\nint x = 10;\nif (x > 5) System.out.println(\"A\");\nelse System.out.println(\"B\");",
                    "", listOf("A", "B", "AB", "Error"), 0,
                    "10 > 5 es true, entra en el if e imprime 'A'."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Completa el operador ternario:",
                    "int edad = 20;\nString r = (edad >= 18) ??? \"adulto\" : \"menor\";",
                    listOf(":", "?", ".", ","), 1,
                    "Sintaxis: condición ? valorSi : valorNo. El ? viene primero."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "¿Necesito SIEMPRE las llaves { } en un if?",
                    "", listOf("Sí, siempre", "No si solo hay 1 sentencia", "Solo en bucles", "Nunca"), 1,
                    "Si solo hay 1 sentencia puedes omitir las { }, pero por buena práctica se recomienda usarlas."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "¿Qué clave usa para el caso 'en otro caso'?",
                    "", listOf("elif", "elseif", "else if", "default"), 2,
                    "Java usa 'else if' (con espacio), no 'elif' como Python."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Imprime 'positivo' si n > 0:",
                    "??? (n > 0) {\n    System.out.println(\"positivo\");\n}",
                    listOf("when", "if", "case", "switch"), 1,
                    "if es la palabra para condicionales en Java.")
            )
        ),

        Lesson(
            id = "java_2_2",
            language = "Java",
            unitNumber = 2,
            title = "Bucles for y while",
            theoryText = """
                Java tiene 3 tipos de bucle.
                
                🔹 for (init; condición; paso) → muy estructurado
                🔹 while (condición) → mientras se cumpla
                🔹 do { } while (condición) → ejecuta AL MENOS una vez
                🔹 for-each: for (Tipo x : coleccion) → recorre colecciones
                🔹 break sale, continue salta a la siguiente iteración
            """.trimIndent(),
            codeExample = """
                // for tradicional
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
                    "¿Cuántas veces imprime?\nfor (int i=1; i<=4; i++) System.out.println(\"x\");",
                    "", listOf("3", "4", "5", "1"), 1,
                    "i va de 1 a 4 (incluido) → 4 iteraciones."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Completa el bucle for-each:",
                    "int[] arr = {1,2,3};\nfor (int x ??? arr) {\n    System.out.println(x);\n}",
                    listOf(":", "in", ",", "of"), 0,
                    "El for-each en Java usa : (dos puntos) entre la variable y la colección."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "¿Cuál se ejecuta SIEMPRE al menos una vez?",
                    "", listOf("for", "while", "do-while", "Ninguno"), 2,
                    "do-while ejecuta el cuerpo PRIMERO, luego comprueba la condición."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "¿Qué hace 'continue'?",
                    "", listOf("Sale del bucle", "Salta a la siguiente iteración", "Reinicia el bucle", "Pausa"), 1,
                    "continue salta al final del cuerpo y vuelve a comprobar la condición."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Sale del bucle cuando i==5:",
                    "for (int i=0; i<10; i++) {\n    if (i == 5) ???;\n}",
                    listOf("continue", "break", "return", "exit"), 1,
                    "break sale completamente del bucle más cercano.")
            )
        ),

        // ============ UNIDAD 3: MÉTODOS Y POO ============

        Lesson(
            id = "java_3_1",
            language = "Java",
            unitNumber = 3,
            title = "Métodos",
            theoryText = """
                Los métodos son funciones dentro de clases.
                
                🔹 modificador tipoRetorno nombre(parámetros) { ... }
                🔹 void si no devuelve nada
                🔹 return devuelve un valor (obligatorio si no es void)
                🔹 static: pertenece a la clase, no a una instancia
                🔹 public/private/protected: visibilidad
            """.trimIndent(),
            codeExample = """
                public class Calculadora {
                    public static int sumar(int a, int b) {
                        return a + b;
                    }
                    
                    public void saludar(String nombre) {
                        System.out.println("Hola " + nombre);
                    }
                }
                
                int total = Calculadora.sumar(3, 5);  // 8
            """.trimIndent(),
            xpReward = 30,
            exercises = listOf(
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "¿Qué tipo de retorno usar si NO devuelve nada?",
                    "", listOf("null", "void", "empty", "none"), 1,
                    "void indica que el método no devuelve ningún valor."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Devuelve el doble de x:",
                    "public int doble(int x) {\n    ??? x * 2;\n}",
                    listOf("print", "return", "yield", "give"), 1,
                    "return envía el valor de vuelta a quien llamó al método."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "¿Qué hace 'static' en un método?",
                    "", listOf("Lo hace inmutable", "Pertenece a la CLASE, no a instancias", "Es más rápido", "No se hereda"), 1,
                    "Un método static se llama como Clase.metodo(), no necesita crear objeto."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "¿Cuál NO es modificador de visibilidad?",
                    "", listOf("public", "private", "protected", "external"), 3,
                    "Java tiene public, private, protected y package-private (sin modificador)."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Define un método público sin retorno llamado saludar:",
                    "public ??? saludar() {\n    System.out.println(\"Hi\");\n}",
                    listOf("int", "void", "String", "static"), 1,
                    "void = no retorna nada.")
            )
        ),

        Lesson(
            id = "java_3_2",
            language = "Java",
            unitNumber = 3,
            title = "Clases y objetos",
            theoryText = """
                Una clase es un molde para crear objetos.
                
                🔹 class NombreClase { ... }
                🔹 Atributos: variables de la clase
                🔹 Constructor: método con el mismo nombre que la clase
                🔹 this. se refiere al objeto actual
                🔹 new ClaseNombre() crea una instancia
            """.trimIndent(),
            codeExample = """
                public class Persona {
                    private String nombre;
                    private int edad;
                    
                    public Persona(String nombre, int edad) {
                        this.nombre = nombre;
                        this.edad = edad;
                    }
                    
                    public String saludar() {
                        return "Hola, soy " + nombre;
                    }
                }
                
                Persona p = new Persona("Ana", 25);
                System.out.println(p.saludar());
            """.trimIndent(),
            xpReward = 35,
            exercises = listOf(
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "¿Cómo se crea una instancia de una clase?",
                    "", listOf("Persona p = Persona();", "Persona p = new Persona();", "Persona p = create Persona();", "var p = Persona.new()"), 1,
                    "En Java se usa el operador 'new' para crear objetos."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Asigna el parámetro al atributo del objeto:",
                    "public Persona(String nombre) {\n    ???.nombre = nombre;\n}",
                    listOf("self", "this", "me", "obj"), 1,
                    "this se refiere al objeto actual. Se usa para distinguir atributo y parámetro."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "¿Qué es un constructor?",
                    "", listOf("Un método static", "Un método especial que crea el objeto", "Un atributo", "Una interfaz"), 1,
                    "El constructor se ejecuta al crear el objeto. Tiene el mismo nombre que la clase."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "¿Qué visibilidad da MENOS acceso?",
                    "", listOf("public", "protected", "package-private", "private"), 3,
                    "private: solo accesible dentro de la propia clase. Es la más restrictiva."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Llama al método saludar del objeto p:",
                    "Persona p = new Persona(\"Ana\");\nString r = p???saludar();",
                    listOf(",", ".", "->", "::"), 1,
                    "El operador . accede a métodos y atributos de un objeto.")
            )
        ),

        // ============ UNIDAD 4: COLECCIONES ============

        Lesson(
            id = "java_4_1",
            language = "Java",
            unitNumber = 4,
            title = "ArrayList",
            theoryText = """
                ArrayList es una lista dinámica (cambia de tamaño).
                
                🔹 import java.util.ArrayList;
                🔹 ArrayList<Tipo> nombre = new ArrayList<>();
                🔹 .add(elem) añadir
                🔹 .get(i) obtener por índice
                🔹 .remove(i) borrar por índice
                🔹 .size() tamaño
            """.trimIndent(),
            codeExample = """
                import java.util.ArrayList;
                
                ArrayList<String> frutas = new ArrayList<>();
                frutas.add("pera");
                frutas.add("uva");
                frutas.add("kiwi");
                
                System.out.println(frutas.get(0));   // pera
                System.out.println(frutas.size());   // 3
                
                frutas.remove(1);                     // borra "uva"
            """.trimIndent(),
            xpReward = 35,
            exercises = listOf(
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "¿Qué método AÑADE un elemento a un ArrayList?",
                    "", listOf("push()", "append()", "add()", "insert()"), 2,
                    "En Java se usa .add() para añadir al final."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Crea un ArrayList de Integer:",
                    "ArrayList<???> nums = new ArrayList<>();",
                    listOf("int", "Integer", "Number", "long"), 1,
                    "Los genéricos en Java necesitan tipos OBJETO, no primitivos. Integer en vez de int."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "¿Qué devuelve list.get(0)?",
                    "ArrayList<String> list = new ArrayList<>();\nlist.add(\"X\");\nlist.add(\"Y\");",
                    listOf("X", "Y", "[X,Y]", "Error"), 0,
                    "Los índices empiezan en 0. .get(0) devuelve el primer elemento, X."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "¿Cuál es el tamaño de la lista?",
                    "ArrayList<Integer> l = new ArrayList<>();\nl.add(1);\nl.add(2);\nl.add(3);\nSystem.out.println(l.size());",
                    listOf("2", "3", "4", "Error"), 1,
                    ".size() devuelve el número de elementos. Se añadieron 3."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Borra el elemento en índice 0:",
                    "list.???(0);",
                    listOf("delete", "pop", "remove", "clear"), 2,
                    ".remove(índice) elimina el elemento en esa posición.")
            )
        ),

        // ============ UNIDAD 5: AVANZADO ============

        Lesson(
            id = "java_5_1",
            language = "Java",
            unitNumber = 5,
            title = "Excepciones (try/catch)",
            theoryText = """
                Las excepciones son errores en runtime. try/catch las gestiona.
                
                🔹 try { ... } código que puede fallar
                🔹 catch (Tipo e) { ... } captura un error
                🔹 finally { ... } se ejecuta SIEMPRE
                🔹 throw new TipoException("msg") lanza manualmente
                🔹 throws en la firma indica que el método puede lanzar
            """.trimIndent(),
            codeExample = """
                try {
                    int[] arr = {1, 2, 3};
                    System.out.println(arr[5]);  // ¡fuera de rango!
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("Índice no válido");
                } catch (Exception e) {
                    System.out.println("Otro error");
                } finally {
                    System.out.println("Limpieza final");
                }
            """.trimIndent(),
            xpReward = 45,
            exercises = listOf(
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "¿Qué bloque CAPTURA una excepción?",
                    "", listOf("try", "catch", "throw", "finally"), 1,
                    "catch atrapa la excepción lanzada en el try."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Lanza manualmente una IllegalArgumentException:",
                    "if (edad < 0) ??? new IllegalArgumentException(\"Edad inválida\");",
                    listOf("raise", "throw", "catch", "send"), 1,
                    "throw lanza una excepción. throws (con s) va en la firma del método."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "¿Qué bloque se ejecuta SIEMPRE?",
                    "", listOf("try", "catch", "finally", "else"), 2,
                    "finally se ejecuta siempre, ocurra excepción o no. Útil para liberar recursos."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "¿Qué excepción lanza int[]{1,2}[5]?",
                    "", listOf("NullPointerException", "ArrayIndexOutOfBoundsException", "ClassCastException", "IOException"), 1,
                    "Acceder a un índice fuera del array lanza ArrayIndexOutOfBoundsException."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Captura cualquier tipo de excepción:",
                    "try { ... } catch (??? e) { ... }",
                    listOf("Error", "Throwable", "Exception", "Object"), 2,
                    "Exception es la clase padre común. Capturarla atrapa todas las RuntimeException y checked exceptions.")
            )
        ),

        Lesson(
            id = "java_5_2",
            language = "Java",
            unitNumber = 5,
            title = "Streams API",
            theoryText = """
                Streams (Java 8+) permiten procesar colecciones de forma funcional.
                
                🔹 .stream() convierte la colección en stream
                🔹 .filter(predicado) filtra elementos
                🔹 .map(función) transforma elementos
                🔹 .collect(...) recolecta el resultado
                🔹 .count(), .sum(), .average() agregaciones
            """.trimIndent(),
            codeExample = """
                import java.util.List;
                import java.util.stream.Collectors;
                
                List<Integer> nums = List.of(1, 2, 3, 4, 5);
                
                List<Integer> pares = nums.stream()
                    .filter(n -> n % 2 == 0)
                    .collect(Collectors.toList());
                // [2, 4]
                
                long cuantos = nums.stream()
                    .filter(n -> n > 2)
                    .count();   // 3
            """.trimIndent(),
            xpReward = 50,
            exercises = listOf(
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "¿Qué método FILTRA un stream?",
                    "", listOf(".select()", ".filter()", ".where()", ".find()"), 1,
                    ".filter(predicado) deja solo los elementos que cumplen la condición."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Convierte una List en Stream:",
                    "List<Integer> l = List.of(1,2,3);\nl.???().forEach(System.out::println);",
                    listOf("stream", "iterator", "asStream", "open"), 0,
                    ".stream() es el método estándar para convertir cualquier Collection en stream."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "¿Qué hace .map(n -> n*2)?",
                    "", listOf("Filtra", "Transforma cada elemento al doble", "Cuenta", "Ordena"), 1,
                    "map aplica la función a cada elemento, devolviendo un nuevo stream transformado."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "¿Qué devuelve nums.stream().count()?",
                    "", listOf("La suma", "El número de elementos", "El primero", "El último"), 1,
                    ".count() devuelve cuántos elementos hay en el stream (long)."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Recolecta el stream a una lista:",
                    "stream.collect(Collectors.???())",
                    listOf("toList", "toArray", "toMap", "toSet"), 0,
                    "Collectors.toList() es la forma clásica. En Java 16+ también está .toList() directo.")
            )
        )
    )
}