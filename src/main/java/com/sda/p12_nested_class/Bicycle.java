package com.sda.p12_nested_class;

public class Bicycle {      // outer-class
    private double maxSpeed = 40;
    private static double gears = 3;

    public double getMaxSpeed() {
        return maxSpeed;
    }


    class Wheel {    // nested inner-class

        public void slowDown() {
            // nested inner-class can access the outer class's field
            maxSpeed *= 0.5;
            System.out.println("Wheel's max speed is now: " + maxSpeed);
        }
    } // end of Wheel class (inner class)


    static class Frame { // static inner class
        public void doNothing() {
            // maxSpeed = 2; // static inner class can NOT access outer class's instance fields
            gears = 4; // static inner class can access outer class's static fields
            System.out.println("I am a method inside a static inner class");
        }
    } // end of Frame (static inner class)

} // end of Bicycle (outer class)
