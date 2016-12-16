package io.fengfu.learning.dubbo.stream;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.ReferenceConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.google.common.io.Closer;
import com.qunar.flight.api.service.IQueryOagInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import qunar.QunarServer;
import qunar.rpc.publish.StreamHook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by fengfu.qu on 2016/7/26.
 */
public class QueryOagInfoServiceConsumer {
    private static Logger logger = LoggerFactory.getLogger(QueryOagInfoServiceConsumer.class);

    public static void main(String[] args) {
        QunarServer.setConfigName("qunar.xml");
        QunarServer.SERVER_START();

        ApplicationConfig appConfig = new ApplicationConfig("f_flightdetail_data");
        ProtocolConfig protocolConfig = new ProtocolConfig("dubbo");
        protocolConfig.setPort(20881);

        RegistryConfig registryConfig = new RegistryConfig("zk.dev.corp.qunar.com:2181");
        registryConfig.setProtocol("zookeeper");
        registryConfig.setGroup("ttsi_data_oag_dev");

        ReferenceConfig<IQueryOagInfoService> referenceConfig = new ReferenceConfig<IQueryOagInfoService>();
        referenceConfig.setApplication(appConfig);
        referenceConfig.setRegistry(registryConfig);
        referenceConfig.setInterface(IQueryOagInfoService.class);
        referenceConfig.setTimeout(7200000);
        referenceConfig.setVersion("1.0.0");
//        referenceConfig.setGroup("demo");

        IQueryOagInfoService oagInfoService = referenceConfig.get();

        logger.info("Start to load data by oag service.");
        StreamHook hook = oagInfoService.loadAll(1);
        InputStream is = hook.openInputStream();

        Closer closer = Closer.create();
        closer.register(is);

        try {
            OutputStream fos = new FileOutputStream("d:/ctrip_oag.csv");
            closer.register(fos);

            byte[] buffer = new byte[1024];
            int bytesRead;
            //read from is to buffer
            while((bytesRead = is.read(buffer)) !=-1){
                fos.write(buffer, 0, bytesRead);
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
