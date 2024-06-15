package com.sda.p18_collections.exercise;

public class Friend extends Person {

    public Friend(String firstname, String lastname, int age) {
        super(firstname, lastname, age);
    }


    @Override
    public String toString() {
        return "Friend{" +
                "firstname='" + this.getFirstname() + '\'' +
                ", lastname='" + this.getLastname() + '\'' +
                ", age=" + this.getAge() +
                '}';
    }
}
