package io.fengfu.learning.thread.barrier;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by qufengfu on 14-3-11.
 */
public class WalkTarget {
    private final int mCount = 5;
    private final CyclicBarrier mBarrier;
    ExecutorService mExecutor;

    class BarrierAction implements Runnable {
        @Override
        public void run() {
            System.out.println("所有线程都已经完成任务,计数达到预设值");
            //mBarrier.reset();//恢复到初始化状态
        }
    }

    WalkTarget() {
        //初始化CyclicBarrier
        mBarrier = new CyclicBarrier(mCount, new BarrierAction());
        mExecutor = Executors.newFixedThreadPool(mCount);

        for (int i = 0; i < mCount; i++) {
            //启动工作线程
            mExecutor.execute(new Walker(mBarrier, i));
        }
    }
}
