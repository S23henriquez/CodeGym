package com.exemple.codegym.data.lessons_i18n.fr

import com.exemple.codegym.models.ExerciseType
import com.exemple.codegym.models.Lesson
import com.exemple.codegym.models.LessonExercise

object SqlLessonsFr {

    val lessons: List<Lesson> = listOf(

        // ============ UNITÉ 1 : SQL DE BASE ============

        Lesson(
            id = "sql_1_1",
            language = "SQL",
            unitNumber = 1,
            title = "SELECT et FROM",
            theoryText = """
                SELECT est la requête la plus utilisée en SQL : elle sert à LIRE des données.
                
                🔹 SELECT col1, col2 FROM table; → sélectionne des colonnes
                🔹 SELECT * FROM table; → TOUTES les colonnes
                🔹 Les mots-clés SQL ignorent la casse, mais par convention on les écrit EN MAJUSCULES
                🔹 Chaque requête se termine par un ;
            """.trimIndent(),
            codeExample = """
                -- Table 'utilisateurs' : id, nom, age
                
                SELECT * FROM utilisateurs;
                -- Retourne toutes les lignes et toutes les colonnes
                
                SELECT nom FROM utilisateurs;
                -- Uniquement la colonne 'nom' de toutes les lignes
                
                SELECT nom, age FROM utilisateurs;
                -- Seulement 'nom' et 'age'
            """.trimIndent(),
            xpReward = 20,
            exercises = listOf(
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "Que fait SELECT * FROM produits ; ?",
                    "", listOf(
                        "Supprime la table",
                        "Renvoie toutes les lignes et colonnes de 'produits'",
                        "Crée la table 'produits'",
                        "Compte le nombre de produits"
                    ), 1,
                    "SELECT * = toutes les colonnes. FROM = de quelle table."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Obtenez uniquement les noms des employés :",
                    "??? nom FROM employes;",
                    listOf("GET", "SELECT", "SHOW", "FETCH"),
                    1, "SELECT est le mot-clé pour lire des données."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "Quel SQL retourne uniquement l'email et le telephone des clients ?",
                    "", listOf(
                        "SELECT * FROM clients;",
                        "SELECT clients(email, telephone);",
                        "SELECT email, telephone FROM clients;",
                        "GET email, telephone FROM clients;"
                    ), 2,
                    "La syntaxe correcte est SELECT col1, col2 FROM table ;."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "Quel caractère termine chaque requête SQL ?",
                    "", listOf(":", ";", ".", "->"), 1,
                    "Le point-virgule (;) marque la fin d'une instruction SQL."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Sélectionnez TOUTES les colonnes de la table voitures :",
                    "SELECT ??? FROM voitures;",
                    listOf("ALL", "*", "ANY", "EVERY"), 1,
                    "L'astérisque * représente 'toutes les colonnes'.")
            )
        ),

