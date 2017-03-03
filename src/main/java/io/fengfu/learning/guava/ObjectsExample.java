package io.fengfu.learning.guava;


import com.google.common.base.Objects;

/**
 * Created by fengfu on 2016/12/20.
 */
public class ObjectsExample {
    public static void main(String[] args) {
        Objects.firstNonNull(null, "");
    }
}
