package codes.JUC.并发打印;

/**
 * # @author  chilcyWind
 * # @Time   2020/11/17 13:56
 * # @version 1.0
 * # @File : 并发打印数字.java
 * # @Software: IntelliJ IDEA
 */
public class noLock {
    volatile boolean flag = false;

    public static void main(String[] args) throws InterruptedException {
        noLock o = new noLock();
        o.runThread();


    }

   void runThread()  throws InterruptedException {
        Thread thread1 = new Thread(new thread1());
        Thread thread2 = new Thread(new thread2());
        thread1.start();
        thread2.start();

    }

    class thread1 implements Runnable {

        @Override
        public void run() {
            int i = 0;
            while (i < 100) {
                if (flag == false) {
                    System.out.println(i);
                    i += 2;
                    flag = true;
                }

            }
        }
    }

    class thread2 implements Runnable {

        @Override
        public void run() {
            int i = 1;
            while (i < 100) {
                if (flag == true) {
                    System.out.println(i);
                    i += 2;
                    flag = false;
                }
            }
        }
    }
}
