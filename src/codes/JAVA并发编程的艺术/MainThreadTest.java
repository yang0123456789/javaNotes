package codes.JAVA并发编程的艺术;

import java.util.TimerTask;
import java.util.Timer;

/**
 * # @author  chilcyWind
 * # @Time   2020/7/21 10:34
 * # @version 1.0
 * # @File : MainThreadTest.java
 * # @Software: IntelliJ IDEA
 *
 * java当中的Timer定时器的4种使用方式
 * https://www.cnblogs.com/kkxwze/p/11168525.html
 */
public class MainThreadTest {
    public static void main(String[] args) {
        new Timer().schedule(new TimerTask(){

            @Override
            public void run() {
                System.out.println("Timer thread is running...");
            }

        }, 500, 500);

        System.out.println("Main thread ends!");
    }

}
