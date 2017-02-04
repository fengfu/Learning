package io.fengfu.learning.concurrent;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

/**
 * Created by fengfu on 2017/2/3.
 */
public class ForkJoinDemo extends RecursiveTask<Integer> {
    private final static int THRESHOLD = 2;

    private int start;
    private int end;

    public ForkJoinDemo(int start, int end){
        this.start = start;
        this.end = end;
    }

    protected Integer compute() {
        int sum = 0;
        if ((end - start) / 2 < THRESHOLD) {
            for (int i = start; i<= end; i++) {
                sum += i;
            }
        } else {
            int mid = (end-start)/2;
            ForkJoinDemo task1 = new ForkJoinDemo(start, mid);
            ForkJoinDemo task2 = new ForkJoinDemo(mid+1, end);

            task1.fork();
            task2.fork();

            sum = task1.join() + task2.join();
        }

        return sum;
    }

    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool();

        ForkJoinDemo demo = new ForkJoinDemo(1, 6);
        Future<Integer> result = forkJoinPool.submit(demo);

        try {
            System.out.println(result.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
