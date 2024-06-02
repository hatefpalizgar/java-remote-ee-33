package com.sda.p07_abstraction_oop_principle.abstract_class;

/*
 * Abstract class in Java:
 * 1. should be declared using `abstract` keyword
 * 2. can have 0 or more abstract methods
 * 3. can have 0 or more concrete methods
 * 4. can have fields
 */

public abstract class MyAbstractClass {
    private String name;

    public abstract void abstractMethod();  // WHAT

    public void concreteMethod() { // HOW
        System.out.println("inside concreteMethod() of MyAbstractClass");
    }
}
