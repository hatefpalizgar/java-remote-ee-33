package com.sda.p27_streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Teacher a = new Teacher("Thomas", "Peterson", 30);
        Teacher b = new Teacher("Thomas", "Blau", 45);
        Teacher c = new Teacher("Henry", "Smith", 23);
        Teacher d = new Teacher("Mike", "Doe", 25);
        Teacher e = new Teacher("Mary", "Williams", 58);

        List<Teacher> applicants = Arrays.asList(a, b, c, d, e);

        // scenario: get the average age of teachers named Thomas

        // first solution: prior to Java 8
        double avg = 0;  // avg = sum / count
        int sum = 0;
        int count = 0;

        for (Teacher t : applicants) {
            if (t.getFirstname().equals("Thomas")) {
                count++;  // count = count + 1
                sum += t.getAge();
            }
        }
        avg = (double) sum / count;
        System.out.println("for-loop average: " + avg);

        // second solution: post Java 8 - using Streams API
        // steps to get the average age of teachers with firstname 'Thomas'
        // 1. find teachers with name 'Thomas'
        // 2. get their ages
        // 3. calculate the average

        Double average = applicants
                .stream()
                .filter(teacher -> teacher.getFirstname().equals("Thomas"))
                .map(teacher -> teacher.getAge())
                .collect(Collectors.averagingInt(age -> age));

        System.out.println("stream API average: " + average); // 37.5

        // scenario: sort the teachers by last name and print their last name to the console
        applicants
                .stream()
                .sorted((t1, t2) -> t1.getLastname().compareToIgnoreCase(t2.getLastname()))
                .forEach(t -> System.out.println(t.getLastname()));


        // ==================== another example ==============================
        List<String> someBingoNumbers =
                Arrays.asList(
                        "N40", "N36", "B12", "B6", "G53", "G49", "G60", "G50", "g64", "I26", "I17", "I29",
                        "O71");
        // scenario: print out bingo numbers that start with 'G' or 'g' in a sorted order

        List<String> gNumbers = new ArrayList<>();

        // prior to Java 8
        for (String number : someBingoNumbers) {
            if (number.toUpperCase().startsWith("G")) {
                gNumbers.add(number);
                System.out.println(number);
            }
        }
        gNumbers.sort((n1, n2) -> n1.compareToIgnoreCase(n2));

        System.out.println(gNumbers);


        // post Java 8
        someBingoNumbers
                .stream()
                .filter(n -> n.toUpperCase().startsWith("G"))
                .sorted()
                .forEach(System.out::println);

        /**
         *
         * @see Exercise1
         * */
    }
}
