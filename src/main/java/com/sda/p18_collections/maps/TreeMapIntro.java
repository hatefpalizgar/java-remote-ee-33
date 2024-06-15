package com.sda.p18_collections.maps;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

//  A TreeMap is a Map implementation in Java that maintains its entries in ascending order, sorted
// according to the keys' natural ordering
//  or according to a Comparator provided at the time of the TreeMap's creation.

//  TreeMap has the following characteristics:
//      - It is a sorted map, meaning that the keys are ordered according to their natural ordering
// or a specified Comparator.
//      - It does not allow null keys, but it does allow null values.
//      - It provides efficient access to the entries based on their keys, as well as efficient
// range queries (queries for a range of keys).
public class TreeMapIntro {

  public static void main(String[] args) {

    System.out.println("================== TreeMap with default Comparator ===============");

    Map<Integer, Integer> treeMap = new TreeMap<>();
    treeMap.put(2, 200);
    treeMap.put(4, 400);
    treeMap.put(1, 100);
    treeMap.put(3, 300);
    // Null keys are not allowed for TreeMap
    // treeMap.put(null, null);

    for (Map.Entry<Integer, Integer> entry : treeMap.entrySet()) {
      System.out.println(entry.getKey());
    }

    System.out.println("================== TreeMap with built-in Comparator ===============");

    treeMap = new TreeMap<>(Comparator.reverseOrder());
    treeMap.put(2, 200);
    treeMap.put(4, 400);
    treeMap.put(1, 100);
    treeMap.put(3, 300);
    for (Map.Entry<Integer, Integer> entry : treeMap.entrySet()) {
      System.out.println(entry.getKey());
    }

    System.out.println("================== TreeMap with custom Comparator ===============");

    Map<String, Integer> mapForSorting = new HashMap<>();

    // Add some key-value pairs to the map
    mapForSorting.put("banana", 2);
    mapForSorting.put("apple", 1);
    mapForSorting.put("cherry", 3);

    // Print the map (unsorted)
    System.out.println("Original map: " + mapForSorting);

    // Create a new TreeMap with the same elements, but sorted by value
    Map<String, Integer> sortedMap = new TreeMap<>(new ValueComparator(mapForSorting));

    // OR you can use the static methods of Comparator:
    // Map<String, Integer> sortedMap = new TreeMap<>(Comparator.naturalOrder());

    sortedMap.putAll(mapForSorting);

    // Print the sorted map
    System.out.println("Sorted map: " + sortedMap);
  }
}

// A comparator that compares the values of the map
class ValueComparator implements Comparator<String> {
  Map<String, Integer> map;

  public ValueComparator(Map<String, Integer> map) {
    this.map = map;
  }

  @Override
  public int compare(String key1, String key2) {
    int value1 = map.get(key1);
    int value2 = map.get(key2);
    return value1 - value2;
  }
}