        Lesson(
            id = "sql_1_2",
            language = "SQL",
            unitNumber = 1,
            title = "WHERE pour filtrer",
            theoryText = """
                WHERE filtre quelles lignes sont retournées selon une condition.
                
                🔹 Opérateurs : =, !=, <, >, <=, >=
                🔹 Combinaisons : AND, OR, NOT
                🔹 LIKE pour des modèles : '%abc%' contient "abc"
                🔹 IN (val1, val2) pour plusieurs valeurs
                🔹 BETWEEN x AND y pour des plages
            """.trimIndent(),
            codeExample = """
                -- Utilisateurs majeurs de 18
                SELECT * FROM utilisateurs WHERE age > 18;
                
                -- Produits pas chers de Nike
                SELECT * FROM produits
                WHERE prix < 50 AND marque = 'Nike';
                
                -- Noms commençant par A
                SELECT * FROM utilisateurs WHERE nom LIKE 'A%';
                
                -- Âges entre 18 et 30
                SELECT * FROM u WHERE age BETWEEN 18 AND 30;
            """.trimIndent(),
            xpReward = 25,
            exercises = listOf(
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "Quelle clause est correcte pour FILTRER les lignes ?",
                    "", listOf("FILTER", "WHERE", "IF", "HAVING"), 1,
                    "WHERE filtre les lignes. HAVING filtre des groupes (avec GROUP BY)."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Produits avec stock > 0 :",
                    "SELECT * FROM produits ??? stock > 0;",
                    listOf("WHEN", "WHERE", "IF", "WITH"), 1,
                    "WHERE est la clause qui ajoute les conditions de filtre."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "Quel opérateur recherche des motifs textuels ?",
                    "", listOf("=", "MATCH", "LIKE", "REGEX"), 2,
                    "LIKE recherche des modèles. % est pour plusieurs caractères, _ est pour un seul."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "Que fait WHERE prix BETWEEN 10 AND 50 ?",
                    "", listOf(
                        "prix = 10 ou 50",
                        "prix entre 10 et 50 (inclus)",
                        "prix inférieur à 10",
                        "Erreur de syntaxe"
                    ), 1,
                    "BETWEEN x AND y sélectionne des valeurs dans cette plage (incluses)."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Filtre les utilisateurs dont le pays est 'Espagne' ou 'Portugal' :",
                    "SELECT * FROM users WHERE pays ??? ('Espagne', 'Portugal');",
                    listOf("=", "IN", "OR", "EQUALS"), 1,
                    "IN (liste) est plus simple que pays='Espagne' OR pays='Portugal'.")
            )
        ),

        Lesson(
            id = "sql_1_3",
            language = "SQL",
            unitNumber = 1,
            title = "ORDER BY et LIMIT",
            theoryText = """
                Trie les résultats et limite le nombre de lignes retournées.
                
                🔹 ORDER BY colonne : par ordre croissant (ASC, par défaut)
                🔹 ORDER BY colonne DESC : ordre décroissant
                🔹 On peut trier plusieurs colonnes
                🔹 LIMIT n : juste les n premières lignes (MySQL/PostgreSQL/SQLite)
                🔹 TOP n est utilisé dans SQL Server
            """.trimIndent(),
            codeExample = """
                -- Le plus cher en premier
                SELECT * FROM produits
                ORDER BY prix DESC;
                
                -- Par catégorie asc, puis prix desc
                SELECT * FROM produits
                ORDER BY categorie ASC, prix DESC;
                
                -- Seulement les 5 plus chers
                SELECT * FROM produits
                ORDER BY prix DESC
                LIMIT 5;
            """.trimIndent(),
            xpReward = 25,
            exercises = listOf(
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "Comment ordonner les résultats du plus grand au plus petit ?",
                    "", listOf("ORDER BY col ASC", "ORDER BY col DESC", "SORT col DOWN", "REVERSE col"), 1,
                    "DESC = décroissant (du grand au petit). ASC = croissant (par défaut)."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Limitez le résultat à 10 lignes :",
                    "SELECT * FROM users ??? 10;",
                    listOf("TOP", "LIMIT", "MAX", "FIRST"), 1,
                    "LIMIT est le standard sur MySQL/PostgreSQL/SQLite. TOP est de SQL Server."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "Quel est l'ordre par défaut d'ORDER BY ?",
                    "", listOf("Croissant (ASC)", "Décroissant (DESC)", "Aléatoire", "Ordre d'insertion"), 0,
                    "Si ce n’est pas spécifié, ORDER BY est ASC (croissant) par défaut."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "Que fait ORDER BY age ASC, nom DESC ?",
                    "", listOf(
                        "Trie seulement par 'age'",
                        "Par age croissant, et pour chaque age, par nom décroissant",
                        "Ignore l'un des deux",
                        "Erreur"
                    ), 1,
                    "Vous pouvez spécifier l'ordre de plusieurs colonnes en série."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Obtenir les 3 produits les plus chers :",
                    "SELECT * FROM produits ORDER BY prix ??? LIMIT 3;",
                    listOf("ASC", "DESC", "TOP", "MAX"), 1,
                    "Les plus chers = ordonner de manière décroissante (DESC) et prendre les 3 premiers.")
            )
        ),

        // ============ UNITÉ 2 : AGRÉGATIONS ============

        Lesson(
            id = "sql_2_1",
            language = "SQL",
            unitNumber = 2,
            title = "Fonctions d'agrégation (COUNT, SUM...)",
            theoryText = """
                Fonctionnent sur de multiples lignes et retournent UNE SEULE valeur.
                
                🔹 COUNT(col) : compte les lignes (sans nulls). COUNT(*) compte tout.
                🔹 SUM(col) : somme des valeurs numériques.
                🔹 AVG(col) : la moyenne.
                🔹 MIN(col) / MAX(col) : minimum et maximum.
            """.trimIndent(),
            codeExample = """
                -- Total d'utilisateurs
                SELECT COUNT(*) FROM utilisateurs;
                
                -- Somme de prix
                SELECT SUM(prix) FROM produits;
                
                -- Moyenne d'âge où statut = 'actif'
                SELECT AVG(age) FROM utilisateurs WHERE statut = 'actif';
            """.trimIndent(),
            xpReward = 30,
            exercises = listOf(
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "Quelle fonction calcule la somme totale d'une colonne numérique ?",
                    "", listOf("TOTAL", "ADD", "SUM", "COUNT"), 2,
                    "SUM(colonne) retourne la somme totale de cette colonne."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "Pour trouver l'âge maximum dans 'eleves' j'utilise :",
                    "", listOf("HIGH(age)", "MAX(age)", "BIG(age)", "TOP(age)"), 1,
                    "MAX(colonne) retourne la valeur maximale."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Complète la requête pour obtenir la moyenne des prix :",
                    "SELECT ???(prix) FROM produits;",
                    listOf("MEAN", "AVG", "MEDIAN", "AVERAGE"), 1,
                    "AVG s'utilise pour obtenir la moyenne."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "Quelle est la différence entre COUNT(col) et COUNT(*) ?",
                    "", listOf("Aucune", "COUNT(*) inclut les NULL de toutes les colonnes", "COUNT(col) est plus rapide", "COUNT(*) les groupe"), 1,
                    "COUNT(*) prend en compte les lignes complètes que des propriétés soient NULL ou pas."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Compte le nombre de ventes totales :",
                    "SELECT ???(*) FROM ventes;",
                    listOf("SUM", "COUNT", "TOTAL", "NO"), 1,
                    "COUNT aide à l'énumération des lignes.")
            )
        ),

        Lesson(
            id = "sql_2_2",
            language = "SQL",
            unitNumber = 2,
            title = "GROUP BY et HAVING",
            theoryText = """
                GROUP BY regroupe les lignes pour des calculs d'agrégation.
                HAVING filtre ces mêmes groupes.
                
                🔹 GROUP BY col1 : regroupe par col1.
                🔹 HAVING est placé APRÈS un GROUP BY.
            """.trimIndent(),
            codeExample = """
                -- Total de produits par catégorie
                SELECT categorie, COUNT(*) 
                FROM produits 
                GROUP BY categorie;
                
                -- Moyenne d'âge par pays, qui passe 18 ans
                SELECT pays, AVG(age) 
                FROM utilisateurs 
                GROUP BY pays 
                HAVING AVG(age) >= 18;
            """.trimIndent(),
            xpReward = 30,
            exercises = listOf(
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "Pour grouper les résultats basés sur une colonne nous utilisons :",
                    "", listOf("ORDER BY", "GROUP BY", "ARRANGE BY", "CLUSTER BY"), 1,
                    "GROUP BY assemble les lignes partageant des valeurs d'une définition commune."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "Pour filtrer sur une fonction d'agrégation conditionnelle, c'est :",
                    "", listOf("WHERE", "HAVING", "FILTER", "MATCH"), 1,
                    "HAVING est conditionné pour appliquer après regroupement les fonctions d'agrégat."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Montrez la somme par marque de produits :",
                    "SELECT marque, COUNT(*) FROM mobiles ??? ??? marque;",
                    listOf("ORDER BY", "GROUP BY", "WHERE ARE", "SORT IN"), 1,
                    "Le couple clé est toujours GROUP BY avec la colonne."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "Est-ce possible de placer WHERE avant le GROUP BY ?",
                    "", listOf("Oui, il filtre avant de regrouper.", "Non, erreur fatale.", "Seulement s'il y a HAVING.", "Impossible en SQL."), 0,
                    "WHERE évalue en premier point les critères sur ligne unitaire avant le regroupement."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Affiche les vendeurs ayant dépassé 100 de somme de ventes :",
                    "SELECT vendeur, SUM(ventes) FROM table GROUP BY vendeur ??? SUM(ventes) > 100;",
                    listOf("WHERE", "HAVING", "AND", "IF"), 1,
                    "À posteriori d'un grouppement, filtrer la somme nécessite la clause HAVING.")
            )
        )
    )
}
