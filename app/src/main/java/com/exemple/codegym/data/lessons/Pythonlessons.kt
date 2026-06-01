package com.exemple.codegym.data.lessons

import com.exemple.codegym.models.ExerciseType
import com.exemple.codegym.models.Lesson
import com.exemple.codegym.models.LessonExercise

/**
 * Lecciones de Python: 10 lecciones distribuidas por unidades:
 *  - Unidad 1: Fundamentos (lecciones 1-3)
 *  - Unidad 2: Control de flujo (lecciones 4-5)
 *  - Unidad 3: Funciones (lección 6)
 *  - Unidad 4: Estructuras de datos (lecciones 7-8)
 *  - Unidad 5: Avanzado (lecciones 9-10)
 */
object PythonLessons {

    val lessons: List<Lesson> = listOf(

        // ============ UNIDAD 1: FUNDAMENTOS ============

        Lesson(
            id = "py_1_1",
            language = "Python",
            unitNumber = 1,
            title = "Variables y tipos",
            theoryText = """
                En Python no hace falta declarar el tipo de las variables. Python lo deduce solo del valor que les asignes.
                
                🔹 Los tipos básicos son: int (enteros), float (decimales), str (texto), bool (True/False)
                
                🔹 Para ver el tipo de algo usa type(valor)
                
                🔹 Los nombres de variables deben empezar por letra o _, no por número.
            """.trimIndent(),
            codeExample = """
                nombre = "Ana"        # str
                edad = 25             # int
                altura = 1.65         # float
                es_estudiante = True  # bool
                
                print(type(edad))     # <class 'int'>
            """.trimIndent(),
            xpReward = 20,
            exercises = listOf(
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "¿Qué tipo es la variable: x = 3.14?",
                    "", listOf("int", "float", "str", "bool"), 1,
                    "3.14 es un número decimal, por lo que es de tipo float."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Completa el código para crear una variable de texto:",
                    "saludo = ???\nprint(saludo)",
                    listOf("\"Hola\"", "Hola", "<Hola>", "{Hola}"), 0,
                    "Las cadenas (str) en Python van entre comillas dobles o simples."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "¿Qué imprime print(type(True))?",
                    "", listOf("<class 'int'>", "<class 'str'>", "<class 'bool'>", "Error"), 2,
                    "True/False son valores booleanos, su tipo es bool."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "¿Cuál de estos NOMBRES de variable es INVÁLIDO en Python?",
                    "", listOf("mi_edad", "_temp", "2dias", "edad2"), 2,
                    "Los nombres de variable no pueden empezar por un número."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Crea una variable con el valor decimal 9.5:",
                    "nota = ???",
                    listOf("9,5", "9.5", "\"9.5\"", "[9.5]"), 1,
                    "En Python los decimales usan punto, no coma. Y sin comillas porque es un número.")
            )
        ),

