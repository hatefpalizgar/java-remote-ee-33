package com.sda.p10_static_vs_nonstatic;

public class NonStaticEmployee {
    String name;
    int empId;
    String company;

    public NonStaticEmployee(String name, int empId, String company) {
        this.name = name;
        this.empId = empId;
        this.company = company;
    }


    public void display() {
        System.out.println("NonStaticEmployee{" +
                "name='" + name + '\'' +
                ", empId=" + empId +
                ", company='" + company + '\'' +
                '}');
    }
}
