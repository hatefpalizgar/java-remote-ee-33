package com.sda.p03_inheritance_oop_principle.example02;

public class SportCar extends Car{

    public SportCar(String model) {
        super(model);
    }

    public void boostSpeed() {
        System.out.println("invoked boostSpeed() --> SportCar class");
    }

    @Override
    public void turnOnEngine() {
        System.out.println("invoked turnOnEngine() --> SportCar class");
    }
}
