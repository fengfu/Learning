package io.fengfu.learning.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by qufengfu on 14-3-5.
 */
public class LearningCallable {
    private static ExecutorService es = Executors.newCachedThreadPool();

    public void process(int id){
        DemoCallable dc = new DemoCallable(id);

        //通过线程池提交任务
        es.submit(dc);

    }

    public void stop(){
        //结束线程池
        es.shutdown();
    }

    public static class DemoCallable implements Callable{
        private int id;

        public DemoCallable(int id){
            this.id = id;
        }

        @Override
        public Boolean call() throws Exception {
            System.out.println("I'm Thread " + this.id);

            Thread.sleep(5000L);

            return true;
        }

    }
    public static void main(String args[]){
        LearningCallable lc = new LearningCallable();

        lc.process(1);
        lc.process(2);
        lc.process(3);

        lc.stop();

    }
}
