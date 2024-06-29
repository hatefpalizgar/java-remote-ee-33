package com.sda.p24_concurrency;

// StopWatchThread is a Thread that counts from 0 to 9
// and waits for 1 second between each count
public class StopWatchThread extends Thread {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        for (int i = 0; i < 10; i++) {
            System.out.println("stop watch: " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
}
