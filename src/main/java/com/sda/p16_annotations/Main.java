package com.sda.p16_annotations;

import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) {
        Student student = new Student("John", "Smith", 23);

        // FQN (Fully Qualified Name) of Student class: com.sda.p16_annotations.Student
        System.out.println(student);

        student.methodWithAnnotation(4);

        //  Reflection API in Java (reverse-engineering)
        Class studentClass = student.getClass();
        Method[] methods = studentClass.getMethods();

        for (Method m : methods) {
            if (m.isAnnotationPresent(MyCustomAnnotation.class)) {
                MyCustomAnnotation annotation = m.getAnnotation(MyCustomAnnotation.class);
                System.out.println(annotation.month()); // JANUARY
                System.out.println(annotation.dates()[0]); // 2024
                System.out.println(annotation.value()[1]); // second value
            }
        }


        // Now, let's process @Deprecated and print out any method name annotated with it to the console
        for (Method m : methods) {
            if (m.isAnnotationPresent(Deprecated.class)) {
                System.out.println("Method " + m.getName() + " is deprecated");
            }
        }


    }
}
