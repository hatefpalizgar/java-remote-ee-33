package com.sda.p25_functional_programming;

// Programming paradigms:
// 1. Object Oriented Programming (Objects are first-class citizens)
// TODO: 2. Declarative programming (what needs to be done)
// TODO: 3. Imperative programming (how needs to be done)
// 4. Functional Programming (Functions are first-class citizens)

import com.sda.p25_functional_programming.lambda_expression.LambdaWithNoParameter;

public class Main {
    public static void main(String[] args) {

//        Printable printable = new Printable() {
//            @Override
//            public void print(String message) {
//                System.out.println(message);
//            }
//        };

        // Lambda token: ->
        // Left side of token: list of all input arguments to the method
        // Right side of token: the body of the method

        // You can write Lambda expression ONLY for functional interfaces
        Printable printable = (String text) -> {
            System.out.println(text);
        };

        printable.print("Hello World");

        /**
        * @see LambdaWithNoParameter
        * */
    }
}
