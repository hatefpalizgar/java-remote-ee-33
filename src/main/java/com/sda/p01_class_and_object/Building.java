package com.sda.p01_class_and_object;

public class Building {
    private String name;
    private int numberOfFloors;
    private int numberOfRooms;

    // all-args constructor
    public Building(String name, int numberOfFloors, int numberOfRooms) {
        this.name = name;
        this.numberOfFloors = numberOfFloors;
        this.numberOfRooms = numberOfRooms;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(int numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    public String toString() {
        return "Building{" +
                "name=" +
                name +
                ", numberOfFloors=" +
                numberOfFloors +
                ", numberOfRooms=" +
                numberOfRooms + "}";
    }
}
