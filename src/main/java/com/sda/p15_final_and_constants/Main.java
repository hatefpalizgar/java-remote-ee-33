package com.sda.p15_final_and_constants;

public class Main {
    public static void main(String[] args) {
        /* ========================================================================================== */
        //                                   Java final Variable
        /* ========================================================================================== */
        // In Java, we cannot change the value of a final variable.
        // Once a final variable is assigned, it always contains the same value.
        // If we try to change the value of a final variable, a compile-time error is generated.

        final int x = 100;
        // x = 200; // compile time error

        /* ========================================================================================== */
        //                                    Java final Class
        /* ========================================================================================== */
        // In Java, a final class cannot be inherited/extended by another class.
        // class SubClass extends FinalClass {...} // incorrect

        /* ========================================================================================== */
        //                                    Java final Method
        /* ========================================================================================== */
        // In Java, the final method cannot be overridden by the child class.

    }
}
