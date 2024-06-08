package com.sda.p14_exceptions;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main1(String[] args) {
        int[] arr = {1, 2, 3, 4, 5}; // max index: 4
        System.out.println(arr[7]); // throws ArrayIndexOutOfBoundsException

        System.out.println("This line never gets executed");
    }

    public static void main2(String[] args) {
        int a = 10;
        int b = 0;

        // try-catch block (exception handler)
        try {
            System.out.println(a / b); // throws ArithmeticException: / by zero
            System.out.println("this line never gets executed");
        } catch (ArithmeticException e) {
            System.out.println("exception caught: " + e); // java.lang.ArithmeticException: / by zero
        }

        System.out.println("This line should be executed");
    }

    /* ========================================================================================== */
    //                                  Exception Hierarchy
    /* ========================================================================================== */

    // https://rollbar.com/blog/java-exceptions-hierarchy-explained/
    // https://facingissuesonit.com/java-exception-handling/

    /* ========================================================================================== */
    //                            Checked vs. Unchecked Exceptions
    /* ========================================================================================== */
    // Checked(compile-time) and unchecked(runtime) exceptions
    // a. Checked exceptions are checked at compile time.
    //  Classes that directly inherit Throwable except RuntimeException and Error e.g. IOException,
    //  InterruptedException
    // b. Unchecked exceptions are not checked at compile time. Classes that inherit
    //   RuntimeException are unchecked exceptions like ArithmeticException, NullPointerException, etc.


    /* ========================================================================================== */
    //                       Handling multiple exceptions using Pipe operator
    /* ========================================================================================== */

    public static void main3(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        try {
            System.out.println(arr[7]);
        } catch (ArrayIndexOutOfBoundsException | NullPointerException e) {
            System.out.println("Exception caught: " + e);
        }
    }

    /* ========================================================================================== */
    //                    Handling multiple exceptions using multiple catch blocks
    /* ========================================================================================== */

    // using pipe operator you're forced to catch all exceptions the same way
    // but with multiple catch-blocks you have more fine-grained control over
    // handling each type of exception
    public static void main4(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        try {
            int result = 10 / 0;  // throws ArithmeticException
            System.out.println(arr[7]);  // will never execute, or throw ArrayIndexOutOfBoundsException
            System.out.println("This line never executes");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBoundsException caught: " + e);
        } catch (ArithmeticException e) {
            System.out.println("ArithmeticException caught: " + e.getMessage() + ":::" + e.getCause());
        } catch (RuntimeException e) {
            System.out.println("RuntimeException caught: " + e);
        } catch (Exception e) {
            System.out.println("Exception caught: " + e.getMessage() + ":::" + e.getCause());
        } catch (Throwable e) {
            System.out.println("Throwable caught: " + e);
        }


        System.out.println("This will execute!");
    }


    public static void main5(String[] args) {
        try {
            someMethod(false);
        } catch (IllegalAccessException e) {
            e.printStackTrace(); // Bad practice, try to avoid print console or printStackTrace, instead use Logging
        }
    }


    public static void someMethod(boolean isTurnedOn) throws IllegalAccessException {
        if (isTurnedOn) {
            System.out.println("Washing machine is turned on");
        } else {
            System.out.println("Washing machine is turned off");
            throw new IllegalAccessException("A turned off machine can't be tested");
        }
    }

    /* ========================================================================================== */
    //                                    Finally Block
    /* ========================================================================================== */

    public static void main6(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        try {
            System.out.println(arr[7]);  // will never execute, or throw ArrayIndexOutOfBoundsException
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        } finally { // finally block runs no matter the exception/crash
            System.out.println("I want this line to always run, no matter exceptions occurs or not, even with crash");
        }

        System.out.println("This never prints anything");
    }

    /* ========================================================================================== */
    //                                    Try with resources
    /* ========================================================================================== */
    public static void main7(String[] args) {
//        FileReader reader = null;
//        try {
//            reader = new FileReader("src/com/sda/Main.java");
//            int c;
//            while((c = reader.read()) != -1){
//                System.out.print((char)c);
//            }
//        } catch (IOException e) {
//            System.out.println(e);
//        } finally {
//            try {
//                reader.close();
//            } catch (IOException e) {
//                System.out.println(e);
//            }
//        }

        // try-with-resources (resource = any object with close() method)
        // This will automatically close the resource for you
        try (FileReader reader = new FileReader("src/com/sda/Main.java")) {
            int c;
            while ((c = reader.read()) != -1) {
                System.out.print((char) c);
            }
        } catch (IOException e) {
            System.out.println(e);
        }

    }

    /* ========================================================================================== */
    //                                    Custom Exceptions
    /* ========================================================================================== */
    public static void main(String[] args) {
        try {
            aMethodThatThrowsCustomException();
        } catch (PasswordNotFoundException e) {
            System.out.println(e);
        }
    }


    public static void aMethodThatThrowsCustomException() throws PasswordNotFoundException {
        throw new PasswordNotFoundException("Password is invalid!");
    }

}
