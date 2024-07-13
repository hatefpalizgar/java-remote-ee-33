package com.sda.p25_functional_programming.builtin_jdk_func_interfaces;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/*
 * Consumer consumes values. This FI (func. interface) always takes an argument and never returns anything.
 * Consumer has a functional method called accept()
 */

public class ConsumerExample {

    public static void main(String[] args) {

        Consumer<Person> personConsumer = p -> {
            System.out.println(p.getName());
            System.out.println(p.getAge());
        };

        Person mary = new Person("Mary", 22);

        personConsumer.accept(mary);


        Consumer<String> stringConsumer = text -> System.out.println(text.toUpperCase());
        stringConsumer.accept("Hello World"); // HELLO WORLD


        List<Person> list = new ArrayList<>();
        list.add(new Person("Toby", 35));
        list.add(new Person("Rose", 20));
        list.add(new Person("Tom", 31));

        // for each person in this list, execute the consumer accept() method
        // in another term, forEach() will consume every Person object in the list
        list.forEach(personConsumer);

        /**
         * Next:
         * @see SupplierExample
         * */

    }

}
