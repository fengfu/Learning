package io.fengfu.learning.http;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

public class QunarHttpDemo {

    public static void main(String[] args) {

        String url = "http://publishfare.qunar.com/api/qfare/search";

        String requestString = "{\"segment\":[{\"dep\":\"SEL\",\"arr\":\"SHA\",\"date\":\"2016-09-18\",\"includeCarrier\":null,\"excludeCarrier\":null}],\"tripType\":\"OW\",\"saleLocation\":null,\"ticketLocaton\":null,\"ptc\":\"ADT\",\"token\":\"CTRIP\",\"agencies\":[],\"accountCode\":null}";

        byte[] requestBytes = requestString.getBytes();

        String responseStr = send(url, requestString);

        System.out.println(responseStr);
    }

    public static String send(String urlPost, String data) {
        URL url = null;
        HttpURLConnection connection = null;
        InputStream inputStream = null;
        try {
            url = new URL(urlPost);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setUseCaches(false);
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            connection.addRequestProperty("token", "CTRIP_20160815");

            Map<String, String> params = new HashMap();
            params.put("request", data);

            OutputStream outputStream = connection.getOutputStream();
            outputStream.write(getQuery(params).getBytes("UTF-8"));
            outputStream.flush();
            outputStream.close();

            inputStream = connection.getInputStream();

            ByteArrayOutputStream outSteam = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int len = -1;
            while ((len = inputStream.read(buffer)) != -1) {
                outSteam.write(buffer, 0, len);
            }
            outSteam.close();
            inputStream.close();
            return new String(outSteam.toByteArray(), "UTF-8");
        } catch (Exception ex) {
            ex.printStackTrace();
            return "";
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
    }

    private static String getQuery(Map<String, String> params) throws UnsupportedEncodingException {
        StringBuilder result = new StringBuilder();
        boolean first = true;

        for (Map.Entry<String, String> entry : params.entrySet()) {
            if (first) {
                first = false;
            } else {
                result.append("&");
            }

            result.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
            result.append("=");
            result.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
        }

        return result.toString();
    }
}
