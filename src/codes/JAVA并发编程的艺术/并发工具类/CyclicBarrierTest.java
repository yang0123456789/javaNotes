package codes.JAVA并发编程的艺术.并发工具类;

import java.util.concurrent.CyclicBarrier;

/**
 * # @author  chilcyWind
 * # @Time   2020/7/22 23:34
 * # @version 1.0
 * # @File : CyclicBarrierTest.java
 * # @Software: IntelliJ IDEA
 */
public class CyclicBarrierTest {
    static CyclicBarrier c = new CyclicBarrier(3);

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    c.await();
                } catch (Exception e) {
                }
                System.out.println(1);
            }
        }).start();
        try {
            c.await();
        } catch (Exception e) {
        }
        System.out.println(2);
    }
}