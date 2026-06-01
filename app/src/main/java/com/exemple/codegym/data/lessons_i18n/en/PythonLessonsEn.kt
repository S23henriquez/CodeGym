package com.exemple.codegym.data.lessons_i18n.en

import com.exemple.codegym.models.ExerciseType
import com.exemple.codegym.models.Lesson
import com.exemple.codegym.models.LessonExercise

object PythonLessonsEn {
    val lessons = listOf(
        // ============ UNIT 1: FUNDAMENTALS ============
        Lesson(
            id = "py_1_1",
            language = "Python",
            unitNumber = 1,
            title = "Introduction and Print",
            theoryText = """
                Python is an easy-to-read programming language.
                
                🔹 Variables don't need a type declared (it's dynamically typed).
                🔹 Code blocks are defined by indentation (spaces), not { }.
                🔹 print() is used to show text on the screen.
            """.trimIndent(),
            codeExample = """
                # This is a comment
                name = "Ana"
                age = 25
                print("Hello", name)
                
                # String formatting (f-strings)
                print(f"I am {age} years old")
            """.trimIndent(),
            xpReward = 20,
            exercises = listOf(
                LessonExercise(
                    ExerciseType.MULTIPLE_CHOICE,
                    "How do you print 'Hello' in Python?",
                    "",
                    listOf(
                        "console.log('Hello')",
                        "System.out.print('Hello')",
                        "print('Hello')",
                        "echo 'Hello'"
                    ),
                    2,
                    "In Python, print() is used to output text to the console."
                ),
                LessonExercise(
                    ExerciseType.FILL_BLANK,
                    "Complete the code to print the variable:",
                    "x = 10\n???(x)",
                    listOf("print", "echo", "show", "log"), 0,
                    "print is the function to display values on the screen."
                ),
                LessonExercise(
                    ExerciseType.MULTIPLE_CHOICE,
                    "How are code blocks defined in Python?",
                    "", listOf("Braces {}", "Parentheses ()", "Indentation (spaces)", "Tags <>"), 2,
                    "Python uses indentation (typically 4 spaces) instead of braces to delimit blocks of code."
                ),
                LessonExercise(
                    ExerciseType.MULTIPLE_CHOICE,
                    "What does this code print?",
                    "print(2 + 3)",
                    listOf("2 + 3", "5", "Error", "23"), 1,
                    "Python evaluates math operations inside print(). 2 + 3 = 5."
                ),
                LessonExercise(
                    ExerciseType.FILL_BLANK,
                    "Complete using an f-string:",
                    "name = 'Luis'\nprint(???\"Hello {name}\")",
                    listOf("f", "F", "format", "s"), 0,
                    "f-strings (put an 'f' before the string) allow variables directly inside {}."
                )
            )
        ),

        Lesson(
            id = "py_1_2",
            language = "Python",
            unitNumber = 1,
            title = "Basic Operations",
            theoryText = """
                Python supports standard mathematical operations.
                
                🔹 + (sum), - (subtraction), * (multiplication)
                🔹 / (decimal division), // (integer division)
                🔹 % (modulo, remainder of the division)
                🔹 ** (exponentiation)
            """.trimIndent(),
            codeExample = """
                print(10 / 3)   # 3.33333333...
                print(10 // 3)  # 3 (integer part)
                print(10 % 3)   # 1 (remainder)
                print(2 ** 3)   # 8 (2 to the power of 3)
            """.trimIndent(),
            xpReward = 25,
            exercises = listOf(
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "What's the result of 10 / 2?",
                    "", listOf("5", "5.0", "Error", "0"), 1,
                    "/ always returns a float (decimal) in Python 3."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Calculate 5 to the power of 2:",
                    "result = 5 ??? 2",
                    listOf("**", "^", "*", "//"), 0,
                    "In Python, ** is the exponentiation operator. ^ is bitwise XOR."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "What does the modulo (%) operator do?",
                    "", listOf("Calculates percentage", "Integer division", "Returns the remainder of a division", "Multiplies numbers"), 2,
                    "10 % 3 = 1 because 10 = 3*3 + 1."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "What does 7 // 2 return?",
                    "", listOf("3.5", "3", "4", "Error"), 1,
                    "// performs integer division (discards decimals). 7/2=3.5 -> 3."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Complete the code to get the remainder of 15 divided by 4:",
                    "print(15 ??? 4)",
                    listOf("%", "/", "//", "*"), 0,
                    "The % operator returns the remainder.")
            )
        ),

        // ============ UNIT 2: CONTROL FLOW ============

