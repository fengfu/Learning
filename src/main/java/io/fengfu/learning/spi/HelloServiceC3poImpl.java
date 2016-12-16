package io.fengfu.learning.spi;

/**
 * Created by fengfu.qu on 2014/2/4.
 */
public class HelloServiceC3poImpl implements HelloService {
    public String sayHello(String name) {
        return "Hello, " + name + ", I'm C3po.";
    }
}
