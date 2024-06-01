package com.sda.p03_inheritance_oop_principle.example01;

public class Main {
    public static void main(String[] args) {
        Person person = new Person("somePersonName", 10, "Dark brown");
        Dad dad = new Dad("John", 45, "black");
        Boy boy = new Boy("Rob", 14, "blonde", "House on fire");

        System.out.println("=========== PERSON ===========");
        person.eat();
        person.play();
        System.out.println(person.getName());

        System.out.println("=========== DAD ===========");
        dad.eat();
        dad.play();
        System.out.println(dad.getName());
        dad.work();
        // dad.dance(); Superclass is NOT a child class

        System.out.println("=========== BOY ===========");
        boy.eat();
        boy.play();
        System.out.println(boy.getName());
        System.out.println(boy.getFavoriteMusic());
        boy.work(); // child class IS ALSO a parent class
        boy.dance();
    }
}
