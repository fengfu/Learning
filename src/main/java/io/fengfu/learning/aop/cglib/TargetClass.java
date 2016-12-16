package io.fengfu.learning.aop.cglib;

/**
 * 被代理类，即目标对象target
 * Created by qufengfu on 14-3-11.
 */
public class TargetClass {
    /**
     * 一个模拟的add方法
     */
    public void add() {
        System.out.println("add ------------");
    }
}
