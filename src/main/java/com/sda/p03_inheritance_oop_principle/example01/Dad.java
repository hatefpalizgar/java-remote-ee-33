package com.sda.p03_inheritance_oop_principle.example01;

// Dad inherits from Person all the fields & methods of Person
// Dad is a child (subclass)
// Person is a parent (superclass)

// Dad is a Person as well?
// Yes -> every child/subclass is ALSO a parent/superclass

// Person is a Dad as well?
// No -> a parent/superclass is NOT a child/subclass
public class Dad extends Person {

    // The super keyword is used to call the constructor of the superclass
    // It's like calling the constructor of the parent class
    public Dad(String name, int age, String hairColor) {
        super(name, age, hairColor); // call the constructor of the superclass of Dad (which is Person)
    }

    // Override method play() from class Person
    // This means that the method play() in class Person is overridden
    // This is called method overriding
    // So, any instance/object created from Dad class can have its own way of playing
    @Override
    public void play() {
        System.out.println("Dad plays with his kids");
    }

    @Override
    public void eat() {
        System.out.println("Dad eats steak");
    }

    // Dad can also have his own method(s) like this
    public void work() {
        System.out.println("Dad works hard");
    }

    // All the getters and setters are inherited from class Person
    // So, we don't need to write them explicitly again as they are implicitly inherited
    // The JVM will automatically generates getters and setters for us during compilation

}
