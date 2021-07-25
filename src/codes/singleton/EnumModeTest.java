package codes.singleton;

/**
 * # @author  chilcyWind
 * # @Time   2020/11/12 19:25
 * # @version 1.0
 * # @File : EnumModeTest.java
 * # @Software: IntelliJ IDEA
 */
public class EnumModeTest {
    public static void main(String[] args) {
        Thread t1=new Thread(new Runnable() {
            @Override
            public void run() {
                EnumMode ins=EnumMode.INSTANCE;
                ins.setId(5);
                System.out.println(Thread.currentThread().getName()+ins.getId());

            }
        },"t1");
        Thread t2=new Thread(new Runnable() {
            @Override
            public void run() {
                EnumMode ins=EnumMode.INSTANCE;
//                ins.setId(5);
                System.out.println(Thread.currentThread().getName()+ins.getId());

            }
        },"t2");
        t1.start();
        t2.start();

    }
}
