package com.sda.p05_composition;


/**
 * Composition is a stricter form of aggregation. It occurs when the two classes you associate are
 * mutually dependent and can’t exist without each other. For example, take a Car and an Engine
 * class: A Car cannot run without an Engine, while an Engine also can’t function without being
 * built into a Car. Another example is a Building and Doors of the building. You can't have a
 * Building with no doors, while a Door also can't function without being built into a building.
 **/

public class Main {
    public static void main(String[] args) {
        House house = new House(3); // House with a maximum 3 rooms
        house.addRoom("Living room");
        house.addRoom("Kitchen");
        house.addRoom("Bedroom");

        System.out.println("House contains rooms: ");
        for (Room room: house.getRooms()) {
            if (room != null) {
                System.out.println("- " + room.getName());
            }
        }
    }
}
