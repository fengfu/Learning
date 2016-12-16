package io.fengfu.learning.aop.cglib;

/**
 * Created by qufengfu on 14-3-11.
 */
public class CglibTest {
    public static void main(String args[]){
        CglibProxy proxy = new CglibProxy();
        TargetClass tc = CglibFactory.getInstance(proxy);
        tc.add();
    }
}
