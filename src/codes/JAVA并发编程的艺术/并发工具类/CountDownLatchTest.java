package codes.JAVA并发编程的艺术.并发工具类;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * # @author  chilcyWind
 * # @Time   2020/7/22 23:23
 * # @version 1.0
 * # @File : CountDownLatchTest.java
 * # @Software: IntelliJ IDEA
 */
public class CountDownLatchTest {
    static CountDownLatch c = new CountDownLatch(2);
    static Object o=new Object();

    public static void main(String[] args) throws InterruptedException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(1);
                c.countDown();
                System.out.println(2);
                c.countDown();
            }
        }).start();
        c.await();
//        o.wait(3);
        System.out.println("3");
    }
}