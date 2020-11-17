package codes.JAVA并发编程的艺术.并发工具类;

/**
 * # @author  chilcyWind
 * # @Time   2020/7/22 23:37
 * # @version 1.0
 * # @File : CyclicBarrierTest2.java
 * # @Software: IntelliJ IDEA
 */

import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest2 {
    static CyclicBarrier c = new CyclicBarrier(2, new A());

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

    static class A implements Runnable {
//       c.await();
        @Override
        public void run() {
            System.out.println(3);
        }
    }
}
