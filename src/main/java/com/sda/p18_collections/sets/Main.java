package com.sda.p18_collections.sets;

import java.time.Month;
import java.util.*;

// To learn more: https://www.geeksforgeeks.org/set-in-java/?ref=lbp

public class Main {
    public static void main(String[] args) {

        // Set doesnt allow duplicates
        // Set is NOT an ordered collection
        Set<String> travelRoutes = new HashSet<>();
        travelRoutes.add("New York");
        travelRoutes.add("Berlin");
        travelRoutes.add("Tallinn");
        travelRoutes.add("Paris");
        travelRoutes.add("London");
        travelRoutes.add("Paris");
        travelRoutes.add("Tallinn");

        System.out.println(travelRoutes);

        /* ============================================================================================== */
        //                              Union, Intersection, Difference
        /* ============================================================================================== */
        // Union: returns a new set containing all elements from both sets
        Set<Integer> a = new HashSet<>();
        a.addAll(List.of(1, 3, 2, 4, 8, 9, 0));

        Set<Integer> b = new HashSet<>();
        b.addAll(List.of(1, 3, 7, 5, 4, 0, 7, 5));

        // To find union of two sets, we can use the following method:
        Set<Integer> union = new HashSet<>(a);
        union.addAll(b);
        System.out.println("Union of two sets: " + union);

        // Intersection: returns a new set containing all elements that are common to both sets
        Set<Integer> intersection = new HashSet<>(a);
        intersection.retainAll(b);
        System.out.println("Intersection of two sets: " + intersection);

        // Difference: returns a new set containing all elements that are in the first set but not in
        // the second set
        Set<Integer> difference = new HashSet<>(a);
        difference.removeAll(b);
        System.out.println("Difference of two sets: " + difference);

        /* ============================================================================================== */
        //                                 HashSet, EnumSet, LinkedHashSet, TreeSet
        /* ============================================================================================== */
        // 1. HashSet: does not guarantee order of elements. It is a good choice for storing elements that
        // are not ordered.
        // 2. EnumSet: is a set of elements of a specific enum type. High-performance and faster than
        // HashSet.
        Set<Month> enumSet = EnumSet.of(Month.JUNE, Month.APRIL, Month.JANUARY);
        System.out.println(enumSet);

        // 3. LinkedHashSet: is a set that maintains the order of elements in which they were inserted.
        // When iterating through a HashSet, the order is unpredictable, while a LinkedHashSet lets us
        // iterate through the elements in the order in which they were inserted.
        Set<String> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add("India");
        linkedHashSet.add("Australia");
        linkedHashSet.add("South Africa");
        linkedHashSet.add("India");

        System.out.println(linkedHashSet);

        // 4. TreeSet: it behaves like a simple set with the exception that it stores element in a
        // sorted format.
        // It is a good choice for storing elements that are ordered and sorted.
        Set<String> treeSet = new TreeSet<>();
        treeSet.add("India");
        treeSet.add("Australia");
        treeSet.add("South Africa");
        treeSet.add("India");
        System.out.println(treeSet);

        // To learn more: https://www.geeksforgeeks.org/set-in-java/?ref=lbp

    }
}
