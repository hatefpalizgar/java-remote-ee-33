package com.sda.p27_streams.no2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Example02 {
    public static void main(String[] args) {
        List<String> someBingoNumbers = Arrays.asList(
                "N40", "N36",
                "B12", "B6",
                "G53", "G49", "G60", "G50", "g64",
                "I26", "I17", "I29",
                "O71");

        Stream<String> stringStream = someBingoNumbers.stream();

        // second approach to create a stream without creating any collection first
        // ad-hoc way
        Stream<String> ioNumberStream = Stream.of("I26", "I17", "I29", "071");
        Stream<String> inNumberStream = Stream.of("N40", "N36", "I26", "I29", "071");

        Stream<String> concatStream = Stream.concat(ioNumberStream, inNumberStream);

        // concatStream.distinct().forEach(s -> System.out.print(s + ", ")); // removes duplicates and keeps only distinct/unique items
        System.out.println(concatStream.distinct().count()); // 6
        // concatStream is closed and can not be re-used again

        // peek() method is ONLY used for debugging purpose
        // DON"T use it in production code
        List<String> words = Stream.of("one", "two", "three", "four")
                .filter(e -> e.length() > 3)
                .peek(e -> System.out.println("Filtered value: " + e))
                .map(String::toUpperCase)
                .peek(e -> System.out.println("Mapped value: " + e))
                .collect(Collectors.toList()); // toList()

        // Debugging Streams API:
        // If using IntelliJ, you can use 'Trace Current Stream Chain' from three-dot menu of debugger
        // otherwise, use peek() menu

        // The output of the last code, demonstrates that items in a stream
        // are passed one by one to the full stream pipeline sequentially.
        // So, stream first processes 'three' from filtering to collection and
        // then it will start processing 'four' from filtering to collection

        /**
         *
         * @see com.sda.p27_streams.no3.FlatMapExample1
         * */
    }
}
