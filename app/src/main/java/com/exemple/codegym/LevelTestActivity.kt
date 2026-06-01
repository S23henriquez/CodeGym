package com.exemple.codegym

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.lifecycleScope
import com.exemple.codegym.data.UserRepository
import com.exemple.codegym.databinding.ActivityLevelTestBinding
import com.exemple.codegym.models.LevelQuestion
import com.exemple.codegym.models.UserLevel
import kotlinx.coroutines.launch

class LevelTestActivity : BaseActivity() {

    companion object {
        const val EXTRA_LANGUAGE = "language" // Clave para pasar el lenguaje seleccionado

        // 30 preguntas por lenguaje (se seleccionarán 10 aleatorias por test)
        val QUESTIONS: Map<String, List<LevelQuestion>> = mapOf(

            // Preguntas de Python de nivel variado (principiante a avanzado)

            "Python" to listOf(
                LevelQuestion(1, "¿Cómo se declara una variable en Python?",
                    listOf("var x = 5", "x = 5", "int x = 5", "let x = 5"), 1, "Python"),          // B - Respuesta correcta en índice 1
                LevelQuestion(2, "¿Qué devuelve type(3.14)?",
                    listOf("<class 'float'>", "<class 'int'>", "<class 'str'>", "None"), 0, "Python"), // A
                LevelQuestion(3, "¿Cómo se crea una lista vacía?",
                    listOf("list = {}", "list = ()", "list = <>", "list = []"), 3, "Python"),          // D
                LevelQuestion(4, "¿Cuál es la salida de print(2 ** 3)?",
                    listOf("6", "9", "8", "Error"), 2, "Python"),                                      // C
                LevelQuestion(5, "¿Qué hace range(5)?",
                    listOf("Genera [1,2,3,4,5]", "Genera [0,1,2,3,4,5]", "Genera [0,1,2,3,4]", "Genera 5 aleatorios"), 2, "Python"), // C
                LevelQuestion(6, "¿Cómo se hereda una clase en Python?",
                    listOf("class B extends A", "class B inherits A", "class B : A", "class B(A):"), 3, "Python"), // D
                LevelQuestion(7, "¿Qué es un decorator?",
                    listOf("Un tipo de variable", "Un módulo externo", "Una función que modifica otra función", "Un operador lógico"), 2, "Python"), // C
                LevelQuestion(8, "¿Qué hace yield?",
                    listOf("Convierte la función en generador", "Retorna y termina la función", "Lanza una excepción", "Define un parámetro"), 0, "Python"), // A
                LevelQuestion(9, "¿Complejidad de buscar en un set?",
                    listOf("O(n)", "O(log n)", "O(n²)", "O(1)"), 3, "Python"),                        // D
                LevelQuestion(10, "¿Qué es GIL en Python?",
                    listOf("Un framework web", "Un gestor de paquetes", "Un lock que impide ejecución paralela de hilos", "Una versión de Python"), 2, "Python"), // C
                LevelQuestion(11, "¿Símbolo para comentarios en Python?",
                    listOf("#", "//", "/*", "--"), 0, "Python"),                                       // A
                LevelQuestion(12, "¿Método para añadir al final de una lista?",
                    listOf("add()", "insert()", "push()", "append()"), 3, "Python"),                   // D
                LevelQuestion(13, "¿Cómo se abre un archivo?",
                    listOf("File.open('f')", "read('f')", "open('f')", "load('f')"), 2, "Python"),     // C
                LevelQuestion(14, "¿Qué es un diccionario?",
                    listOf("Una lista ordenada", "Un conjunto único", "Un tipo de función", "Una estructura clave-valor"), 3, "Python"), // D
                LevelQuestion(15, "¿Qué devuelve len('hola')?",
                    listOf("3", "5", "4", "Error"), 2, "Python"),                                      // C
                LevelQuestion(16, "¿Palabra clave para definir función?",
                    listOf("function", "fun", "def", "func"), 2, "Python"),                            // C
                LevelQuestion(17, "¿Qué es una tupla?",
                    listOf("Una lista mutable", "Una secuencia inmutable", "Un diccionario", "Un conjunto"), 1, "Python"), // B
                LevelQuestion(18, "¿Qué hace split()?",
                    listOf("Une strings", "Elimina espacios", "Convierte a mayúsculas", "Divide un string en lista"), 3, "Python"), // D
                LevelQuestion(19, "¿Qué es pip?",
                    listOf("Un IDE", "Un gestor de paquetes", "Un tipo de bucle", "Un debugger"), 1, "Python"), // B
                LevelQuestion(20, "¿Qué hace isinstance(x, int)?",
                    listOf("Convierte x a int", "Comprueba si x es de tipo int", "Suma x a int", "Declara x como int"), 1, "Python"), // B
                LevelQuestion(21, "¿Cuál es la salida de bool(0)?",
                    listOf("True", "False", "0", "Error"), 1, "Python"),                               // B
                LevelQuestion(22, "¿Qué hace el operador //?",
                    listOf("Módulo", "Exponente", "División entera", "División normal"), 2, "Python"), // C
                LevelQuestion(23, "¿Qué es una list comprehension?",
                    listOf("Un tipo de bucle for", "Una función lambda", "Una forma compacta de crear listas", "Un método de listas"), 2, "Python"), // C
                LevelQuestion(24, "¿Qué hace enumerate(lista)?",
                    listOf("Cuenta elementos", "Ordena la lista", "Elimina duplicados", "Devuelve índice y valor en iteración"), 3, "Python"), // D
                LevelQuestion(25, "¿Módulo para números aleatorios?",
                    listOf("random", "math", "numpy", "os"), 0, "Python"),                             // A
                LevelQuestion(26, "¿Qué hace strip()?",
                    listOf("Elimina letras", "Divide el string", "Convierte a lista", "Elimina espacios al inicio y final"), 3, "Python"), // D
                LevelQuestion(27, "¿Qué es una función lambda?",
                    listOf("Una función recursiva", "Una función anónima de una línea", "Una función asíncrona", "Una función decorada"), 1, "Python"), // B
                LevelQuestion(28, "¿Qué hace zip(lista1, lista2)?",
                    listOf("Comprime archivos", "Duplica listas", "Combina dos listas en pares", "Filtra elementos"), 2, "Python"), // C
                LevelQuestion(29, "¿Qué es __init__?",
                    listOf("Un destructor", "Un método estático", "El constructor de la clase", "Un método privado"), 2, "Python"), // C
                LevelQuestion(30, "¿Qué hace map(func, lista)?",
                    listOf("Filtra elementos", "Aplica func a cada elemento", "Ordena la lista", "Cuenta elementos"), 1, "Python")  // B
            ),

            // Preguntas de Java de nivel variado (principiante a avanzado)
            "Java" to listOf(
                LevelQuestion(1, "¿Cómo se declara un entero en Java?",
                    listOf("integer x = 5", "int x = 5;", "var x = 5", "x: Int = 5"), 1, "Java"),         // B
                LevelQuestion(2, "¿Qué es JVM?",
                    listOf("Java Virtual Machine, ejecuta bytecode", "Un IDE", "Un framework", "Un gestor de dependencias"), 0, "Java"), // A
                LevelQuestion(3, "¿Clase base de todas las clases en Java?",
                    listOf("Base", "Class", "Object", "Super"), 2, "Java"),                                 // C
                LevelQuestion(4, "¿Qué hace el modificador final?",
                    listOf("Hace la clase abstracta", "Hace el método público", "Elimina el objeto", "Impide herencia o reasignación"), 3, "Java"), // D
                LevelQuestion(5, "¿Diferencia entre == y equals() en Strings?",
                    listOf("Son iguales", "equals() es más rápido", "== compara referencia, equals() contenido", "== solo funciona con int"), 2, "Java"), // C
                LevelQuestion(6, "¿Qué es una interfaz en Java?",
                    listOf("Una clase con constructor", "Un tipo de variable", "Un loop especial", "Un contrato de métodos abstractos"), 3, "Java"), // D
                LevelQuestion(7, "¿Qué hace synchronized?",
                    listOf("Controla acceso concurrente a un bloque", "Ordena una lista", "Sincroniza bases de datos", "Importa librerías"), 0, "Java"), // A
                LevelQuestion(8, "¿Qué es el patrón Singleton?",
                    listOf("Una clase con múltiples instancias", "Una clase con una sola instancia global", "Un tipo de array", "Un método estático"), 1, "Java"), // B
                LevelQuestion(9, "¿Qué es Optional<T>?",
                    listOf("Un array opcional", "Una interfaz genérica", "Un contenedor que puede o no tener valor", "Un tipo primitivo"), 2, "Java"), // C
                LevelQuestion(10, "¿Qué es un Stream en Java 8+?",
                    listOf("Un hilo de ejecución", "Un socket de red", "Un tipo de archivo", "Una secuencia de elementos para operaciones funcionales"), 3, "Java"), // D
                LevelQuestion(11, "¿Qué es el garbage collector?",
                    listOf("Un debugger", "Un gestor de memoria automático", "Un compilador", "Un framework"), 1, "Java"), // B
                LevelQuestion(12, "¿Qué significa public static void main?",
                    listOf("Un método privado", "Un constructor", "Un método abstracto", "El punto de entrada del programa"), 3, "Java"), // D
                LevelQuestion(13, "¿Qué es una excepción checked?",
                    listOf("Una excepción en tiempo de ejecución", "Un error del sistema", "Una excepción que debe manejarse en compilación", "Una excepción ignorada"), 2, "Java"), // C
                LevelQuestion(14, "¿Qué hace ArrayList?",
                    listOf("Un array de tamaño fijo", "Un mapa clave-valor", "Un conjunto sin duplicados", "Una lista dinámica basada en array"), 3, "Java"), // D
                LevelQuestion(15, "¿Qué es la herencia en Java?",
                    listOf("Compartir variables globales", "Una clase que extiende otra", "Implementar una interfaz", "Sobrecarga de métodos"), 1, "Java"), // B
                LevelQuestion(16, "¿Qué hace toString()?",
                    listOf("Convierte a número", "Devuelve representación en String del objeto", "Compara objetos", "Clona el objeto"), 1, "Java"), // B
                LevelQuestion(17, "¿Qué es un constructor?",
                    listOf("Un método que destruye el objeto", "Una variable estática", "Un método heredado", "Un método especial que inicializa el objeto"), 3, "Java"), // D
                LevelQuestion(18, "¿Qué hace instanceof?",
                    listOf("Crea una instancia", "Cuenta instancias", "Comprueba si un objeto es de cierto tipo", "Destruye una instancia"), 2, "Java"), // C
                LevelQuestion(19, "¿Qué es el polimorfismo?",
                    listOf("Tener múltiples constructores", "Herencia múltiple", "Un tipo de bucle", "Un objeto que puede tomar múltiples formas"), 3, "Java"), // D
                LevelQuestion(20, "¿Qué hace HashMap?",
                    listOf("Una lista ordenada", "Un conjunto de valores únicos", "Una estructura clave-valor con acceso O(1)", "Un array dinámico"), 2, "Java"), // C
                LevelQuestion(21, "¿Qué es abstract en Java?",
                    listOf("Una clase que no puede instanciarse directamente", "Una clase final", "Un método público", "Un tipo primitivo"), 0, "Java"), // A
                LevelQuestion(22, "¿Qué hace super()?",
                    listOf("Llama al constructor de la clase padre", "Llama al método estático", "Destruye el objeto padre", "Crea una superclase"), 0, "Java"), // A
                LevelQuestion(23, "¿Qué es encapsulamiento?",
                    listOf("Heredar de múltiples clases", "Sobrecargar métodos", "Crear interfaces", "Ocultar implementación y exponer solo lo necesario"), 3, "Java"), // D
                LevelQuestion(24, "¿Qué hace try-catch?",
                    listOf("Maneja excepciones", "Crea hilos", "Importa librerías", "Define interfaces"), 0, "Java"), // A
                LevelQuestion(25, "¿Qué es un enum en Java?",
                    listOf("Un tipo de array", "Un conjunto de constantes con nombre", "Una interfaz especial", "Un tipo primitivo"), 1, "Java"), // B
                LevelQuestion(26, "¿Qué hace Collections.sort()?",
                    listOf("Filtra una colección", "Elimina duplicados", "Ordena una lista", "Cuenta elementos"), 2, "Java"), // C
                LevelQuestion(27, "¿Qué es un lambda en Java 8?",
                    listOf("Un tipo de clase", "Un tipo de bucle", "Un método estático", "Una función anónima concisa"), 3, "Java"), // D
                LevelQuestion(28, "¿Qué hace this en Java?",
                    listOf("Llama al padre", "Referencia al objeto actual", "Crea una copia", "Destruye el objeto"), 1, "Java"), // B
                LevelQuestion(29, "¿Qué es un package en Java?",
                    listOf("Una librería externa", "Un agrupador de clases relacionadas", "Un tipo de archivo", "Un módulo del SO"), 1, "Java"), // B
                LevelQuestion(30, "¿Qué hace String.format()?",
                    listOf("Convierte a mayúsculas", "Divide un string", "Crea un string formateado con variables", "Compara strings"), 2, "Java")  // C
            ),

            // Preguntas de Kotlin de nivel variado
            "Kotlin" to listOf(
                LevelQuestion(1, "¿Cómo se declara una variable inmutable?",
                    listOf("var x = 5", "let x = 5", "val x = 5", "const x = 5"), 2, "Kotlin"),           // C
                LevelQuestion(2, "¿Qué es null safety en Kotlin?",
                    listOf("Es una librería externa", "El compilador previene NullPointerException", "Kotlin no tiene null", "Solo aplica a Int"), 1, "Kotlin"), // B
                LevelQuestion(3, "¿Para qué sirve ?. en Kotlin?",
                    listOf("Safe call: solo ejecuta si no es null", "Comparación", "Lanza excepción", "Declaración de tipo"), 0, "Kotlin"), // A
                LevelQuestion(4, "¿Qué es una data class?",
                    listOf("Una clase sin métodos", "Una clase abstracta", "Un objeto singleton", "Clase que genera equals/hashCode/copy automáticamente"), 3, "Kotlin"), // D
                LevelQuestion(5, "¿Diferencia entre List y MutableList?",
                    listOf("No hay diferencia", "MutableList es más lenta", "List es inmutable, MutableList permite cambios", "List solo acepta String"), 2, "Kotlin"), // C
                LevelQuestion(6, "¿Qué son las extension functions?",
                    listOf("Funciones heredadas", "Funciones asíncronas", "Funciones privadas", "Funciones que añaden comportamiento sin herencia"), 3, "Kotlin"), // D
                LevelQuestion(7, "¿Qué es una sealed class?",
                    listOf("Una clase con jerarquía cerrada de subclases", "Una clase final", "Una clase abstracta", "Un enum especial"), 0, "Kotlin"), // A
                LevelQuestion(8, "¿Qué hace suspend en una función?",
                    listOf("La pausa permanentemente", "La convierte en corrutina suspendible", "La hace privada", "La hace recursiva"), 1, "Kotlin"), // B
                LevelQuestion(9, "¿Qué es Flow en Kotlin?",
                    listOf("Un bucle especial", "Un tipo de lista", "Una secuencia asíncrona de valores", "Una colección ordenada"), 2, "Kotlin"), // C
                LevelQuestion(10, "¿Qué es el operador ?:",
                    listOf("Safe call", "Comparación", "Nullable cast", "Elvis: devuelve valor por defecto si es null"), 3, "Kotlin"), // D
                LevelQuestion(11, "¿Diferencia entre var y val?",
                    listOf("var es inmutable, val es mutable", "var es mutable, val es inmutable", "Son lo mismo", "val es solo para números"), 1, "Kotlin"), // B
                LevelQuestion(12, "¿Qué es un object en Kotlin?",
                    listOf("Una instancia normal", "Un tipo de interfaz", "Un singleton declarado directamente", "Una clase abstracta"), 2, "Kotlin"), // C
                LevelQuestion(13, "¿Qué hace let en Kotlin?",
                    listOf("Declara una variable", "Ejecuta un bloque con el objeto como argumento", "Lanza una excepción", "Crea un bucle"), 1, "Kotlin"), // B
                LevelQuestion(14, "¿Qué es un companion object?",
                    listOf("Un objeto externo", "Una clase hija", "Un módulo", "Miembros estáticos dentro de una clase"), 3, "Kotlin"), // D
                LevelQuestion(15, "¿Qué hace also en Kotlin?",
                    listOf("Ejecuta un bloque y devuelve el mismo objeto", "Transforma el objeto", "Filtra valores nulos", "Crea una copia"), 0, "Kotlin"), // A
                LevelQuestion(16, "¿Qué es un coroutine scope?",
                    listOf("Un tipo de bucle", "El contexto en el que se ejecutan las corrutinas", "Un hilo de ejecución", "Un módulo de red"), 1, "Kotlin"), // B
                LevelQuestion(17, "¿Qué hace apply en Kotlin?",
                    listOf("Aplica un filtro", "Lanza una corrutina", "Configura un objeto y lo devuelve", "Crea una lista"), 2, "Kotlin"), // C
                LevelQuestion(18, "¿Qué es when en Kotlin?",
                    listOf("Un bucle", "Una función", "Un tipo de clase", "Un equivalente mejorado de switch/case"), 3, "Kotlin"), // D
                LevelQuestion(19, "¿Qué hace !! en Kotlin?",
                    listOf("Negación doble", "Comparación estricta", "Fuerza el valor no-null o lanza NullPointerException", "Operador de rango"), 2, "Kotlin"), // C
                LevelQuestion(20, "¿Qué es una inline function?",
                    listOf("Una función cuyo código se inserta en el lugar de llamada", "Una función pequeña", "Una función estática", "Una función recursiva"), 0, "Kotlin"), // A
                LevelQuestion(21, "¿Qué hace withContext?",
                    listOf("Crea un nuevo contexto de UI", "Destruye una corrutina", "Crea un scope", "Cambia el dispatcher de una corrutina"), 3, "Kotlin"), // D
                LevelQuestion(22, "¿Qué es un higher-order function?",
                    listOf("Una función muy compleja", "Una función de extensión", "Una función que recibe o devuelve funciones", "Una función suspendida"), 2, "Kotlin"), // C
                LevelQuestion(23, "¿Qué hace takeIf?",
                    listOf("Toma el primer elemento", "Devuelve el objeto si cumple la condición, sino null", "Filtra una lista", "Lanza excepción si falla"), 1, "Kotlin"), // B
                LevelQuestion(24, "¿Qué es StateFlow?",
                    listOf("Un tipo de lista", "Un scope de corrutina", "Un canal de comunicación", "Un Flow que mantiene el último estado emitido"), 3, "Kotlin"), // D
                LevelQuestion(25, "¿Qué hace runBlocking?",
                    listOf("Ejecuta corrutinas bloqueando el hilo actual", "Bloquea la UI", "Cancela una corrutina", "Crea un scope nuevo"), 0, "Kotlin"), // A
                LevelQuestion(26, "¿Qué es un reified type parameter?",
                    listOf("Un tipo genérico normal", "Un tipo abstracto", "Un tipo primitivo", "Un tipo genérico accesible en tiempo de ejecución con inline"), 3, "Kotlin"), // D
                LevelQuestion(27, "¿Qué hace flatMap?",
                    listOf("Aplana y transforma colecciones anidadas", "Filtra elementos", "Ordena la colección", "Agrupa elementos"), 0, "Kotlin"), // A
                LevelQuestion(28, "¿Qué es un delegated property?",
                    listOf("Una propiedad heredada", "Una propiedad cuya lógica se delega a otro objeto", "Una propiedad estática", "Una propiedad nullable"), 1, "Kotlin"), // B
                LevelQuestion(29, "¿Qué hace groupBy en Kotlin?",
                    listOf("Ordena elementos", "Filtra duplicados", "Agrupa elementos por un criterio", "Une colecciones"), 2, "Kotlin"), // C
                LevelQuestion(30, "¿Qué es ViewModel en Android?",
                    listOf("Una vista XML", "Un tipo de Fragment", "Un repositorio de datos", "Una clase que sobrevive cambios de configuración"), 3, "Kotlin")  // D
            ),

            // Preguntas de C++ de nivel variado
            "C++" to listOf(
                LevelQuestion(1, "¿Cómo se imprime en C++?",
                    listOf("print(\"hola\")", "cout << \"hola\";", "System.out.println(\"hola\")", "echo \"hola\""), 1, "C++"), // B
                LevelQuestion(2, "¿Qué es un puntero?",
                    listOf("Una variable que almacena una dirección de memoria", "Una copia de una variable", "Un tipo de función", "Una referencia constante"), 0, "C++"), // A
                LevelQuestion(3, "¿Diferencia entre new y malloc?",
                    listOf("No hay diferencia", "malloc es más seguro", "new llama constructor (C++), malloc no (C)", "new es más lento"), 2, "C++"), // C
                LevelQuestion(4, "¿Qué hace delete[]?",
                    listOf("Elimina un archivo", "Borra un elemento", "Libera un puntero simple", "Libera memoria de un array dinámico"), 3, "C++"), // D
                LevelQuestion(5, "¿Qué es una referencia (&)?",
                    listOf("Un alias de una variable existente", "Un puntero a puntero", "Un tipo de array", "Una dirección de memoria"), 0, "C++"), // A
                LevelQuestion(6, "¿Qué es sobrecarga de operadores?",
                    listOf("Usar demasiados operadores", "Un error de compilación", "Redefinir el comportamiento de operadores en clases propias", "Heredar operadores"), 2, "C++"), // C
                LevelQuestion(7, "¿Qué es una clase template?",
                    listOf("Una clase abstracta", "Una clase sin atributos", "Una clase heredada", "Una clase genérica parametrizada por tipo"), 3, "C++"), // D
                LevelQuestion(8, "¿Qué son los smart pointers?",
                    listOf("Punteros más rápidos", "Punteros que gestionan su propia memoria", "Punteros a funciones", "Arrays dinámicos"), 1, "C++"), // B
                LevelQuestion(9, "¿Qué es RAII?",
                    listOf("Un framework", "Un tipo de loop", "Resource Acquisition Is Initialization", "Una librería estándar"), 2, "C++"), // C
                LevelQuestion(10, "¿Diferencia entre virtual y override?",
                    listOf("Son sinónimos", "override es para abstractas", "virtual es solo en interfaces", "virtual declara método sobreescribible, override indica que sobreescribe"), 3, "C++"), // D
                LevelQuestion(11, "¿Qué es el operador ::?",
                    listOf("Comparación", "Operador de ámbito/scope", "Puntero a función", "Acceso a array"), 1, "C++"), // B
                LevelQuestion(12, "¿Qué es un destructor?",
                    listOf("Un constructor alternativo", "Un operador de borrado", "Una función estática", "Un método que se llama al destruir el objeto"), 3, "C++"), // D
                LevelQuestion(13, "¿Qué hace std::vector?",
                    listOf("Un array de tamaño fijo", "Un array dinámico de la STL", "Una lista enlazada", "Un mapa"), 1, "C++"), // B
                LevelQuestion(14, "¿Qué es herencia múltiple?",
                    listOf("Heredar de una clase abstracta", "Una clase que hereda de varias clases", "Sobrecargar métodos", "Usar interfaces"), 1, "C++"), // B
                LevelQuestion(15, "¿Qué hace const en una variable?",
                    listOf("La hace pública", "La hace estática", "Impide que sea modificada", "La inicializa a 0"), 2, "C++"), // C
                LevelQuestion(16, "¿Qué es un namespace?",
                    listOf("Un tipo de puntero", "Una clase especial", "Un espacio con nombre para organizar código", "Un tipo de array"), 2, "C++"), // C
                LevelQuestion(17, "¿Qué hace std::map?",
                    listOf("Almacena pares clave-valor ordenados", "Crea un array", "Crea una lista enlazada", "Filtra elementos"), 0, "C++"), // A
                LevelQuestion(18, "¿Qué es una función inline?",
                    listOf("Una función recursiva", "Una función virtual", "Una función estática", "Una función cuyo código se inserta en el punto de llamada"), 3, "C++"), // D
                LevelQuestion(19, "¿Qué hace sizeof()?",
                    listOf("Cuenta elementos", "Devuelve el tamaño en bytes de un tipo", "Libera memoria", "Compara tamaños"), 1, "C++"), // B
                LevelQuestion(20, "¿Qué es un iterator en STL?",
                    listOf("Un tipo de puntero inteligente", "Un objeto que permite recorrer contenedores", "Un tipo de función", "Un algoritmo de ordenación"), 1, "C++"), // B
                LevelQuestion(21, "¿Qué hace std::sort()?",
                    listOf("Busca un elemento", "Elimina duplicados", "Ordena un rango de elementos", "Mezcla dos contenedores"), 2, "C++"), // C
                LevelQuestion(22, "¿Qué es una función virtual pura?",
                    listOf("Una función sin implementación que debe sobreescribirse", "Una función muy rápida", "Una función con puntero", "Una función inline"), 0, "C++"), // A
                LevelQuestion(23, "¿Qué hace auto en C++11?",
                    listOf("Crea variables automáticas", "Libera memoria", "Deduce el tipo de la variable automáticamente", "Crea punteros"), 2, "C++"), // C
                LevelQuestion(24, "¿Qué es move semantics?",
                    listOf("Mover código entre archivos", "Un tipo de bucle", "Transferir recursos sin copiarlos", "Un operador de asignación"), 2, "C++"), // C
                LevelQuestion(25, "¿Qué hace std::unique_ptr?",
                    listOf("Un puntero inteligente con propiedad única", "Crea punteros compartidos", "Un array dinámico", "Un iterador"), 0, "C++"), // A
                LevelQuestion(26, "¿Qué es una lambda en C++?",
                    listOf("Un tipo de clase", "Un operador especial", "Una función anónima definida en línea", "Un puntero a función"), 2, "C++"), // C
                LevelQuestion(27, "¿Qué hace std::thread?",
                    listOf("Crea procesos", "Sincroniza hilos", "Pausa la ejecución", "Crea y gestiona hilos de ejecución"), 3, "C++"), // D
                LevelQuestion(28, "¿Qué es constexpr?",
                    listOf("Una variable const normal", "Un valor evaluado en tiempo de compilación", "Un tipo de puntero", "Una función virtual"), 1, "C++"), // B
                LevelQuestion(29, "¿Qué hace std::shared_ptr?",
                    listOf("Un puntero con propiedad única", "Un puntero débil", "Un puntero compartido con conteo de referencias", "Un array dinámico"), 2, "C++"), // C
                LevelQuestion(30, "¿Qué es el operador ->?",
                    listOf("Comparación", "Operador de rango", "Asignación", "Acceso a miembros a través de un puntero"), 3, "C++")  // D
            ),

            // Preguntas de SQL de nivel variado
            "SQL" to listOf(
                LevelQuestion(1, "¿Qué hace SELECT * FROM users?",
                    listOf("Borra la tabla users", "Devuelve todas las filas y columnas de users", "Crea la tabla users", "Inserta datos en users"), 1, "SQL"), // B
                LevelQuestion(2, "¿Cuál es la cláusula para filtrar resultados?",
                    listOf("HAVING", "FILTER", "LIMIT", "WHERE"), 3, "SQL"),                               // D
                LevelQuestion(3, "¿Qué hace COUNT(*)?",
                    listOf("Suma valores", "Cuenta columnas", "Obtiene el máximo", "Cuenta el número de filas"), 3, "SQL"), // D
                LevelQuestion(4, "¿Diferencia entre WHERE y HAVING?",
                    listOf("WHERE filtra filas, HAVING filtra grupos tras GROUP BY", "No hay diferencia", "HAVING es más rápido", "WHERE solo con números"), 0, "SQL"), // A
                LevelQuestion(5, "¿Qué es una PRIMARY KEY?",
                    listOf("La primera columna siempre", "Una clave foránea", "Un índice opcional", "Identificador único e irrepetible de cada fila"), 3, "SQL"), // D
                LevelQuestion(6, "¿Qué hace INNER JOIN?",
                    listOf("Une todas las filas", "Devuelve solo filas con coincidencia en ambas tablas", "Une solo la izquierda", "Elimina duplicados"), 1, "SQL"), // B
                LevelQuestion(7, "¿Qué es una transacción?",
                    listOf("Una consulta lenta", "Un tipo de índice", "Conjunto de operaciones que se ejecutan de forma atómica", "Una vista de la BD"), 2, "SQL"), // C
                LevelQuestion(8, "¿Qué hace EXPLAIN?",
                    listOf("Documenta la BD", "Describe las columnas", "Exporta datos", "Muestra el plan de ejecución de la consulta"), 3, "SQL"), // D
                LevelQuestion(9, "¿Qué es normalización?",
                    listOf("Ordenar datos alfabéticamente", "Estructurar tablas para reducir redundancia", "Comprimir la BD", "Añadir índices"), 1, "SQL"), // B
                LevelQuestion(10, "¿Qué es un índice en SQL?",
                    listOf("Estructura que acelera búsquedas a costa de espacio", "Una clave foránea", "Una restricción de unicidad", "Un tipo de JOIN"), 0, "SQL"), // A
                LevelQuestion(11, "¿Qué hace ORDER BY?",
                    listOf("Filtra resultados", "Agrupa resultados", "Ordena los resultados", "Limita resultados"), 2, "SQL"), // C
                LevelQuestion(12, "¿Qué hace GROUP BY?",
                    listOf("Ordena filas", "Agrupa filas por un valor común", "Filtra grupos", "Une tablas"), 1, "SQL"), // B
                LevelQuestion(13, "¿Qué es un LEFT JOIN?",
                    listOf("Devuelve solo coincidencias", "Elimina duplicados", "Une por la derecha", "Devuelve todas las filas de la izquierda aunque no haya coincidencia"), 3, "SQL"), // D
                LevelQuestion(14, "¿Qué hace DISTINCT?",
                    listOf("Ordena valores", "Elimina filas duplicadas del resultado", "Cuenta valores únicos", "Filtra nulos"), 1, "SQL"), // B
                LevelQuestion(15, "¿Qué hace LIMIT?",
                    listOf("Filtra resultados", "Agrupa resultados", "Ordena resultados", "Limita el número de filas devueltas"), 3, "SQL"), // D
                LevelQuestion(16, "¿Qué es una FOREIGN KEY?",
                    listOf("La clave principal", "Una clave que referencia a otra tabla", "Un índice único", "Una restricción de null"), 1, "SQL"), // B
                LevelQuestion(17, "¿Qué hace INSERT INTO?",
                    listOf("Modifica datos", "Elimina filas", "Inserta nuevas filas en una tabla", "Crea una tabla"), 2, "SQL"), // C
                LevelQuestion(18, "¿Qué hace UPDATE?",
                    listOf("Modifica datos existentes en una tabla", "Inserta datos", "Elimina la tabla", "Crea índices"), 0, "SQL"), // A
                LevelQuestion(19, "¿Qué hace DELETE FROM?",
                    listOf("Elimina la tabla", "Elimina columnas", "Vacía la base de datos", "Elimina filas de una tabla"), 3, "SQL"), // D
                LevelQuestion(20, "¿Qué es una vista (VIEW)?",
                    listOf("Una tabla física", "Un índice especial", "Una consulta guardada como tabla virtual", "Una copia de la BD"), 2, "SQL"), // C
                LevelQuestion(21, "¿Qué hace SUM()?",
                    listOf("Cuenta filas", "Suma los valores de una columna", "Obtiene el promedio", "Obtiene el máximo"), 1, "SQL"), // B
                LevelQuestion(22, "¿Qué hace AVG()?",
                    listOf("Suma valores", "Obtiene el mínimo", "Cuenta filas", "Calcula el promedio de una columna"), 3, "SQL"), // D
                LevelQuestion(23, "¿Qué es un subquery?",
                    listOf("Una tabla secundaria", "Un tipo de JOIN", "Un índice compuesto", "Una consulta dentro de otra consulta"), 3, "SQL"), // D
                LevelQuestion(24, "¿Qué hace TRUNCATE?",
                    listOf("Elimina columnas", "Reorganiza índices", "Elimina todas las filas sin registrar cada una", "Elimina la tabla"), 2, "SQL"), // C
                LevelQuestion(25, "¿Qué es ACID?",
                    listOf("Un lenguaje de consulta", "Un tipo de índice", "Atomicidad, Consistencia, Aislamiento, Durabilidad", "Un protocolo de red"), 2, "SQL"), // C
                LevelQuestion(26, "¿Qué hace UNION?",
                    listOf("Une tablas con JOIN", "Intersecta resultados", "Filtra resultados", "Combina resultados de dos consultas eliminando duplicados"), 3, "SQL"), // D
                LevelQuestion(27, "¿Qué es un stored procedure?",
                    listOf("Una vista guardada", "Un tipo de índice", "Un conjunto de instrucciones SQL guardadas y reutilizables", "Una transacción automática"), 2, "SQL"), // C
                LevelQuestion(28, "¿Qué hace COALESCE()?",
                    listOf("Devuelve el primer valor no nulo de una lista", "Cuenta valores null", "Convierte tipos", "Agrupa valores"), 0, "SQL"), // A
                LevelQuestion(29, "¿Qué es un trigger?",
                    listOf("Un tipo de JOIN", "Un índice especial", "Una vista materializada", "Una acción automática que se ejecuta ante un evento en la BD"), 3, "SQL"), // D
                LevelQuestion(30, "¿Qué hace ROLLBACK?",
                    listOf("Confirma una transacción", "Deshace una transacción al estado anterior", "Elimina un índice", "Crea un punto de guardado"), 1, "SQL")  // B
            )
        )
    }


