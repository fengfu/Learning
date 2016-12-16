package io.fengfu.learning.blocking;

/**
 * Created by fengfu.qu on 2015/6/6.
 */
public class Demo {
    public static void main(String[] args){
        Producer pro1 = new Producer(1);
        Producer pro2 = new Producer(2);
        Producer pro3 = new Producer(3);

        pro1.start();
        pro2.start();
        pro3.start();
    }
}
