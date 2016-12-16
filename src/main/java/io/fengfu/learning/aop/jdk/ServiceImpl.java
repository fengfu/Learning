package io.fengfu.learning.aop.jdk;

/**
 * 被代理类，即目标类target
 *
 * Created by qufengfu on 14-3-11.
 */
public class ServiceImpl implements Service {
    /*
     * (non-Javadoc)
     *
     * @see jdkproxy.Service#add()
     */
    public void add() {
        System.out.println("ServiceImpl add>>>>>>>>>>>>>>>>>>");
    }

    /*
     * (non-Javadoc)
     *
     * @see jdkproxy.Service#update()
     */
    public void update() {
        System.out.println("ServiceImpl update>>>>>>>>>>>>>>>");
    }
}
