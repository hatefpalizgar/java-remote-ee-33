package com.sda.p24_concurrency.atomic;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class Main {
    // Non-atomic variable
    // Therefore, it is possible for multiple threads to interfere with each other
    // and produce an incorrect result
    // private static int count = 0;

    // Atomic variable
    // We say an operation is atomic if, while it is being performed,
    // another thread cannot read/change the value of the variables being changed
    // similar to synchronized (which applies to methods and blocks) but for variables
    private static AtomicInteger count = new AtomicInteger(0);

    // TODO: What is AtomicReference? When to use them?
    // TODO: Are String variables atomic by default? or not?


    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    // count++;
                    count.incrementAndGet();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    // count++;
                    count.incrementAndGet();
                }
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            // handle exception
        }

        System.out.println("Final count: " + count);
    }
}
