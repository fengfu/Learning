package io.fengfu.learning.concurrent.semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * Created by fengfu on 2017/2/6.
 */
public class SemaphoreDemo implements Runnable {
    Semaphore semaphore;

    public SemaphoreDemo(Semaphore semaphore){
        this.semaphore = semaphore;
    }

    public void run() {
        try {
//            semaphore.acquire();

            Thread.sleep(2000);

            System.out.println("Thread " + Thread.currentThread().getId() + " done.");

            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(20);
        Semaphore semaphore = new Semaphore(1);
//
        final SemaphoreDemo sd = new SemaphoreDemo(semaphore);
//        for (int i=0;i<20;i++) {
            es.submit(sd);
//        }

        try {
            semaphore.acquire();

            boolean result = semaphore.tryAcquire(3, TimeUnit.SECONDS);
            System.out.println("Result="+result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        }
        es.shutdown();
    }
}
