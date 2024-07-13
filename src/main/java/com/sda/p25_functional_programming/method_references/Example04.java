package com.sda.p25_functional_programming.method_references;

/**
 * <h1>Method reference to a constructor OR <code>constructor references</code></h1>
 * <code> Class::new </code>
 */
public class Example04 {
    public static void main(String[] args) {

        // approach 1. using Lambda expression
        Manufacture energizer = (number) -> new Battery(number);

        // approach 2. using Method Reference
        Manufacture panasonic = Battery::new;


        energizer.manufacture(100);
        panasonic.manufacture(100);

        // What if we have two constructors in Battery
        NewManufacture energizer2 = (number, brand) -> new Battery(number, brand);
        NewManufacture panasonic2 = Battery::new;


    }
}


@FunctionalInterface
interface Manufacture {
    Battery manufacture(int value);
    // the signature of manufacture() method is similar to the signature of Battery constructor
}

@FunctionalInterface
interface NewManufacture {
    Battery newManufacture (int value, String brand);
    // the signature of newManufacture() method is similar to the signature of Battery second constructor
}



class Battery {
    public Battery(int capacity) {
        System.out.println("Battery is created with capacity: " + capacity);
    }

    public Battery(int capacity, String brand) {
        System.out.println("Battery is created with capacity: " + capacity + " and brand: " + brand);
    }
}
