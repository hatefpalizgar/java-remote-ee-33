package com.sda.p06_aggregation;

public class Student {
    private String name;
    private Backpack backpack;  // each student HAS-A backpack

    // If student object is destroyed, the backpack object could still exist
    // independently.

    // This illustrates the aggregation relationship; notebooks (parts) can exist even if
    // the (whole) student is no longer present


    public Student(String name, Backpack backpack) {
        this.name = name;
        this.backpack = backpack;
    }

    public String getName() {
        return name;
    }

    public Backpack getBackpack() {
        return backpack;
    }
}
