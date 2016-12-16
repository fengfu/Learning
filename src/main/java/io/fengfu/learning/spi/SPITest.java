package io.fengfu.learning.spi;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * Created by fengfu.qu on 2014/2/4.
 */
public class SPITest {
    public static void main(String[] args) {
        ServiceLoader<HelloService> loader = ServiceLoader.load(HelloService.class);
        Iterator<HelloService> it = loader.iterator();
        while(it.hasNext()){
            HelloService helloSPI = it.next();
            System.out.println(helloSPI.sayHello("Fengfu"));
        }
    }
}
