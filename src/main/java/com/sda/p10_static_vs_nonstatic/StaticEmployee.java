package com.sda.p10_static_vs_nonstatic;

public class StaticEmployee {
    static String company = "SDA"; // static field is loaded into memory before object creation
    String name;
    int empId;

    // This custom context/block is initialization block; which mean it runs during class loading time
    {
        System.out.println("custom context/scope/block executed");
        System.out.println("from within initialization block: " + company); // correct we can access
        System.out.println("from within initialization block: " + name);
        display(); // deferred/delayed until object is created
    }

    static {
        System.out.println("custom context/scope/block executed");
        System.out.println("from within initialization block: " + company); // correct we can access
        // System.out.println("from within initialization block: " + name);
        // display();
    }

    public StaticEmployee(String name, int empId) {
        this.name = name;
        this.empId = empId;
    }

    // static method is loaded into memory before object creation
    public static double calculateSalary(double basic, double taxRate) {
        // System.out.println(empId); // ** incorrect: [Non-static field 'empId' cannot be referenced from a static context]
        return basic * (1 - taxRate);
    }

    public void display() {
        System.out.println(company); // ** correct: [static members can be referenced from a non-static context]
        System.out.println("StaticEmployee{" +
                "name='" + name + '\'' +
                ", empId='" + empId + '\'' +
                '}');
    }
}
