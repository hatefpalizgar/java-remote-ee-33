package com.sda.p18_collections.lists;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        /* ============================================================================================== */
        //                                       List Interface
        /* ============================================================================================== */
        // Java List interface is a member of the Java Collections Framework.
        // List allows you to add duplicate elements.
        // List allows you to have ‘null’ elements
        // List interface got many default methods in Java 8, for example replaceAll(), sort() and
        // spliterator().
        // List is an ordered collection of items.


        // declare a list of String items
        List<String> list = new ArrayList<>();

        // How to add elements to a list?
        list.add("A");
        list.add("B");

        // Remove element from a list
        list.remove("A");

        // To get size of a list
        System.out.println(list.size());  // 1

        // Check if a list is empty or not
        System.out.println(list.isEmpty()); // false

        // Check if a list contains a specific element
        System.out.println(list.contains("A")); // false

        // Remove all elements (clear the list)
        list.clear();

        // Add multiple items to a list
        list.addAll(List.of("A", "B", "C", "D", "A"));

        // Get element from a list
        System.out.println(list.get(1)); // B

        // Replace an element in a list by index
        list.set(0, "B");

        // Find the first index of an element
        System.out.println(list.indexOf("B")); // 0
        // Find the last index of an element
        System.out.println(list.lastIndexOf("B")); // 1

        // Possible to add null item
        list.add(null);

        list.add(3, "Z");

        // Print the list content
        System.out.println(list);

        /* ============================================================================================== */
        //                               Java Array to List using Arrays class
        /* ============================================================================================== */
        String[] vowels = {"a", "e", "i", "o", "u"};
        List<String> vowelsList = Arrays.asList(vowels);

        System.out.println(vowelsList);

        // Arrays.asList(...) returns a list that can't be structurally modified
        // vowelsList.remove("e");  // throws UnsupportedOperationException: remove
        // vowelsList.clear();
        vowelsList.set(0, "b"); // any modification on the converted list (via Arrays.asList()) will apply to the original array

        // So the best way is to use for-loop for creating list by iterating over the array
        List<String> myList = new ArrayList<>();
        for (String s : vowels) {
            myList.add(s);
        }

        // This way, we can modify the returned list
        myList.remove("a");

        System.out.println(myList);


        /* ============================================================================================== */
        //                            Java List to array using toArray()
        /* ============================================================================================== */
        List<String> letters = new ArrayList<>(List.of("A", "B", "C"));

        // convert list to array
        String[] strArray = new String[letters.size()];
        strArray = letters.toArray(strArray);

        System.out.println(Arrays.toString(strArray)); // [A, B, C]


        /* ============================================================================================== */
        //                            List sort using sort()
        /* ============================================================================================== */
        List<Integer> integerList = new ArrayList<>();
        // let's put 10 random numbers in this list
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            integerList.add(random.nextInt(1000));
        }

        // natural sorting using Collections class
        Collections.sort(integerList);
        System.out.println("Sorted: " + integerList);



        /* ============================================================================================== */
        //                            List Iterator using iterator()
        /* ============================================================================================== */

        // Iterator is a class that can be used to iterate over a collection.
        // It has:
        // next() method -> which returns the next element in the collection
        // hasNext() method -> which returns true if there are more elements to be iterated over
        // remove() method -> which removes the current element from the collection

        List<Integer> numList = new ArrayList<>(List.of(1, 2, 3, 4, 5));
        Iterator<Integer> iterator = numList.iterator();

        // Let's try to remove an element from the list while using for-loop iteration
//        for (Integer i: numList) {
//            if (i % 2 == 0) numList.remove(i); // throws ConcurrentModificationExcpetion
//            // Since, you can't modify any list during iteration
//            // Unless, you use Iterator for doing so
//        }

        // simple iteration
        while (iterator.hasNext()) {
            int number = iterator.next();
            System.out.print(number + " ");
        }

        // modification of list using iterator
        iterator = numList.iterator(); // creates a new iterator starting before index 0
        while (iterator.hasNext()) {
            int number = iterator.next();
            if (number % 2 == 0) iterator.remove();
        }

        System.out.println("After removing even numbers: " + numList);

        // TODO: There is another type of Iterator called ListIterator; compare them together


        /* ============================================================================================== */
        //                                       ArrayList
        /* ============================================================================================== */
        // ArrayList is a class that implements List interface.
        // ArrayList in Java is used to store dynamically sized collection of elements.
        // Contrary to Arrays that are fixed in size, an ArrayList grows its size automatically when new
        // elements are added to it.
        // ArrayList internally uses an array to store the elements. Just like arrays, It allows you to
        // retrieve the elements by their index.
        // ArrayList allows duplicate and null values.
        // ArrayList is an ordered collection; It maintains the insertion order of the elements.
        // ArrayList is not synchronized, therefore it's not thread-safe.


        /* ============================================================================================== */
        //                                       LinkedList
        /* ============================================================================================== */
        // LinkedList is a linear data structure where the elements are not stored in contiguous
        // locations and every element is a separate object with a data part and address part.
        // The elements are linked using pointers or addresses.
        // Each element is known as a node.
        // It also has a few disadvantages like the nodes cannot be accessed directly instead we need to
        // start from the head and follow through the link to reach a node we wish to access
        // LinkedLists are generally slower than ArrayLists when it comes to accessing elements at a specific
        // index, but they are faster at inserting and deleting elements in the middle of the list
        // As a rule of thumb: Use an ArrayList for storing and accessing data, and LinkedList to
        // manipulate data.
        // Another difference between a LinkedList and an ArrayList is that LinkedLists have additional
        // methods for manipulating the list,
        // such as addFirst() and addLast(), which allow you to insert elements at the beginning or end
        // of the list.

        LinkedList<String> linkedList = new LinkedList<>(List.of("e1", "e2", "e3"));
        linkedList.addFirst("first item");
        linkedList.addLast("second item");
        linkedList.pop();
        linkedList.push("pushed element");

        Collections.sort(linkedList);

        System.out.println(linkedList);

        /* ============================================================================================== */
        //                                       Interview Questions
        /* ============================================================================================== */
        // 1. What is the difference between ArrayList and LinkedList?
        // 2. How to sort an ArrayList of objects using custom comparator?
        // 3. How to synchronize concurrent modifications to an ArrayList?
        // (Collections.synchronizedList() and CopyOnWriteArrayList)


    }
}
