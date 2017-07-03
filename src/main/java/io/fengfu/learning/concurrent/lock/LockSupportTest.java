package io.fengfu.learning.concurrent.lock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.LockSupport;

/**
 * Created by fengfu on 2016/12/26.
 */
public class LockSupportTest {
    private static final Logger logger = LoggerFactory.getLogger(LockSupportTest.class);

    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(20);

        CallerThread ct1 = new CallerThread(1);
        CallerThread ct2 = new CallerThread(2);
        CallerThread ct3 = new CallerThread(3);
        CallerThread ct4 = new CallerThread(4);
        CallerThread ct5 = new CallerThread(5);

        es.execute(ct1);
        es.execute(ct2);
        es.execute(ct3);
        es.execute(ct4);
        es.execute(ct5);

        es.shutdown();
    }

    static class AsynchronousThread extends Thread{
        private Thread t;
        public AsynchronousThread(String name, Thread t){
            super(name);
            this.t = t;
        }

        @Override
        public void run(){
            try {
                logger.info("Start to run:{}", this.getName());
                if (this.getName().endsWith("1")){
                    Thread.sleep(6000);
                }else{
                    Thread.sleep(2000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            logger.info("Thread:{} is done.", this.getName());
            LockSupport.unpark(this.t);
        }
    }

    static class CallerThread extends Thread{
        private int index;
        public CallerThread(int index){
            super("CallerThread-"+index);
            this.index = index;
        }

        @Override
        public void run(){
            AsynchronousThread at1 = new AsynchronousThread("AsynchronousThread-"+this.index, Thread.currentThread());
            at1.start();

            LockSupport.parkUntil(3000);
        }
    }
}
