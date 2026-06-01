package com.exemple.codegym.data.lessons

import com.exemple.codegym.models.ExerciseType
import com.exemple.codegym.models.Lesson
import com.exemple.codegym.models.LessonExercise

/**
 * Lecciones de C++: 10 lecciones por unidades.
 */
object CppLessons {

    val lessons: List<Lesson> = listOf(

        // ============ UNIDAD 1: C++ BÁSICO ============

        Lesson(
            id = "cpp_1_1",
            language = "C++",
            unitNumber = 1,
            title = "Hola mundo y cout",
            theoryText = """
                En C++ para imprimir se usa cout (se lee "ce-out") del namespace std.
                
                🔹 std::cout es el flujo de salida estándar
                🔹 << inserta valores en el flujo
                🔹 std::endl o "\n" hace salto de línea
                🔹 #include <iostream> es necesario
                🔹 Cada sentencia termina con ;
            """.trimIndent(),
            codeExample = """
                #include <iostream>
                using namespace std;
                
                int main() {
                    cout << "Hola mundo" << endl;
                    cout << "Edad: " << 25 << endl;
                    return 0;
                }
            """.trimIndent(),
            xpReward = 25,
            exercises = listOf(
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "¿Cuál es la forma correcta de imprimir en C++?",
                    "", listOf("print(\"hola\")", "cout << \"hola\";", "echo \"hola\";", "println(\"hola\");"), 1,
                    "En C++ se usa cout junto con el operador << para imprimir."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Completa el include necesario para usar cout:",
                    "#include <???>",
                    listOf("stdio", "iostream", "string", "stdlib"),
                    1, "iostream contiene cout, cin, endl y otros flujos de E/S."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "¿Qué hace endl?",
                    "", listOf("Termina el programa", "Salto de línea", "Borra la pantalla", "Pausa"), 1,
                    "endl inserta un salto de línea (equivalente a \"\\n\")."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "¿Qué función es la entrada principal de un programa C++?",
                    "", listOf("start()", "main()", "begin()", "init()"), 1,
                    "main() es la función obligatoria por la que empieza la ejecución."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Imprime 5 con cout:",
                    "cout ??? 5 << endl;",
                    listOf(">>", "<<", "->", "."), 1,
                    "El operador << inserta valores en el stream de salida.")
            )
        ),

