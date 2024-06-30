package com.sda.p24_concurrency.deadlock;

public class Main {
    public static void main(String[] args) {
        Resource resource = new Resource();
        Thread t1 = new DeadlockThread(resource);
        Thread t2 = new DeadlockThread(resource);
        t1.start();
        t2.start();
    }


    static class DeadlockThread extends Thread {
        private Resource resource;

        public DeadlockThread(Resource resource) {
            this.resource = resource;
        }

        @Override
        public void run() {
            resource.acquire();
            // if we want to prevent deadlock to happen, we have to make threads release the lock as below:
            resource.release();
        }
    }

    static class Resource {
        private boolean isLocked = false;

        public synchronized void acquire() {
            System.out.println("Thread[" + Thread.currentThread().getName() + "]: checking lock");
            while (isLocked) {
                try {
                    System.out.println("Thread[" + Thread.currentThread().getName() + "]: waiting for the lock to be released");
                    wait();
                } catch (InterruptedException e) {
                    // handle exception
                }
            }
            isLocked = true;
            System.out.println("Thread[" + Thread.currentThread().getName() + "]: lock is acquired");
        }

        public synchronized void release() {
            try {
                Thread.sleep(3000);
                isLocked = false;
                System.out.println("Thread[" + Thread.currentThread().getName() + "]: lock is released");
                notify();
            } catch (InterruptedException ex) {
                // handle exception
            }
        }
    }
}
