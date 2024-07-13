package com.sda.p25_functional_programming.builtin_jdk_func_interfaces;

import java.util.function.Predicate;

public class PredicateExample {
    public static void main(String[] args) {
        Checker<String> checker = (message) -> message.contains("Java");

       boolean isAJavaDeveloper = checker.check("John is a Java developer");

        System.out.println(isAJavaDeveloper); // true

        Checker<Person> lab = (person) -> person.getAge() > 30;

        Person john = new Person("John", 24);

        boolean result = lab.check(john);

        System.out.println(result); // false

        // JDK built-in Predicate
        Predicate<Person> pr = (person) -> person.getName().contains("h");

        result = pr.test(john); // john contains "h"
        System.out.println(result); // true

        /**
         * Next:
         * @see ConsumerExample
         * */

    }
}


@FunctionalInterface
interface Checker<T> {
    boolean check(T input);
}
