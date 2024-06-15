package com.sda.p18_collections.maps;

import java.util.*;

public class HashMapIntro {

    /* ========================================================================= */
    //                                   Map
    /* ========================================================================= */
    // Map is a collection of key-value pairs.
    // Keys are unique but values can be duplicated.
    // Each key is linked to a specific value.
    // Once stored in a Map, you can later look up the value using just the key.
    // Map is not a subtype of Collection therefore it behaves a bit different from the rest of
    // Collection types.
    // Java Collections API contains the following Map implementations:
    // - HashMap
    // - TreeMap
    // - LinkedHashMap
    // - Hashtable
    // - Properties
    // - EnumMap
    // - WeakHashMap
    // - IdentityHashMap
    // - ConcurrentHashMap


    // HashMap does not guarantee any order of the elements stored internally in the map.
    // TreeMap guarantees that the elements are stored in sorted order.

    public static void main(String[] args) {
        /* ========================================================================= */
        //                              Creating a Map
        /* ========================================================================= */
        Map<String, String> map = new HashMap<>();

        map.put("key1", "value1");
        map.put("key2", "value2");
        map.put("key3", "value3");
        map.put("key4", "value3");
        map.put("key1", "value5"); // This will replace the value of key1 with value5

        // Only Java objects are allowed as keys and values. Primitive types are automatically boxed.

        // You can use null as a key/value or even both in a Map.
        map.put(null, "value6");
        map.put("key", null);

        System.out.println(map);

        Map<String, String> map2 = new HashMap<>();
        map2.putAll(map); // copying all entries from one map to another using putAll() method

        /* ========================================================================= */
        //                              Accessing a Map
        /* ========================================================================= */
        // You can access and iterate over keys and values using the following methods:
        // - get(key)
        // - getOrDefault(key, defaultValue)
        // - keySet()
        // - values()
        // - entrySet()

        String result = map.get("key1"); // return value5
        System.out.println(result + " ia the value mapped to key1");

        String value = map.getOrDefault("key8", "88888888888");
        System.out.println("value = " + value); // return 88888888888

        Set<String> keyset = map.keySet();
        System.out.println(keyset);

        Collection<String> values = map.values();
        System.out.println(values);

        // Entry: key-value pair
        Set<Map.Entry<String, String>> entrySet = map.entrySet();
        System.out.println(entrySet);

        System.out.println("===============================");

        // a more common way of iterating through an array
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        // You can use the containsKey() method to check if a key is present in the map.
        boolean containsKey = map.containsKey("key1");
        System.out.println("containsKey = " + containsKey); // true

        // You can use the containsValue() method to check if a value is present in the map.
        boolean containsValue = map.containsValue("value1");
        System.out.println("containsValue = " + containsValue); // false

        /* ========================================================================= */
        //                           Removing in a Map
        /* ========================================================================= */
        String removedValue = map.remove("key1"); // removes the entry with key1 and returns the value
        System.out.println(removedValue);

        // clear() method removes all entries of a map
        // map.clear();

        /* ========================================================================= */
        //                           Replacing in a Map
        /* ========================================================================= */
        map = new HashMap<>();
        map.replace("key", "val2"); // no "key" entry, no replace
        map.put("key", "val1"); // map now contains "key" entry
        map.replace("key", "new value"); // "key" entry replaced
        System.out.println(map.get("key")); // new value
        // using replace you can avoid creating a new entry in the map if the key you're trying to replace
        // doesn't already exist in the map. Using put() is not a recommended way of replacing/overwriting entries,
        // though it's possible.



        /* ========================================================================= */
        //                           Interview Questions
        /* ========================================================================= */
        // 1. What is the difference between a HashMap and a TreeMap?
        // 2. How the put() method of HashMap works in Java? (Hashing)
        // Answer:
        // https://www.java67.com/2013/06/how-get-method-of-hashmap-or-hashtable-works-internally.html
        // The put() method of HashMap works in the principle of hashing.
        // It is responsible for storing an object into the backend array.
        // The hashcode() method is used in conjunction with a hash function to find the correct
        // location for the object into the bucket.
        // If a collision occurs, then the entry object which contains both key and value is added to a
        // linked list,
        // and that linked list is stored into the bucket location.

        // At least you should know that:
        // i) Two unequal objects may return the same hashcode.
        // ii) When two objects are equal by equals(), they must have the same hashcode.

        // 3. How the get() method of HashMap works in Java?
        // 4. What is the requirement for an object to be used as a key or value in HashMap?
        // Answer:
        // The key or value object must implement the equals() and hashcode() method.
        // The hash code is used when you insert the key object into the map,
        // while equals are used when you try to retrieve a value from the map.

        // 5.Can you store a null key in Java HashMap?
        // Answer:
        // Yes, HashMap allows one null key, which is stored at the first location of bucket array e.g.,
        // bucket[0] = value.
        // The HashMap doesn't call hashCode() on the null key because it will throw
        // NullPointerException,
        // hence when a user call the get() method with null, then the value of the first index is
        // returned.

        // 6. Can you store a null value in Java HashMap? Yes. You can put as many null values as you
        // want.

        // 7. Which data structure is used to implement HashMap in Java? HashTable. Array is used for
        // bucket and linked list is used for collision.

        // 8. Can you store a duplicate key in HashMap? No.

        // 9. Is HashMap thread-safe in Java? No. HashMap is not thread-safe. For thread-safety, you
        // need to use ConcurrentHashMap.

        // 10. Are entries in HashMap ordered? No.

        String keyA = "A";
        String valA = "1";
        Map<String, String> map1 = new HashMap<>();
        map1.put(keyA, valA); // map1 makes a copy of keyA & valA
        System.out.println(map1);
        keyA = "B"; // it won't change the keyA stored in map
        valA = "2"; // it won't change the valA stored in map
        System.out.println(map1);

        String a = "hello";
        String b = "hello";
        String c = "hello";

        // TODO: Read more on "String Pool" concept
    }
}
