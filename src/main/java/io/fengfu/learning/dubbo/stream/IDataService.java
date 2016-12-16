package io.fengfu.learning.dubbo.stream;

import qunar.rpc.publish.StreamHook;

/**
 * Created by fengfu.qu on 2016/7/26.
 */
public interface IDataService {
    StreamHook loadAll();
}
