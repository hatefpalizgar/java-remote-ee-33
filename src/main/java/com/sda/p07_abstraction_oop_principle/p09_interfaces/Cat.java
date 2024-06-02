package com.sda.p07_abstraction_oop_principle.p09_interfaces;

// you implement an interface
// you extend an abstract class

// 'extends' keyword ALWAYS comes before 'implements' keyword
public class Cat extends Animal implements Loveable{
    private String color;

    public Cat(int age, String color) {
        super(age);
        this.color = color;
    }

    @Override
    public void love() {
        System.out.println("showing love to a cat");
    }
}
