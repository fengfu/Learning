package io.fengfu.learning.string;

/**
 * Created by fengfu.qu on 2016/6/23.
 */
public class InternSample {
    private static void test1(){
        String s = new String("1");
        s.intern();
        String s2 = "1";
        System.out.println(s == s2);

        String s3 = new String("1") + new String("1");
        s3.intern();
        String s4 = "11";
        System.out.println(s3 == s4);
    }

    private static void test2(){
        String s = new String("1");
        String s2 = "1";
        s.intern();
        System.out.println(s == s2);

        String s3 = new String("1") + new String("1");
        String s4 = "11";
        s3.intern();
        System.out.println(s3 == s4);
    }

    public static void main(String[] args) {
        test1();

        test2();
    }
}
