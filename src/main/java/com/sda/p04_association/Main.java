package com.sda.p04_association;

/*
 * Association:
 * A general "uses-a" or "knows-a" relationship between two or more objects.
 * Represents the relationship between objects that can exist independently.
 * Not tied to ownership or lifecycle.
 * Can be one-way, two-way (bidirectional), one-to-one, one-to-many, many-to-one, or many-to-many.
 *
 * Example: A Teacher and Student relationship.
 * A Teacher can teach multiple Students, and a Student can be taught by multiple Teachers
 * */

public class Main {
    public static void main(String[] args) {

        Teacher teacher = new Teacher("Mr. Smith");
        Student student = new Student("Alice", teacher);

        System.out.println(student.getName() + " is trained by " + student.getTeacher().getName());
    }
}
