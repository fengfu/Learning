package io.fengfu.learning.thread;

/**
 * Created with IntelliJ IDEA.
 * User: qufengfu
 * Date: 14-2-19
 * Time: 下午2:33
 *代码 1 使用CAS实现的非阻塞计数器
 */
public class CasCounter {
    private SimulatedCAS value;
    public int getValue() {
        return value.get();
    }
    public int increment() {
        int v;
        do {
            v = value.get();  //1
        }
        while (v != value.compareAndSwap(v, v + 1));  //2
        return v + 1;
    }
}