package com.sda.p25_functional_programming.builtin_jdk_func_interfaces;

import java.util.function.Supplier;

/*
 * Supplier always returns some value and never takes an arg.
 * Supplier is a FI which has get() method.
 */

public class SupplierExample {
    public static void main(String[] args) {
        Supplier<Person> personSupplier = () -> new Person("Rio", 29);

        Person rio = personSupplier.get();
        Person rio2 = personSupplier.get();

        System.out.println(rio.getName());  // Rio
        System.out.println(rio.getAge());   // 29

        /**
         * Next:
         *
         * @see FunctionExample
         */

    }
}
