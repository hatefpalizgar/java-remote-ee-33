package com.sda.p25_functional_programming.method_references;

import java.util.Arrays;
import java.util.Comparator;

/**
 *
 *
 * <h1>Method reference to an instance method of an arbitrary object of a particular type </h1>
 * <code> Class::instanceMethod </code>
 */
public class Example03 {
    public static void main(String[] args) {
        String[] stringArray = {"Steve", "Rick", "Anita", "Adam", "Lucy", "Sam", "John"};

        Comparator<String> stringComparator = (str1, str2) -> str1.compareToIgnoreCase(str2);


        Arrays.sort(
                stringArray,
                stringComparator); // approach 1: using Lambda expression

        Arrays.sort(
                stringArray,
                String::compareToIgnoreCase); // approach 2: using Method Reference


        for (String str: stringArray) {  // enhanced for-loop
            System.out.println(str);
        }

        /**
         *
         * @see Example04
         *
         */
    }
}
