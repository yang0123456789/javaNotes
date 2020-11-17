package codes.JUC;

import java.text.SimpleDateFormat;
import java.util.Random;

/**
 * # @author  chilcyWind
 * # @Time   2020/11/17 15:16
 * # @version 1.0
 * # @File : ThreadLocalExample.java
 * # @Software: IntelliJ IDEA
 */
public class ThreadLocalExample2 implements Runnable {
    // SimpleDateFormat 不是线程安全的，所以每个线程都要有自己独立的副本
    private static final ThreadLocal<SimpleDateFormat> formatter = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyyMMdd HHmm"));
//    用ThreadLocal作为容器，当每个线程访问这个 formatter 变量时，ThreadLocal会为每个线程提供一份变量，各个线程互不影响。

    public static void main(String[] args) throws InterruptedException {
        ThreadLocalExample2 obj = new ThreadLocalExample2();
        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(obj, "" + i);
            Thread.sleep(new Random().nextInt(1000));
            t.start();
        }
    }

    @Override
    public void run() {
        System.out.println("Thread Name= " + Thread.currentThread().getName() + " default Formatter = " + formatter.get().toPattern());
//        System.out.println("Thread Name= " + Thread.currentThread().getName()+" threadlocal的值 = " + formatter.);

        try {
            Thread.sleep(new Random().nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //formatter pattern is changed here by thread, but it won't reflect to other threads
        formatter.set(new SimpleDateFormat());

        System.out.println("Thread Name= " + Thread.currentThread().getName() + " formatter = " + formatter.get().toPattern());
    }

}
