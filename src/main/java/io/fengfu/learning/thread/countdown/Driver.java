package io.fengfu.learning.thread.countdown;

import java.util.concurrent.CountDownLatch;

/**
 * Created by qufengfu on 14-3-11.
 */
public class Driver {
    private static final int TOTAL_THREADS = 10;
    private final CountDownLatch mStartSignal = new CountDownLatch(1);
    private final CountDownLatch mDoneSignal = new CountDownLatch(TOTAL_THREADS);

    void main() {
        for (int i = 0; i < TOTAL_THREADS; i++) {
            new Thread(new Worker(mStartSignal, mDoneSignal, i)).start();
        }
        System.out.println("预备……:" + System.currentTimeMillis());

        doPrepareWork();// 准备工作
        mStartSignal.countDown();// 计数减一为0，工作线程真正启动具体操作

        System.out.println(">>>>>>>>>>>>>>>>>>开始>>>>>>>>>>>>>>>>>>>>>>");

        doSomethingElse();//做点自己的事情
        try {
            mDoneSignal.await();// 等待所有工作线程结束
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("全部处理完毕.");
        System.out.println("Main Thread Now:" + System.currentTimeMillis());
    }

    void doPrepareWork() {
        System.out.println("Ready,GO!");
    }

    void doSomethingElse() {
        for (int i = 0; i < 100000; i++) {
            ;// delay
        }
        System.out.println("Main Thread Do something else.");
    }
}
