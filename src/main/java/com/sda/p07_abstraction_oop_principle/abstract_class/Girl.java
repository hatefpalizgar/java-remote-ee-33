package com.sda.p07_abstraction_oop_principle.abstract_class;

// by extending Human(abstract class) we are "enforcing"
// any child class of Human(like Girl here) to have two methods
// 1. eat()
// 2. breathe()

// Using abstract methods, is a sort of signing a "contract".

// By extending Human, we can be %100 sure that any subclass of Human
// will certainly have two methods eat() and breathe()

public class Girl extends Human {
    @Override
    public void eat() {
        // ....
    }

    @Override
    public void breathe() {
        // ....
    }
}
