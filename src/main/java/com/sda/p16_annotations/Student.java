package com.sda.p16_annotations;

import java.time.Month;

public class Student {

    private String firstname;
    private String lastname;
    private int age;

    public Student(String firstname, String lastname, int age) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", age=" + age +
                '}';
    }

    @Deprecated
    @MyCustomAnnotation(
            value = {"first value", "second value"},
            dates = {"2024", "2023"}
    )
    public void methodWithAnnotation(@Deprecated int number) {
        System.out.println("inside annotated method");
    }

}
