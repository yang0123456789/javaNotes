package codes.JUC.并发打印;

/**
 * # @author  chilcyWind
 * # @Time   2020/11/17 20:52
 * # @version 1.0
 * # @File : PrintXY.java
 * # @Software: IntelliJ IDEA
 * 两个线程输入xyyx
 */
public class PrintXY {
    static int x = 0;
    static int y = 0;
    static Object obj = new Object();
    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (obj) {
                    while (x < 2) {
                        while (y < 2 && x != 0) {
                            try {
                                obj.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        System.out.print("x");
                        x++;
                        obj.notify();
                    }
                }
            }
        });
        t1.setName("Therad1");

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (obj) {
                    while (y < 2) {
                        while (x == 0) {
                            try {
                                obj.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        System.out.print("y");
                        y++;
                        obj.notify();
                    }
                }
            }
        });
        t2.setName("Therad2");

        t1.start();
        t2.start();
    }
}