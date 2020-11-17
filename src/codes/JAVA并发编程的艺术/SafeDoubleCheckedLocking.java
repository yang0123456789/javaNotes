package codes.JAVA并发编程的艺术;

/**
 * # @author  chilcyWind
 * # @Time   2020/7/20 22:09
 * # @version 1.0
 * # @File : SafeDoubleCheckedLocking.java
 * # @Software: IntelliJ IDEA
 */
public class SafeDoubleCheckedLocking {

    private volatile static Instance instance;

    public static Instance getInstance() {

        if (instance == null) {

            synchronized (SafeDoubleCheckedLocking.class) {

                if (instance == null)

                    instance = new Instance(); // instance为volatile，现在没问题了

            }

        }

        return instance;

    }

}