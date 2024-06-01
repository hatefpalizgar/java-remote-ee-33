package com.sda.p01_class_and_object;

public class Main {
    public static void main(String[] args) {
        Building b1 = new Building("Akadeemia", 4, 2);
        Building b2 = new Building("MaxMilian", 5, 3);

        System.out.println("Building name: " + b1.getName()); // Akadeemia
        System.out.println("Number of floors: " + b1.getNumberOfFloors()); // 4


        b2.setNumberOfFloors(6);
        System.out.println("Number of floors for b2: " + b2.getNumberOfFloors()); // 6
    }
}
