package io.fengfu.learning.proxy;

/**
 * Created by fengfu on 2017/1/11.
 */
public class DemoServiceImpl implements IDemoService {
    public void sayHello(String name) {
        System.out.println("Hello, " + name);
    }
}
