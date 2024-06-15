package com.sda.p18_collections.exercise;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Person p1 = new Person("Hatef", "Palizgar", 35);
        Person p2 = new Person("Adam", "Smith", 25);

        Friend f1 = new Friend("John", "Doe", 22);
        Friend f2 = new Friend("Mary", "Abraham", 40);

        Map<Person, Friend> map = new HashMap<>();

        // add some entry to the map
        map.put(p1, f1);
        map.put(p2, f2);

        // add duplicate key (POSSIBLE) - new entry will override the previous entry
        // map.put(p1, f2);

        // let's display the content of the map
        for (Map.Entry<Person, Friend> entry: map.entrySet()) {
            System.out.println(entry.getKey().toString() + " : " + entry.getValue().toString());
        }

        System.out.println(map.get(p1)); // f1

        System.out.println(map.containsKey(p1)); // true

        for (Friend f: map.values()) {
            System.out.println(f);
        }

        Map<Person, List<Friend>> party = new HashMap<>();
        party.put(p1, List.of(f1, f2));
        party.put(p2, Arrays.asList(f1,f2));

        // TODO: print the list of people in this party like below:
        // For each friend, print the firstname of the person followed by :
        // Then on a new line print the details of the friend itself
        /*
        Adam:
        John Doe 22
        Adam:
        Mary Abraham 40
        Hatef:
        John Doe 22
        Hatef:
        Mary Abraham 40
        */

        Person pA = new Person("A", "A", 1);
        Person pB = new Person("B", "B", 2);
        Map<Person, Person> map1 = new HashMap<>();
        map1.put(pA, pB); // map1 stores a reference to pA & pB
        System.out.println(map1);
        pA.setFirstname("Y"); // it will change pA stored in map1
        pA.setLastname("Y"); // it will change pA stored in map1
        System.out.println(map1);
    }
}
