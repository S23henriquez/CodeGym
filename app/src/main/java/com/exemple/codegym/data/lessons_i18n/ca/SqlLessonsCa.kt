package com.exemple.codegym.data.lessons_i18n.ca

import com.exemple.codegym.models.ExerciseType
import com.exemple.codegym.models.Lesson
import com.exemple.codegym.models.LessonExercise

object SqlLessonsCa {

    val lessons: List<Lesson> = listOf(

        // ============ UNIT 1: SQL BÀSIC ============

        Lesson(
            id = "sql_1_1",
            language = "SQL",
            unitNumber = 1,
            title = "SELECT i FROM",
            theoryText = """
                SELECT és la consulta més usada en SQL: serveix per LLEGIR dades.
                
                🔹 SELECT col1, col2 FROM taula;  →  selecciona columnes
                🔹 SELECT * FROM taula;  →  TOTES les columnes
                🔹 Les paraules clau SQL no distingeixen majúscules, però per convenció van EN MAJÚSCULES
                🔹 Cada consulta acaba amb ;
            """.trimIndent(),
            codeExample = """
                -- Taula 'usuaris': id, nom, edat
                
                SELECT * FROM usuaris;
                -- Retorna totes les files amb totes les columnes
                
                SELECT nom FROM usuaris;
                -- Només la columna nom de totes les files
                
                SELECT nom, edat FROM usuaris;
                -- Només nom i edat
            """.trimIndent(),
            xpReward = 20,
            exercises = listOf(
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "Què fa SELECT * FROM productes;?",
                    "", listOf(
                        "Esborra la taula",
                        "Retorna totes les files i columnes de productes",
                        "Crea la taula productes",
                        "Compta quants n'hi ha"
                    ), 1,
                    "SELECT * = totes les columnes. FROM = de quina taula."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Obtingues només els noms dels empleats:",
                    "??? nom FROM empleats;",
                    listOf("GET", "SELECT", "SHOW", "FETCH"),
                    1, "SELECT és la paraula clau per consultar/llegir dades."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "Quin SQL retorna només email i telefon de clients?",
                    "", listOf(
                        "SELECT * FROM clients;",
                        "SELECT clients(email, telefon);",
                        "SELECT email, telefon FROM clients;",
                        "GET email, telefon FROM clients;"
                    ), 2,
                    "SELECT col1, col2 FROM taula; és la sintaxi correcta."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "Quin caràcter acaba cada consulta SQL?",
                    "", listOf(":", ";", ".", "->"), 1,
                    "El punt i coma ; marca la fi d'una sentència SQL."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Selecciona TOTES les columnes de la taula cotxes:",
                    "SELECT ??? FROM cotxes;",
                    listOf("ALL", "*", "ANY", "EVERY"), 1,
                    "L'asterisc * és el comodí per 'totes les columnes'.")
            )
        ),

