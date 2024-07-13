package com.sda.p25_functional_programming.method_references;


/**
 *
 *
 * <h1>Method reference to a static method of a class</h1>
 * <code> Class::staticMethod </code>
 */
public class Example02 {
    public static void main(String[] args) {
        // First, let's use lambda expression
        Calculator calculator = (numA, numB) -> numA * numB;

        // Now, let's use Method Reference
        Calculator calculator2 = Multiplication::multiply; // Here we're only REFERENCING multiply() method
        int result = calculator2.calculate(11, 5); // Here we're calling multiply() method
        // on line 17: we're explicitly calling calculate() method, but thanks to METHOD REFERENCING done on line 16
        // we're implicitly calling multiply() method

        System.out.println("Product of given numbers is: " + result); // 55

        /**
         *
         * @see Example03
         */
    }
}

@FunctionalInterface
interface Calculator {
    int calculate (int a, int b);
}


class Multiplication {
    public static int multiply(int a, int b) {
        return a * b;
    }
}
