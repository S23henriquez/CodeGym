package com.exemple.codegym

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.exemple.codegym.adapters.SyllabusAdapter
import com.exemple.codegym.databinding.ActivitySyllabusBinding
import com.exemple.codegym.models.SyllabusUnit
import com.exemple.codegym.models.UserLevel

class SyllabusActivity : BaseActivity() {

    // Agrupa las constantes y el temario fijo para reutilizarlo en toda la pantalla.
    companion object {
        const val EXTRA_LANGUAGE = "language"
        const val EXTRA_LEVEL    = "level"
        const val EXTRA_SCORE    = "score"

        // Estructura el temario por lenguaje, nivel y unidades para mostrar solo lo que toca.
        val SYLLABUS: Map<String, Map<String, List<SyllabusUnit>>> = mapOf(

            // Temario de Python, organizado por nivel para facilitar la navegación.
            "Python" to mapOf(
                "Principiante" to listOf(
                    SyllabusUnit(1, "Fundamentos",
                        listOf("Variables y tipos", "Operadores", "Input/Output"), isUnlocked = true), // Primera unidad desbloqueada para que el alumno empiece
                    SyllabusUnit(2, "Control de flujo",
                        listOf("if/elif/else", "Bucles for y while", "break y continue")),
                    SyllabusUnit(3, "Funciones",
                        listOf("Definir funciones", "Parámetros y retorno", "Scope")),
                    SyllabusUnit(4, "Estructuras de datos",
                        listOf("Listas", "Tuplas", "Diccionarios", "Sets"))
                ),
                "Intermedio" to listOf(
                    SyllabusUnit(1, "POO en Python",
                        listOf("Clases y objetos", "Herencia", "Polimorfismo"), isUnlocked = true), // Unidad inicial desbloqueada para nivel intermedio
                    SyllabusUnit(2, "Módulos y paquetes",
                        listOf("import", "pip", "Crear módulos propios")),
                    SyllabusUnit(3, "Manejo de errores",
                        listOf("try/except/finally", "Excepciones personalizadas")),
                    SyllabusUnit(4, "Comprensiones y generadores",
                        listOf("List comprehensions", "Dict comprehensions", "yield"))
                ),
                "Avanzado" to listOf(
                    SyllabusUnit(1, "Concurrencia",
                        listOf("Threading", "Multiprocessing", "asyncio"), isUnlocked = true), // Unidad inicial desbloqueada para nivel avanzado
                    SyllabusUnit(2, "Decoradores avanzados",
                        listOf("Decoradores con parámetros", "functools", "wraps")),
                    SyllabusUnit(3, "Metaclases",
                        listOf("type", "Metaclases personalizadas", "__init_subclass__")),
                    SyllabusUnit(4, "Optimización",
                        listOf("Profiling", "Cython basics", "Numba"))
                )
            ),

            // Temario de Java, con las mismas tres rutas de progreso por nivel.
            "Java" to mapOf(
                "Principiante" to listOf(
                    SyllabusUnit(1, "Java Básico",
                        listOf("Tipos primitivos", "Operadores", "Scanner"), isUnlocked = true), // Primera unidad desbloqueada
                    SyllabusUnit(2, "Control de flujo",
                        listOf("if/switch", "for/while", "Arrays")),
                    SyllabusUnit(3, "Métodos",
                        listOf("Definición", "Sobrecarga", "Recursión")),
                    SyllabusUnit(4, "POO Básica",
                        listOf("Clases", "Objetos", "Constructores"))
                ),
                "Intermedio" to listOf(
                    SyllabusUnit(1, "POO Avanzada",
                        listOf("Herencia", "Interfaces", "Clases abstractas"), isUnlocked = true), // Unidad inicial desbloqueada para intermedio
                    SyllabusUnit(2, "Colecciones",
                        listOf("ArrayList", "HashMap", "Iterator")),
                    SyllabusUnit(3, "Excepciones",
                        listOf("try/catch", "throws", "Excepciones propias")),
                    SyllabusUnit(4, "Java I/O",
                        listOf("FileReader", "BufferedWriter", "Serialización"))
                ),
                "Avanzado" to listOf(
                    SyllabusUnit(1, "Genéricos y Lambdas",
                        listOf("Generics", "Lambda expressions", "Functional interfaces"), isUnlocked = true), // Unidad inicial desbloqueada para avanzado
                    SyllabusUnit(2, "Streams API",
                        listOf("filter/map/reduce", "Collectors", "Optional")),
                    SyllabusUnit(3, "Concurrencia",
                        listOf("Threads", "ExecutorService", "CompletableFuture")),
                    SyllabusUnit(4, "Patrones de diseño",
                        listOf("Singleton", "Factory", "Observer"))
                )
            ),

            // Temario de Kotlin, pensado para reforzar sintaxis moderna y corutinas.
            "Kotlin" to mapOf(
                "Principiante" to listOf(
                    SyllabusUnit(1, "Kotlin Básico",
                        listOf("val/var", "Tipos y null safety", "String templates"), isUnlocked = true), // Primera unidad desbloqueada
                    SyllabusUnit(2, "Control de flujo",
                        listOf("if/when", "for/while", "Rangos")),
                    SyllabusUnit(3, "Funciones",
                        listOf("Funciones básicas", "Parámetros por defecto", "Named arguments")),
                    SyllabusUnit(4, "Colecciones",
                        listOf("List", "Map", "Set", "Operadores funcionales"))
                ),
                "Intermedio" to listOf(
                    SyllabusUnit(1, "POO en Kotlin",
                        listOf("Classes", "Data classes", "Herencia", "Interfaces"), isUnlocked = true), // Unidad inicial desbloqueada
                    SyllabusUnit(2, "Extension functions",
                        listOf("Extender clases", "Extension properties", "Scope functions")),
                    SyllabusUnit(3, "Lambdas y HOF",
                        listOf("Lambdas", "Funciones de orden superior", "Inline functions")),
                    SyllabusUnit(4, "Sealed y Enum classes",
                        listOf("Sealed class", "Enum class", "when exhaustivo"))
                ),
                "Avanzado" to listOf(
                    SyllabusUnit(1, "Corrutinas",
                        listOf("suspend", "launch/async", "Coroutine scopes"), isUnlocked = true), // Unidad inicial desbloqueada para avanzado
                    SyllabusUnit(2, "Flow",
                        listOf("StateFlow", "SharedFlow", "Operadores de Flow")),
                    SyllabusUnit(3, "Delegados",
                        listOf("by lazy", "by observable", "Delegados propios")),
                    SyllabusUnit(4, "KSP y Reflection",
                        listOf("Annotation processing", "KSP", "Reflection básica"))
                )
            ),

            // Temario de C++, con especial atención a memoria, STL y concurrencia.
            "C++" to mapOf(
                "Principiante" to listOf(
                    SyllabusUnit(1, "C++ Básico",
                        listOf("Variables y tipos", "cin/cout", "Operadores"), isUnlocked = true), // Primera unidad desbloqueada
                    SyllabusUnit(2, "Control de flujo",
                        listOf("if/switch", "for/while", "Arrays")),
                    SyllabusUnit(3, "Funciones",
                        listOf("Definición", "Paso por valor/referencia", "Sobrecarga")),
                    SyllabusUnit(4, "Punteros básicos",
                        listOf("Qué es un puntero", "& y *", "Aritmética de punteros"))
                ),
                "Intermedio" to listOf(
                    SyllabusUnit(1, "POO en C++",
                        listOf("Clases", "Constructores/Destructores", "Herencia"), isUnlocked = true), // Unidad inicial desbloqueada
                    SyllabusUnit(2, "Memoria dinámica",
                        listOf("new/delete", "Heap vs Stack", "Memory leaks")),
                    SyllabusUnit(3, "STL",
                        listOf("vector", "map", "algorithm", "iterators")),
                    SyllabusUnit(4, "Sobrecarga de operadores",
                        listOf("operator+", "operator<<", "Comparadores"))
                ),
                "Avanzado" to listOf(
                    SyllabusUnit(1, "Templates",
                        listOf("Function templates", "Class templates", "Specialization"), isUnlocked = true), // Unidad inicial desbloqueada para avanzado
                    SyllabusUnit(2, "Smart Pointers",
                        listOf("unique_ptr", "shared_ptr", "weak_ptr")),
                    SyllabusUnit(3, "C++17/20 Moderno",
                        listOf("structured bindings", "std::optional", "Concepts")),
                    SyllabusUnit(4, "Concurrencia",
                        listOf("std::thread", "mutex", "async/future"))
                )
            ),

            // Temario de SQL, centrado en consultas, diseño de datos y optimización.
            "SQL" to mapOf(
                "Principiante" to listOf(
                    SyllabusUnit(1, "SQL Básico",
                        listOf("SELECT / FROM / WHERE", "ORDER BY", "LIMIT"), isUnlocked = true), // Primera unidad desbloqueada
                    SyllabusUnit(2, "Filtros y operadores",
                        listOf("AND/OR/NOT", "BETWEEN", "LIKE", "IN")),
                    SyllabusUnit(3, "Funciones de agregación",
                        listOf("COUNT", "SUM", "AVG", "MIN/MAX")),
                    SyllabusUnit(4, "Modificar datos",
                        listOf("INSERT", "UPDATE", "DELETE"))
                ),
                "Intermedio" to listOf(
                    SyllabusUnit(1, "JOINs",
                        listOf("INNER JOIN", "LEFT/RIGHT JOIN", "FULL OUTER JOIN"), isUnlocked = true), // Unidad inicial desbloqueada
                    SyllabusUnit(2, "Agrupaciones",
                        listOf("GROUP BY", "HAVING", "Subconsultas")),
                    SyllabusUnit(3, "Diseño de tablas",
                        listOf("PRIMARY KEY", "FOREIGN KEY", "Constraints")),
                    SyllabusUnit(4, "Índices",
                        listOf("CREATE INDEX", "Cuándo usar índices", "EXPLAIN"))
                ),
                "Avanzado" to listOf(
                    SyllabusUnit(1, "Transacciones",
                        listOf("BEGIN/COMMIT/ROLLBACK", "ACID", "Isolation levels"), isUnlocked = true), // Unidad inicial desbloqueada para avanzado
                    SyllabusUnit(2, "Vistas y CTEs",
                        listOf("CREATE VIEW", "WITH (CTE)", "CTEs recursivos")),
                    SyllabusUnit(3, "Stored Procedures",
                        listOf("CREATE PROCEDURE", "Parámetros", "Cursores")),
                    SyllabusUnit(4, "Optimización",
                        listOf("Query plan", "Particionado", "Normalización"))
                )
            )
        )
    }

