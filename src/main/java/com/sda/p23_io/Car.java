package com.sda.p23_io;

import java.io.Serializable;

// Serializable is an interface with no method
// Interfaces with no method are called "Marker" interfaces
public class Car implements Serializable {

    // TODO: Google > serialVersionUID in Java? What? Why?
    private static final long serialVersionUID = 1L;

    private String model;
    private double price;


    public Car(String model, double price) {
        this.model = model;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", price=" + price +
                '}';
    }
}
