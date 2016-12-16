package io.fengfu.learning.dubbo.stream;

import com.google.common.io.Closer;
import com.qunar.flight.api.service.IQueryOagInfoService;
import qunar.QunarServer;
import qunar.rpc.publish.PublishService;
import qunar.rpc.publish.StreamHook;
import qunar.rpc.publish.StreamPublisher;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by fengfu.qu on 2016/7/26.
 */
public class DataServiceImpl implements IDataService {
    private final PublishService ps;

    IQueryOagInfoService oagInfoService;

    public DataServiceImpl(){
        this.ps = (PublishService) QunarServer.getService("Publisher");
    }

    public StreamHook loadAll() {
        Closer closer = Closer.create();

        StreamPublisher streamPublisher = ps.createPublisher(true);
        OutputStream os = streamPublisher.openStream();
        closer.register(os);
        try{
            BufferedReader reader = new BufferedReader(new FileReader("d:/atpco/data/ATP.INTFTNTS.D150613.T2359"));
            closer.register(reader);

            String line;
            while((line = reader.readLine())!=null){
                os.write(line.getBytes());
                os.write("\r\n".getBytes());

//                os.flush();
            }
            //别忘了处理异常的代码
        } catch(Throwable t){
            try {
                closer.rethrow(t);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } finally{
            try {
                closer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //内容已经写入到流了，准备返回了
        return streamPublisher.publish();
    }
}