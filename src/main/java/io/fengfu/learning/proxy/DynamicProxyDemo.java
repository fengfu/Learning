package io.fengfu.learning.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * Created by fengfu on 2017/1/11.
 */
public class DynamicProxyDemo {
    public static void main(String[] args) {
        IDemoService demoService = new DemoServiceImpl();

        InvocationHandler handler = new DemoServiceProxy(demoService);

        IDemoService proxyService = (IDemoService) Proxy.newProxyInstance(handler.getClass().getClassLoader(),
                demoService.getClass().getInterfaces(), handler);

        proxyService.sayHello("Fengfu");
    }
}