        Lesson(
            id = "py_2_1",
            language = "Python",
            unitNumber = 2,
            title = "Conditionals (if-else)",
            theoryText = """
                Control the flow with if, elif, and else.
                
                🔹 End the condition line with a colon (:)
                🔹 Indent the code block
                🔹 and = both true
                🔹 or = one true
                🔹 not = negate
            """.trimIndent(),
            codeExample = """
                age = 18
                if age >= 18:
                    print("Adult")
                elif age >= 13:
                    print("Teenager")
                else:
                    print("Child")
            """.trimIndent(),
            xpReward = 25,
            exercises = listOf(
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "What's missing for the 'if' condition to work?",
                    "if x > 10\n    print('Greater')",
                    listOf("Parentheses around x > 10", "A colon (:) at the end", "Braces {}", "Semicolon (;)"), 1,
                    "Python requires a colon (:) after conditions."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Complete to print 'Pass' if grade >= 5:",
                    "grade = 7\n??? grade >= 5:\n    print('Pass')",
                    listOf("if", "for", "while", "def"), 0,
                    "To evaluate a condition, use 'if'."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "What does the code print?",
                    "x = 0\nif x:\n    print('Yes')\nelse:\n    print('No')",
                    listOf("Yes", "No", "0", "Error"), 1,
                    "0 is considered False in Python, so it goes to else."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "What is the correct operator for 'equal to'?",
                    "", listOf("=", "==", "===", "!="), 1,
                    "= assigns values. == checks for equality."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Complete the elif for 'age between 13 and 17':",
                    "if age < 13:\n    print('child')\n??? age < 18:\n    print('teenager')",
                    listOf("else", "elif", "if", "or"), 1,
                    "elif is used to add intermediate conditions between if and else.")
            )
        ),

        Lesson(
            id = "py_2_2",
            language = "Python",
            unitNumber = 2,
            title = "for and while loops",
            theoryText = """
                Loops repeat operations:
                
                🔹 for: iterates over a sequence (list, range, string...)
                🔹 while: repeats as long as a condition is met
                🔹 break: exits the loop
                🔹 continue: jumps to the next iteration
                🔹 range(n): generates 0, 1, 2, ..., n-1
            """.trimIndent(),
            codeExample = """
                # for with range
                for i in range(5):
                    print(i)        # 0,1,2,3,4
                
                # for over a list
                for fruit in ["pear", "grape"]:
                    print(fruit)
                
                # while
                counter = 0
                while counter < 3:
                    print(counter)
                    counter += 1
            """.trimIndent(),
            xpReward = 25,
            exercises = listOf(
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "How many times will 'hello' be printed?",
                    "for i in range(4):\n    print('hello')",
                    listOf("3", "4", "5", "0"), 1,
                    "range(4) generates 4 values: 0,1,2,3 → 4 iterations."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Complete to iterate from 0 to 9:",
                    "for i in ???(10):\n    print(i)",
                    listOf("range", "len", "list", "iter"), 0,
                    "range(10) generates 0,1,2,...,9 (does not include 10)."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "What does 'break' do inside a loop?",
                    "", listOf("Jumps to next iteration", "Exits the loop immediately", "Restarts the loop", "Prints a message"), 1,
                    "break ends the loop. continue skips to the next iteration."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "What is the last value printed?",
                    "i = 0\nwhile i < 3:\n    print(i)\n    i += 1",
                    listOf("0", "1", "2", "3"), 2,
                    "Prints 0, 1, 2. When i=3 the condition is False and it exits."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Complete to add 1 to the counter:",
                    "n = 0\nwhile n < 5:\n    n ??? 1",
                    listOf("=+", "+=", "++", "=1+"), 1,
                    "+= is the addition assignment operator. Equivalent to n = n + 1.")
            )
        ),

        // ============ UNIT 3: FUNCTIONS ============

        Lesson(
            id = "py_3_1",
            language = "Python",
            unitNumber = 3,
            title = "Functions",
            theoryText = """
                Functions are blocks of reusable code.
                
                🔹 def name(parameters): defines the function
                🔹 return: returns a value
                🔹 Without return, the function implicitly returns None
                🔹 You can assign default values to parameters
            """.trimIndent(),
            codeExample = """
                def say_hello(name):
                    return f"Hello {name}"
                
                def add(a, b=10):    # defaults to b=10
                    return a + b
                
                print(say_hello("Ana"))   # Hello Ana
                print(add(5))             # 15 (uses b=10)
                print(add(5, 3))          # 8
            """.trimIndent(),
            xpReward = 30,
            exercises = listOf(
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "Which keyword defines a function?",
                    "", listOf("function", "def", "func", "lambda"), 1,
                    "In Python, functions are declared with 'def'."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Complete to return the double of x:",
                    "def double(x):\n    ??? x * 2",
                    listOf("print", "return", "def", "yield"), 1,
                    "return returns the computed value to where the function is called."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "What does it print?",
                    "def f(x=5):\n    return x * 2\nprint(f())",
                    listOf("0", "5", "10", "Error"), 2,
                    "Called without parameters, so x uses default value 5. 5*2=10."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "What does a function return if there's no return statement?",
                    "", listOf("0", "False", "None", "Error"), 2,
                    "If there is no return, Python implicitly returns None."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Call the function with arguments a=2 and b=3:",
                    "def add(a, b):\n    return a+b\nresult = ???",
                    listOf("add 2,3", "add(2,3)", "add[2,3]", "add{2,3}"), 1,
                    "Functions are called with parentheses and comma-separated arguments.")
            )
        ),

        // ============ UNIT 4: DATA STRUCTURES ============

        Lesson(
            id = "py_4_1",
            language = "Python",
            unitNumber = 4,
            title = "Lists",
            theoryText = """
                Lists store collections that are ordered and mutable (they can change).
                
                🔹 Created using [ ]
                🔹 Accessible via index (starts at 0)
                🔹 .append(x): adds to the end
                🔹 .remove(x): removes the first occurrence
                🔹 len(list): size
                🔹 Iterable with for loop
            """.trimIndent(),
            codeExample = """
                fruits = ["pear", "grape", "kiwi"]
                
                print(fruits[0])         # pear
                print(len(fruits))       # 3
                
                fruits.append("mango")
                fruits.remove("grape")
                
                print(fruits)            # ['pear', 'kiwi', 'mango']
            """.trimIndent(),
            xpReward = 30,
            exercises = listOf(
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "What does this snippet print?",
                    "list = [10, 20, 30]\nprint(list[1])",
                    listOf("10", "20", "30", "Error"), 1,
                    "Indexes start at 0. Position 0=10, 1=20, 2=30."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Add 'blue' to the end of the list:",
                    "colors = [\"red\", \"green\"]\ncolors.???(\"blue\")",
                    listOf("add", "append", "push", "insert"), 1,
                    "append() adds to the end of a list in Python."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "How do you create an empty list?",
                    "", listOf("list = ()", "list = []", "list = {}", "list = <>"), 1,
                    "Lists use brackets [ ]. () is a tuple, {} is a dict or set."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "What is printed?",
                    "nums = [5, 10, 15]\nprint(len(nums))",
                    listOf("3", "30", "5", "15"), 0,
                    "len() returns the total number of items: 3."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Access the LAST element using a negative index:",
                    "list = [1, 2, 3, 4]\nprint(list[???])",
                    listOf("0", "4", "-1", "last"), 2,
                    "Negative indices count backwards from the end. -1 is the last item.")
            )
        ),

        Lesson(
            id = "py_4_2",
            language = "Python",
            unitNumber = 4,
            title = "Dictionaries",
            theoryText = """
                Dictionaries store key→value pairs. Like a JSON object.
                
                🔹 Created using { key: value, ... }
                🔹 Accessible via dict[key]
                🔹 Assign: dict[key] = value (creates or updates)
                🔹 .keys() / .values() / .items()
                🔹 'key' in dict: checks if key exists
            """.trimIndent(),
            codeExample = """
                person = {
                    "name": "Ana",
                    "age": 25
                }
                
                print(person["name"])     # Ana
                
                person["city"] = "Madrid" # adds a new key
                person["age"] = 26        # updates existing
                
                print("name" in person)   # True
            """.trimIndent(),
            xpReward = 30,
            exercises = listOf(
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "How do you access the value of the key 'age'?",
                    "d = {\"name\":\"Ana\", \"age\":25}",
                    listOf("d.age", "d[\"age\"]", "d->age", "d(age)"), 1,
                    "In Python, access values with brackets and the key name as a string."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Add the key 'country' with value 'Italy':",
                    "d = {}\nd[???] = \"Italy\"",
                    listOf("country", "\"country\"", "<country>", "(country)"), 1,
                    "The key must be a string inside quotes."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "What is returned by 'name' in {\"name\":\"Ana\"}?",
                    "", listOf("True", "False", "Ana", "Error"), 0,
                    "The 'in' operator checks if a key exists in the dictionary."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "Which method returns exclusively the KEYS?",
                    "", listOf(".items()", ".values()", ".keys()", ".all()"), 2,
                    ".keys() returns keys, .values() returns values, .items() returns pairs."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Create an empty dictionary:",
                    "d = ???",
                    listOf("[]", "{}", "()", "<>"), 1,
                    "An empty dictionary is created using curly braces {}.")
            )
        ),

        // ============ UNIT 5: ADVANCED ============

        Lesson(
            id = "py_5_1",
            language = "Python",
            unitNumber = 5,
            title = "List Comprehensions",
            theoryText = """
                List comprehensions build lists in a single line of code.
                
                🔹 Syntax: [expression for item in iterable]
                🔹 With condition: [expr for x in list if condition]
                🔹 More readable and faster than a traditional for-loop
            """.trimIndent(),
            codeExample = """
                # Traditional way
                squares = []
                for n in range(5):
                    squares.append(n*n)
                # squares = [0,1,4,9,16]
                
                # Using list comprehension
                squares = [n*n for n in range(5)]
                
                # With a condition
                evens = [n for n in range(10) if n % 2 == 0]
                # evens = [0,2,4,6,8]
            """.trimIndent(),
            xpReward = 40,
            exercises = listOf(
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "What does [x*2 for x in range(3)] generate?",
                    "", listOf("[0,2,4]", "[2,4,6]", "[1,2,3]", "[0,1,2]"), 0,
                    "range(3) = 0,1,2. Multiply each by 2 = 0,2,4."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Create a list of squares for numbers 1 to 4:",
                    "squares = [??? for x in range(1,5)]",
                    listOf("x+x", "x*2", "x**2", "x*x*x"), 2,
                    "** is for powers. x**2 = x squared. (x*x is valid too, but this option must be chosen)"),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "What is generated by [x for x in range(5) if x > 2]?",
                    "", listOf("[0,1,2]", "[3,4]", "[2,3,4]", "[1,2,3,4]"), 1,
                    "Filters values where x > 2 from range(5)=0,1,2,3,4 → 3 and 4 remain."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "What does this yield? [s.upper() for s in [\"a\",\"b\"]]",
                    "", listOf("['A','B']", "[\"a\",\"b\"]", "AB", "Error"), 0,
                    "Converts each string to uppercase. Yields ['A','B']."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Filter out items to keep only those with length > 4:",
                    "n = [\"Ana\", \"Luis\", \"Maria\"]\nlong_names = [x for x in n ??? len(x) > 4]",
                    listOf("for", "if", "where", "while"), 1,
                    "'if' acts as a filter in a list comprehension.")
            )
        ),

        Lesson(
            id = "py_5_2",
            language = "Python",
            unitNumber = 5,
            title = "Exception Handling",
            theoryText = """
                Exceptions are errors that arise during execution.
                With try/except you can catch them and handle them smoothly.
                
                🔹 try: block that might fail
                🔹 except: what to do if it fails
                🔹 finally: executes ALWAYS (error or not)
                🔹 raise: triggers an exception manually
            """.trimIndent(),
            codeExample = """
                try:
                    x = int(input("Number: "))
                    print(10 / x)
                except ValueError:
                    print("That is not a valid number")
                except ZeroDivisionError:
                    print("Cannot divide by zero")
                finally:
                    print("End of execution")
            """.trimIndent(),
            xpReward = 40,
            exercises = listOf(
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "Which exception does 10/0 raise?",
                    "", listOf("ValueError", "TypeError", "ZeroDivisionError", "IndexError"), 2,
                    "Dividing by zero raises a ZeroDivisionError."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Catch any exception that happens inside the try block:",
                    "try:\n    x = risky()\n??? Exception as e:\n    print(e)",
                    listOf("catch", "except", "rescue", "handle"), 1,
                    "In Python, 'except' is used instead of 'catch'."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "Which block runs ALWAYS, regardless of an error occurring or not?",
                    "", listOf("try", "except", "finally", "else"), 2,
                    "'finally' always runs. It is useful for freeing up resources."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "What is printed?",
                    "try:\n    print(int('abc'))\nexcept ValueError:\n    print('bad')",
                    listOf("abc", "bad", "Error", "0"), 1,
                    "int('abc') causes a ValueError, so the except block catches it and prints 'bad'."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Raise an exception manually:",
                    "if age < 0:\n    ??? ValueError(\"Invalid age\")",
                    listOf("throw", "raise", "except", "error"), 1,
                    "'raise' is the keyword to manually trigger an exception in Python.")
            )
        )
    )
}