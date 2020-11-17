package codes.JAVA并发编程的艺术.并发工具类;

/**
 * # @author  chilcyWind
 * # @Time   2020/7/22 23:58
 * # @version 1.0
 * # @File : CyclicBarrierTest3.java
 * # @Software: IntelliJ IDEA
 */

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;



public class CyclicBarrierTest3 {
    static CyclicBarrier c = new CyclicBarrier(2);

    public static void main(String[] args) throws InterruptedException,BrokenBarrierException

    {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    c.await();
                } catch (Exception e) {
                }
            }
        });
        thread.start();
        thread.interrupt();
        try {
            c.await();
        } catch (Exception e) {
            System.out.println(c.isBroken());
        }
    }
}
