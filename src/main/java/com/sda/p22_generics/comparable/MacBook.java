package com.sda.p22_generics.comparable;

// If you need to make instances of a class comparable to each other,
// so that you can sort them, you can compare them etc.
// you need to make that class implement Comparable interface
public class MacBook implements Comparable<MacBook> {
    private int cpuCore;

    public MacBook(int cpuCore) {
        this.cpuCore = cpuCore;
    }

    @Override
    public int compareTo(MacBook anotherMacBook) {
        // if we return 0: this == anotherMacBook
        // if we return a positive number: this > anotherMacBook
        // if we return a negative number: this < anotherMacBook
        return this.cpuCore - anotherMacBook.cpuCore;
        // here greatness means bigger number of cpuCore
    }
}
