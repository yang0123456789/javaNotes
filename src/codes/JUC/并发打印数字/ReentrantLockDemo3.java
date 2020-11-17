package codes.JUC.并发打印数字;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * # @author  chilcyWind
 * # @Time   2020/11/17 15:05
 * # @version 1.0
 * # @File : RunnableDemo3.java
 * # @Software: IntelliJ IDEA
 */
public class ReentrantLockDemo3 {
    public static void main(String[] args) throws  InterruptedException{
        Thread t1 = new Thread(new TestDemo2(0));
        Thread t2 = new Thread(new TestDemo2(1));
        Thread t3 = new Thread(new TestDemo2(2));
        t1.start();
        t2.start();
        t3.start();
        t1.join();
        t2.join();
        t3.join();
    }
    //ReentrantLock实现
    public static class TestDemo2 implements Runnable{
        private int no;
        private static ReentrantLock lock = new  ReentrantLock();
        private static Condition condition =  lock.newCondition();
        private static int count;
        public TestDemo2(int no){
            this.no = no;
        }

        @Override
        public void run() {
            while (true){
                lock.lock();
                if (count>100){
                    break;
                }else {
                    if (count%3 == this.no){
                        System.out.println(this.no+"-->"+count);
                        count++;
                    }else {
                        try {
                            condition.await();
                        } catch (InterruptedException e)  {
                            e.printStackTrace();
                        }
                    }
                }
                condition.signalAll();
                lock.unlock();
            }
        }
    }

}
