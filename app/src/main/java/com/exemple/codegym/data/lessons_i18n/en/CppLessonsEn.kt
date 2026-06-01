package com.exemple.codegym.data.lessons_i18n.en

import com.exemple.codegym.models.ExerciseType
import com.exemple.codegym.models.Lesson
import com.exemple.codegym.models.LessonExercise

object CppLessonsEn {

    val lessons: List<Lesson> = listOf(

        // ============ UNIT 1: BASIC C++ ============

        Lesson(
            id = "cpp_1_1",
            language = "C++",
            unitNumber = 1,
            title = "Hello world and cout",
            theoryText = """
                In C++ you print to the screen using cout (pronounced "see-out") from the std namespace.
                
                🔹 std::cout is the standard output stream
                🔹 << inserts values into the stream
                🔹 std::endl or "\n" adds a line break
                🔹 #include <iostream> is required
                🔹 Every statement ends with ;
            """.trimIndent(),
            codeExample = """
                #include <iostream>
                using namespace std;
                
                int main() {
                    cout << "Hello world" << endl;
                    cout << "Age: " << 25 << endl;
                    return 0;
                }
            """.trimIndent(),
            xpReward = 25,
            exercises = listOf(
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "What is the proper way to print in C++?",
                    "", listOf("print(\"hello\")", "cout << \"hello\";", "echo \"hello\";", "println(\"hello\");"), 1,
                    "In C++, cout is used along with the << operator to print."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Complete the needed include to use cout:",
                    "#include <???>",
                    listOf("stdio", "iostream", "string", "stdlib"),
                    1, "iostream provides cout, cin, endl and other I/O streams."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "What does endl do?",
                    "", listOf("Ends the program", "Adds a line break", "Clears the screen", "Pauses"), 1,
                    "endl inserts a newline (equivalent to \"\\n\")."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "Which function is the main entry point of a C++ program?",
                    "", listOf("start()", "main()", "begin()", "init()"), 1,
                    "main() is the mandatory starting function of any execution."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Print 5 using cout:",
                    "cout ??? 5 << endl;",
                    listOf(">>", "<<", "->", "."), 1,
                    "The << operator inserts values into the output stream.")
            )
        ),

