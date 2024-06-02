package com.sda.p11_anonymous_class;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {

        /* ========== Anonymous class using Abstract class ========== */

        Cat cat = new Cat("Kitty");

        // polymorphism
        Animal cat2 = new Cat("Kitty");


        // instantiating abstract class is IMPOSSIBLE
        // Animal dog = new Animal();


        // right side curly brace is like
        // ???? extends Animal but without any class name
        // below is an ad-hoc object creation (you can't reuse this class again)
        // below we're instantiating and extending Animal at the same time.
        // Here, we're creating an instance of Animal(abstract), with the specified name "dog" and
        // providing implementation of the makeSound() method

        // NB! "dog" is the name of instance variable we have created NOT the name of the class.
        // The concrete class has no name (anonymous)
        Animal dog = new Animal("Rex") {
            @Override
            public void makeSound() {
                System.out.println("Woof...Woof");
            }
        };

        dog.makeSound();

        // Anonymous class can be useful when you need to use a class just once, or when you need to
        // override just a few methods of a class or interface.

        // Cons:
        // They can make code less readable, especially if the anonymous class is large or has lots of
        // methods
        // So, use them with caution.

        // FYI, later we will use anonymous class concept in Lambda expressions.



        /* ========== Anonymous class using Interface ========== */
        // Similar to abstract class, we can't instantiate interfaces.
        // Playable playable = new Playable();
        Playable playable = new Playable() {
            @Override
            public void play() {
             // ...
            }

            @Override
            public void love() {
            // ...
            }
        };


        // A real-world example from Java library called JavaFX
        Button button = new Button("Click Me");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Button clicked!");
            }
        });

    }
}
