package io.fengfu.learning.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by fengfu on 2017/1/11.
 */
public class DemoServiceProxy implements InvocationHandler {
    private Object subject;

    public DemoServiceProxy(Object subject) {
        this.subject = subject;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Before invoke...");
        method.invoke(subject, args);
        System.out.println("After invoke...");
        return null;
    }
}
