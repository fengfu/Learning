package io.fengfu.learning.geo;

/**
 * 坐标工具
 *
 * @author Jackie
 */
public class CoordinateUtil {
    //地球半径
    private static double EARTH_RADIUS = 6378.137;

    /**
     * 毫秒格式转换为度
     *
     * @param msec 毫秒格式的坐标
     * @return 度格式的坐标
     */
    public static double msec2Degree(int msec) {
        return msec / 3600000;
    }

    /**
     * 度分->度度
     *
     * @param
     * @return
     */
    public static double dm2dd(int degree, double minute) {
        return degree + minute / 60;
    }

    /**
     * 将度数转换成角度
     *
     * @param d 纬度
     * @return 对应的角度
     */
    private static double degree2Radian(double d) {
        return d * Math.PI / 180.0;
    }

    /**
     * 计算两点之间的距离,单位米
     *
     * @param lng1 第一个点的经度
     * @param lat1 第一个点的纬度
     * @param lng2 第二个点的经度
     * @param lat2 第二个点的纬度
     * @return 两点之间的距离
     */
    public static double distance(double lat1, double lng1, double lat2, double lng2) {
        double radLat1 = degree2Radian(lat1);
        double radLat2 = degree2Radian(lat2);
        double a = radLat1 - radLat2;
        double b = degree2Radian(lng1) - degree2Radian(lng2);
        double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a / 2), 2) + Math.cos(radLat1)
                * Math.cos(radLat2) * Math.pow(Math.sin(b / 2), 2)));
        s = s * EARTH_RADIUS;
        s = Math.round(s * 10000) / 10;
        return s;
    }

    public static void main(String[] args) {
        System.out.println(CoordinateUtil.distance(40.303030923538358, 110.634734723428780, 40.300982431593980, 110.634719462833000));
        //110.634719462833000,40.300982431593980
//    System.out.println(Math.cos(90));
    }
}
