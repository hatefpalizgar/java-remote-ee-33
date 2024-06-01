package com.sda.p02_encapsulation_oop_principle;

// Now, let's talk about Encapsulation in Java.
// Encapsulation is the process of wrapping up the data (fields) and code acting on the data
// (methods) in a single unit.
// Encapsulation is achieved by making fields private and providing public getter and
// setter methods to access and modify the fields.
// Getter methods allow read access to the fields.
// Setter methods allow for the modification of field values while enabling validation or
// constraint checks.

public class Main {
    public static void main(String[] args) {
        Pocket aPocket = new Pocket(4000);
        System.out.println(aPocket.getMoney()); // 4000

        aPocket.setMoney(5000); // this should not work and should show error in the console
        System.out.println(aPocket.getMoney()); // 4000
    }
}
