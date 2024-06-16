package com.sda.p22_generics;

// We can limit the generic type to only subclasses of Vehicle using extends Vehicle
public class Garage<T extends Vehicle> {
    private T item;

    public Garage(T item) {
        this.item = item;
    }

    public void invoice() {
        item.repair();
        System.out.println("Total cost: $$$");
    }
}
