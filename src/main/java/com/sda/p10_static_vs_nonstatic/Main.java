package com.sda.p10_static_vs_nonstatic;

/* ========================================================================================== */
//                                    Static vs Non-Static
//                  https://examples.javacodegeeks.com/static-vs-non-static-in-java/
/* ========================================================================================== */

// Static:
// Static members are called directly on the class name.
// Non-Static:
// Non-Static members are called on an instance of the class.

public class Main {
    public static void main1(String[] args) {
        NonStaticEmployee emp1 = new NonStaticEmployee("John", 1001, "SDA");
        NonStaticEmployee emp2 = new NonStaticEmployee("Adam", 1002, "SDA");
        System.out.println(emp1.name); // you can access non-static fields/methods ONLY using an instance variable/reference
        emp1.display();
        emp2.display();
    }

    public static void main2(String[] args) {
        StaticEmployee emp1 = new StaticEmployee("Mark", 1001); // static methods&fields are loaded first, then object is created
        StaticEmployee emp2 = new StaticEmployee("Maria", 1002);
        // you can access non-static fields/methods ONLY using an instance variable/reference
        // ** [non-static members belong to the OBJECT]
        System.out.println(emp1.name);

        // You should access static fields/method ONLY using a class itself
        // a static field/method is shared across all instances of a class
        // ** [static members belong to the CLASS]
        System.out.println(StaticEmployee.company);
    }

    public static void main(String[] args) {
        StaticEmployee emp1 = new StaticEmployee("Tom", 1001);
        emp1.display();

        System.out.println("The salary for " + emp1.empId + " is: " + StaticEmployee.calculateSalary(2000, 0.2));
    }
}
