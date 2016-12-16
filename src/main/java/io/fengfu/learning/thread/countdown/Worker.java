package io.fengfu.learning.thread.countdown;

import java.util.concurrent.CountDownLatch;

/**
 * Created by qufengfu on 14-3-11.
 */
public class Worker implements Runnable {
    private final CountDownLatch mStartSignal;
    private final CountDownLatch mDoneSignal;
    private final int mThreadIndex;

    Worker(final CountDownLatch startSignal, final CountDownLatch doneSignal, final int threadIndex) {
        this.mDoneSignal = doneSignal;
        this.mStartSignal = startSignal;
        this.mThreadIndex = threadIndex;
    }

    @Override
    public void run() {
        try {
            System.out.println("线程 " + mThreadIndex + ", 准备完毕 " + System.currentTimeMillis());
            mStartSignal.await();// 阻塞，等待mStartSignal计数为0运行后面的代码
            // 所有的工作线程都在等待同一个启动的命令
            doWork();// 具体操作
            System.out.println("线程 " + mThreadIndex + " 处理完毕:" + System.currentTimeMillis());
            mDoneSignal.countDown();// 完成以后计数减一
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void doWork() {
        for (int i = 0; i < 1000000; i++) {
            ;// 耗时操作
        }
        System.out.println("线程 " + mThreadIndex + ":正在执行……");
    }
}
