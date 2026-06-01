package com.exemple.codegym.data.lessons

import com.exemple.codegym.models.ExerciseType
import com.exemple.codegym.models.Lesson
import com.exemple.codegym.models.LessonExercise

/**
 * Lecciones de SQL: 10 lecciones por unidades.
 */
object SqlLessons {

    val lessons: List<Lesson> = listOf(

        // ============ UNIDAD 1: SQL BÁSICO ============

        Lesson(
            id = "sql_1_1",
            language = "SQL",
            unitNumber = 1,
            title = "SELECT y FROM",
            theoryText = """
                SELECT es la consulta más usada en SQL: sirve para LEER datos.
                
                🔹 SELECT col1, col2 FROM tabla;  →  selecciona columnas
                🔹 SELECT * FROM tabla;  →  TODAS las columnas
                🔹 Las palabras clave SQL no distinguen mayúsculas, pero por convención van EN MAYÚSCULAS
                🔹 Cada consulta termina con ;
            """.trimIndent(),
            codeExample = """
                -- Tabla 'usuarios': id, nombre, edad
                
                SELECT * FROM usuarios;
                -- Devuelve todas las filas con todas las columnas
                
                SELECT nombre FROM usuarios;
                -- Solo la columna nombre de todas las filas
                
                SELECT nombre, edad FROM usuarios;
                -- Solo nombre y edad
            """.trimIndent(),
            xpReward = 20,
            exercises = listOf(
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "¿Qué hace SELECT * FROM productos;?",
                    "", listOf(
                        "Borra la tabla",
                        "Devuelve todas las filas y columnas de productos",
                        "Crea la tabla productos",
                        "Cuenta cuántos hay"
                    ), 1,
                    "SELECT * = todas las columnas. FROM = de qué tabla."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Obtén solo los nombres de empleados:",
                    "??? nombre FROM empleados;",
                    listOf("GET", "SELECT", "SHOW", "FETCH"),
                    1, "SELECT es la palabra clave para consultar/leer datos."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "¿Qué SQL devuelve solo email y telefono de clientes?",
                    "", listOf(
                        "SELECT * FROM clientes;",
                        "SELECT clientes(email, telefono);",
                        "SELECT email, telefono FROM clientes;",
                        "GET email, telefono FROM clientes;"
                    ), 2,
                    "SELECT col1, col2 FROM tabla; es la sintaxis correcta."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "¿Qué carácter termina cada consulta SQL?",
                    "", listOf(":", ";", ".", "->"), 1,
                    "El punto y coma ; marca el fin de una sentencia SQL."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Selecciona TODAS las columnas de la tabla coches:",
                    "SELECT ??? FROM coches;",
                    listOf("ALL", "*", "ANY", "EVERY"), 1,
                    "El asterisco * es el comodín para 'todas las columnas'.")
            )
        ),

