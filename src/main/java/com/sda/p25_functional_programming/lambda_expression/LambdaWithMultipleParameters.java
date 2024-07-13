package com.sda.p25_functional_programming.lambda_expression;

import com.sda.p25_functional_programming.builtin_jdk_func_interfaces.PredicateExample;

public class LambdaWithMultipleParameters {
    public static void main(String[] args) {

        StringConcatFunctionalInterface s = (str1, str2) -> {
            return str1 + str2;
        };

        // If your lambda expression is a one-liner (a method body with single line)
        // then you can skip putting curly braces,
        // and Java returns by default whatever is on the right side of Lambda token
        StringConcatFunctionalInterface s2 = (str1, str2) -> str1 + str2;


        System.out.println(s.concat("Hello ", "World"));

        /**
         * Next:
         * @see PredicateExample
         * */

    }
}

@FunctionalInterface
interface StringConcatFunctionalInterface {
    String concat(String a, String b);
}
