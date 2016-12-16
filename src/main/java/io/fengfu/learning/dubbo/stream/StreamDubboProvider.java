package io.fengfu.learning.dubbo.stream;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.ServiceConfig;
import qunar.QunarServer;

import java.io.IOException;

/**
 * Created by fengfu.qu on 2016/7/26.
 */
public class StreamDubboProvider {
    public static void main(String[] args) throws IOException {
        QunarServer.setConfigName("qunar.xml");
        QunarServer.SERVER_START();

        ApplicationConfig appConfig = new ApplicationConfig("demo");
        ProtocolConfig protocolConfig = new ProtocolConfig("dubbo");
        protocolConfig.setPort(20881);

        RegistryConfig registryConfig = new RegistryConfig("zk.dev.corp.qunar.com:2181");
        registryConfig.setProtocol("zookeeper");
        registryConfig.setGroup("demo");

        init(appConfig, protocolConfig, registryConfig, new DataServiceImpl(), "demo");

        System.in.read();
    }

    private static void init(ApplicationConfig applicationConfig, ProtocolConfig protocolConfig, RegistryConfig registryConfig, IDataService dataService, String group){
        ServiceConfig<IDataService> dataServiceConfig = new ServiceConfig<IDataService>();
        dataServiceConfig.setApplication(applicationConfig);
        dataServiceConfig.setProtocol(protocolConfig);
        dataServiceConfig.setRegistry(registryConfig);
        dataServiceConfig.setInterface(IDataService.class);
        dataServiceConfig.setRef(dataService);
        dataServiceConfig.setGroup(group);
        dataServiceConfig.setVersion("0.0.1");
        dataServiceConfig.export();
    }
}