package com.sda.p25_functional_programming;

// If an interface contains EXACTLY one ABSTRACT method
// it is called Functional Interface
// Printable here is a functional interface

// @FunctionalInterface is added so that we can mark an interface as functional

// a functional interface can contain any number of default or static method
// a functional interface can ONLY extend another interface when the parent interface does not have
// any abstract method

// We have JDK built-in func interfaces like Runnable, Callable, Comparator, ActionListener etc.

@FunctionalInterface
public interface Printable {
    void print(String message);

    static void save () {
        // static methods are allowed in functional interfaces
    }

    default void someMethod() {
        // default methods are allowed in functional interfaces
    }
}
