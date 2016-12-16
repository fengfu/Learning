package io.fengfu.learning.http;

import com.ning.http.client.AsyncCompletionHandler;
import com.ning.http.client.Response;
import qunar.hc.QProxyAsyncClient;

import java.io.IOException;

public class QProxyAsyncClientDemo {

    public static void main(String[] args) {

        String url = "http://ctripgroup.ctrip.com/flight/intlengine/feetaxquery";

        QProxyAsyncClient qac = new QProxyAsyncClient();
        // 异步的处理请求结果
        try {
            qac.get(url, new AsyncCompletionHandler<Boolean>() {

                // 请求成功后会回调这个方法
                @Override
                public Boolean onCompleted(Response response) throws Exception {

                    if (response.getStatusCode() == 200) {

                        System.out.println("===============================================");
                        System.out.println(response.getResponseBody());
                        System.out.println("===============================================");
                        //do something here
                        return true;
                    } else  {
                        //do something here
                        return false;
                    }
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
