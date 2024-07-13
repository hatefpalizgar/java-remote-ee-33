package com.sda.p25_functional_programming.builtin_jdk_func_interfaces;

import com.sda.p25_functional_programming.method_references.Example01;

import java.util.function.Function;

/*
 * Function represents a functional interfaces that consumes one arg and produces a result
 * Function has a method called apply()
 */

public class FunctionExample {
    public static void main(String[] args) {
        Function<String, String> stringFunction = (input) -> input.substring(5);

        String output = stringFunction.apply("This is a test Function interface in Java 8");

        System.out.println(output);

        // Function can have different types of input and output

        Function<String, Integer> characterCounter = (txt) -> txt.length();

        Integer count = characterCounter.apply("Hello World");

        System.out.println(count); // 11

        /**
         * Next: Method References
         *
         * @see Example01
         * */

    }
}
