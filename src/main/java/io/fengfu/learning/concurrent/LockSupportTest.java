package io.fengfu.learning.concurrent;

import java.util.concurrent.locks.LockSupport;

/**
 * Created by fengfu on 2016/12/26.
 */
public class LockSupportTest {
    public static void main(String[] args) {
        AsynchronousThread at1 = new AsynchronousThread("t1", Thread.currentThread());
        AsynchronousThread at2 = new AsynchronousThread("t2", Thread.currentThread());

        at1.start();

        LockSupport.park();
//        LockSupport.parkUntil(2000l);

        at2.start();

        System.out.println("Main thread done.");
    }
}

class AsynchronousThread extends Thread{
    private Thread t;
    public AsynchronousThread(String name, Thread t){
        super(name);
        this.t = t;
    }

    @Override
    public void run(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(this.getName() + " done.");
        LockSupport.unpark(this.t);
    }
}
