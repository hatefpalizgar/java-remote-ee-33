package com.sda.p03_inheritance_oop_principle.example02;

public class Car {
    private String model;

    public Car(String model) {
        this.model = model;
    }

    public void turnOnEngine() {
        System.out.println("invoked turnOnEngine() --> Car class");
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                '}';
    }
}
