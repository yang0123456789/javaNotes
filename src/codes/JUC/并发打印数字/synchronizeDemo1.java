package codes.JUC.并发打印数字;

import codes.proxyTest.jdkProxy.MAIN;

/**
 * # @author  chilcyWind
 * # @Time   2020/11/17 14:40
 * # @version 1.0
 * # @File : RunnableDemo1.java
 * # @Software: IntelliJ IDEA
 */

//synchronize关键字实现
public class synchronizeDemo1 {
    public static void main(String[] args) {
        Thread thread1=new Thread(new thread1(1));
        Thread thread2=new Thread(new thread1(0));
        thread1.start();
        thread2.start();
    }

    static class thread1 implements Runnable {
        private static Object lock = new Object();

        private static int count =0 ;

        int no;

        public thread1(int no){
            this.no = no;
        }
        @Override
        public void run() {
            while (true) {
                synchronized (lock) {
                    if (count > 100) {
                        break;
                    }
                    if (count % 2 == this.no) {
                        System.out.println(this.no +  "--->" + count);
                        count++;
                    } else {
                        try {
                            lock.wait();
                        } catch (InterruptedException e)  {
                            e.printStackTrace();
                        }
                    }
                    lock.notifyAll();
                }
            }
        }
    }

}

