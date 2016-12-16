package io.fengfu.learning.thread.barrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

/**
 * Created by qufengfu on 14-3-11.
 */
public class Walker implements Runnable {
    private final CyclicBarrier mBarrier;
    private final int mThreadIndex;

    Walker(final CyclicBarrier barrier, final int threadIndex) {
        mBarrier = barrier;
        mThreadIndex = threadIndex;
    }

    public void run() {
        System.out.println("Thread " + mThreadIndex + " is running...");
        // 执行任务
        try {
            TimeUnit.MILLISECONDS.sleep(5000);
            // do task
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 完成任务以后，等待其他线程完成任务
        try {
            mBarrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        // 其他线程任务都完成以后，阻塞解除，可以继续接下来的任务
        System.out.println("Thread " + mThreadIndex + " do something else");
    }
}
