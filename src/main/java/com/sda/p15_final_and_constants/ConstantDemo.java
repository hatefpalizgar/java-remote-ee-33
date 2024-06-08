package com.sda.p15_final_and_constants;

/**
 * The {@code ConstantsDemo} class demonstrates the use of constants in Java. Constants in Java are
 * variables whose values cannot be changed once they are initialized, typically declared with the
 * {@code final} keyword. Constants are useful for defining values that remain constant throughout
 * the execution of a program.
 *
 * <p>Constants are particularly useful for storing configuration values such as database URLs,
 * maximum number of login attempts, or any other fixed values that should not be altered during the
 * execution of the program. They enhance the readability, maintainability, and safety of the code.
 *
 * <p>Key Points:
 *
 * <ul>
 *   <li>Constants are declared with the {@code final} keyword and must be initialized at the time
 *       of declaration.
 *   <li>Constants are usually named in uppercase letters, with underscores to separate words.
 *   <li>Once assigned, the value of a constant cannot be changed.
 *   <li>Constants can be local to a method or part of a class (using {@code static}).
 *   <li>They are used to prevent accidental modification of critical values and facilitate code
 *       reuse.
 * </ul>
 */

public class ConstantDemo {

    // Declaring a constant (static + final)
    // convention for naming constants: ALL UPPERCASE LETTERS + UNDERLINE
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final int MAX_LOGIN_ATTEMPTS = 3;


    // Best practice: avoid writing "magic numbers", replace them with variables

    public static void main(String[] args) {
        System.out.println("Connecting to database: " + DB_URL);

        for (int i = 1; i <= MAX_LOGIN_ATTEMPTS; i++) {
            System.out.println("Attempt " + i + " of " + MAX_LOGIN_ATTEMPTS);
            // logic for login attempt goes here...
        }

        System.out.println("Unable to connect to database at: " + DB_URL);
    }
}
