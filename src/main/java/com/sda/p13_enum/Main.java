package com.sda.p13_enum;

import static com.sda.p13_enum.SimpleUnit.*;

public class Main {
    public static void main(String[] args) {
        String name = "John";
        int age = 5;

        SimpleUnit unit = CENTIMETER;
        System.out.println(unit); // CENTIMETER
        System.out.println(INCH);
        System.out.println(FOOT);

        ComplexUnit complexUnit = ComplexUnit.CENTIMETER; // you can't directly call the constructor
        double myOrder = complexUnit.whatIsMyOrder(); // you can invoke enum's method

        // Goal of enum:
        // Is to declare a predefined set of values (e.g. colors)
        // Clients are not allowed to have/use any other colors than those defined by enums
        System.out.println(Color.BLUE);

        // Using proper enums, print weekdays
        // Also, display their corresponding day number (1 for Monday and so on)
        //  Monday
        //  1
        System.out.println(Weekday.MONDAY); // MONDAY
        System.out.println(Weekday.MONDAY.getOrder()); // 1
        System.out.println(Weekday.MONDAY.name()); // ? MONDAY
        System.out.println(Weekday.MONDAY.ordinal()); // ? 0
        System.out.println(Weekday.TUESDAY.ordinal()); // ? 1


        System.out.println(TrafficLight.RED.getMsg()); // stop!
    }
}

enum Weekday {
    MONDAY(1),
    TUESDAY(2),
    WEDNESDAY(3),
    THURSDAY(4),
    FRIDAY(5),
    SATURDAY(6),
    SUNDAY(7);

    private int order;

    Weekday(int order) {
        this.order = order;
    }

    public int getOrder() {
        return order;
    }
}

enum TrafficLight {
    RED("stop!"),
    GREEN("go!"),
    YELLOW("slow down!");

    private String msg;

    TrafficLight(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