        Lesson(
            id = "cpp_1_2",
            language = "C++",
            unitNumber = 1,
            title = "Variables and types",
            theoryText = """
                C++ is strongly typed: every variable's type must be declared.
                
                🔹 int: integer
                🔹 double / float: decimal numbers
                🔹 char: a single character (in single quotes)
                🔹 bool: true/false
                🔹 string: text string (requires #include <string>)
                🔹 const: makes a variable immutable
            """.trimIndent(),
            codeExample = """
                #include <string>
                
                int age = 25;
                double height = 1.65;
                char initial = 'A';
                bool isStudent = true;
                std::string name = "Ana";
                const double PI = 3.14159;
                
                // PI = 3.14;  // ❌ ERROR: const cannot be modified
            """.trimIndent(),
            xpReward = 25,
            exercises = listOf(
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "Which type should you use to store 'A'?",
                    "", listOf("string", "char", "int", "byte"), 1,
                    "char stores a SINGLE character. Uses single quotes ' '."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Declare a PI constant:",
                    "??? double PI = 3.14;",
                    listOf("var", "const", "final", "static"), 1,
                    "const makes a variable immutable in C++."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "What is missing on this line?\nint x = 5",
                    "", listOf("Brace }", "Semicolon ;", "Comma ,", "Nothing"), 1,
                    "In C++ every statement ends with a semicolon."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "Which is the CORRECT type for 1.5?",
                    "", listOf("int", "char", "double", "string"), 2,
                    "double stores decimal numbers with double precision."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Declare a bool variable initialized to false:",
                    "??? active = false;",
                    listOf("boolean", "bool", "Boolean", "logic"), 1,
                    "In C++ the type is named bool, not boolean.")
            )
        ),

        Lesson(
            id = "cpp_1_3",
            language = "C++",
            unitNumber = 1,
            title = "cin (keyboard input)",
            theoryText = """
                cin reads user input from the keyboard.
                
                🔹 cin >> variable: reads and stores in the variable
                🔹 Can be chained: cin >> x >> y;
                🔹 cin only reads up to the first space
                🔹 To read a full line: getline(cin, str)
            """.trimIndent(),
            codeExample = """
                #include <iostream>
                #include <string>
                using namespace std;
                
                int main() {
                    int age;
                    string name;
                    
                    cout << "Age: ";
                    cin >> age;
                    
                    cout << "Name: ";
                    cin.ignore();
                    getline(cin, name);
                    
                    cout << "Hello " << name << endl;
                }
            """.trimIndent(),
            xpReward = 25,
            exercises = listOf(
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "How do you READ input in C++?",
                    "", listOf("cout >>", "cin >>", "input()", "read()"), 1,
                    "cin (with operator >>) reads from keyboard."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Read an integer from the keyboard:",
                    "int n;\ncin ??? n;",
                    listOf("<<", ">>", "->", "."), 1,
                    "The operator >> extracts from the input stream to the variable."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "Which function reads a FULL LINE with spaces?",
                    "", listOf("cin", "scanf", "getline", "fgets"), 2,
                    "getline(cin, str) reads until a newline is found."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "If you ask for an int with cin and user types 'abc', what happens?",
                    "", listOf("Compiles and saves 0", "Stream enters error state", "Program crashes", "Converts the string"), 1,
                    "cin enters a fail state. The variable gets an indeterminate value."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Read two chained integers:",
                    "int a, b;\ncin ??? a ??? b;",
                    listOf(">>, <<", ">>, >>", "<<, <<", "->, ->"), 1,
                    "Multiple >> can be chained together.")
            )
        ),

        // ============ UNIT 2: CONTROL FLOW ============

        Lesson(
            id = "cpp_2_1",
            language = "C++",
            unitNumber = 2,
            title = "if and switch",
            theoryText = """
                Conditionals in C++ are similar to Java and C.
                
                🔹 if (condition) { ... }
                🔹 else if / else
                🔹 switch (variable) { case x: ... break; default: ... }
                🔹 Ternary operator: cond ? yes : no
                🔹 IMPORTANT: switch requires break or it falls through
            """.trimIndent(),
            codeExample = """
                int day = 3;
                
                if (day == 1) {
                    cout << "Monday";
                } else if (day == 3) {
                    cout << "Wednesday";
                } else {
                    cout << "Other";
                }
                
                switch (day) {
                    case 1: cout << "Mon"; break;
                    case 3: cout << "Wed"; break;
                    default: cout << "?"; break;
                }
            """.trimIndent(),
            xpReward = 30,
            exercises = listOf(
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "What happens in a switch if 'break' is forgotten?",
                    "", listOf("Compiler error", "Switch fails", "Keeps executing the next case (fall-through)", "Ends program"), 2,
                    "If there is no break, execution continues to the following cases (fall-through)."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Complete the generic case of a switch:",
                    "switch (x) {\n    case 1: break;\n    ???: cout << \"Other\";\n}",
                    listOf("else", "default", "other", "all"), 1,
                    "default acts like 'else' in an if-else structure inside a switch."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "What does the following ternary operator evaluation return?\nint max = (10 > 5) ? 10 : 5;",
                    "", listOf("10", "5", "10:5", "Error"), 0,
                    "10 > 5 is true, so it returns the first value (10)."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Check if age is greater or equal to 18:",
                    "??? (age >= 18) { cout << \"Adult\"; }",
                    listOf("if", "when", "switch", "case"), 0,
                    "if is the standard word for evaluation.")
            )
        ),

        Lesson(
            id = "cpp_2_2",
            language = "C++",
            unitNumber = 2,
            title = "Loops",
            theoryText = """
                C++ provides for, while and do-while loops. Can also use range-based for in C++11+.
                
                🔹 for(init; cond; step) { ... }
                🔹 while(cond) { ... }
                🔹 do { ... } while(cond); -> note the ; at the end!
                🔹 Range for: for (int x : collection)
            """.trimIndent(),
            codeExample = """
                for (int i = 0; i < 3; i++) {
                    cout << i;
                } // 012
                
                int c = 0;
                while (c < 2) {
                    cout << c++;
                } // 01
                
                int arr[] = {10, 20};
                for (int val : arr) {
                    cout << val;
                } // 1020
            """.trimIndent(),
            xpReward = 30,
            exercises = listOf(
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "Which loop executes AT LEAST ONCE?",
                    "", listOf("for", "while", "do-while", "None"), 2,
                    "do-while executes the block before checking the condition."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Complete the range-based loop over the array:",
                    "int xs[] = {1,2};\nfor (int x ??? xs) { }",
                    listOf("in", "of", ":", "->"), 2,
                    "C++11 added range-based loops using a colon (:)."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "What happens if there's no condition in a for loop? for(;;)",
                    "", listOf("Compiler error", "Infinite loop", "Runs once", "Is ignored"), 1,
                    "If you leave condition empty, it is considered true -> infinite loop.")
            )
        ),

        // ============ UNIT 3: FUNCTIONS AND POINTERS ============

        Lesson(
            id = "cpp_3_1",
            language = "C++",
            unitNumber = 3,
            title = "Functions and References",
            theoryText = """
                Functions must be declared before they are used (or put prototypes at the top).
                
                🔹 returnType name(parameters)
                🔹 Pass by value: copies the variable (modifying param does not change original)
                🔹 Pass by reference: passes a reference using & (modifying changes original)
            """.trimIndent(),
            codeExample = """
                // Pass by value
                void sum1(int x) { x++; }
                
                // Pass by reference
                void sum2(int &x) { x++; }
                
                int a = 5;
                sum1(a); // a is still 5
                
                int b = 5;
                sum2(b); // b becomes 6!
            """.trimIndent(),
            xpReward = 35,
            exercises = listOf(
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "What symbol is used to pass by reference?",
                    "", listOf("*", "&", "&&", "->"), 1,
                    "& in parameters implies a reference. Modifying it modifies the original."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Pass x by reference so it can be modified:",
                    "void doubleIt(int ???x) { x = x*2; }",
                    listOf("*", "&", "$", "ref"), 1,
                    "& establishes pass by reference."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "What happens if I call func() before declaring it?",
                    "", listOf("Compiles fine", "Compiler error: func not declared", "Warns", "Creates dynamic func"), 1,
                    "In C++, the compiler must see the declaration/prototype before use.")
            )
        ),

        Lesson(
            id = "cpp_3_2",
            language = "C++",
            unitNumber = 3,
            title = "Pointers",
            theoryText = """
                A pointer is a variable that stores a MEMORY ADDRESS of another variable.
                
                🔹 type* ptr: declares a pointer
                🔹 &var: gets memory address of a variable
                🔹 *ptr: dereferences -> gets the value located at address
                🔹 nullptr: represents a safe null pointer (C++11)
            """.trimIndent(),
            codeExample = """
                int x = 10;
                int* p = &x;  // p points to x memory address
                
                cout << p;    // Prints memory address (e.g. 0x00A1)
                cout << *p;   // Prints value (10)
                
                *p = 20;      // Modifies value through pointer
                cout << x;    // 20
            """.trimIndent(),
            xpReward = 40,
            exercises = listOf(
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "What does the operator '&' do when put before a variable?",
                    "", listOf("And logical", "And bitwise", "Returns memory address", "Creates a pointer"), 2,
                    "& gets the physical memory address of the variable."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Get the VALUE pointed by 'p':",
                    "int v = ???p;",
                    listOf("&", "*", "->", "."), 1,
                    "Asterisk * dereferences the pointer, giving access to the target value."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "What is nullptr?",
                    "", listOf("Zero", "A safe null pointer", "An exception", "False"), 1,
                    "nullptr (C++11) is the SAFE way in C++ to represent an empty pointer. Replaces old NULL."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "Which one correctly declares an int pointer?",
                    "", listOf("int p*", "int* p", "ptr<int> p", "*int p"), 1,
                    "int* p or int *p (space is optional). The asterisk is attached to the type or variable name."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Modify x to 20 through pointer p:",
                    "int x = 5;\nint* p = &x;\n???p = 20;",
                    listOf("&", "*", "->", "."), 1,
                    "*p accesses the stored targeted value. *p = 20 modifies x.")
            )
        ),

        // ============ UNIT 4: OOP ============

        Lesson(
            id = "cpp_4_1",
            language = "C++",
            unitNumber = 4,
            title = "Classes and Objects",
            theoryText = """
                Classes in C++ consist of public and private sections.
                
                🔹 class Name { ... };  ⚠️ ends with ;
                🔹 public: / private: label the sections
                🔹 Constructor: same name as class
                🔹 Destructor: ~Class()
                🔹 Member access: . (object) or -> (pointer)
            """.trimIndent(),
            codeExample = """
                class Person {
                private:
                    string name;
                    int age;
                
                public:
                    // Constructor
                    Person(string n, int a) {
                        name = n;
                        age = a;
                    }
                    
                    void sayHi() {
                        cout << "Hello, I'm " << name;
                    }
                };
                
                Person p("Ana", 25);
                p.sayHi();
            """.trimIndent(),
            xpReward = 40,
            exercises = listOf(
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "With what character does a class declaration END in C++?",
                    "", listOf("Brace }", "Semicolon ;", "Comma ,", "Nothing"), 1,
                    "Classes in C++ end with }; (brace + semicolon). It's a common error to forget it."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Make an attribute completely restricted from outside access:",
                    "class A {\n    ???: int val;\n};",
                    listOf("public", "private", "protected", "hidden"), 1,
                    "private limits the access exclusively to the class itself."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "What's the name of the special method that builds the object?",
                    "", listOf("init()", "create()", "Constructor (same name as class)", "main()"), 2,
                    "Constructor has the same name as the class; it is invoked upon instantiation."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "To access members from a POINTER you use?",
                    "", listOf(".", "::", "->", "&"), 2,
                    "-> is for pointers. . is for direct objects. p->method() is equivalent to (*p).method()."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Define the destructor of class Person:",
                    "class Person {\npublic:\n    ???Person() { /* cleanup */ }\n};",
                    listOf("!", "~", "-", "del"), 1,
                    "Destructors carry a ~ before the name. Triggered when object is destroyed.")
            )
        ),

        // ============ UNIT 5: ADVANCED ============

        Lesson(
            id = "cpp_5_1",
            language = "C++",
            unitNumber = 5,
            title = "Vectors (STL)",
            theoryText = """
                vector is a dynamic array from the STL (Standard Template Library).
                
                🔹 #include <vector>
                🔹 vector<Type> v; declaration
                🔹 .push_back(x): adds to the end
                🔹 .pop_back(): deletes last element
                🔹 .size(): size
                🔹 v[i] or v.at(i): get via index (.at throws exception if out of range)
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
                
                nums.pop_back();        // eliminates 30
                
                for (int n : nums) cout << n;
            """.trimIndent(),
            xpReward = 45,
            exercises = listOf(
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "Which method ADDS to the end of a vector?",
                    "", listOf("add()", "push_back()", "append()", "insert()"), 1,
                    "push_back() places an element at the end of the vector."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Declare a vector of strings:",
                    "vector<???> names;",
                    listOf("string", "char", "String", "char*"), 0,
                    "vector<string> is the required syntax. Don't forget #include <string>."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "What does v.size() return?",
                    "", listOf("The capacity", "The number of elements", "The first element", "Allocated Bytes"), 1,
                    ".size() returns the amount of elements inside the vector at the current time."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "Difference between v[5] and v.at(5)?",
                    "", listOf(
                        "None",
                        ".at() throws exception if out of range, [] doesn't",
                        "[] is slower",
                        ".at() is readonly"
                    ), 1,
                    ".at() provides safety: launches out_of_range. [] does not verify bounds."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Remove the last element of a vector:",
                    "v.???();",
                    listOf("pop", "pop_back", "remove_last", "erase_end"), 1,
                    "pop_back() removes the last element and decreases vector size.")
            )
        ),

        Lesson(
            id = "cpp_5_2",
            language = "C++",
            unitNumber = 5,
            title = "Smart Pointers",
            theoryText = """
                Smart pointers handle memory automatically, preventing memory leaks.
                
                🔹 #include <memory>
                🔹 unique_ptr: single owner, destroyed automatically
                🔹 shared_ptr: multiple can share, destroyed alongside last owner
                🔹 weak_ptr: weak reference, doesn't increase ref counter
                🔹 make_unique<T>() / make_shared<T>(): recommended ways to construct
            """.trimIndent(),
            codeExample = """
                #include <memory>
                using namespace std;
                
                // unique_ptr (C++14)
                auto p = make_unique<int>(42);
                cout << *p;   // 42
                // No delete required, frees by itself
                
                // shared_ptr
                auto sp = make_shared<string>("Hi");
                auto sp2 = sp;   // now both point; counter = 2
                // Freed when no references are left
            """.trimIndent(),
            xpReward = 50,
            exercises = listOf(
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "What's the main benefit of smart pointers?",
                    "", listOf("They're faster", "Handle memory automatically, preventing memory leaks", "Require less data", "They are mandatory"), 1,
                    "Their massive advantage: they release internal memory automatically when no longer needed."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Create a unique_ptr to an int with a value of 100:",
                    "auto p = ???<int>(100);",
                    listOf("new_unique", "make_unique", "create_unique", "unique"), 1,
                    "make_unique<T>(args) is the secure and widely recommended way."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "How many unique_ptr can hold the same object reference?",
                    "", listOf("0", "1 (it is unique)", "2", "Unlimited"), 1,
                    "unique_ptr exercises single, exclusive ownership. Only 1 controls it."),
                LessonExercise(ExerciseType.MULTIPLE_CHOICE,
                    "When does a shared_ptr release memory?",
                    "", listOf("Instantly", "When counter reaches 0 (no more references)", "Manually via delete", "Never"), 1,
                    "shared_ptr uses an internal reference counter. It deallocates when 0 owners remain."),
                LessonExercise(ExerciseType.FILL_BLANK,
                    "Declare a shared_ptr via make_shared:",
                    "auto sp = ???<string>(\"Hello\");",
                    listOf("make_unique", "make_shared", "make_weak", "make_ptr"), 1,
                    "make_shared<T>() accurately spawns a shared_ptr with minimized performance overhead.")
            )
        )
    )
}