package com.sda.p25_functional_programming.lambda_expression;

public class LambdaWithSingleParameter {
    public static void main(String[] args) {

        // You can remove the input argument type from the lambda expression
        // since Java knows the functional interface's method signature
        IncrementFunctionalInterface f = (digit) -> {
            return digit + 5;
        };

        // If your lambda takes only one parameter,
        // you can remove the parenthesis around input arg/param
        IncrementFunctionalInterface g = number -> {
          return number + 7;
        };

        System.out.println(f.increment(20)); // 25
        System.out.println(g.increment(20)); // 27

        /**
         * @see LambdaWithMultipleParameters
         * */
    }
}

@FunctionalInterface
interface IncrementFunctionalInterface {
    int increment(int num);
}
