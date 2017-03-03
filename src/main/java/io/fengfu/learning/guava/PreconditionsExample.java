package io.fengfu.learning.guava;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by fengfu on 2016/12/19.
 */
public class PreconditionsExample {
    private String label;
    private int[] values = new int[5];
    private int currentIndex;

    public PreconditionsExample(String label){
        this.label = checkNotNull(label, "Label can not be null.");
    }

    public static void main(String[] args) {
        new PreconditionsExample(null);
    }
}
