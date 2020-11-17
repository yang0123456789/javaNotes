package codes.JAVA并发编程的艺术;

import java.util.Timer;
import java.util.concurrent.TimeUnit;

/**
 * # @author  chilcyWind
 * # @Time   2020/7/21 10:02
 * # @version 1.0
 * # @File : were.java
 * # @Software: IntelliJ IDEA
 */
public class Interrupted {

    public static void main(String[] args) throws Exception {

// sleepThread不停的尝试睡眠

        Thread sleepThread = new Thread(new SleepRunner(), "SleepThread");

        sleepThread.setDaemon(true);

// busyThread不停的运行

        Thread busyThread = new Thread(new BusyRunner(), "BusyThread");

        busyThread.setDaemon(true);

        long  start = System.currentTimeMillis();


        sleepThread.start();

        busyThread.start();

// 休眠5秒，让sleepThread和busyThread充分运行

        TimeUnit.SECONDS.sleep(5);

        sleepThread.interrupt();

        busyThread.interrupt();

        System.out.println("SleepThread interrupted is " + sleepThread.isInterrupted());

        System.out.println("BusyThread interrupted is " + busyThread.isInterrupted());
        long  end = System.currentTimeMillis();
        System.out.println("start time:" + start+ "; end time:" + end+ "; Run Time:" + (end - start) + "(ms)");

// 防止sleepThread和busyThread立刻退出SleepUtils.second(2);

    }

    static class SleepRunner implements Runnable {

        @Override

        public void run() {

            while (true) {

                SleepUtils.second(15);
                System.out.println("我在休眠");

            }

        }

    }

    static class BusyRunner implements Runnable {

        @Override

        public void run() {

            while (true) {

            }

        }

    }

}