package com.sda.p07_abstraction_oop_principle.abstract_class;

public class MyConcreteClass extends MyAbstractClass{

    // when extending an abstract class, Java forces us
    // to implement ALL the abstract methods

    // so you can think of an abstract method as a CONTRACT
    @Override
    public void abstractMethod() {
        System.out.println("inside abstractMethod() --> MyConcreteClass");
    }
}
