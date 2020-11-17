package codes.JAVA并发编程的艺术;

import java.util.concurrent.TimeUnit;

/**
 * # @author  chilcyWind
 * # @Time   2020/7/21 15:19
 * # @version 1.0
 * # @File : Profiler.java
 * # @Software: IntelliJ IDEA
 */
public class Profiler { // 第一次get()方法调用时会进行初始化（如果set方法没有调用），每个线程会调用一次

    private static final ThreadLocal<Long> TIME_THREADLOCAL = new ThreadLocal<Long>() {
        protected Long initialValue() {
            System.out.println(System.currentTimeMillis());
            return System.currentTimeMillis();
        }
    };

    public static final void begin() {
        TIME_THREADLOCAL.set(System.currentTimeMillis());
    }

    public static final long end() {
        return System.currentTimeMillis() - TIME_THREADLOCAL.get();
    }

    public static void main(String[] args) throws Exception {
        Profiler.begin();
        TimeUnit.SECONDS.sleep(1);
        System.out.println("Cost: " + Profiler.end() + " mills");
    }
}