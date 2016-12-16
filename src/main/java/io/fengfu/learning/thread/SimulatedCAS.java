package io.fengfu.learning.thread;

/**
 * Created with IntelliJ IDEA.
 * User: qufengfu
 * Date: 14-2-19
 * Time: 下午2:35
 * To change this template use File | Settings | File Templates.
 */
public class SimulatedCAS {
    private int value;

    public synchronized int get() {
        return value;
    }

    public synchronized int compareAndSwap(int expectedValue, int newValue) {
        int oldValue = value;
        if (oldValue == expectedValue)
            value = newValue;
        return oldValue;
    }

    public synchronized boolean compareAndSet(int expectedValue,
                                              int newValue) {
        return (expectedValue
                == compareAndSwap(expectedValue, newValue));
    }
}