    private lateinit var binding: ActivitySyllabusBinding

    // Inicializa la pantalla, carga el temario correcto y prepara la navegación al aprendizaje.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySyllabusBinding.inflate(layoutInflater) // Vincula el layout con data binding para acceder a vistas
        setContentView(binding.root)

        // Lee los datos enviados por la pantalla anterior; usa valores por defecto si faltan.
        val language = intent.getStringExtra(EXTRA_LANGUAGE) ?: "Python" // Obtiene idioma o "Python" si no existe
        val level    = intent.getStringExtra(EXTRA_LEVEL) ?: "Principiante" // Obtiene nivel o "Principiante" si no existe
        val score    = intent.getIntExtra(EXTRA_SCORE, 0) // Obtiene puntuación o 0 si no existe

        // Muestra el título del temario con el lenguaje seleccionado.
        binding.tvSyllabusTitle.text = getString(R.string.syllabus_title) + " · $language"
        // Enseña el nivel detectado y la puntuación para dar contexto al alumno.
        binding.tvSyllabusLevel.text = getString(R.string.syllabus_level_detected, level, score)

        // Obtiene las unidades del temario; si no existen, evita errores devolviendo una lista vacía.
        val units = SYLLABUS[language]?.get(level) ?: emptyList() // Busca el temario anidado (idioma→nivel→unidades)
        binding.rvSyllabus.layoutManager = LinearLayoutManager(this) // Configura disposición vertical para las unidades
        binding.rvSyllabus.adapter = SyllabusAdapter(units) // Vincula el adaptador para mostrar las unidades

        // Al pulsar el botón, se vuelve a la pantalla principal de aprendizaje.
        binding.btnStartLearning.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java)) // Abre la pantalla de aprendizaje principal
            finishAffinity() // Cierra todas las actividades anteriores de la pila
        }
    }
}