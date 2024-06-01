package com.sda.p03_inheritance_oop_principle.example01;

public class Person {
    private String name;
    private int age;
    private String hairColor;

    public Person(String name, int age, String hairColor) {
        this.name = name;
        this.age = age;
        this.hairColor = hairColor;
    }

    // Here play() is a method/function/behaviour of Person class
    // It is used to tell a person object/instance to play a game
    public void play(){
        System.out.println("I am playing");
    }

    // eat() is another method used to tell a person to eat
    public void eat() {
        System.out.println("I am eating");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getHairColor() {
        return hairColor;
    }

    public void setHairColor(String hairColor) {
        this.hairColor = hairColor;
    }
}