    private lateinit var binding: ActivityLevelTestBinding
    private lateinit var language: String

    // 10 preguntas aleatorias para este test
    private lateinit var questions: List<LevelQuestion>
    private var currentIndex = 0
    private var score = 0 // Puntuación del test

    // Opción seleccionada (-1 si no hay selección)
    private var selectedOption = -1

    // Repositorio para guardar resultados
    private val repo = UserRepository()

    // Inicializa el test: obtiene el lenguaje, carga 10 preguntas aleatorias y muestra la primera.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLevelTestBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtiene el lenguaje
        language = intent.getStringExtra(EXTRA_LANGUAGE) ?: "Python"

        // Obtiene 10 preguntas aleatorias
        questions = (QUESTIONS[language] ?: emptyList()).shuffled().take(10)

        showQuestion()
        setupButtons()
    }

    // Muestra la pregunta actual: actualiza el progreso, opciones y listeners.
    private fun showQuestion() {
        if (currentIndex >= questions.size) {
            // Si se acabaron las preguntas
            finishTest()
            return
        }

        // Obtiene la pregunta actual
        val q = questions[currentIndex]

        // Reinicia selección
        selectedOption = -1

        binding.tvTestProgress.text = "${currentIndex + 1} / ${questions.size}"
        binding.progressTest.progress = ((currentIndex.toFloat() / questions.size) * 100).toInt()
        binding.tvTestQuestion.text = q.text

        // Oculta botón hasta seleccionar opción
        binding.btnConfirm.visibility = View.GONE

        // Configurar las opciones (A, B, C, D)
        val optionViews = listOf(binding.optionA, binding.optionB, binding.optionC, binding.optionD)
        val optionTexts = listOf(binding.tvOptA, binding.tvOptB, binding.tvOptC, binding.tvOptD)

        // Itera sobre cada tarjeta
        optionViews.forEachIndexed { i, card ->

            // Si hay opción, muéstrala; si no, vacío
            optionTexts[i].text = if (i < q.options.size) q.options[i] else ""

            // Muestra solo si hay opción
            card.visibility = if (i < q.options.size) View.VISIBLE else View.GONE

            // Color por defecto
            card.setCardBackgroundColor(ContextCompat.getColor(this, R.color.surface2))
            card.strokeWidth = 2
            card.setOnClickListener { selectOption(i) }
        }
    }

    // Marca una opción como seleccionada resaltándola visualmente y mostrando botón de confirmación.
    private fun selectOption(index: Int) {
        selectedOption = index

        // Guarda el índice
        val optionViews = listOf(binding.optionA, binding.optionB, binding.optionC, binding.optionD)

        // Itera sobre cada tarjeta
        optionViews.forEachIndexed { i, card ->

            // Borde más grueso si está seleccionada
            card.strokeWidth = if (i == index) 6 else 2
            card.setCardBackgroundColor(

                // Fondo rojo si seleccionada
                if (i == index) ContextCompat.getColor(this, R.color.red_card_bg)
                else ContextCompat.getColor(this, R.color.surface2)
            )
        }
        // Muestra botón de confirmación
        binding.btnConfirm.visibility = View.VISIBLE
    }

    // Configura el botón de confirmación para verificar respuesta y avanzar a siguiente pregunta.
    private fun setupButtons() {
        binding.btnConfirm.setOnClickListener {
            val q = questions[currentIndex]

            // Si es correcta, suma punto
            if (selectedOption == q.correctIndex) score++

            // Avanza a siguiente pregunta
            currentIndex++
            showQuestion()
        }
    }

    // Finaliza el test: calcula el nivel basado en la puntuación y lo guarda en Firebase.
    private fun finishTest() {
        // Calcula el nivel según puntuación
        val level = getLocalizedLevel(score)

        // Guarda el resultado en Firebase usando el ID del usuario autenticado
        val uid = repo.currentUid()
        if (uid != null) {

            lifecycleScope.launch {
                repo.saveTestResult(uid, language, level)
                goToSyllabus(level)
            }
        } else {
            goToSyllabus(level)

        }
    }

    // Navega a la pantalla del temario, pasando el lenguaje, nivel y puntuación.
    private fun goToSyllabus(level: String) {

        // Intent para SyllabusActivity
        val intent = Intent(this, SyllabusActivity::class.java).apply {

            // Pasa el lenguaje
            putExtra(SyllabusActivity.EXTRA_LANGUAGE, language)

            // Pasa el nivel detectado
            putExtra(SyllabusActivity.EXTRA_LEVEL, level)

            // Pasa la puntuación (aciertos)
            putExtra(SyllabusActivity.EXTRA_SCORE, score)
        }
        startActivity(intent)

        finish()
    }

    // Traduce la puntuación a nivel (Principiante, Intermedio o Avanzado).
    private fun getLocalizedLevel(score: Int): String {
        return when {
            // Si puntuación >= mínimo avanzado
            score >= UserLevel.AVANZADO.minScore -> getString(R.string.level_advanced)
            // Si está en rango intermedio
            score >= UserLevel.INTERMEDIO.minScore -> getString(R.string.level_intermediate)
            // Si no, principiante
            else -> getString(R.string.level_beginner)
        }
    }
}