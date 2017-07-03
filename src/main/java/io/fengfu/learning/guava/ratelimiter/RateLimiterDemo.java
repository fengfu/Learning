package io.fengfu.learning.guava.ratelimiter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import com.google.common.util.concurrent.RateLimiter;

/**
 * Created by fengfu on 2017/6/30.
 */
public class RateLimiterDemo {

    private int permitsPerSecond = 2; //每秒许可数量
    private int threadNum = 10;

    public static void main(String[] args) {

        new RateLimiterDemo().call();
    }

    private void call() {

        ExecutorService executor = Executors.newFixedThreadPool(threadNum);
        final RateLimiter rateLimiter = RateLimiter.create(permitsPerSecond);
        for (int i=0; i<threadNum; i++) {
            executor.execute(new ApiCallTask(rateLimiter));
        }

        executor.shutdown();
    }
}

class ApiCallTask implements Runnable{
    private RateLimiter rateLimiter;
    private boolean runing = true;
    public ApiCallTask(RateLimiter rateLimiter) {
        this.rateLimiter = rateLimiter;
    }

    public void run() {

        while(runing){
            rateLimiter.acquire(); // may wait
            getData();
        }
    }

    /**模拟调用合作伙伴API接口*/
    private void getData(){
        System.out.println(Thread.currentThread().getName()+" runing!");
        try {
            TimeUnit.MILLISECONDS.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
