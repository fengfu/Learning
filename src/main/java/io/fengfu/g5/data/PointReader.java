package io.fengfu.g5.data;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;

/**
 * Created by fengfu.qu on 2014/4/11.
 */
public class PointReader {
    public static void main(String[] args){
//        try {
//            FileInputStream fis = new FileInputStream("D:/G5/data/points.txt");
//
//            BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
//
//            String line;
//            double lat=0,lng=0;
//            String areaId="";
//
//            IGeoClient baidu = new BaiduMapClient();
//
//            while((line=reader.readLine())!=null){
//                String[] data = line.split(",");
//
//                if (data[1].equals(areaId)){
//                    double dist = CoordinateUtil.distance(lat, lng, new Double(data[7]).doubleValue(), new Double(data[6]).doubleValue());
//                    if (dist>2000){
//                        lat = new Double(data[7]).doubleValue();
//                        lng = new Double(data[6]).doubleValue();
//
//                        GeoPoint[] gps = baidu.WGS84toBD09(new GeoPoint(lat, lng));
//
//                        System.out.printf("%s,%s,%s\n", data[2], gps[0].getLat(), gps[0].getLng());
//
//                        Thread.sleep(100L);
//                    }
//                }else{
//                    areaId = data[1];
//                    lat = new Double(data[7]).doubleValue();
//                    lng = new Double(data[6]).doubleValue();
//
//                    GeoPoint[] gps = baidu.WGS84toBD09(new GeoPoint(lat, lng));
//
//                    System.out.printf("%s,%s,%s\n", data[2], gps[0].getLat(), gps[0].getLng());
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }
}
