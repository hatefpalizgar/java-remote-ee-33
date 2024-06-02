package com.sda.p07_abstraction_oop_principle.abstract_class;

public class Main {
    public static void main(String[] args) {

        // We can NOT instantiate an abstract class
        // MyAbstractClass aClass = new MyAbstractClass();
        MyConcreteClass aClass = new MyConcreteClass();
        aClass.abstractMethod(); // inside abstractMethod() --> MyConcreteClass
        aClass.concreteMethod(); // inside concreteMethod() of MyAbstractClass




    }
}
