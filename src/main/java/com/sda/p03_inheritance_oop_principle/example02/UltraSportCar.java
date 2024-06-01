package com.sda.p03_inheritance_oop_principle.example02;

// any UltraSportCar is ALSO a SportCar
// any UltraSportCar is ALSO a Car
public class UltraSportCar extends SportCar{
    private String nitrogenType;

    public UltraSportCar(String model, String nitrogenType) {
        super(model);
        this.nitrogenType = nitrogenType;
    }

    public String getNitrogenType() {
        return nitrogenType;
    }

    @Override
    public void turnOnEngine() {
        System.out.println("invoked turnOnEngine() --> UltraSportCar class");
    }
}