        Lesson(
            id = "py_1_2",
            language = "Python",
            unitNumber = 1,
            title = "Operadores aritméticos",
            theoryText = """
                Los operadores aritméticos te permiten hacer cálculos:
                
                🔹 +, -, *, /  (suma, resta, multiplicación, división)
                🔹 //  división entera (descarta decimales)
                🔹 %   módulo (devuelve el RESTO de la división)
                🔹 **  potencia (a elevado a b)
            """.trimIndent(),
            codeExample = """
                print(10 + 3)    # 13
                print(10 / 3)    # 3.333...
                print(10 // 3)   # 3 (división entera)
                print(10 % 3)    # 1 (resto)
                print(2 ** 8)    # 256 (potencia)
            """.trimIndent(),
            xpReward = 20,
            exercises = listOf(
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "¿Cuál es el resultado de 17 % 5?",
                    "", listOf("3", "2", "3.4", "85"), 1,
                    "% es el resto. 17 entre 5 es 3 y sobran 2."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "¿Cuál es el resultado de 2 ** 4?",
                    "", listOf("8", "16", "24", "6"), 1,
                    "** es potencia: 2 elevado a 4 = 2*2*2*2 = 16."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "¿Qué imprime print(7 // 2)?",
                    "", listOf("3.5", "3", "4", "1"), 1,
                    "// es división entera. 7/2=3.5, descarta los decimales → 3."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Calcula 100 al cuadrado:",
                    "print(100 ??? 2)",
                    listOf("*", "//", "**", "%"), 2,
                    "** es potencia. 100 ** 2 = 10000."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "¿Cuál es el resultado de (5 + 3) * 2?",
                    "", listOf("13", "16", "10", "26"), 1,
                    "Como las matemáticas: primero los paréntesis (5+3=8), luego *2 = 16.")
            )
        ),

        Lesson(
            id = "py_1_3",
            language = "Python",
            unitNumber = 1,
            title = "Strings y formato",
            theoryText = """
                Las cadenas de texto (strings) son secuencias de caracteres entre comillas.
                
                🔹 Concatenación: usar +
                🔹 f-string: f"Hola {nombre}" interpola variables
                🔹 len(s) → longitud
                🔹 s.upper() / s.lower() → mayúsculas/minúsculas
                🔹 s[0] → primer carácter (los strings se indexan desde 0)
            """.trimIndent(),
            codeExample = """
                nombre = "Ana"
                edad = 25
                
                print("Hola " + nombre)        # Hola Ana
                print(f"Tienes {edad} años")   # Tienes 25 años
                print(len(nombre))              # 3
                print(nombre.upper())           # ANA
                print(nombre[0])                # A
            """.trimIndent(),
            xpReward = 25,
            exercises = listOf(
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "¿Qué imprime print(len(\"Python\"))?",
                    "", listOf("5", "6", "7", "Error"), 1,
                    "len() cuenta los caracteres. P-y-t-h-o-n son 6."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Crea un f-string que imprima 'Hola Marta':",
                    "nombre = \"Marta\"\nprint(f\"Hola ???\")",
                    listOf("nombre", "{nombre}", "(nombre)", "[nombre]"), 1,
                    "Dentro de un f-string, las variables van entre llaves {}."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "¿Qué imprime \"hola\".upper()?",
                    "", listOf("hola", "HOLA", "Hola", "Error"), 1,
                    "El método .upper() convierte todo el string a mayúsculas."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "¿Qué devuelve \"abcde\"[2]?",
                    "", listOf("a", "b", "c", "d"), 2,
                    "Los strings se indexan desde 0. Posición 0=a, 1=b, 2=c."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Concatena nombre y apellido con un espacio:",
                    "n = \"Ana\"\na = \"López\"\nprint(n ??? \" \" ??? a)",
                    listOf("/", "+", "*", "."), 1,
                    "+ concatena strings en Python.")
            )
        ),

        // ============ UNIDAD 2: CONTROL DE FLUJO ============

        Lesson(
            id = "py_2_1",
            language = "Python",
            unitNumber = 2,
            title = "Condicionales if/elif/else",
            theoryText = """
                Los condicionales te permiten ejecutar código solo si se cumple una condición.
                
                🔹 if: si la condición es True
                🔹 elif: si las anteriores no se cumplen pero ésta sí
                🔹 else: si ninguna anterior se cumple
                
                ⚠️ Python usa indentación (4 espacios) para marcar los bloques.
            """.trimIndent(),
            codeExample = """
                edad = 18
                
                if edad < 18:
                    print("Menor de edad")
                elif edad == 18:
                    print("Justo mayor de edad")
                else:
                    print("Adulto")
            """.trimIndent(),
            xpReward = 25,
            exercises = listOf(
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "¿Qué imprime este código?",
                    "x = 10\nif x > 5:\n    print('A')\nelse:\n    print('B')",
                    listOf("A", "B", "Nada", "Error"), 0,
                    "10 > 5 es True, entra en el if e imprime 'A'."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Completa para imprimir 'Aprobado' si nota >= 5:",
                    "nota = 7\n??? nota >= 5:\n    print('Aprobado')",
                    listOf("if", "for", "while", "def"), 0,
                    "Para evaluar una condición se usa 'if'."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "¿Qué imprime el código?",
                    "x = 0\nif x:\n    print('Sí')\nelse:\n    print('No')",
                    listOf("Sí", "No", "0", "Error"), 1,
                    "0 se considera False en Python, por eso entra en el else."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "¿Cuál es el operador correcto para 'igual a'?",
                    "", listOf("=", "==", "===", "!="), 1,
                    "= asigna valores. == compara igualdad."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Completa el elif para 'edad entre 13 y 17':",
                    "if edad < 13:\n    print('niño')\n??? edad < 18:\n    print('adolescente')",
                    listOf("else", "elif", "if", "or"), 1,
                    "elif sirve para añadir condiciones intermedias entre if y else.")
            )
        ),

        Lesson(
            id = "py_2_2",
            language = "Python",
            unitNumber = 2,
            title = "Bucles for y while",
            theoryText = """
                Los bucles repiten código:
                
                🔹 for: itera sobre una secuencia (lista, range, string...)
                🔹 while: repite mientras se cumpla una condición
                🔹 break: sale del bucle
                🔹 continue: salta a la siguiente iteración
                🔹 range(n): genera 0, 1, 2, ..., n-1
            """.trimIndent(),
            codeExample = """
                # for con range
                for i in range(5):
                    print(i)        # 0,1,2,3,4
                
                # for sobre lista
                for fruta in ["pera", "uva"]:
                    print(fruta)
                
                # while
                contador = 0
                while contador < 3:
                    print(contador)
                    contador += 1
            """.trimIndent(),
            xpReward = 25,
            exercises = listOf(
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "¿Cuántas veces imprime 'hola'?",
                    "for i in range(4):\n    print('hola')",
                    listOf("3", "4", "5", "0"), 1,
                    "range(4) genera 4 valores: 0,1,2,3 → 4 iteraciones."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Completa para iterar de 0 a 9:",
                    "for i in ???(10):\n    print(i)",
                    listOf("range", "len", "list", "iter"), 0,
                    "range(10) genera 0,1,2,...,9 (no incluye el 10)."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "¿Qué hace 'break' dentro de un bucle?",
                    "", listOf("Pasa a la siguiente iteración", "Sale del bucle inmediatamente", "Reinicia el bucle", "Imprime un mensaje"), 1,
                    "break termina el bucle. continue es el que pasa a la siguiente."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "¿Cuál es el último valor que imprime?",
                    "i = 0\nwhile i < 3:\n    print(i)\n    i += 1",
                    listOf("0", "1", "2", "3"), 2,
                    "Imprime 0, 1, 2. Cuando i=3 la condición es False y sale."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Completa para sumar 1 al contador:",
                    "n = 0\nwhile n < 5:\n    n ??? 1",
                    listOf("=+", "+=", "++", "=1+"), 1,
                    "+= es el operador de suma+asignación. Equivale a n = n + 1.")
            )
        ),

        // ============ UNIDAD 3: FUNCIONES ============

        Lesson(
            id = "py_3_1",
            language = "Python",
            unitNumber = 3,
            title = "Funciones",
            theoryText = """
                Las funciones son bloques de código reutilizables.
                
                🔹 def nombre(parámetros): la define
                🔹 return: devuelve un valor
                🔹 Sin return, la función devuelve None implícitamente
                🔹 Puedes tener parámetros con valor por defecto
            """.trimIndent(),
            codeExample = """
                def saludar(nombre):
                    return f"Hola {nombre}"
                
                def sumar(a, b=10):    # b por defecto = 10
                    return a + b
                
                print(saludar("Ana"))   # Hola Ana
                print(sumar(5))         # 15 (usa b=10)
                print(sumar(5, 3))      # 8
            """.trimIndent(),
            xpReward = 30,
            exercises = listOf(
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "¿Qué palabra clave define una función?",
                    "", listOf("function", "def", "func", "lambda"), 1,
                    "En Python las funciones se declaran con 'def'."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Completa para devolver el doble de x:",
                    "def doble(x):\n    ??? x * 2",
                    listOf("print", "return", "def", "yield"), 1,
                    "return devuelve el valor calculado al que llamó la función."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "¿Qué imprime?",
                    "def f(x=5):\n    return x * 2\nprint(f())",
                    listOf("0", "5", "10", "Error"), 2,
                    "Llama sin parámetros, así que x usa su valor por defecto 5. 5*2=10."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "¿Qué devuelve una función sin return?",
                    "", listOf("0", "False", "None", "Error"), 2,
                    "Si no hay return, Python devuelve None implícitamente."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Llama a la función con argumentos a=2 y b=3:",
                    "def suma(a, b):\n    return a+b\nresult = ???",
                    listOf("suma 2,3", "suma(2,3)", "suma[2,3]", "suma{2,3}"), 1,
                    "Las funciones se llaman con paréntesis y argumentos separados por comas.")
            )
        ),

        // ============ UNIDAD 4: ESTRUCTURAS DE DATOS ============

        Lesson(
            id = "py_4_1",
            language = "Python",
            unitNumber = 4,
            title = "Listas",
            theoryText = """
                Las listas almacenan colecciones ordenadas y mutables (se pueden cambiar).
                
                🔹 Se crean con [ ]
                🔹 Se accede por índice (desde 0)
                🔹 .append(x): añade al final
                🔹 .remove(x): elimina la primera ocurrencia
                🔹 len(lista): tamaño
                🔹 Se puede iterar con for
            """.trimIndent(),
            codeExample = """
                frutas = ["pera", "uva", "kiwi"]
                
                print(frutas[0])         # pera
                print(len(frutas))       # 3
                
                frutas.append("mango")
                frutas.remove("uva")
                
                print(frutas)            # ['pera', 'kiwi', 'mango']
            """.trimIndent(),
            xpReward = 30,
            exercises = listOf(
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "¿Qué imprime?",
                    "lista = [10, 20, 30]\nprint(lista[1])",
                    listOf("10", "20", "30", "Error"), 1,
                    "Los índices empiezan en 0. Posición 0=10, 1=20, 2=30."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Añade 'azul' al final de la lista:",
                    "colores = [\"rojo\", \"verde\"]\ncolores.???(\"azul\")",
                    listOf("add", "append", "push", "insert"), 1,
                    "append() añade al final de la lista en Python."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "¿Cómo se crea una lista vacía?",
                    "", listOf("lista = ()", "lista = []", "lista = {}", "lista = <>"), 1,
                    "Las listas usan corchetes [ ]. () es una tupla, {} es un diccionario o set."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "¿Qué imprime?",
                    "nums = [5, 10, 15]\nprint(len(nums))",
                    listOf("3", "30", "5", "15"), 0,
                    "len() devuelve el número de elementos: 3."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Accede al ÚLTIMO elemento usando índice negativo:",
                    "lista = [1, 2, 3, 4]\nprint(lista[???])",
                    listOf("0", "4", "-1", "last"), 2,
                    "Los índices negativos cuentan desde el final. -1 es el último.")
            )
        ),

        Lesson(
            id = "py_4_2",
            language = "Python",
            unitNumber = 4,
            title = "Diccionarios",
            theoryText = """
                Los diccionarios almacenan pares clave→valor. Como un objeto JSON.
                
                🔹 Se crean con { clave: valor, ... }
                🔹 Acceso: dict[clave]
                🔹 Asignar: dict[clave] = valor (crea o actualiza)
                🔹 .keys() / .values() / .items()
                🔹 'clave' in dict: comprueba si existe
            """.trimIndent(),
            codeExample = """
                persona = {
                    "nombre": "Ana",
                    "edad": 25
                }
                
                print(persona["nombre"])     # Ana
                
                persona["ciudad"] = "Madrid" # añade clave nueva
                persona["edad"] = 26          # actualiza
                
                print("nombre" in persona)    # True
            """.trimIndent(),
            xpReward = 30,
            exercises = listOf(
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "¿Cómo accedes al valor de la clave 'edad'?",
                    "d = {\"nombre\":\"Ana\", \"edad\":25}",
                    listOf("d.edad", "d[\"edad\"]", "d->edad", "d(edad)"), 1,
                    "En Python se accede con corchetes y la clave entre comillas."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Añade la clave 'pais' con valor 'Italia':",
                    "d = {}\nd[???] = \"Italia\"",
                    listOf("pais", "\"pais\"", "<pais>", "(pais)"), 1,
                    "La clave debe ir como string entre comillas."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "¿Qué devuelve 'nombre' in {\"nombre\":\"Ana\"}?",
                    "", listOf("True", "False", "Ana", "Error"), 0,
                    "El operador 'in' comprueba si una clave existe en el diccionario."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "¿Qué método devuelve solo las CLAVES?",
                    "", listOf(".items()", ".values()", ".keys()", ".all()"), 2,
                    ".keys() devuelve las claves, .values() los valores, .items() pares."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Crea un diccionario vacío:",
                    "d = ???",
                    listOf("[]", "{}", "()", "<>"), 1,
                    "Un diccionario vacío se crea con llaves {}.")
            )
        ),

        // ============ UNIDAD 5: AVANZADO ============

        Lesson(
            id = "py_5_1",
            language = "Python",
            unitNumber = 5,
            title = "List comprehensions",
            theoryText = """
                Las list comprehensions crean listas en una sola línea.
                
                🔹 Sintaxis: [expresión for elemento in iterable]
                🔹 Con condición: [expr for x in lista if condición]
                🔹 Más legibles y rápidas que un for tradicional
            """.trimIndent(),
            codeExample = """
                # Forma tradicional
                cuadrados = []
                for n in range(5):
                    cuadrados.append(n*n)
                # cuadrados = [0,1,4,9,16]
                
                # Con list comprehension
                cuadrados = [n*n for n in range(5)]
                
                # Con filtro
                pares = [n for n in range(10) if n % 2 == 0]
                # pares = [0,2,4,6,8]
            """.trimIndent(),
            xpReward = 40,
            exercises = listOf(
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "¿Qué genera [x*2 for x in range(3)]?",
                    "", listOf("[0,2,4]", "[2,4,6]", "[1,2,3]", "[0,1,2]"), 0,
                    "range(3) = 0,1,2. Multiplicado por 2 = 0,2,4."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Crea una lista con los cuadrados de 1 a 4:",
                    "cuadrados = [??? for x in range(1,5)]",
                    listOf("x+x", "x*2", "x**2", "x*x*x"), 2,
                    "** es potencia. x**2 = x al cuadrado. (x*x también vale, pero hay que elegir esta opción)"),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "¿Qué genera [x for x in range(5) if x > 2]?",
                    "", listOf("[0,1,2]", "[3,4]", "[2,3,4]", "[1,2,3,4]"), 1,
                    "Filtra solo los x > 2 en range(5) = 0,1,2,3,4 → quedan 3 y 4."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "¿Qué hace esto? [s.upper() for s in [\"a\",\"b\"]]",
                    "", listOf("['A','B']", "[\"a\",\"b\"]", "AB", "Error"), 0,
                    "Convierte cada string a mayúsculas. Resultado: ['A','B']."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Filtra solo nombres con más de 4 caracteres:",
                    "n = [\"Ana\", \"Luis\", \"María\"]\nlargos = [x for x in n ??? len(x) > 4]",
                    listOf("for", "if", "where", "while"), 1,
                    "if filtra los elementos en una list comprehension.")
            )
        ),

        Lesson(
            id = "py_5_2",
            language = "Python",
            unitNumber = 5,
            title = "Manejo de excepciones",
            theoryText = """
                Las excepciones son errores que ocurren durante la ejecución.
                Con try/except puedes capturarlos y manejarlos.
                
                🔹 try: bloque que puede fallar
                🔹 except: lo que hacer si falla
                🔹 finally: se ejecuta SIEMPRE (haya error o no)
                🔹 raise: lanza una excepción manualmente
            """.trimIndent(),
            codeExample = """
                try:
                    x = int(input("Número: "))
                    print(10 / x)
                except ValueError:
                    print("Eso no es un número")
                except ZeroDivisionError:
                    print("No se divide por cero")
                finally:
                    print("Fin del programa")
            """.trimIndent(),
            xpReward = 40,
            exercises = listOf(
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "¿Qué excepción lanza 10/0?",
                    "", listOf("ValueError", "TypeError", "ZeroDivisionError", "IndexError"), 2,
                    "Dividir entre cero lanza ZeroDivisionError."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Captura cualquier error que ocurra en el try:",
                    "try:\n    x = riesgoso()\n??? Exception as e:\n    print(e)",
                    listOf("catch", "except", "rescue", "handle"), 1,
                    "En Python se usa 'except', no 'catch' como en otros lenguajes."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "¿Qué bloque se ejecuta SIEMPRE, haya error o no?",
                    "", listOf("try", "except", "finally", "else"), 2,
                    "finally se ejecuta siempre. Útil para liberar recursos (cerrar archivos, etc.)."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "¿Qué imprime?",
                    "try:\n    print(int('abc'))\nexcept ValueError:\n    print('mal')",
                    listOf("abc", "mal", "Error", "0"), 1,
                    "int('abc') falla con ValueError, así que entra en el except → imprime 'mal'."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Lanza manualmente una excepción:",
                    "if edad < 0:\n    ??? ValueError(\"Edad inválida\")",
                    listOf("throw", "raise", "except", "error"), 1,
                    "raise es la palabra clave para lanzar excepciones en Python.")
            )
        )
    )
}