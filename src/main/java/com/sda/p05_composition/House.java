package com.sda.p05_composition;

/*
  House Class:
	- Manages an array of rooms and their count.
	- Responsible for creating and containing rooms.
	- Rooms do not exist independently of the House. If the House is destroyed, the rooms are also destroyed.
*/

public class House {
    private Room[] rooms;
    private int roomCount;

    public House(int numberOfRooms) {
        rooms = new Room[numberOfRooms];
        roomCount  = 0; // variable to keep track of number of rooms we added so far
    }

    public void addRoom(String roomName) {
        // check if rooms[] has empty capacity
        if (roomCount < rooms.length) {
            rooms[roomCount] = new Room(roomName);
            roomCount++;
        } else {
            System.out.println("House has the maximum number of rooms");
        }
    }

    public Room[] getRooms() {
        return rooms;
    }
}
