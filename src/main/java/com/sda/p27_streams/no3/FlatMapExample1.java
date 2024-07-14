package com.sda.p27_streams.no3;

import java.util.Arrays;
import java.util.List;

public class FlatMapExample1 {
    public static void main(String[] args) {
        // Example 1. Converting a nested list into a list
        List<Integer> list1 = Arrays.asList(1, 2, 3);
        List<Integer> list2 = Arrays.asList(4, 5, 6);
        List<Integer> list3 = Arrays.asList(7, 8, 9);

        List<List<Integer>> listOfLists = Arrays.asList(list1, list2, list3);

        List<Integer> listOfIntegers = listOfLists
                .stream() // Stream<List<Integer>>
                .flatMap(l -> l.stream()) // Stream<Integer>
                .toList();

        System.out.println(listOfIntegers);


        // Example 2. Converting nested arrays into List
        String[][] dataArray = new String[][] {{"a", "b"}, {"c", "d"}, {"e", "f"}, {"g", "h"}};

        List<String> listOfChars = Arrays.stream(dataArray)
                .flatMap(a -> Arrays.stream(a))
                .toList();

        System.out.println(listOfChars);

        /**
         *
         * @see FlatMapExample2
         * */
    }
}
