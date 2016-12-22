package io.fengfu.learning.thread.threadlocal;

/**
 * Created by fengfu on 2016/12/22.
 */
public class InheritableThreadlocalExample {
    InheritableThreadLocal<StringBuilder> a = new InheritableThreadLocal<StringBuilder>();
    InheritableThreadLocal<String> b = new InheritableThreadLocal<String>();

    public static void main(String[] args) throws InterruptedException {
        final InheritableThreadlocalExample test = new InheritableThreadlocalExample();

        test.a.set(new StringBuilder("main---hello"));
        test.b.set("main---zero");
        System.out.println(test.a.get());
        System.out.println(test.b.get());

        Thread thread1 = new Thread() {
            public void run() {
                System.out.println(test.a.get());
                System.out.println(test.b.get());
                StringBuilder a = test.a.get().append("---subThread");
                test.a.set(a);
                test.b.set("subThread--zero");
                System.out.println(test.a.get());
                System.out.println(test.b.get());
            };
        };
        thread1.start();
        thread1.join();

        System.out.println(test.a.get());
        System.out.println(test.b.get());
    }
}
