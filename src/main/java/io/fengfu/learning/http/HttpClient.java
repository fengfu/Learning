package io.fengfu.learning.http;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLContexts;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.SSLContext;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by fengfu.qu on 2016/8/16.
 */
public class HttpClient {
    private static final Logger logger = LoggerFactory.getLogger(HttpClient.class);

//    private static final CloseableHttpClient httpclient = HttpClientBuilder.create().disableContentCompression().build();
    private static final CloseableHttpClient httpclient = HttpClients.createDefault();

    private static final int DEFAULT_HTTP_TIME_OUT = 2000;

    private static final String DEFAULT_GET_RESPONSE_CHARSET = "UTF-8";

    /**
     * 通过apache的httpclient实现的post请求
     * @throws IOException
     */
    public static String doPost(String url, Map<String, String> header, Map<String, String> param, int timeoutTime) throws IOException {
        if (timeoutTime <= 0) {
            timeoutTime = DEFAULT_HTTP_TIME_OUT;
        }
        logger.info("post url:{}， params:{}", url, param);
        HttpPost httpPost = new HttpPost(url);


        // 设置请求和传输超时时间
        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectTimeout(timeoutTime)
                .setSocketTimeout(timeoutTime)
                .build();
        httpPost.setConfig(requestConfig);

        //设置header
        for (Map.Entry<String, String> entry : header.entrySet()) {
            httpPost.addHeader(entry.getKey(), entry.getValue());
        }

        // 拼接参数
        List<NameValuePair> formParams = new ArrayList();
        for (Map.Entry<String, String> entry : param.entrySet()) {
            formParams.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
        }

        httpPost.setEntity(new UrlEncodedFormEntity(formParams));
//        httpPost.setEntity(new GzipCompressingEntity(new ByteArrayEntity());

        CloseableHttpResponse response = httpclient.execute(httpPost);
        HttpEntity entity = response.getEntity();
        return EntityUtils.toString(entity, DEFAULT_GET_RESPONSE_CHARSET);
    }

    /**
     * 通过apache的httpclient实现的post json请求
     * @throws IOException
     */
    public static String doPost(String url, Map<String, String> header, String json, int timeoutTime) throws IOException {
        if (timeoutTime <= 0) {
            timeoutTime = DEFAULT_HTTP_TIME_OUT;
        }
        logger.info("post url:{}， params:{}", url, json);
        HttpPost httpPost = new HttpPost(url);

        // 设置请求和传输超时时间
        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectTimeout(timeoutTime)
                .setSocketTimeout(timeoutTime)
                .build();
        httpPost.setConfig(requestConfig);

//        httpPost.addHeader("content-type", "application/json");
//        httpPost.addHeader("Accept","application/json");

        //设置header
        for (Map.Entry<String, String> entry : header.entrySet()) {
            httpPost.addHeader(entry.getKey(), entry.getValue());
        }

        httpPost.setEntity(new StringEntity(json, DEFAULT_GET_RESPONSE_CHARSET));
        CloseableHttpResponse response = httpclient.execute(httpPost);
        HttpEntity entity = response.getEntity();
        return EntityUtils.toString(entity, DEFAULT_GET_RESPONSE_CHARSET);
    }

    /**
     * 通过apache的httpclient实现的post请求
     * @param url 请求url
     * @param defaultCharset 响应编码格式
     * @param timeoutTime 超时时间（毫秒）
     * @throws IOException
     */
    public static String doGet(String url, String defaultCharset, int timeoutTime) throws IOException {
        if (timeoutTime <= 0) {
            timeoutTime = DEFAULT_HTTP_TIME_OUT;
        }
        if (StringUtils.isBlank(defaultCharset)) {
            defaultCharset = DEFAULT_GET_RESPONSE_CHARSET;
        }
        logger.info("get url:{}", url);
        HttpGet httpGet = new HttpGet(url);
        // 设置请求和传输超时时间
        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectTimeout(timeoutTime)
                .setSocketTimeout(timeoutTime)
                .build();
        httpGet.setConfig(requestConfig);
        CloseableHttpResponse response = httpclient.execute(httpGet);
        HttpEntity entity = response.getEntity();
        return EntityUtils.toString(entity, defaultCharset);
    }

    /**
     * 把调用参数拼接到url上
     */
    public static String createGetUrl(String url, Map<String, String> params ) {
//        URI uri = new URIBuilder()
//                .setScheme("http")
//                .setHost("www.google.com")
//                .setPath("/search")
//                .setParameter("q", "httpclient")
//                .setParameter("btnG", "Google Search")
//                .setParameter("aq", "f")
//                .setParameter("oq", "")
//                .build();
//        HttpGet httpget = new HttpGet(uri);

        if(StringUtils.isBlank(url)) {
            return null;
        }
        if(params == null || params.size() == 0) {
            return url;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(url);
        sb.append('?');
        for (String s : params.keySet()) {
            sb.append(s);
            sb.append('=');
            sb.append(params.get(s));
            sb.append('&');
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    public static void main(String[] args) {
        String url = "https://ctripgroup.ctrip.com/flight/intlengine/feetaxquery";

        String json = "{'accountCode':'','agencies':[],'ptc':'ADT','saleLocation':'','segment':[{'arr':'LAX','date':'2016-09-20','dep':'SHA','excludeCarrier':'','includeCarrier':''},{'arr':'SHA','date':'2016-09-30','dep':'LAX','excludeCarrier':'','includeCarrier':''}],'ticketLocaton':'NCN','token':'CTRIP','tripType':'RT'}";
//
        Map<String, String> headers = new HashMap<String, String>(2);
        headers.put("token", "CTRIP_20160815");
        headers.put("Accept-Encoding", "gzip,deflate");
//        headers.put("Content-Encoding", "gzip");

        Map<String, String> params = new HashMap<String, String>(1);
        params.put("request", json);

        try {
            SSLContext sslContext = SSLContexts.custom()
                    .loadTrustMaterial(null, new TrustStrategy() {

                        public boolean isTrusted(final X509Certificate[] chain, final String authType) throws CertificateException {
                            return true;
                        }
                    })
                    .useTLS()
                    .build();

            String result = HttpClient.doPost(url, headers, params, 10000);

            System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (KeyStoreException e) {
            e.printStackTrace();
        } catch (KeyManagementException e) {
            e.printStackTrace();
        }
    }
}