        Lesson(
            id = "sql_1_2",
            language = "SQL",
            unitNumber = 1,
            title = "WHERE para filtrar",
            theoryText = """
                WHERE filtra qué filas se devuelven según una condición.
                
                🔹 Operadores: =, !=, <, >, <=, >=
                🔹 Combinaciones: AND, OR, NOT
                🔹 LIKE para patrones: '%abc%' contiene "abc"
                🔹 IN (val1, val2) para múltiples valores
                🔹 BETWEEN x AND y para rangos
            """.trimIndent(),
            codeExample = """
                -- Usuarios mayores de 18
                SELECT * FROM usuarios WHERE edad > 18;
                
                -- Productos baratos de Nike
                SELECT * FROM productos
                WHERE precio < 50 AND marca = 'Nike';
                
                -- Nombres que empiezan por A
                SELECT * FROM usuarios WHERE nombre LIKE 'A%';
                
                -- Edades entre 18 y 30
                SELECT * FROM u WHERE edad BETWEEN 18 AND 30;
            """.trimIndent(),
            xpReward = 25,
            exercises = listOf(
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "¿Cuál es la cláusula correcta para FILTRAR filas?",
                    "", listOf("FILTER", "WHERE", "IF", "HAVING"), 1,
                    "WHERE filtra filas. HAVING filtra grupos (con GROUP BY)."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Productos con stock > 0:",
                    "SELECT * FROM productos ??? stock > 0;",
                    listOf("WHEN", "WHERE", "IF", "WITH"), 1,
                    "WHERE es la cláusula que añade condiciones de filtrado."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "¿Qué operador busca patrones en texto?",
                    "", listOf("=", "MATCH", "LIKE", "REGEX"), 2,
                    "LIKE busca patrones. % es comodín de varios caracteres, _ de uno solo."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "¿Qué hace WHERE precio BETWEEN 10 AND 50?",
                    "", listOf(
                        "precio = 10 o 50",
                        "precio entre 10 y 50 (inclusive)",
                        "precio menor que 10",
                        "Error de sintaxis"
                    ), 1,
                    "BETWEEN x AND y selecciona valores en el rango (incluidos)."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Filtra usuarios cuyo país sea España O Portugal:",
                    "SELECT * FROM users WHERE pais ??? ('España', 'Portugal');",
                    listOf("=", "IN", "OR", "EQUALS"), 1,
                    "IN (lista) es más limpio que pais='España' OR pais='Portugal'.")
            )
        ),

        Lesson(
            id = "sql_1_3",
            language = "SQL",
            unitNumber = 1,
            title = "ORDER BY y LIMIT",
            theoryText = """
                Ordena resultados y limita cuántas filas se devuelven.
                
                🔹 ORDER BY columna: ascendente (ASC, por defecto)
                🔹 ORDER BY columna DESC: descendente
                🔹 Se pueden ordenar varias columnas
                🔹 LIMIT n: solo las primeras n filas (MySQL/PostgreSQL/SQLite)
                🔹 TOP n se usa en SQL Server
            """.trimIndent(),
            codeExample = """
                -- Más caro primero
                SELECT * FROM productos
                ORDER BY precio DESC;
                
                -- Por categoría asc, luego precio desc
                SELECT * FROM productos
                ORDER BY categoria ASC, precio DESC;
                
                -- Solo los 5 más caros
                SELECT * FROM productos
                ORDER BY precio DESC
                LIMIT 5;
            """.trimIndent(),
            xpReward = 25,
            exercises = listOf(
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "¿Cómo se ordenan resultados de mayor a menor?",
                    "", listOf("ORDER BY col ASC", "ORDER BY col DESC", "SORT col DOWN", "REVERSE col"), 1,
                    "DESC = descendente (mayor a menor). ASC = ascendente (por defecto)."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Limita el resultado a 10 filas:",
                    "SELECT * FROM users ??? 10;",
                    listOf("TOP", "LIMIT", "MAX", "FIRST"), 1,
                    "LIMIT es estándar en MySQL, PostgreSQL, SQLite. TOP es de SQL Server."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "¿Cuál es el orden por defecto de ORDER BY?",
                    "", listOf("Ascendente (ASC)", "Descendente (DESC)", "Aleatorio", "Por inserción"), 0,
                    "Si no especificas, ORDER BY es ASC (ascendente) por defecto."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "¿Qué hace ORDER BY edad ASC, nombre DESC?",
                    "", listOf(
                        "Ordena solo por edad",
                        "Por edad ascendente, y dentro de cada edad por nombre descendente",
                        "Ignora una de las dos",
                        "Error"
                    ), 1,
                    "Se pueden combinar varias columnas. Cada una con su propio orden."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Los 3 productos más caros:",
                    "SELECT * FROM productos ORDER BY precio ??? LIMIT 3;",
                    listOf("ASC", "DESC", "TOP", "MAX"), 1,
                    "Más caros = ordenar de mayor a menor (DESC) y tomar los primeros.")
            )
        ),

        // ============ UNIDAD 2: AGREGACIONES ============

        Lesson(
            id = "sql_2_1",
            language = "SQL",
            unitNumber = 2,
            title = "Funciones de agregación",
            theoryText = """
                Las funciones de agregación calculan valores sobre grupos de filas.
                
                🔹 COUNT(*): cuenta filas
                🔹 SUM(col): suma valores
                🔹 AVG(col): media
                🔹 MIN(col) / MAX(col): mínimo / máximo
                🔹 Suelen ir con GROUP BY para agrupar
            """.trimIndent(),
            codeExample = """
                -- Cuántos usuarios hay
                SELECT COUNT(*) FROM usuarios;
                
                -- Total de ventas
                SELECT SUM(precio) FROM ventas;
                
                -- Edad media
                SELECT AVG(edad) FROM usuarios;
                
                -- Producto más caro
                SELECT MAX(precio) FROM productos;
            """.trimIndent(),
            xpReward = 30,
            exercises = listOf(
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "¿Qué hace COUNT(*)?",
                    "", listOf("Suma valores", "Cuenta el número de filas", "Cuenta columnas", "Devuelve el máximo"), 1,
                    "COUNT(*) cuenta cuántas filas hay en el resultado."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Obtén el precio máximo:",
                    "SELECT ???(precio) FROM productos;",
                    listOf("HIGHEST", "MAX", "TOP", "MAXIMUM"), 1,
                    "MAX(columna) devuelve el valor máximo de esa columna."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "¿Qué calcula AVG?",
                    "", listOf("Suma", "Mediana", "Media (promedio)", "Moda"), 2,
                    "AVG = average = media aritmética."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "¿Qué devuelve SELECT SUM(cantidad) FROM ventas;?",
                    "", listOf("Cantidad de ventas", "Suma total de las cantidades", "La venta más cara", "Error"), 1,
                    "SUM suma todos los valores de la columna 'cantidad'."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Cuenta cuántos usuarios distintos hay:",
                    "SELECT COUNT(??? id) FROM usuarios;",
                    listOf("ALL", "DISTINCT", "UNIQUE", "ONLY"), 1,
                    "DISTINCT elimina duplicados. COUNT(DISTINCT col) cuenta valores únicos.")
            )
        ),

        Lesson(
            id = "sql_2_2",
            language = "SQL",
            unitNumber = 2,
            title = "GROUP BY",
            theoryText = """
                GROUP BY agrupa filas que comparten un valor para aplicar agregaciones por grupo.
                
                🔹 GROUP BY columna: agrupa por esa columna
                🔹 Las columnas en SELECT deben estar en GROUP BY o ser agregaciones
                🔹 HAVING filtra grupos (como WHERE pero sobre el resultado agrupado)
                🔹 Orden: SELECT → FROM → WHERE → GROUP BY → HAVING → ORDER BY
            """.trimIndent(),
            codeExample = """
                -- Cuántos productos hay por categoría
                SELECT categoria, COUNT(*) AS cuantos
                FROM productos
                GROUP BY categoria;
                
                -- Solo categorías con más de 5 productos
                SELECT categoria, COUNT(*) AS cuantos
                FROM productos
                GROUP BY categoria
                HAVING COUNT(*) > 5;
            """.trimIndent(),
            xpReward = 35,
            exercises = listOf(
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "¿Qué hace GROUP BY?",
                    "", listOf(
                        "Ordena los resultados",
                        "Agrupa filas que comparten valor en una columna",
                        "Une dos tablas",
                        "Filtra resultados"
                    ), 1,
                    "GROUP BY agrupa filas para aplicar funciones agregadas a cada grupo."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Cuenta usuarios por país:",
                    "SELECT pais, COUNT(*) FROM users ??? pais;",
                    listOf("ORDER BY", "GROUP BY", "WHERE", "JOIN"), 1,
                    "GROUP BY agrupa las filas con el mismo valor en la columna especificada."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "¿Diferencia entre WHERE y HAVING?",
                    "", listOf(
                        "Son sinónimos",
                        "WHERE filtra filas, HAVING filtra grupos tras GROUP BY",
                        "HAVING es más rápido",
                        "WHERE solo con números"
                    ), 1,
                    "WHERE filtra antes de agrupar. HAVING filtra después (sobre los grupos)."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "¿Qué muestra esta consulta?\nSELECT marca, AVG(precio)\nFROM coches\nGROUP BY marca;",
                    "", listOf(
                        "El precio medio de todos los coches",
                        "El precio medio por cada marca",
                        "Las marcas ordenadas",
                        "Los coches más caros"
                    ), 1,
                    "AVG con GROUP BY marca calcula la media para cada marca por separado."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Filtra grupos donde haya más de 10 elementos:",
                    "GROUP BY ciudad ??? COUNT(*) > 10",
                    listOf("WHERE", "HAVING", "FILTER", "WITH"), 1,
                    "HAVING filtra DESPUÉS de GROUP BY. WHERE no funciona con agregaciones.")
            )
        ),

        // ============ UNIDAD 3: JOINS ============

        Lesson(
            id = "sql_3_1",
            language = "SQL",
            unitNumber = 3,
            title = "INNER JOIN",
            theoryText = """
                JOIN combina filas de 2 o más tablas relacionadas.
                
                🔹 INNER JOIN: solo filas con coincidencia en ambas tablas
                🔹 ON: condición de unión (usualmente claves)
                🔹 Se usan alias (a, b) para acortar nombres
                🔹 Ejemplo típico: usuarios JOIN pedidos ON usuarios.id = pedidos.user_id
            """.trimIndent(),
            codeExample = """
                -- usuarios: id, nombre
                -- pedidos: id, user_id, total
                
                SELECT u.nombre, p.total
                FROM usuarios u
                INNER JOIN pedidos p ON u.id = p.user_id;
                
                -- Devuelve solo usuarios CON pedidos
                -- (los usuarios sin pedidos NO aparecen)
            """.trimIndent(),
            xpReward = 40,
            exercises = listOf(
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "¿Qué devuelve INNER JOIN?",
                    "", listOf(
                        "Todas las filas de ambas tablas",
                        "Solo filas con coincidencia en ambas tablas",
                        "Las filas de la tabla izquierda",
                        "Las filas no coincidentes"
                    ), 1,
                    "INNER JOIN solo devuelve filas donde la condición ON se cumple en AMBAS tablas."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Une usuarios y pedidos por user_id:",
                    "SELECT * FROM usuarios u\nJOIN pedidos p ??? u.id = p.user_id;",
                    listOf("WHERE", "ON", "WITH", "AND"), 1,
                    "ON especifica la condición de unión. WHERE va después si filtras adicionalmente."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "Si hago INNER JOIN entre A (10 filas) y B (5 filas) y solo hay 3 coincidencias, ¿cuántas filas obtengo?",
                    "", listOf("3", "5", "10", "15"), 0,
                    "INNER JOIN solo devuelve las filas que coinciden: 3."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "¿Para qué sirve poner alias (u, p)?",
                    "", listOf("Es obligatorio", "Para acortar nombres y evitar ambigüedad", "Mejora rendimiento", "Cambia el nombre real"), 1,
                    "Los alias hacen las consultas más legibles, especialmente con varios JOINs."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Selecciona el nombre del usuario y total del pedido:",
                    "SELECT u.???, p.??? FROM usuarios u JOIN pedidos p ON u.id=p.user_id;",
                    listOf("nombre, total", "*, *", "all, all", "name, amount"), 0,
                    "Acceso a columnas con alias.columna. Nombres tal como están en las tablas.")
            )
        ),

        Lesson(
            id = "sql_3_2",
            language = "SQL",
            unitNumber = 3,
            title = "LEFT JOIN",
            theoryText = """
                LEFT JOIN devuelve TODAS las filas de la tabla izquierda, aunque no haya coincidencia.
                
                🔹 LEFT JOIN: izquierda completa + coincidencias derecha
                🔹 Si no hay coincidencia, las columnas de la derecha son NULL
                🔹 Útil para detectar "huérfanos" (sin relación)
                🔹 RIGHT JOIN es lo opuesto (raro de usar)
            """.trimIndent(),
            codeExample = """
                -- Lista TODOS los usuarios, con o sin pedidos
                SELECT u.nombre, p.total
                FROM usuarios u
                LEFT JOIN pedidos p ON u.id = p.user_id;
                
                -- Si Juan no tiene pedidos:
                -- nombre='Juan', total=NULL
                
                -- Encontrar usuarios SIN pedidos
                SELECT u.nombre
                FROM usuarios u
                LEFT JOIN pedidos p ON u.id = p.user_id
                WHERE p.id IS NULL;
            """.trimIndent(),
            xpReward = 40,
            exercises = listOf(
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "¿Qué devuelve LEFT JOIN?",
                    "", listOf(
                        "Solo filas con coincidencia",
                        "Todas las filas de la tabla IZQUIERDA + coincidencias",
                        "Solo las filas no coincidentes",
                        "Igual que INNER JOIN"
                    ), 1,
                    "LEFT JOIN devuelve toda la tabla izquierda. Si no hay match, NULL en columnas derechas."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Encuentra usuarios SIN pedidos:",
                    "SELECT u.* FROM users u\nLEFT JOIN pedidos p ON u.id=p.user_id\nWHERE p.id ??? NULL;",
                    listOf("=", "IS", "==", "EQUALS"), 1,
                    "Para comparar con NULL se usa IS NULL o IS NOT NULL, NUNCA = NULL."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "Si LEFT JOIN una tabla A (10 filas) con B (5 coincidencias), ¿cuántas filas obtengo?",
                    "", listOf("5", "10", "15", "Depende"), 1,
                    "LEFT JOIN devuelve TODAS las filas de A (10), las que no coincidan tendrán NULLs."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "¿Qué valor tienen las columnas derechas si no hay coincidencia?",
                    "", listOf("0", "Vacío \"\"", "NULL", "Error"), 2,
                    "NULL representa la ausencia de valor cuando no hay coincidencia."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Une categorías con productos (mostrar todas las categorías):",
                    "SELECT c.nombre, p.titulo\nFROM categorias c\n??? JOIN productos p ON c.id=p.cat_id;",
                    listOf("INNER", "LEFT", "RIGHT", "CROSS"), 1,
                    "LEFT JOIN para mostrar TODAS las categorías, incluso las que no tienen productos.")
            )
        ),

        // ============ UNIDAD 4: MODIFICAR DATOS ============

        Lesson(
            id = "sql_4_1",
            language = "SQL",
            unitNumber = 4,
            title = "INSERT, UPDATE, DELETE",
            theoryText = """
                Las operaciones de modificación: insertar, actualizar, borrar.
                
                🔹 INSERT INTO tabla (cols) VALUES (vals);
                🔹 UPDATE tabla SET col=val WHERE condición;
                🔹 DELETE FROM tabla WHERE condición;
                🔹 ⚠️ Sin WHERE en UPDATE/DELETE = afecta a TODAS las filas
            """.trimIndent(),
            codeExample = """
                -- Insertar
                INSERT INTO usuarios (nombre, edad)
                VALUES ('Marta', 28);
                
                -- Actualizar
                UPDATE usuarios
                SET edad = 29
                WHERE nombre = 'Marta';
                
                -- Borrar
                DELETE FROM usuarios
                WHERE edad < 18;
            """.trimIndent(),
            xpReward = 35,
            exercises = listOf(
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "¿Qué comando AÑADE filas?",
                    "", listOf("ADD", "INSERT", "CREATE", "PUT"), 1,
                    "INSERT INTO añade filas nuevas. CREATE crea tablas/bases de datos."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Actualiza el email del usuario con id=5:",
                    "??? users SET email='nuevo@x.com' WHERE id=5;",
                    listOf("MODIFY", "UPDATE", "CHANGE", "SET"), 1,
                    "UPDATE tabla SET col=valor WHERE condición."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "⚠️ ¿Qué hace DELETE FROM users; (sin WHERE)?",
                    "", listOf(
                        "Da error",
                        "Borra el primer usuario",
                        "Borra TODAS las filas de la tabla",
                        "No hace nada"
                    ), 2,
                    "Sin WHERE, DELETE borra TODAS las filas. Lección: usa siempre WHERE."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "¿Cuál es la sintaxis correcta de INSERT?",
                    "", listOf(
                        "INSERT users VALUES ('Ana', 25);",
                        "INSERT INTO users (nombre, edad) VALUES ('Ana', 25);",
                        "ADD users ('Ana', 25);",
                        "INSERT users SET nombre='Ana';"
                    ), 1,
                    "INSERT INTO tabla (cols) VALUES (vals); es la sintaxis estándar."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Borra solo los productos sin stock:",
                    "??? FROM productos WHERE stock = 0;",
                    listOf("REMOVE", "DROP", "DELETE", "ERASE"), 2,
                    "DELETE FROM tabla WHERE condición. DROP elimina la tabla entera.")
            )
        ),

        // ============ UNIDAD 5: AVANZADO ============

        Lesson(
            id = "sql_5_1",
            language = "SQL",
            unitNumber = 5,
            title = "Subconsultas",
            theoryText = """
                Una subconsulta es una consulta DENTRO de otra.
                
                🔹 Pueden ir en SELECT, FROM o WHERE
                🔹 Suelen ir entre paréntesis ( )
                🔹 Útiles para comparar con resultados calculados
                🔹 EXISTS / NOT EXISTS para chequear existencia
            """.trimIndent(),
            codeExample = """
                -- Usuarios con edad mayor que la media
                SELECT * FROM usuarios
                WHERE edad > (SELECT AVG(edad) FROM usuarios);
                
                -- Productos que tienen al menos un pedido
                SELECT * FROM productos p
                WHERE EXISTS (
                    SELECT 1 FROM pedidos
                    WHERE producto_id = p.id
                );
            """.trimIndent(),
            xpReward = 50,
            exercises = listOf(
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "¿Qué es una subconsulta?",
                    "", listOf(
                        "Una consulta más rápida",
                        "Una consulta dentro de otra",
                        "Una consulta sin WHERE",
                        "Una consulta con JOIN"
                    ), 1,
                    "Subconsulta = consulta SQL anidada dentro de otra, generalmente entre paréntesis."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Productos con precio mayor al promedio:",
                    "SELECT * FROM productos\nWHERE precio > (SELECT ???(precio) FROM productos);",
                    listOf("MAX", "MIN", "AVG", "COUNT"), 2,
                    "AVG calcula el promedio. La subconsulta devuelve un solo valor a comparar."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "¿Dónde puede ir una subconsulta?",
                    "", listOf("Solo en WHERE", "Solo en SELECT", "En SELECT, FROM o WHERE", "Solo en FROM"), 2,
                    "Las subconsultas pueden aparecer en múltiples cláusulas SQL."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "¿Qué hace EXISTS (subconsulta)?",
                    "", listOf(
                        "Cuenta filas",
                        "Devuelve TRUE si la subconsulta tiene resultados",
                        "Comprueba si existe la tabla",
                        "Devuelve la primera fila"
                    ), 1,
                    "EXISTS devuelve TRUE/FALSE según si la subconsulta produce filas o no."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Empleados que NO han hecho ventas:",
                    "SELECT * FROM empleados e\nWHERE NOT ??? (\n    SELECT 1 FROM ventas WHERE emp_id = e.id\n);",
                    listOf("EXISTS", "EQUAL", "JOIN", "ANY"), 0,
                    "NOT EXISTS = no tiene resultados. Útil para encontrar 'huérfanos'.")
            )
        )
    )
}