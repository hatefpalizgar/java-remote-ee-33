package com.sda.p24_concurrency.synchronization;

// Bench here is our SHARED RESOURCE
public class Bench {
    private int availableSeats;

    public Bench(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    // a synchronized method can be called only by ONE thread at a time
    // thanks to the lock

    // critical section: a part which we don't want several threads to run at the same time
    public synchronized void takeASeat() {
        if (availableSeats > 0) {
            System.out.println(Thread.currentThread().getName() + " taking a seat...");
            this.availableSeats--;
            System.out.println("Free seats available: " + this.availableSeats);
        } else {
            System.out.println("no more available seats for "+ Thread.currentThread().getName() +", all taken!");
        }
    }
}
