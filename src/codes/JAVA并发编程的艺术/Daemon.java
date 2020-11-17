package codes.JAVA并发编程的艺术;

/**
 * # @author  chilcyWind
 * # @Time   2020/7/21 9:48
 * # @version 1.0
 * # @File : Daemon.java
 * # @Software: IntelliJ IDEA
 */
public class Daemon {
    public static void main(String[] args) {
        Thread thread = new Thread(new DaemonRunner(), "DaemonRunner");
        thread.setDaemon(true);
        thread.start();
//        SleepUtils.second(3);
    }

    static class DaemonRunner implements Runnable {
        @Override
        public void run() {
            try {
                SleepUtils.second(2);
            } finally {
                System.out.println("DaemonThread finally run.");
            }
        }
    }
}