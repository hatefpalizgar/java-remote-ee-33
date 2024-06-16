package com.sda.p22_generics;

// Here, we are parameterizing the GenericBox class with parameter T
// T: is a "type parameter"
public class GenericBox<T> {
    private T item;

    public GenericBox(T item) {
        this.item = item;
    }
}
