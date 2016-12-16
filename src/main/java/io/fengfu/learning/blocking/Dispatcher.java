package io.fengfu.learning.blocking;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created by fengfu.qu on 2015/6/6.
 */
public class Dispatcher {
    private static BlockingQueue<Integer> queue = new LinkedBlockingDeque<Integer>(2);
    private static ExecutorService executorService = Executors.newFixedThreadPool(2);

    static{
        Consumer con1 = new Consumer(queue);
        Consumer con2 = new Consumer(queue);
        executorService.execute(con1);
        executorService.execute(con2);
    }

    public static void put(Integer data){
        try {
            queue.put(data);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static Integer take(){
        try {
            return queue.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }
}
