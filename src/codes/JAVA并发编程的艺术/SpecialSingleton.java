package codes.JAVA并发编程的艺术;

/**
 * # @author  chilcyWind
 * # @Time   2020/7/20 22:38
 * # @version 1.0
 * # @File : SpecialSingleton.java
 * # @Software: IntelliJ IDEA
 */



/**
 * 静态内部类实现单例模式
 * @author CrazyPig
 *
 */
public class SpecialSingleton {

    // 静态内部类
    private static class NestClass {
        private static SpecialSingleton instance;
        static {
            System.out.println("instance = new SingletonTest()");
            instance = new SpecialSingleton();
        }
    }   

    // 不能直接new
    private SpecialSingleton() {
        System.out.println("private SingletonTest()");
    }

    public static SpecialSingleton getInstance() {
        System.out.println("SingletonTest getInstance()");
        return NestClass.instance;
    }

    public static void main(String[] args) {
        SpecialSingleton instance = SpecialSingleton.getInstance();
        System.out.println("========================================");
        SpecialSingleton instance01 = SpecialSingleton.getInstance();
        System.out.println("========================================");
        SpecialSingleton instance02 = SpecialSingleton.getInstance();
    }

}