        Lesson(
            id = "sql_1_2",
            language = "SQL",
            unitNumber = 1,
            title = "WHERE per filtrar",
            theoryText = """
                WHERE filtra quines files es retornen segons una condició.
                
                🔹 Operadors: =, !=, <, >, <=, >=
                🔹 Combinacions: AND, OR, NOT
                🔹 LIKE per patrons: '%abc%' conté "abc"
                🔹 IN (val1, val2) per múltiples valors
                🔹 BETWEEN x AND y per rangs
            """.trimIndent(),
            codeExample = """
                -- Usuaris majors de 18
                SELECT * FROM usuaris WHERE edat > 18;
                
                -- Productes barats de Nike
                SELECT * FROM productes
                WHERE preu < 50 AND marca = 'Nike';
                
                -- Noms que comencen per A
                SELECT * FROM usuaris WHERE nom LIKE 'A%';
                
                -- Edats entre 18 i 30
                SELECT * FROM u WHERE edat BETWEEN 18 AND 30;
            """.trimIndent(),
            xpReward = 25,
            exercises = listOf(
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "Quina és la clàusula correcta per FILTRAR files?",
                    "", listOf("FILTER", "WHERE", "IF", "HAVING"), 1,
                    "WHERE filtra files. HAVING filtra grups (amb GROUP BY)."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Productes amb estoc > 0:",
                    "SELECT * FROM productes ??? estoc > 0;",
                    listOf("WHEN", "WHERE", "IF", "WITH"), 1,
                    "WHERE és la clàusula que afegeix condicions de filtratge."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "Quin operador cerca patrons en text?",
                    "", listOf("=", "MATCH", "LIKE", "REGEX"), 2,
                    "LIKE cerca patrons. % és el comodí de diversos caràcters, _ d'un de sol."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "Què fa WHERE preu BETWEEN 10 AND 50?",
                    "", listOf(
                        "preu = 10 o 50",
                        "preu entre 10 i 50 (inclosos)",
                        "preu menor que 10",
                        "Error de sintaxi"
                    ), 1,
                    "BETWEEN x AND y selecciona valors en el rang (inclosos)."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Filtra usuaris el país dels quals sigui Espanya O Portugal:",
                    "SELECT * FROM users WHERE pais ??? ('Espanya', 'Portugal');",
                    listOf("=", "IN", "OR", "EQUALS"), 1,
                    "IN (llista) és més net que pais='Espanya' OR pais='Portugal'.")
            )
        ),

        Lesson(
            id = "sql_1_3",
            language = "SQL",
            unitNumber = 1,
            title = "ORDER BY i LIMIT",
            theoryText = """
                Ordena resultats i limita quantes files es retornen.
                
                🔹 ORDER BY columna: ascendent (ASC, per defecte)
                🔹 ORDER BY columna DESC: descendent
                🔹 Es poden ordenar diverses columnes
                🔹 LIMIT n: només les primeres n files (MySQL/PostgreSQL/SQLite)
                🔹 TOP n s'usa a SQL Server
            """.trimIndent(),
            codeExample = """
                -- Més car primer
                SELECT * FROM productes
                ORDER BY preu DESC;
                
                -- Per categoria asc, després preu desc
                SELECT * FROM productes
                ORDER BY categoria ASC, preu DESC;
                
                -- Només els 5 més cars
                SELECT * FROM productes
                ORDER BY preu DESC
                LIMIT 5;
            """.trimIndent(),
            xpReward = 25,
            exercises = listOf(
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "Com s'ordenen resultats de major a menor?",
                    "", listOf("ORDER BY col ASC", "ORDER BY col DESC", "SORT col DOWN", "REVERSE col"), 1,
                    "DESC = descendent (major a menor). ASC = ascendent (per defecte)."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Limita el resultat a 10 files:",
                    "SELECT * FROM users ??? 10;",
                    listOf("TOP", "LIMIT", "MAX", "FIRST"), 1,
                    "LIMIT és estàndard a MySQL, PostgreSQL, SQLite. TOP és de SQL Server."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "Quin és l'ordre per defecte de ORDER BY?",
                    "", listOf("Ascendent (ASC)", "Descendent (DESC)", "Aleatori", "Per inserció"), 0,
                    "Si no específiques, ORDER BY és ASC (ascendent) per defecte."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "Què fa ORDER BY edat ASC, nom DESC?",
                    "", listOf(
                        "Ordena només per edat",
                        "Per edat ascendent, i dins de cada edat per nom descendent",
                        "Ignora una de les dues",
                        "Error"
                    ), 1,
                    "Es poden combinar diverses columnes. Cadascuna amb el seu propi ordre."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Els 3 productes més cars:",
                    "SELECT * FROM productes ORDER BY preu ??? LIMIT 3;",
                    listOf("ASC", "DESC", "TOP", "MAX"), 1,
                    "Més cars = ordenar de major a menor (DESC) i prendre els primers.")
            )
        ),

        // ============ UNITAT 2: AGREGACIONS ============

        Lesson(
            id = "sql_2_1",
            language = "SQL",
            unitNumber = 2,
            title = "Funcions d'Agregació (COUNT, SUM...)",
            theoryText = """
                Operen sobre múltiples files i retornen UN SOL valor.
                
                🔹 COUNT(col): compta les files (sense nuls). COUNT(*) compta totes.
                🔹 SUM(col): suma els valors numèrics.
                🔹 AVG(col): mitjana (Average).
                🔹 MIN(col) / MAX(col): mínim i màxim.
            """.trimIndent(),
            codeExample = """
                -- Total d'usuaris (COMPTA)
                SELECT COUNT(*) FROM usuaris;
                
                -- Suma de preus
                SELECT SUM(preu) FROM productes;
                
                -- Mitjana d'edat on l'estat és actiu
                SELECT AVG(edat) FROM usuaris WHERE estat = 'actiu';
            """.trimIndent(),
            xpReward = 30,
            exercises = listOf(
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "Quina funció calcula la suma total d'una columna numèrica?",
                    "", listOf("TOTAL", "ADD", "SUM", "COUNT"), 2,
                    "SUM(columna) retorna la suma de tots els seus valors."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "Si necessito trobar l'edat màxima a la taula 'alumnes', utilitzo:",
                    "", listOf("HIGH(edat)", "MAX(edat)", "BIG(edat)", "TOP(edat)"), 1,
                    "MAX(columna) troba el valor més alt."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Completa la consulta per obtenir la mitjana dels preus:",
                    "SELECT ???(preu) FROM productes;",
                    listOf("MEAN", "AVG", "MEDIAN", "AVERAGE"), 1,
                    "AVG (Average) s'usa per obtenir la mitjana."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "Quina és la diferència entre COUNT(col) i COUNT(*)?",
                    "", listOf("Cap, fan el mateix", "COUNT(*) inclou valors NULLs de la columna", "COUNT(col) és més ràpid", "COUNT(*) agrupa files"), 1,
                    "COUNT(*) compta files senceres sense importar si hi ha valors nuls."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Compta el total de files a la taula vendes:",
                    "SELECT ???(*) FROM vendes;",
                    listOf("SUM", "COUNT", "TOTAL", "NO"), 1,
                    "COUNT és la funció adequada per enumerar files.")
            )
        ),

        Lesson(
            id = "sql_2_2",
            language = "SQL",
            unitNumber = 2,
            title = "GROUP BY i HAVING",
            theoryText = """
                GROUP BY agrupa files per al càlcul d'agregacions per cada grup.
                HAVING filtra els grups (com WHERE filtra files individuals).
                
                🔹 GROUP BY col1: crea particions segons col1.
                🔹 HAVING es posa DESPRÉS del GROUP BY.
            """.trimIndent(),
            codeExample = """
                -- Total de productes PER categoria
                SELECT categoria, COUNT(*) 
                FROM productes 
                GROUP BY categoria;
                
                -- Mitjana d'edat de cada país, OMETENT on mitjana < 18
                SELECT pais, AVG(edat) 
                FROM usuaris 
                GROUP BY pais 
                HAVING AVG(edat) >= 18;
            """.trimIndent(),
            xpReward = 30,
            exercises = listOf(
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "Per agrupar els resultats en conjunts base d'una columna s'utilitza:",
                    "", listOf("ORDER BY", "GROUP BY", "ARRANGE BY", "CLUSTER BY"), 1,
                    "GROUP BY posa plegades files amb els mateixos valors."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "Si cal filtrar a condició d'una funció d'agregació, utilitzo:",
                    "", listOf("WHERE", "HAVING", "FILTER", "MATCH"), 1,
                    "HAVING es fa servir sempre associat a GROUP BY quan s'usen agregacions."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Mostra quants i de quina marca són:",
                    "SELECT marca, COUNT(*) FROM mòbils ??? ??? marca;",
                    listOf("ORDER BY", "GROUP BY", "WHERE ARE", "SORT IN"), 1,
                    "Sempre és GROUP BY columna."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "Es pot posar un WHERE abans d'un GROUP BY?",
                    "", listOf("Sí, filtra files avanç que s'agrupin.", "No, dona lloc a error.", "Només si hi ha HAVING.", "En sql nou."), 0,
                    "WHERE avalua files directes, les que el passen són les incloses al GROUP BY."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Només mostra grups el total dels quals passi dels 100:",
                    "SELECT venedor, SUM(vendes) FROM taula GROUP BY venedor ??? SUM(vendes) > 100;",
                    listOf("WHERE", "HAVING", "AND", "IF"), 1,
                    "Després d'agrupar i operar s'ha d'usar HAVING.")
            )
        )
    )
}
