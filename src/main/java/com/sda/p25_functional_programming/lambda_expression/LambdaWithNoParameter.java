package com.sda.p25_functional_programming.lambda_expression;

public class LambdaWithNoParameter {
    public static void main(String[] args) {

        // Lambda expression/function with no parameter/arg
        SayHelloFunctionalInterface hello = () -> {
           return "Hi";
        };

        System.out.println(hello.sayHello());  // Hi


        // How it was prior to Java 8 / Lambda (using Anonymous class)
        SayHelloFunctionalInterface hello2 = new SayHelloFunctionalInterface() {
            @Override
            public String sayHello() {
                return "Hi";
            }
        };

        /**
         * @see LambdaWithSingleParameter
         * */

    }
}


@FunctionalInterface
interface SayHelloFunctionalInterface {
    String sayHello();
}
