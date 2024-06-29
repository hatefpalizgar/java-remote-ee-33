package com.sda.p24_concurrency.synchronization;

public class Main {
    public static void main(String[] args) {
        Bench bench = new Bench(1);

        Thread threadA = new SeatTakerThread(bench);
        Thread threadB = new SeatTakerThread(bench);

        threadA.start();
        threadB.start();
    }
}
