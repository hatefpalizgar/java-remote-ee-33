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
    public static void main1(String[] args) throws InterruptedException {
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

        /* ========================================================================= */
        //                States for Threads (running, waiting, dead)
        /* ========================================================================= */

        // The five states are as follows:
        // New: A thread is in this state when it has been created, but the start() method has not yet
        // been called on it
        // Runnable: A thread is in this state when it is eligible to run, but the Java runtime has not
        // yet selected it to run. This is also known as the "ready" state
        // Running: A thread is in this state when it is currently executing its run() method
        // Blocked (Non-runnable state): A thread is in this state when it is waiting for a resource that
        // is currently held by another thread
        // Dead or Terminated: A thread is in this state when it has completed execution of its run()
        // method or when it has been stopped

    }

    /* ========================================================================= */
    //                              Synchronization
    /* ========================================================================= */
        /*
         1. What is synchronization?
          Synchronization is a mechanism that allows multiple threads to access shared resources in a controlled manner,
          preventing race conditions and data corruption.

          2. Why is synchronization important? Without synchronization, it is possible for multiple
          threads to access a shared resource simultaneously, which can lead to race conditions and data corruption.
          Synchronization ensures that only one thread can access a shared resource at a time, preventing these issues.
        */


    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        Thread t1 = new IncrementThread(counter);
        Thread t2 = new IncrementThread(counter);

        t1.start();
        t2.start();

        t1.join(); // main thread should wait for t1 to terminate
        t2.join(); // main thread should wait for t2 to terminate

        System.out.println(counter.getCount()); // 2000
    }


    static class Counter { // SHARED RESOURCE
        private int count = 0;
        private Object lock = new Object();

        // when a thread enters a synchronized method, it acquires the lock for the object
        // on which the method is defined (counter object)
        // This means that other thread cannot enter any synchronized method on the same object
        // until the first thread has exited the method (released the lock)
        // if we don't use synchronized keyword, it causes RACE CONDITION to happen.
        // RACE CONDITION: when two or more threads try to access shared resources concurrently,
        // and the outcome of the program depends on the interleaving of the threads
        public synchronized void increment() {
            count++;
        }

        // getCount() method can be accessed by multiple threads simultaneously
        // because it's not synchronized
        public int getCount() {
            return count;
        }

        // Sometimes, you don't want to synchronize the whole method;
        // instead you can synchronize a specific part of that method using blocks
        public void doSomething() {
            synchronized (lock){

            }
            // other stuff in the method
        }

    } // Counter class


    static class IncrementThread extends Thread {
        private Counter counter;

        public IncrementThread(Counter counter) {
            this.counter = counter;
        }

        @Override
        public void run() {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        }
    } // IncrementThread class


    /* ========================================================================= */
    //                                Thread Pools
    /* ========================================================================= */
    // Refer to threadpool package

    /* ========================================================================= */
    //                            Concurrent collections
    /* ========================================================================= */
    // Concurrent collections are data structures that are designed to support concurrent access and
    // modification
    // by multiple threads.
    // In Java, the java.util.concurrent package provides several concurrent collection classes,
    // such as ConcurrentHashMap, CopyOnWriteArrayList, and BlockingQueue
    // Some key benefits of using concurrent collections include:
    // - Improved performance: Concurrent collections are designed to perform well in the presence of
    // multiple threads,
    // and can often provide better performance than traditional collections in a concurrent setting
    // - Simplified thread safety: Concurrent collections provide built-in thread safety, so you don't
    // have to manually synchronize access to the collection.
    // This can make it easier to write correct concurrent code
    // - Support for common concurrent scenarios: Concurrent collections provide support for common
    // concurrent scenarios,
    // such as producer-consumer patterns and parallel processing.


    /* ========================================================================= */
    //                        Race conditions and Deadlocks
    /* ========================================================================= */

    // Deadlock: Deadlock occurs when two or more threads are blocked and waiting for each other to
    // release a lock,
    // resulting in a standstill.
    // refer to deadlock package


    // Race condition: refer to synchronization block above


}// Main class
