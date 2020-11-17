package codes.JAVA并发编程的艺术.lockTest;



import codes.JAVA并发编程的艺术.SleepUtils;

import java.util.concurrent.locks.Lock;

/**
 * # @author  chilcyWind
 * # @Time   2020/7/21 23:17
 * # @version 1.0
 * # @File : TwinsLockTest.java
 * # @Software: IntelliJ IDEA
 */
public class TwinsLockTest {
    public static void main(String[] args) {
        test();
    }
    public static void test() {
        final Lock lock = new TwinsLock();
        class Worker extends Thread {
            public void run() {
                while (true) {
                    lock.lock();
                    try {
                        SleepUtils.second(1);
                        System.out.println(Thread.currentThread().getName());
                        SleepUtils.second(1);
                    } finally {
                        lock.unlock();
                    }
                }
            }
        }// 启动10个线程
        for (int i = 0; i < 10; i++) {
            Worker w = new Worker();
            w.setDaemon(true);
            w.start();
        }// 每隔1秒换行
        for (int i = 0; i < 10; i++) {
            SleepUtils.second(1);
            System.out.println();
        }
    }
}
