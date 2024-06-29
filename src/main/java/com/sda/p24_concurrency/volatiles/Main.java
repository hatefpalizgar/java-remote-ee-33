package com.sda.p24_concurrency.volatiles;

public class Main {

    // volatile keyword here makes sure that
    // the changes made in one thread are
    // immediately reflected/visible in other thread
    private static volatile int MY_INT = 0;

    public static void main(String[] args) {
        // start ChangeMaker thread
        ChangeMaker changeMaker = new ChangeMaker();
        changeMaker.start();

        // start ChangeListener thread
        ChangeListener changeListener = new ChangeListener();
        changeListener.start();
    }

    static class ChangeListener extends Thread {
        @Override
        public void run() {
            int local_value = MY_INT;
            while (local_value < 5) {
                if (local_value != MY_INT) { // check if MY_INT has been modified by ChangeMaker thread
                    System.out.println("Got change for MY_INT: " + MY_INT);
                    local_value = MY_INT;
                }
            }
        }
    }


    static class ChangeMaker extends Thread {
        @Override
        public void run() {
            int local_value = MY_INT;
            while (MY_INT < 5) {
                System.out.println("incrementing local_value to " + (local_value + 1));
                MY_INT = ++local_value;
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    } // ChangeMaker class


}// Main class
