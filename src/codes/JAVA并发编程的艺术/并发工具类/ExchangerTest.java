package codes.JAVA并发编程的艺术.并发工具类;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * # @author  chilcyWind
 * # @Time   2020/7/23 8:27
 * # @version 1.0
 * # @File : ExchangerTest.java
 * # @Software: IntelliJ IDEA
 */
public class ExchangerTest {

    private static final Exchanger<String> exgr = new Exchanger<String>();

    private static ExecutorService threadPool =Executors.newFixedThreadPool(2);

    public static void main(String[] args) {

        threadPool.execute(new Runnable() {

            @Override

            public void run() {

                try {

                    String A = "银行流水A"; // A录入银行流水数据

//                    exgr.exchange(A);

                    String B = exgr.exchange(A);

                    System.out.println("A和B数据是否一致：" + A.equals(B) + "，A录入的是：" + A + "，B录入是：" + B);


                } catch (InterruptedException e) {

                }

            }

        });

        threadPool.execute(new Runnable() {

            @Override

            public void run() {

                try {

                    String B = "银行流水B"; // B录入银行流水数据
                     exgr.exchange(B);
//

//                    String A = exgr.exchange("B");
//                    System.out.println("A和B数据是否一致：" + A.equals(B) + "，A录入的是：" + A + "，B录入是：" + B);

                } catch (InterruptedException e) {

                }

            }

        });

        threadPool.shutdown();

    }

}