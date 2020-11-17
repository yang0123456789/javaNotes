package codes.JAVA并发编程的艺术;

/**
 * # @author  chilcyWind
 * # @Time   2020/7/20 22:36
 * # @version 1.0
 * # @File : TraditionalSingletion.java
 * # @Software: IntelliJ IDEA
 */


/**
 * 传统方式实现单例模式
 *
 *
 *
 */
public class TraditionalSingletion {

    // 单实例
    private static TraditionalSingletion instance;

    // 不让new
    private TraditionalSingletion() {
        System.out.println("private TraditionalSingletion()");
    }

    public synchronized static TraditionalSingletion getInstance() {
        System.out.println("TraditionalSingletion getInstance()");
        if (instance == null) {
            System.out.println("instance = new TraditionalSingletion()");
            instance = new TraditionalSingletion();
        }
        return instance;
    }

    public static void main(String[] args) {
        TraditionalSingletion instance = TraditionalSingletion.getInstance();
        System.out.println("========================================");
        TraditionalSingletion instance01 = TraditionalSingletion.getInstance();
        System.out.println("========================================");
        TraditionalSingletion instance02 = TraditionalSingletion.getInstance();
    }

}
