package io.fengfu.learning.thread.barrier;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

/**
 * 裁判
 * Created by qufengfu on 14-3-18.
 */
public class Referee {
    private final static int TOTAL_THREADS = 4;
    private final static CountDownLatch startLatch = new CountDownLatch(1);

    class BarrierAction implements Runnable {
        @Override
        public void run() {
            System.out.println("所有的运动员都已经到达。");
            //mBarrier.reset();//恢复到初始化状态
        }
    }

    public void play() {
        CyclicBarrier barrier = new CyclicBarrier(TOTAL_THREADS, new BarrierAction());

        for (int i = 0; i < TOTAL_THREADS; i++) {
            new Thread(new io.fengfu.learning.thread.barrier.Athlete(startLatch, barrier, i)).start();
        }

        System.out.println("裁判员：各就位......，预备......跑!");

        //计数减一
        startLatch.countDown();

        System.out.println("裁判员：让这群野狗飞奔去吧......");
    }
}
