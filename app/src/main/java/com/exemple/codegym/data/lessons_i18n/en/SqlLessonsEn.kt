package com.exemple.codegym.data.lessons_i18n.en

import com.exemple.codegym.models.ExerciseType
import com.exemple.codegym.models.Lesson
import com.exemple.codegym.models.LessonExercise

/**
 * SQL lessons (EN).
 * NOTE: This file is intentionally English-only so the app shows zero Spanish
 * when the app language is set to English.
 */
object SqlLessonsEn {

    val lessons: List<Lesson> = listOf(

        // ============ UNIT 1: SQL BASICS ============

        Lesson(
            id = "sql_1_1",
            language = "SQL",
            unitNumber = 1,
            title = "SELECT and FROM",
            theoryText = """
                SELECT is the most used query in SQL: it READS data.

                🔹 SELECT col1, col2 FROM table;  → selects specific columns
                🔹 SELECT * FROM table;           → ALL columns
                🔹 SQL keywords are case-insensitive, but by convention they are written IN UPPERCASE
                🔹 Each statement ends with a semicolon ;
            """.trimIndent(),
            codeExample = """
                -- Table 'users': id, name, age

                SELECT * FROM users;
                -- Returns all rows with all columns

                SELECT name FROM users;
                -- Only the name column (for all rows)

                SELECT name, age FROM users;
                -- Only name and age
            """.trimIndent(),
            xpReward = 20,
            exercises = listOf(
                LessonExercise(
                    ExerciseType.MULTIPLE_CHOICE,
                    "What does SELECT * FROM products; do?",
                    "",
                    listOf(
                        "Deletes the table",
                        "Returns all rows and columns from products",
                        "Creates the products table",
                        "Counts how many products exist"
                    ),
                    1,
                    "SELECT * means all columns. FROM specifies which table."
                ),
                LessonExercise(
                    ExerciseType.FILL_BLANK,
                    "Get only the employees' names:",
                    "??? name FROM employees;",
                    listOf("GET", "SELECT", "SHOW", "FETCH"),
                    1,
                    "SELECT is the keyword used to query/read data."
                ),
                LessonExercise(
                    ExerciseType.MULTIPLE_CHOICE,
                    "Which SQL returns only email and phone from customers?",
                    "",
                    listOf(
                        "SELECT * FROM customers;",
                        "SELECT customers(email, phone);",
                        "SELECT email, phone FROM customers;",
                        "GET email, phone FROM customers;"
                    ),
                    2,
                    "SELECT col1, col2 FROM table; is the correct syntax."
                ),
                LessonExercise(
                    ExerciseType.MULTIPLE_CHOICE,
                    "Which character ends each SQL statement?",
                    "",
                    listOf(":", ";", ".", "->"),
                    1,
                    "A semicolon ; marks the end of an SQL statement."
                ),
                LessonExercise(
                    ExerciseType.FILL_BLANK,
                    "Select ALL columns from the cars table:",
                    "SELECT ??? FROM cars;",
                    listOf("ALL", "*", "ANY", "EVERY"),
                    1,
                    "The asterisk * is the wildcard for 'all columns'."
                )
            )
        ),

        Lesson(
            id = "sql_1_2",
            language = "SQL",
            unitNumber = 1,
            title = "WHERE filters rows",
            theoryText = """
                WHERE filters which rows are returned based on a condition.

                🔹 Operators: =, !=, <, >, <=, >=
                🔹 Combinations: AND, OR, NOT
                🔹 LIKE for patterns: '%abc%' contains "abc"
                🔹 IN (val1, val2) for multiple values
                🔹 BETWEEN x AND y for ranges
            """.trimIndent(),
            codeExample = """
                -- Users older than 18
                SELECT * FROM users WHERE age > 18;

                -- Cheap Nike products
                SELECT * FROM products
                WHERE price < 50 AND brand = 'Nike';

                -- Names that start with A
                SELECT * FROM users WHERE name LIKE 'A%';

                -- Ages between 18 and 30
                SELECT * FROM u WHERE age BETWEEN 18 AND 30;
            """.trimIndent(),
            xpReward = 25,
            exercises = listOf(
                LessonExercise(
                    ExerciseType.MULTIPLE_CHOICE,
                    "Which clause is used to FILTER rows?",
                    "",
                    listOf("FILTER", "WHERE", "IF", "HAVING"),
                    1,
                    "WHERE filters rows. HAVING filters groups (with GROUP BY)."
                ),
                LessonExercise(
                    ExerciseType.FILL_BLANK,
                    "Products with stock > 0:",
                    "SELECT * FROM products ??? stock > 0;",
                    listOf("WHEN", "WHERE", "IF", "WITH"),
                    1,
                    "WHERE is the clause that adds filter conditions."
                ),
                LessonExercise(
                    ExerciseType.MULTIPLE_CHOICE,
                    "Which operator searches for text patterns?",
                    "",
                    listOf("=", "MATCH", "LIKE", "REGEX"),
                    2,
                    "LIKE searches patterns. % matches many characters, _ matches one."
                ),
                LessonExercise(
                    ExerciseType.MULTIPLE_CHOICE,
                    "What does WHERE price BETWEEN 10 AND 50 do?",
                    "",
                    listOf(
                        "price equals 10 or 50",
                        "price between 10 and 50 (inclusive)",
                        "price lower than 10",
                        "Syntax error"
                    ),
                    1,
                    "BETWEEN x AND y selects values within the range (inclusive)."
                ),
                LessonExercise(
                    ExerciseType.FILL_BLANK,
                    "Filter users whose country is Spain OR Portugal:",
                    "SELECT * FROM users WHERE country ??? ('Spain', 'Portugal');",
                    listOf("=", "IN", "OR", "EQUALS"),
                    1,
                    "IN (list) is cleaner than country='Spain' OR country='Portugal'."
                )
            )
        ),

        Lesson(
            id = "sql_1_3",
            language = "SQL",
            unitNumber = 1,
            title = "ORDER BY and LIMIT",
            theoryText = """
                Sort results and limit how many rows are returned.

                🔹 ORDER BY column: ascending (ASC, default)
                🔹 ORDER BY column DESC: descending
                🔹 You can sort by multiple columns
                🔹 LIMIT n: only the first n rows (MySQL/PostgreSQL/SQLite)
                🔹 TOP n is used in SQL Server
            """.trimIndent(),
            codeExample = """
                -- Most expensive first
                SELECT * FROM products
                ORDER BY price DESC;

                -- Category asc, then price desc
                SELECT * FROM products
                ORDER BY category ASC, price DESC;

                -- Only the 5 most expensive
                SELECT * FROM products
                ORDER BY price DESC
                LIMIT 5;
            """.trimIndent(),
            xpReward = 25,
            exercises = listOf(
                LessonExercise(
                    ExerciseType.MULTIPLE_CHOICE,
                    "How do you sort results from highest to lowest?",
                    "",
                    listOf("ORDER BY col ASC", "ORDER BY col DESC", "SORT col DOWN", "REVERSE col"),
                    1,
                    "DESC = descending (high to low). ASC = ascending (default)."
                ),
                LessonExercise(
                    ExerciseType.FILL_BLANK,
                    "Limit the result to 10 rows:",
                    "SELECT * FROM users ??? 10;",
                    listOf("TOP", "LIMIT", "MAX", "FIRST"),
                    1,
                    "LIMIT is common in MySQL/PostgreSQL/SQLite. TOP is SQL Server."
                ),
                LessonExercise(
                    ExerciseType.MULTIPLE_CHOICE,
                    "What is the default ORDER BY direction?",
                    "",
                    listOf("Ascending (ASC)", "Descending (DESC)", "Random", "Insertion order"),
                    0,
                    "If you don't specify, ORDER BY defaults to ASC (ascending)."
                ),
                LessonExercise(
                    ExerciseType.MULTIPLE_CHOICE,
                    "What does ORDER BY age ASC, name DESC do?",
                    "",
                    listOf(
                        "Sorts only by age",
                        "Age ascending, and within each age name descending",
                        "Ignores one of them",
                        "Error"
                    ),
                    1,
                    "You can sort by multiple columns, each with its own direction."
                ),
                LessonExercise(
                    ExerciseType.FILL_BLANK,
                    "The 3 most expensive products:",
                    "SELECT * FROM products ORDER BY price ??? LIMIT 3;",
                    listOf("ASC", "DESC", "TOP", "MAX"),
                    1,
                    "Most expensive = sort high to low (DESC) and take the first rows."
                )
            )
        ),

        // ============ UNIT 2: AGGREGATIONS ============

        Lesson(
            id = "sql_2_1",
            language = "SQL",
            unitNumber = 2,
            title = "Aggregate functions",
            theoryText = """
                Aggregate functions compute values over sets of rows.

                🔹 COUNT(*): counts rows
                🔹 SUM(col): sums values
                🔹 AVG(col): average
                🔹 MIN(col) / MAX(col): min / max
                🔹 Often used with GROUP BY
            """.trimIndent(),
            codeExample = """
                -- How many users exist
                SELECT COUNT(*) FROM users;

                -- Total sales amount
                SELECT SUM(price) FROM sales;

                -- Average age
                SELECT AVG(age) FROM users;

                -- Most expensive product
                SELECT MAX(price) FROM products;
            """.trimIndent(),
            xpReward = 30,
            exercises = listOf(
                LessonExercise(
                    ExerciseType.MULTIPLE_CHOICE,
                    "What does COUNT(*) do?",
                    "",
                    listOf("Sums values", "Counts the number of rows", "Counts columns", "Returns the maximum"),
                    1,
                    "COUNT(*) counts how many rows are in the result."
                ),
                LessonExercise(
                    ExerciseType.FILL_BLANK,
                    "Get the maximum price:",
                    "SELECT ???(price) FROM products;",
                    listOf("HIGHEST", "MAX", "TOP", "MAXIMUM"),
                    1,
                    "MAX(column) returns the maximum value in that column."
                ),
                LessonExercise(
                    ExerciseType.MULTIPLE_CHOICE,
                    "What does AVG compute?",
                    "",
                    listOf("Sum", "Median", "Average (mean)", "Mode"),
                    2,
                    "AVG = average (arithmetic mean)."
                ),
                LessonExercise(
                    ExerciseType.MULTIPLE_CHOICE,
                    "What does SELECT SUM(quantity) FROM sales; return?",
                    "",
                    listOf("Number of sales", "Total sum of quantities", "The most expensive sale", "Error"),
                    1,
                    "SUM adds up all values in the 'quantity' column."
                ),
                LessonExercise(
                    ExerciseType.FILL_BLANK,
                    "Count how many distinct users there are:",
                    "SELECT COUNT(??? id) FROM users;",
                    listOf("ALL", "DISTINCT", "UNIQUE", "ONLY"),
                    1,
                    "DISTINCT removes duplicates. COUNT(DISTINCT col) counts unique values."
                )
            )
        ),

        Lesson(
            id = "sql_2_2",
            language = "SQL",
            unitNumber = 2,
            title = "GROUP BY",
            theoryText = """
                GROUP BY groups rows that share a value so you can apply aggregations per group.

                🔹 GROUP BY column: groups by that column
                🔹 Columns in SELECT must be in GROUP BY or be aggregated
                🔹 HAVING filters groups (like WHERE, but after grouping)
                🔹 Order: SELECT → FROM → WHERE → GROUP BY → HAVING → ORDER BY
            """.trimIndent(),
            codeExample = """
                -- How many products per category
                SELECT category, COUNT(*) AS count
                FROM products
                GROUP BY category;

                -- Only categories with more than 5 products
                SELECT category, COUNT(*) AS count
                FROM products
                GROUP BY category
                HAVING COUNT(*) > 5;
            """.trimIndent(),
            xpReward = 35,
            exercises = listOf(
                LessonExercise(
                    ExerciseType.MULTIPLE_CHOICE,
                    "What does GROUP BY do?",
                    "",
                    listOf(
                        "Sorts results",
                        "Groups rows that share a value in a column",
                        "Joins two tables",
                        "Filters results"
                    ),
                    1,
                    "GROUP BY groups rows so aggregate functions apply to each group."
                ),
                LessonExercise(
                    ExerciseType.FILL_BLANK,
                    "Count users by country:",
                    "SELECT country, COUNT(*) FROM users ??? country;",
                    listOf("ORDER BY", "GROUP BY", "WHERE", "JOIN"),
                    1,
                    "GROUP BY groups rows with the same value in the specified column."
                ),
                LessonExercise(
                    ExerciseType.MULTIPLE_CHOICE,
                    "What's the difference between WHERE and HAVING?",
                    "",
                    listOf(
                        "They are synonyms",
                        "WHERE filters rows, HAVING filters groups after GROUP BY",
                        "HAVING is faster",
                        "WHERE only works with numbers"
                    ),
                    1,
                    "WHERE filters before grouping. HAVING filters after grouping (on groups)."
                ),
                LessonExercise(
                    ExerciseType.MULTIPLE_CHOICE,
                    "What does this query show?\nSELECT brand, AVG(price)\nFROM cars\nGROUP BY brand;",
                    "",
                    listOf(
                        "The average price of all cars",
                        "The average price for each brand",
                        "Brands sorted",
                        "The most expensive cars"
                    ),
                    1,
                    "AVG with GROUP BY brand computes an average per brand."
                ),
                LessonExercise(
                    ExerciseType.FILL_BLANK,
                    "Filter groups with more than 10 items:",
                    "GROUP BY city ??? COUNT(*) > 10",
                    listOf("WHERE", "HAVING", "FILTER", "WITH"),
                    1,
                    "HAVING filters AFTER GROUP BY. WHERE does not work on aggregates like COUNT(*)."
                )
            )
        ),

        // ============ UNIT 3: JOINS ============

        Lesson(
            id = "sql_3_1",
            language = "SQL",
            unitNumber = 3,
            title = "INNER JOIN",
            theoryText = """
                JOIN combines rows from 2+ related tables.

                🔹 INNER JOIN: only rows that match in BOTH tables
                🔹 ON: join condition (usually keys)
                🔹 Aliases (u, p) make queries shorter and clearer
                🔹 Typical: users JOIN orders ON users.id = orders.user_id
            """.trimIndent(),
            codeExample = """
                -- users: id, name
                -- orders: id, user_id, total

                SELECT u.name, o.total
                FROM users u
                INNER JOIN orders o ON u.id = o.user_id;

                -- Returns only users WITH orders
                -- (users without orders do NOT appear)
            """.trimIndent(),
            xpReward = 40,
            exercises = listOf(
                LessonExercise(
                    ExerciseType.MULTIPLE_CHOICE,
                    "What does INNER JOIN return?",
                    "",
                    listOf(
                        "All rows from both tables",
                        "Only rows that match in both tables",
                        "Only rows from the left table",
                        "Only non-matching rows"
                    ),
                    1,
                    "INNER JOIN returns only rows where the ON condition matches in BOTH tables."
                ),
                LessonExercise(
                    ExerciseType.FILL_BLANK,
                    "Join users and orders by user_id:",
                    "SELECT * FROM users u\nJOIN orders o ??? u.id = o.user_id;",
                    listOf("WHERE", "ON", "WITH", "AND"),
                    1,
                    "ON specifies the join condition. WHERE comes later for additional filtering."
                ),
                LessonExercise(
                    ExerciseType.MULTIPLE_CHOICE,
                    "If I INNER JOIN A (10 rows) with B and only 3 matches exist, how many rows do I get?",
                    "",
                    listOf("3", "5", "10", "15"),
                    0,
                    "INNER JOIN returns only matching rows: 3."
                ),
                LessonExercise(
                    ExerciseType.MULTIPLE_CHOICE,
                    "Why use aliases (u, o)?",
                    "",
                    listOf("Required", "Shorter names and less ambiguity", "Better performance", "Renames the real table"),
                    1,
                    "Aliases improve readability, especially with multiple JOINs."
                ),
                LessonExercise(
                    ExerciseType.FILL_BLANK,
                    "Select the user's name and the order total:",
                    "SELECT u.???, o.??? FROM users u JOIN orders o ON u.id=o.user_id;",
                    listOf("name, total", "*, *", "all, all", "nombre, total"),
                    0,
                    "You access columns with alias.column. Use the real column names."
                )
            )
        ),

        Lesson(
            id = "sql_3_2",
            language = "SQL",
            unitNumber = 3,
            title = "LEFT JOIN",
            theoryText = """
                LEFT JOIN returns ALL rows from the left table, even if there is no match.

                🔹 LEFT JOIN: full left table + matching right rows
                🔹 If no match exists, right-side columns are NULL
                🔹 Useful to detect "orphans" (no related row)
                🔹 RIGHT JOIN is the opposite (less commonly used)
            """.trimIndent(),
            codeExample = """
                -- List ALL users, with or without orders
                SELECT u.name, o.total
                FROM users u
                LEFT JOIN orders o ON u.id = o.user_id;

                -- If John has no orders:
                -- name='John', total=NULL

                -- Find users WITHOUT orders
                SELECT u.name
                FROM users u
                LEFT JOIN orders o ON u.id = o.user_id
                WHERE o.id IS NULL;
            """.trimIndent(),
            xpReward = 40,
            exercises = listOf(
                LessonExercise(
                    ExerciseType.MULTIPLE_CHOICE,
                    "What does LEFT JOIN return?",
                    "",
                    listOf(
                        "Only matching rows",
                        "All rows from the LEFT table + matches",
                        "Only non-matching rows",
                        "Same as INNER JOIN"
                    ),
                    1,
                    "LEFT JOIN returns the entire left table. Non-matches have NULLs on the right."
                ),
                LessonExercise(
                    ExerciseType.FILL_BLANK,
                    "Find users WITHOUT orders:",
                    "SELECT u.* FROM users u\nLEFT JOIN orders o ON u.id=o.user_id\nWHERE o.id ??? NULL;",
                    listOf("=", "IS", "==", "EQUALS"),
                    1,
                    "To compare with NULL you must use IS NULL / IS NOT NULL, never = NULL."
                ),
                LessonExercise(
                    ExerciseType.MULTIPLE_CHOICE,
                    "If I LEFT JOIN A (10 rows) with B (5 matches), how many rows do I get?",
                    "",
                    listOf("5", "10", "15", "It depends"),
                    1,
                    "LEFT JOIN returns ALL rows from A (10). Non-matches will have NULLs."
                ),
                LessonExercise(
                    ExerciseType.MULTIPLE_CHOICE,
                    "What value do right-side columns have when there is no match?",
                    "",
                    listOf("0", "Empty string", "NULL", "Error"),
                    2,
                    "NULL represents the absence of a value when there is no matching row."
                ),
                LessonExercise(
                    ExerciseType.FILL_BLANK,
                    "Join categories with products (show all categories):",
                    "SELECT c.name, p.title\nFROM categories c\n??? JOIN products p ON c.id=p.cat_id;",
                    listOf("INNER", "LEFT", "RIGHT", "CROSS"),
                    1,
                    "Use LEFT JOIN to show ALL categories, even those without products."
                )
            )
        ),

        // ============ UNIT 4: MODIFYING DATA ============

        Lesson(
            id = "sql_4_1",
            language = "SQL",
            unitNumber = 4,
            title = "INSERT, UPDATE, DELETE",
            theoryText = """
                Data modification operations: insert, update, delete.

                🔹 INSERT INTO table (cols) VALUES (vals);
                🔹 UPDATE table SET col=val WHERE condition;
                🔹 DELETE FROM table WHERE condition;
                🔹 ⚠️ UPDATE/DELETE without WHERE affects ALL rows
            """.trimIndent(),
            codeExample = """
                -- Insert
                INSERT INTO users (name, age)
                VALUES ('Marta', 28);

                -- Update
                UPDATE users
                SET age = 29
                WHERE name = 'Marta';

                -- Delete
                DELETE FROM users
                WHERE age < 18;
            """.trimIndent(),
            xpReward = 35,
            exercises = listOf(
                LessonExercise(
                    ExerciseType.MULTIPLE_CHOICE,
                    "Which command ADDS new rows?",
                    "",
                    listOf("ADD", "INSERT", "CREATE", "PUT"),
                    1,
                    "INSERT INTO adds new rows. CREATE creates tables/databases."
                ),
                LessonExercise(
                    ExerciseType.FILL_BLANK,
                    "Update the email of the user with id=5:",
                    "??? users SET email='new@x.com' WHERE id=5;",
                    listOf("MODIFY", "UPDATE", "CHANGE", "SET"),
                    1,
                    "UPDATE table SET col=value WHERE condition."
                ),
                LessonExercise(
                    ExerciseType.MULTIPLE_CHOICE,
                    "⚠️ What does DELETE FROM users; (without WHERE) do?",
                    "",
                    listOf(
                        "It errors",
                        "Deletes the first user",
                        "Deletes ALL rows in the table",
                        "Does nothing"
                    ),
                    2,
                    "Without WHERE, DELETE removes ALL rows. Always use WHERE."
                ),
                LessonExercise(
                    ExerciseType.MULTIPLE_CHOICE,
                    "Which is the correct INSERT syntax?",
                    "",
                    listOf(
                        "INSERT users VALUES ('Ana', 25);",
                        "INSERT INTO users (name, age) VALUES ('Ana', 25);",
                        "ADD users ('Ana', 25);",
                        "INSERT users SET name='Ana';"
                    ),
                    1,
                    "INSERT INTO table (cols) VALUES (vals); is the standard syntax."
                ),
                LessonExercise(
                    ExerciseType.FILL_BLANK,
                    "Delete only products with no stock:",
                    "??? FROM products WHERE stock = 0;",
                    listOf("REMOVE", "DROP", "DELETE", "ERASE"),
                    2,
                    "DELETE FROM table WHERE condition. DROP removes the entire table."
                )
            )
        ),

        // ============ UNIT 5: ADVANCED ============

        Lesson(
            id = "sql_5_1",
            language = "SQL",
            unitNumber = 5,
            title = "Subqueries",
            theoryText = """
                A subquery is a query INSIDE another query.

                🔹 It can appear in SELECT, FROM, or WHERE
                🔹 Usually wrapped in parentheses ( )
                🔹 Useful to compare against computed results
                🔹 EXISTS / NOT EXISTS checks whether rows exist
            """.trimIndent(),
            codeExample = """
                -- Users older than the average
                SELECT * FROM users
                WHERE age > (SELECT AVG(age) FROM users);

                -- Products that have at least one order
                SELECT * FROM products p
                WHERE EXISTS (
                    SELECT 1 FROM orders
                    WHERE product_id = p.id
                );
            """.trimIndent(),
            xpReward = 50,
            exercises = listOf(
                LessonExercise(
                    ExerciseType.MULTIPLE_CHOICE,
                    "What is a subquery?",
                    "",
                    listOf(
                        "A faster query",
                        "A query inside another query",
                        "A query without WHERE",
                        "A query with JOIN"
                    ),
                    1,
                    "A subquery is an SQL query nested inside another query, usually in parentheses."
                ),
                LessonExercise(
                    ExerciseType.FILL_BLANK,
                    "Products with price greater than the average:",
                    "SELECT * FROM products\nWHERE price > (SELECT ???(price) FROM products);",
                    listOf("MAX", "MIN", "AVG", "COUNT"),
                    2,
                    "AVG computes the average. The subquery returns a single value to compare against."
                ),
                LessonExercise(
                    ExerciseType.MULTIPLE_CHOICE,
                    "Where can a subquery appear?",
                    "",
                    listOf("Only in WHERE", "Only in SELECT", "In SELECT, FROM, or WHERE", "Only in FROM"),
                    2,
                    "Subqueries can appear in multiple SQL clauses."
                ),
                LessonExercise(
                    ExerciseType.MULTIPLE_CHOICE,
                    "What does EXISTS (subquery) do?",
                    "",
                    listOf(
                        "Counts rows",
                        "Returns TRUE if the subquery returns any rows",
                        "Checks if the table exists",
                        "Returns the first row"
                    ),
                    1,
                    "EXISTS returns TRUE/FALSE depending on whether the subquery produces rows."
                ),
                LessonExercise(
                    ExerciseType.FILL_BLANK,
                    "Employees who have NOT made any sales:",
                    "SELECT * FROM employees e\nWHERE NOT ??? (\n    SELECT 1 FROM sales WHERE emp_id = e.id\n);",
                    listOf("EXISTS", "EQUAL", "JOIN", "ANY"),
                    0,
                    "NOT EXISTS means the subquery returns no rows. It's great to find 'orphans'."
                )
            )
        )
    )
}
