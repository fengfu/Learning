package io.fengfu.learning.dubbo.async.consumer;

/**
 * Created by fengfu.qu on 2016/3/22.
 */

@Async
public interface HelloService {
    String sayHello(String name);
}
