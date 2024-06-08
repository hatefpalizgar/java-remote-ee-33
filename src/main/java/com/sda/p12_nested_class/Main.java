package com.sda.p12_nested_class;
/* ========================================================================================== */
//                                    Inner Class
/* ========================================================================================== */

/*
 * In Java, it is possible to declare classes inside other classes.
 * We call these classes nested classes. They can be declared as:
 *  1. static classes (so-called static nested), using the static keyword
 *  2. non-static classes (so-called non-static or inner)
 *
 * I suggest to read more in depth examples in the following link: https://docs.java.en.sdacademy.pro/javaAdvanced/inner_classes/#inner-classes
 * Also once mastered the concepts of inner classes, take a look at 'local classes' here: https://docs.java.en.sdacademy.pro/javaAdvanced/local_classes/#local-classes
 */

public class Main {
    public static void main(String[] args) {
        Bicycle myBike = new Bicycle();
        System.out.println(myBike.getMaxSpeed()); // 40


        // Even though you should not instantiate an inner class on its own,
        // but Java made it possible (If you want to instantiate an inner class, then
        // define it as a regular class)

        Bicycle.Wheel aWheel = myBike.new Wheel(); // syntactically correct, but better to avoid
        aWheel.slowDown(); // Wheel's max speed is now: 20.0


        Bicycle.Frame aFrame = new Bicycle.Frame();
        aFrame.doNothing(); // I am a method inside a static inner class

    }
}
