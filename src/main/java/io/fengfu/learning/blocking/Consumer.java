package io.fengfu.learning.blocking;

import java.util.concurrent.BlockingQueue;

/**
 * Created by fengfu.qu on 2015/6/6.
 */
public class Consumer implements Runnable {
    private static BlockingQueue<Integer> queue=null;

    public Consumer(BlockingQueue<Integer> queue){
        this.queue = queue;
    }

    public void run() {
        try {
            while(true){
                Integer data = queue.take();
                System.out.println("~~~~~~~~~~消费:"+data);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
