package io.fengfu.learning.thread.countdown;

import java.util.concurrent.CountDownLatch;

/**
 * Created by qufengfu on 14-3-18.
 */
public class CountDownLatchDemo {
    private final static int TOTAL_THREADS = 4;
    private final static CountDownLatch startLatch = new CountDownLatch(1);
    private final static CountDownLatch athleteLatch = new CountDownLatch(TOTAL_THREADS);

    public static void main(String[] args){

        for (int i=0;i<TOTAL_THREADS;i++){
            new Thread(new Athlete(startLatch, athleteLatch, i)).start();
        }

        System.out.println("裁判员：各就位......，预备......跑!");

        //计数减一
        startLatch.countDown();

        System.out.println("裁判员：让这群野狗飞奔一会吧......");

        try {
            athleteLatch.await();

            System.out.println("裁判员：终于跑完了，我也该休息一会了");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
