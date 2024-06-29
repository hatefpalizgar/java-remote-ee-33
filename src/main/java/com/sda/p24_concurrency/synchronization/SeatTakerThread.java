package com.sda.p24_concurrency.synchronization;

public class SeatTakerThread extends Thread{

    private Bench bench; // reference to the shared resource

    public SeatTakerThread(Bench bench) {
        this.bench = bench;
    }

    @Override
    public void run() {
        bench.takeASeat();
    }
}
