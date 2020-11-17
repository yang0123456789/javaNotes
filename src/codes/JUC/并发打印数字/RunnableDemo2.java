package codes.JUC.并发打印数字;

/**
 * # @author  chilcyWind
 * # @Time   2020/11/17 14:58
 * # @version 1.0
 * # @File : RunnableDemo2.java
 * # @Software: IntelliJ IDEA
 */
public class RunnableDemo2 {
    public static void main(String[] args) {
        Thread thread1=new Thread(new printNum(0));
        Thread thread2=new Thread(new printNum(1));
        thread1.start();
        thread2.start();

    }

    static class printNum implements Runnable {
        public static Object lock = new Object();
        static int count = 0;
        int no;

        printNum(int no) {
            this.no = no;
        }

        @Override
        public void run() {
            while (true) {
                synchronized (this.lock) {
                    if (count > 100) break;
                    if (count % 2 == no) {
                        System.out.println("1====>" + count);
                        count++;
                    } else {
                        try {
                            lock.wait();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    lock.notifyAll();
                }
            }
        }
    }
}
