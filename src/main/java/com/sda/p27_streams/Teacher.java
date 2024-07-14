package com.sda.p27_streams;

public class Teacher {
    private String firstname;
    private String lastname;
    private int age;

    public Teacher(String firstname, String lastname, int age) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public int getAge() {
        return age;
    }
}
