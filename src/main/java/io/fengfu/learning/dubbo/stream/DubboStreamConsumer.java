package io.fengfu.learning.dubbo.stream;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.ReferenceConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.google.common.io.Closer;
import qunar.QunarServer;
import qunar.rpc.publish.StreamHook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by fengfu.qu on 2016/7/26.
 */
public class DubboStreamConsumer {
    public static void main(String[] args) {
        QunarServer.setConfigName("qunar.xml");
        QunarServer.SERVER_START();

        ApplicationConfig appConfig = new ApplicationConfig("demo");
        ProtocolConfig protocolConfig = new ProtocolConfig("dubbo");
        protocolConfig.setPort(20881);

        RegistryConfig registryConfig = new RegistryConfig("zk.dev.corp.qunar.com:2181");
        registryConfig.setProtocol("zookeeper");
        registryConfig.setGroup("demo");

        ReferenceConfig<IDataService> referenceConfig = new ReferenceConfig<IDataService>();
        referenceConfig.setApplication(appConfig);
        referenceConfig.setRegistry(registryConfig);
        referenceConfig.setInterface(IDataService.class);
        referenceConfig.setTimeout(10000);
        referenceConfig.setVersion("0.0.1");
        referenceConfig.setGroup("demo");

        IDataService dataService = referenceConfig.get();

        StreamHook hook = dataService.loadAll();
        InputStream is = hook.openInputStream();

        Closer closer = Closer.create();
        closer.register(is);

        try {
            OutputStream os = new FileOutputStream("d:/testDubboStream.txt");
            closer.register(os);

            byte[] buffer = new byte[1024];
            int bytesRead;
            //read from is to buffer
            while((bytesRead = is.read(buffer)) !=-1){
                os.write(buffer, 0, bytesRead);
            }
        } catch (Throwable t) {
            try {
                closer.rethrow(t);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } finally {
            try {
                closer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        QunarServer.SERVER_STOP();
    }
}
