package codes.JAVA并发编程的艺术;

/**
 * # @author  chilcyWind
 * # @Time   2020/9/2 19:43
 * # @version 1.0
 * # @File : Singleton.java
 * # @Software: IntelliJ IDEA
 */
public class Singleton {

    private volatile static Singleton uniqueInstance;
//    双重校验锁实现对象单例（线程安全）
    private Singleton() {
    }

    public  static Singleton getUniqueInstance() {
        //先判断对象是否已经实例过，没有实例化过才进入加锁代码
        if (uniqueInstance == null) {
            //类对象加锁
            synchronized (Singleton.class) {
                if (uniqueInstance == null) {
                    uniqueInstance = new Singleton();
                }
            }
        }
        return uniqueInstance;
    }
}
