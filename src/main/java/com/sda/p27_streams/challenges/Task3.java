package com.sda.java.p27_streams.challenges;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import org.junit.jupiter.api.Test;

public class Task3 {
    public String findTopStudent(List<Student> students) {
        String result = students.stream()
                .max(Comparator.comparing(Student::getGrade))
                .map(Student::getName)
                .orElse("No student found");
        return result;
    }

    @Test
    void testFindTopStudent() {
        Student s1 = new Student("John", 18, 85);
        Student s2 = new Student("Mary", 19, 90);
        Student s3 = new Student("Mike", 20, 80);
        Student s4 = new Student("David", 18, 95);
        List<Student> students = Arrays.asList(s1, s2, s3, s4);

        String expected = "David";
        String actual = findTopStudent(students);

        assertEquals(expected, actual);
    }

    static class Student {
        private String name;
        private int age;
        private double grade;

        public Student(String name, int age, double grade) {
            this.name = name;
            this.age = age;
            this.grade = grade;
        }

        public String getName() {
            return name;
        }

        public double getGrade() {
            return grade;
        }
    }
}


