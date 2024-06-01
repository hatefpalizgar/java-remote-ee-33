package com.sda.p03_inheritance_oop_principle.example02;

public class Main {
    public static void main(String[] args) {
        Car aCar = new Car("Ford");
        System.out.println(aCar.getModel()); // Ford
        aCar.turnOnEngine(); // invoked turnOnEngine() --> Car class
        ignite(aCar); // invoked turnOnEngine() --> Car class

        SportCar aSportCar = new SportCar("Toyota");
        System.out.println(aSportCar.getModel());

        aSportCar.boostSpeed(); // invoked boostSpeed() --> SportCar class
        aSportCar.turnOnEngine(); // invoked turnOnEngine() --> SportCar class
        ignite(aSportCar); // invoked turnOnEngine() --> SportCar class

        // Since "any SportCar is also a Car",
        // We can do something like below:
        Car bSportCar = new SportCar("Subaru");

        // but below is incorrect (not compile)
        // "any Car is NOT a SportCar"
        // SportCar bSportCar = new Car("Subaru");

        Car aUltraSportCar = new UltraSportCar("Buggati", "Nitro-123");
        ignite(aUltraSportCar); // invoked turnOnEngine() --> UltraSportCar class

    }

    // the exact type of this Car will be resolved at runtime
    public static void ignite(Car car) {
        car.turnOnEngine();
    }

    // Poly-morphism (poly: multi, morph: shape)

//    public static void ignite(SportCar car) {
//        car.turnOnEngine();
//    }
//
//    public static void ignite(UltraSportCar car) {
//        car.turnOnEngine();
//    }
}
