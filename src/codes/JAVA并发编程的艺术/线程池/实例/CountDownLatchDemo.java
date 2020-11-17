package codes.JAVA并发编程的艺术.线程池.实例;

/**
 * # @author  chilcyWind
 * # @Time   2020/7/21 15:56
 * # @version 1.0
 * # @File : CountDownLatchDemo.java
 * # @Software: IntelliJ IDEA
 */

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: 王琦 <QQ.Eamil>1124602935@qq.com</QQ.Eamil>
 * @Date: 2019-5-4 0004 9:43
 * @Description: 倒计时器示例:火箭发射
 */
public class CountDownLatchDemo implements Runnable{

    static final CountDownLatch latch = new CountDownLatch(10);
    static final CountDownLatchDemo demo = new CountDownLatchDemo();

    @Override
    public void run() {
        // 模拟检查任务
        try {
            Thread.sleep(new Random().nextInt(10) * 1000);
            System.out.println("check complete");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            //计数减一
            //放在finally避免任务执行过程出现异常，导致countDown()不能被执行
            latch.countDown();//当前线程调用此方法，则计数减一
        }
    }


    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newFixedThreadPool(10);
        for (int i=0; i<10; i++){
            exec.execute(demo);
        }

        // 等待检查
        latch.await();//阻塞当前线程，直到计数器的值为0

        // 发射火箭
        System.out.println("Fire!");
        // 关闭线程池
        exec.shutdown();
    }
}