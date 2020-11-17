package codes.JUC.ThreadPoolTest;

import java.util.Date;
/**
 * # @author  chilcyWind
 * # @Time   2020/11/17 19:39
 * # @version 1.0
 * # @File : MyRunnable.java
 * # @Software: IntelliJ IDEA
 * 这是一个简单的Runnable类，需要大约5秒钟来执行其任务
 */
public class MyRunnable implements Runnable {

    private String command;

    public MyRunnable(String s) {
        this.command = s;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " Start. Time = " + new Date());
        processCommand();
        System.out.println(Thread.currentThread().getName() + " End. Time = " + new Date());
    }

    private void processCommand() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return this.command;
    }
}