        Lesson(
            id = "cpp_1_2",
            language = "C++",
            unitNumber = 1,
            title = "Variables y tipos",
            theoryText = """
                C++ es un lenguaje fuertemente tipado: hay que declarar el tipo de cada variable.
                
                🔹 int: entero
                🔹 double / float: decimales
                🔹 char: un solo carácter (con comilla simple)
                🔹 bool: true/false
                🔹 string: cadena (necesita #include <string>)
                🔹 const: hace la variable inmutable
            """.trimIndent(),
            codeExample = """
                #include <string>
                
                int edad = 25;
                double altura = 1.65;
                char inicial = 'A';
                bool esEstudiante = true;
                std::string nombre = "Ana";
                const double PI = 3.14159;
                
                // PI = 3.14;  // ❌ ERROR: const no se modifica
            """.trimIndent(),
            xpReward = 25,
            exercises = listOf(
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "¿Qué tipo usar para guardar 'A'?",
                    "", listOf("string", "char", "int", "byte"), 1,
                    "char guarda UN solo carácter. Va con comilla simple ' '."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Declara una constante PI:",
                    "??? double PI = 3.14;",
                    listOf("var", "const", "final", "static"), 1,
                    "const hace la variable inmutable en C++."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "¿Qué falta en esta línea?\nint x = 5",
                    "", listOf("Llave }", "Punto y coma ;", "Coma ,", "Nada"), 1,
                    "En C++ todas las sentencias terminan con punto y coma."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "¿Cuál es el tipo CORRECTO para 1.5?",
                    "", listOf("int", "char", "double", "string"), 2,
                    "double almacena decimales con doble precisión."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Declara una variable bool inicializada a falso:",
                    "??? activo = false;",
                    listOf("boolean", "bool", "Boolean", "logic"), 1,
                    "En C++ el tipo se llama bool, no boolean.")
            )
        ),

        Lesson(
            id = "cpp_1_3",
            language = "C++",
            unitNumber = 1,
            title = "cin (entrada por teclado)",
            theoryText = """
                cin lee datos del usuario por teclado.
                
                🔹 cin >> variable: lee y guarda en la variable
                🔹 Se pueden encadenar: cin >> x >> y;
                🔹 cin solo lee hasta el primer espacio
                🔹 Para leer una línea entera: getline(cin, str)
            """.trimIndent(),
            codeExample = """
                #include <iostream>
                #include <string>
                using namespace std;
                
                int main() {
                    int edad;
                    string nombre;
                    
                    cout << "Edad: ";
                    cin >> edad;
                    
                    cout << "Nombre: ";
                    cin.ignore();
                    getline(cin, nombre);
                    
                    cout << "Hola " << nombre << endl;
                }
            """.trimIndent(),
            xpReward = 25,
            exercises = listOf(
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "¿Cómo se LEE entrada en C++?",
                    "", listOf("cout >>", "cin >>", "input()", "read()"), 1,
                    "cin (con operador >>) lee del teclado."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Lee un entero del teclado:",
                    "int n;\ncin ??? n;",
                    listOf("<<", ">>", "->", "."), 1,
                    "El operador >> extrae del stream de entrada hacia la variable."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "¿Qué función lee una LÍNEA ENTERA con espacios?",
                    "", listOf("cin", "scanf", "getline", "fgets"), 2,
                    "getline(cin, str) lee hasta encontrar un salto de línea."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "Si pides un int con cin y el usuario escribe 'abc', ¿qué pasa?",
                    "", listOf("Compila y guarda 0", "El stream entra en estado de error", "El programa crashea", "Convierte la cadena"), 1,
                    "cin entra en estado fail. La variable queda con valor indeterminado."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Lee dos enteros encadenados:",
                    "int a, b;\ncin ??? a ??? b;",
                    listOf(">>, <<", ">>, >>", "<<, <<", "->, ->"), 1,
                    "Se pueden encadenar varios >> para leer varias variables seguidas.")
            )
        ),

        // ============ UNIDAD 2: CONTROL DE FLUJO ============

        Lesson(
            id = "cpp_2_1",
            language = "C++",
            unitNumber = 2,
            title = "if y switch",
            theoryText = """
                Las condicionales en C++ son similares a Java y C.
                
                🔹 if (condición) { ... }
                🔹 else if / else
                🔹 switch (variable) { case x: ... break; default: ... }
                🔹 Operador ternario: cond ? sí : no
                🔹 IMPORTANTE: switch usa break o sigue cayendo en cascada
            """.trimIndent(),
            codeExample = """
                int dia = 3;
                
                if (dia == 1) {
                    cout << "Lunes";
                } else if (dia == 2) {
                    cout << "Martes";
                } else {
                    cout << "Otro día";
                }
                
                // Con switch
                switch (dia) {
                    case 1: cout << "Lunes"; break;
                    case 2: cout << "Martes"; break;
                    default: cout << "Otro";
                }
            """.trimIndent(),
            xpReward = 30,
            exercises = listOf(
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "¿Qué pasa si OLVIDAS el break en un case?",
                    "", listOf("Error de compilación", "Continúa ejecutando los siguientes case (fall-through)", "Termina el programa", "Salta al default"), 1,
                    "Sin break, la ejecución 'cae' al siguiente case. Es un error muy común."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Operador ternario para asignar 'mayor' o 'menor':",
                    "string s = (x > 0) ??? \"mayor\" : \"menor\";",
                    listOf(":", "?", ".", "="), 1,
                    "Sintaxis: condición ? valorSi : valorNo. El ? va primero."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "¿Qué imprime?\nint x = 5;\nif (x > 3) cout << \"A\";\nelse cout << \"B\";",
                    "", listOf("A", "B", "AB", "Error"), 0,
                    "5 > 3 es true, entra en el if e imprime 'A'."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "¿Qué hace 'default' en un switch?",
                    "", listOf("Se ejecuta primero", "Se ejecuta si NINGÚN case coincide", "Es obligatorio", "Termina el switch"), 1,
                    "default es opcional, se ejecuta si ningún case coincide. Como el else."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Comprueba si 2 condiciones son ambas true:",
                    "if (x > 0 ??? y > 0) { ... }",
                    listOf("AND", "&&", "and", "&"), 1,
                    "&& es el AND lógico. & es a nivel de bits.")
            )
        ),

        Lesson(
            id = "cpp_2_2",
            language = "C++",
            unitNumber = 2,
            title = "Bucles for, while y do-while",
            theoryText = """
                C++ tiene los bucles clásicos.
                
                🔹 for (inicio; condición; paso) { ... }
                🔹 while (condición) { ... }
                🔹 do { ... } while (condición); ← se ejecuta al menos 1 vez
                🔹 break y continue funcionan como en Java
                🔹 Range-based: for (int x : vector) { ... }  (C++11+)
            """.trimIndent(),
            codeExample = """
                // for clásico
                for (int i = 0; i < 5; i++) {
                    cout << i << " ";   // 0 1 2 3 4
                }
                
                // while
                int n = 10;
                while (n > 0) {
                    cout << n;
                    n--;
                }
                
                // Range-based (C++11)
                int nums[] = {10, 20, 30};
                for (int x : nums) cout << x;
            """.trimIndent(),
            xpReward = 30,
            exercises = listOf(
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "¿Cuántas veces imprime?\nfor (int i=0; i<5; i++) cout << \"x\";",
                    "", listOf("4", "5", "6", "0"), 1,
                    "i va de 0 a 4 → 5 iteraciones."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Decremento en cada iteración:",
                    "for (int i=10; i>0; ???) { ... }",
                    listOf("i+1", "i--", "i+=1", "i*-1"), 1,
                    "i-- decrementa la variable en cada iteración."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "¿Cuál se ejecuta SIEMPRE al menos una vez?",
                    "", listOf("for", "while", "do-while", "ninguno"), 2,
                    "do-while ejecuta el cuerpo PRIMERO y luego comprueba la condición."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "¿Qué hace 'break' dentro de un bucle?",
                    "", listOf("Salta a la siguiente iteración", "Sale del bucle", "Reinicia el bucle", "Pausa"), 1,
                    "break sale completamente del bucle más interno."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Range-based for sobre array:",
                    "int arr[] = {1,2,3};\nfor (int x ??? arr) cout << x;",
                    listOf("in", ":", ",", "of"), 1,
                    "El range-based for de C++11 usa : para separar variable y colección.")
            )
        ),

        // ============ UNIDAD 3: FUNCIONES Y PUNTEROS ============

        Lesson(
            id = "cpp_3_1",
            language = "C++",
            unitNumber = 3,
            title = "Funciones",
            theoryText = """
                Las funciones se declaran con tipo de retorno + nombre + parámetros.
                
                🔹 tipo nombre(parámetros) { ... }
                🔹 void: no devuelve nada
                🔹 return devuelve un valor
                🔹 Parámetros por valor (copia) o por referencia (&)
                🔹 Sobrecarga: varias funciones con el mismo nombre y diferentes parámetros
            """.trimIndent(),
            codeExample = """
                // Función con retorno
                int sumar(int a, int b) {
                    return a + b;
                }
                
                // void = sin retorno
                void saludar(string nombre) {
                    cout << "Hola " << nombre;
                }
                
                // Por referencia (modifica el original)
                void incrementar(int& x) {
                    x++;
                }
                
                int n = 5;
                incrementar(n);   // n vale 6
            """.trimIndent(),
            xpReward = 35,
            exercises = listOf(
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "¿Qué tipo retorna una función que NO devuelve nada?",
                    "", listOf("null", "void", "empty", "none"), 1,
                    "void indica ausencia de valor de retorno."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Devuelve el doble de x:",
                    "int doble(int x) {\n    ??? x * 2;\n}",
                    listOf("print", "return", "yield", "give"), 1,
                    "return envía el valor de vuelta a quien llamó la función."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "¿Qué hace pasar un parámetro por REFERENCIA (&)?",
                    "", listOf("Crea una copia", "Permite modificar el original", "Es más lento", "Copia solo el puntero"), 1,
                    "Pasar por referencia (&) permite que la función modifique la variable original."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "¿Es válido tener 2 funciones con el mismo nombre y diferentes parámetros?",
                    "", listOf("Sí, se llama sobrecarga", "No, da error", "Solo en main()", "Solo si son void"), 0,
                    "C++ permite sobrecarga de funciones: el compilador elige según los argumentos."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Pasa el parámetro por REFERENCIA:",
                    "void cambiar(int??? x) { x = 10; }",
                    listOf("*", "&", "@", "$"), 1,
                    "& en el parámetro indica paso por referencia. * sería un puntero.")
            )
        ),

        Lesson(
            id = "cpp_3_2",
            language = "C++",
            unitNumber = 3,
            title = "Punteros",
            theoryText = """
                Un puntero es una variable que almacena la DIRECCIÓN DE MEMORIA de otra variable.
                
                🔹 & (operador dirección): obtiene la dirección
                🔹 * (operador desreferencia): accede al valor
                🔹 int* p declara puntero a int
                🔹 nullptr representa puntero nulo
                🔹 Aritmética de punteros: p++, p+1
            """.trimIndent(),
            codeExample = """
                int x = 42;
                int* p = &x;        // p guarda la dirección de x
                
                cout << x;          // 42
                cout << p;          // dirección hex
                cout << *p;         // 42 (el valor al que apunta)
                
                *p = 100;           // Cambia x a 100 a través del puntero
                cout << x;          // 100
                
                int* nulo = nullptr;  // puntero nulo seguro
            """.trimIndent(),
            xpReward = 40,
            exercises = listOf(
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "Si int x=10 y int* p=&x, ¿qué imprime cout << *p?",
                    "", listOf("La dirección de x", "10", "Error", "Un valor aleatorio"), 1,
                    "*p (desreferencia) accede al valor en la dirección. Como p apunta a x → 10."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Guarda la dirección de x:",
                    "int x = 5;\nint* ptr = ???x;",
                    listOf("&", "*", "@", "#"), 0,
                    "& devuelve la dirección de memoria de una variable."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "¿Qué representa nullptr?",
                    "", listOf("Cero", "Un puntero nulo seguro", "Una excepción", "Falso"), 1,
                    "nullptr (C++11) es la forma SEGURA de representar un puntero nulo. Sustituye al viejo NULL."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "¿Cuál declara correctamente un puntero a int?",
                    "", listOf("int p*", "int* p", "ptr<int> p", "*int p"), 1,
                    "int* p o int *p (el espacio es opcional). El asterisco va junto al tipo."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Modifica x a 20 a través del puntero p:",
                    "int x = 5;\nint* p = &x;\n???p = 20;",
                    listOf("&", "*", "->", "."), 1,
                    "*p accede al valor apuntado. *p = 20 modifica x.")
            )
        ),

        // ============ UNIDAD 4: POO ============

        Lesson(
            id = "cpp_4_1",
            language = "C++",
            unitNumber = 4,
            title = "Clases y objetos",
            theoryText = """
                Las clases en C++ tienen secciones públicas y privadas.
                
                🔹 class Nombre { ... };  ⚠️ termina con ;
                🔹 public: / private: marcan secciones
                🔹 Constructor: mismo nombre que la clase
                🔹 Destructor: ~Clase()
                🔹 Acceso a miembros: . (objeto) o -> (puntero)
            """.trimIndent(),
            codeExample = """
                class Persona {
                private:
                    string nombre;
                    int edad;
                
                public:
                    // Constructor
                    Persona(string n, int e) {
                        nombre = n;
                        edad = e;
                    }
                    
                    void saludar() {
                        cout << "Hola, soy " << nombre;
                    }
                };
                
                Persona p("Ana", 25);
                p.saludar();
            """.trimIndent(),
            xpReward = 40,
            exercises = listOf(
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "¿Con qué carácter TERMINA una declaración de clase en C++?",
                    "", listOf("Llave }", "Punto y coma ;", "Coma ,", "Nada"), 1,
                    "Las clases en C++ terminan con }; (llave + punto y coma). Es un error común olvidarlo."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Hace que un atributo sea inaccesible desde fuera:",
                    "class A {\n    ???: int valor;\n};",
                    listOf("public", "private", "protected", "hidden"), 1,
                    "private restringe el acceso a la propia clase."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "¿Cómo se llama al método especial que se ejecuta al crear el objeto?",
                    "", listOf("init()", "create()", "Constructor (mismo nombre que la clase)", "main()"), 2,
                    "El constructor tiene el mismo nombre que la clase y se ejecuta al instanciar."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "¿Para acceder a miembros DESDE UN PUNTERO usas?",
                    "", listOf(".", "::", "->", "&"), 2,
                    "-> es para punteros. . es para objetos directos. p->metodo() equivale a (*p).metodo()."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Define el destructor de la clase Persona:",
                    "class Persona {\npublic:\n    ???Persona() { /* limpieza */ }\n};",
                    listOf("!", "~", "-", "del"), 1,
                    "El destructor lleva ~ antes del nombre. Se llama al destruir el objeto.")
            )
        ),

        // ============ UNIDAD 5: AVANZADO ============

        Lesson(
            id = "cpp_5_1",
            language = "C++",
            unitNumber = 5,
            title = "Vectors (STL)",
            theoryText = """
                vector es un array dinámico de la STL (Standard Template Library).
                
                🔹 #include <vector>
                🔹 vector<Tipo> v; declaración
                🔹 .push_back(x): añadir al final
                🔹 .pop_back(): elimina el último
                🔹 .size(): tamaño
                🔹 v[i] o v.at(i): acceder por índice (.at lanza excepción si fuera de rango)
            """.trimIndent(),
            codeExample = """
                #include <vector>
                using namespace std;
                
                vector<int> nums;
                nums.push_back(10);
                nums.push_back(20);
                nums.push_back(30);
                
                cout << nums[0];        // 10
                cout << nums.size();    // 3
                
                nums.pop_back();        // elimina 30
                
                for (int n : nums) cout << n;
            """.trimIndent(),
            xpReward = 45,
            exercises = listOf(
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "¿Qué método AÑADE al final de un vector?",
                    "", listOf("add()", "push_back()", "append()", "insert()"), 1,
                    "push_back() añade un elemento al final del vector."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Declara un vector de strings:",
                    "vector<???> nombres;",
                    listOf("string", "char", "String", "char*"), 0,
                    "vector<string> es la sintaxis correcta. Necesitas #include <string>."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "¿Qué devuelve v.size()?",
                    "", listOf("La capacidad", "El número de elementos", "El primer elemento", "Bytes ocupados"), 1,
                    ".size() devuelve cuántos elementos tiene el vector actualmente."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "¿Diferencia entre v[5] y v.at(5)?",
                    "", listOf(
                        "Ninguna",
                        ".at() lanza excepción si fuera de rango, [] no",
                        "[] es más lento",
                        ".at() solo lectura"
                    ), 1,
                    ".at() es seguro: lanza out_of_range si el índice no es válido. [] no comprueba."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Elimina el último elemento del vector:",
                    "v.???();",
                    listOf("pop", "pop_back", "remove_last", "erase_end"), 1,
                    "pop_back() elimina el último elemento del vector.")
            )
        ),

        Lesson(
            id = "cpp_5_2",
            language = "C++",
            unitNumber = 5,
            title = "Smart Pointers",
            theoryText = """
                Los smart pointers gestionan automáticamente la memoria, evitando memory leaks.
                
                🔹 #include <memory>
                🔹 unique_ptr: dueño único, se destruye automáticamente
                🔹 shared_ptr: varios pueden compartir, se destruye con el último
                🔹 weak_ptr: referencia débil, no afecta al contador
                🔹 make_unique<T>() / make_shared<T>(): forma recomendada de crearlos
            """.trimIndent(),
            codeExample = """
                #include <memory>
                using namespace std;
                
                // unique_ptr (C++14)
                auto p = make_unique<int>(42);
                cout << *p;   // 42
                // No hace falta delete, se libera solo
                
                // shared_ptr
                auto sp = make_shared<string>("Hola");
                auto sp2 = sp;   // ahora ambos apuntan; contador = 2
                // Se libera cuando no queden referencias
            """.trimIndent(),
            xpReward = 50,
            exercises = listOf(
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "¿Cuál es el principal beneficio de smart pointers?",
                    "", listOf("Son más rápidos", "Gestionan memoria automáticamente, evitan memory leaks", "Ocupan menos", "Son obligatorios"), 1,
                    "Su gran ventaja: liberan la memoria automáticamente cuando ya no se usan."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Crea un unique_ptr a un int con valor 100:",
                    "auto p = ???<int>(100);",
                    listOf("new_unique", "make_unique", "create_unique", "unique"), 1,
                    "make_unique<T>(args) es la forma recomendada y segura."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "¿Cuántos unique_ptr pueden apuntar al mismo objeto?",
                    "", listOf("0", "1 (es único)", "2", "Ilimitados"), 1,
                    "unique_ptr tiene propiedad única. Solo uno es dueño del recurso."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "¿Cuándo se libera la memoria de un shared_ptr?",
                    "", listOf("Al instante", "Cuando el contador llega a 0 (sin referencias)", "Manualmente con delete", "Nunca"), 1,
                    "shared_ptr usa contador de referencias. Libera cuando llega a 0."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Declara un shared_ptr con make_shared:",
                    "auto sp = ???<string>(\"Hola\");",
                    listOf("make_unique", "make_shared", "make_weak", "make_ptr"), 1,
                    "make_shared<T>() crea un shared_ptr de forma eficiente.")
            )
        )
    )
}