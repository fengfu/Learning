package io.fengfu.learning.concurrent.semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Created by fengfu on 2017/2/6.
 */
public class SemaphoreDemo implements Runnable {
    final Semaphore semaphore = new Semaphore(5);

    @Override
    public void run() {
        try {
            semaphore.acquire();

            Thread.sleep(2000);

            System.out.println("Thread " + Thread.currentThread().getId() + " done.");

            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(20);

        final SemaphoreDemo sd = new SemaphoreDemo();
        for (int i=0;i<20;i++) {
            es.submit(sd);
        }

        es.shutdown();
    }
}
