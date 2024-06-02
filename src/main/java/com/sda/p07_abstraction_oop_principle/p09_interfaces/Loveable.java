package com.sda.p07_abstraction_oop_principle.p09_interfaces;

// interface is a contract
public interface Loveable {
    // you can not have instance fields
    // String name;

    // you can have static fields (fields in Interface is static by default)
    String name = "HJSLDJF";

    void love(); // abstract

    // you can have static methods
    static int getAge() {
        return 0;
    }

    // From Java 8+, it is also possible to have concrete methods in Java
    // BUT, you have to define them as 'default'
    default void someMethod() {  // concrete
        //...
    }

    // Interfaces were primarily designed to ONLY have abstract methods

}
