package io.fengfu.learning.thread.countdown;

import java.util.concurrent.CountDownLatch;

/**
 * Created by qufengfu on 14-3-18.
 */
public class Athlete implements Runnable {

    private final CountDownLatch startSignal;
    private final CountDownLatch latch;
    private final int seq;

    Athlete(CountDownLatch startSignal, CountDownLatch latch, int seq){
        this.startSignal = startSignal;
        this.latch = latch;
        this.seq = seq;
    }

    @Override
    public void run() {
        try {
            System.out.println("运动员"+this.seq+"等待中......");
            //等待开始信号
            startSignal.await();

            Thread.sleep(10000L);

            System.out.println("运动员" + this.seq + "跑完啦，happy去啦......");
            latch.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
