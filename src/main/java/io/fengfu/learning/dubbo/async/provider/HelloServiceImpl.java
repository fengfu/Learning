package io.fengfu.learning.dubbo.async.provider;

import com.alibaba.dubbo.rpc.RpcContext;
import io.fengfu.learning.dubbo.async.consumer.HelloService;

/**
 * Created by fengfu.qu on 2016/3/22.
 */
public class HelloServiceImpl implements HelloService {
    public String sayHello(String name) {
        RpcContext.getContext();

        return null;
    }
}
