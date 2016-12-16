package io.fengfu.learning.thread.barrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

/**
 * 运动员
 * Created by qufengfu on 14-3-18.
 */
public class Athlete implements Runnable {
    private final CountDownLatch startSignal;
    private final CyclicBarrier barrier;
    private final int seq;

    Athlete(CountDownLatch startSignal, CyclicBarrier barrier, int seq){
        this.startSignal = startSignal;
        this.barrier = barrier;
        this.seq = seq;
    }

    @Override
    public void run() {
        try {
            System.out.println("运动员"+this.seq+"等待中......");
            //等待开始信号
            startSignal.await();

            System.out.println("运动员"+this.seq+"出发!");

            Thread.sleep(10000L + seq*1000);

            System.out.println("运动员" + this.seq + "跑完啦，等后面的乌龟哟:(");
            barrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
