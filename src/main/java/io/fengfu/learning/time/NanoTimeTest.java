package io.fengfu.learning.time;

/**
 * Created by fengfu.qu on 2016/8/21.
 */
public class NanoTimeTest {
    public static void main(String[] args) throws Exception {
        while (true) {
            long start = System.nanoTime();
            for (int i = 0; i < 10000; i++)
                ;
            long end = System.nanoTime();
            long cost = end - start;
            if (cost < 0) {
                System.out.println("start: " + start + ", end: " + end + ", cost: " + cost);
            }
        }
    }
}
