package io.fengfu.learning.blocking;

/**
 * Created by fengfu.qu on 2015/6/6.
 */
public class Producer extends Thread {
    private int num;

    public Producer(int num){
        this.num = num;
    }

    public void run() {
        System.out.println("==========生产"+this.num);
        Dispatcher.put(this.num);
        System.out.println(">>>>>>>>>>放入"+this.num);
    }
}
