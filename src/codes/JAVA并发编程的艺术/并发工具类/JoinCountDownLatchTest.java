package codes.JAVA并发编程的艺术.并发工具类;

/**
 * # @author  chilcyWind
 * # @Time   2020/7/22 23:15
 * # @version 1.0
 * # @File : JoinCountDownLatchTest.java
 * # @Software: IntelliJ IDEA
 */
public class JoinCountDownLatchTest {
    public static void main(String[] args) throws InterruptedException {
        Thread parser1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("parser1 finish");
            }
        });
        Thread parser2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("parser2 finish");
            }
        });
        parser1.start();
        parser2.start();
        parser1.join();
        parser2.join();
        System.out.println("all parser finish");
    }
}
