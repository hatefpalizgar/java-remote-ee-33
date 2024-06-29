package com.sda.p24_concurrency;

public class Main {

    /* ========================================================================= */
    //                     Creating and Starting Threads
    /* ========================================================================= */

    /*
     To create a thread in Java, you can do one of the following:
      1. Extend the Thread class and override its run() method
      2. Implement the Runnable interface and pass it to a Thread object in the constructor
    */
    public static void main(String[] args) throws InterruptedException {
        System.out.println(Thread.currentThread().getName()); // main thread

        // 1. Extend the Thread class and override its run() method
        StopWatchThread myStopWatch = new StopWatchThread();
        StopWatchThread myStopWatch2 = new StopWatchThread();

        // myStopWatch.run();
        // NEVER call run() of threads yourself; If you call the run()
        // method, the method itself will execute as part of the main thread,
        // not a new thread, and the program will not run concurrently

        // The correct way to start a thread is to call start() method
        myStopWatch.start();
        myStopWatch2.start();

        // The new thread is created by the operating system,
        // and the Java runtime is responsible for managing it
        // and scheduling it to run.

        // 2. Implement the Runnable interface and pass it to a Thread object in the constructor
        Runnable myRunnableThread = new RunnableThread();
        // myRunnableThread.start(); // we don't have start() method on any Runnable thread
        // instead, we need to pass this runnable object as a constructor argument to another thread class
        Thread myRunnableThreadUsingThreadClass = new Thread(myRunnableThread);
        myRunnableThreadUsingThreadClass.start();

        // order of execution of threads above is NOT guaranteed;
        // It means each time you run this application, they might start in different order

        // Order of threads execution in a multithreaded application is non-deterministic;
        // You might end up having them executed in different order each time

        /* ========================================================================= */
        //                           Stopping Threads
        /* ========================================================================= */
        // myStopWatch.stop();
        // How to stop a thread by calling the stop() method (deprecated as might cause data corruption)
        // or by using other methods such as interrupt() or volatile variables (volatile boolean flags to
        // stop run method execution)
        // Refer to volatiles package

    }
}
