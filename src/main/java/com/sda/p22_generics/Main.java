package com.sda.p22_generics;

/*
 * ==============================================================================================
 *                                      Generics
 * ==============================================================================================
 *
 * Generics are a way to create reusable code that can be used with different types.
 * A generic type is a generic class or interface that is parameterized over types.
 *
 * There is a CONVENTION that the parameterized type name is a single uppercase letter.
 * Also, there is a convention specifying which letter should be used:
 *  E, T - element type
 *  K - key type
 *  V - value type
 *  T - type
 *  N - number type
 *  S, U, V if there are more parameterized types
 *
 * Look at List and Map interfaces in Java documentation
 */

public class Main {
    public static void main(String[] args) {
        Car car = new Car();
        ElectricCar electricCar = new ElectricCar();
        // Every object of type subclass is definitely an object of type superclass
        // Objects of type superclass ARE NOT an object of type subclass

        //Box box = new Box(electricCar);   // Box can only accept ElectricCar object or subclasses of ElectricCar
        //Box anotherBox = new Box(car); // Box can not accept Car object

        VehicleBox box = new VehicleBox(electricCar); // VehicleBox can take any subclass/implementation of Vehicle
        VehicleBox anotherBox = new VehicleBox(car);

        GenericBox<Car> gb = new GenericBox<>(car);
        GenericBox<ElectricCar> gb1 = new GenericBox<>(electricCar);


        Garage<Car> garage = new Garage<>(new Car());
        Garage<ElectricCar> garage2 = new Garage<>(new ElectricCar());

        // Garage<Plane> planeGarage = new Garage<Plane>(new Plane());

        // Below we can pass to the constructor any ElectricCar or subclasses of ElectricCar like electricCar
        // GenericBox<? extends ElectricCar> box1 = new GenericBox<>(car);
        GenericBox<? extends ElectricCar> box2 = new GenericBox<>(electricCar);

        // Below we can pass to the constructor any ElectricCar or superclasses of ElectricCar like car
        GenericBox<? super ElectricCar> box3 = new GenericBox<>(car);
        GenericBox<? super ElectricCar> box4 = new GenericBox<>(electricCar);

        // TODO:
        Plane plane = new Plane();
        GenericBox<? super ElectricCar> box5 = new GenericBox<>(plane);
        System.out.println(box5);

        // Java erases the generics across the code during compilation
        // So, the compiled code has no traces of any generic

        // This phenomenon is called "Erasure" in Java

    }
}
