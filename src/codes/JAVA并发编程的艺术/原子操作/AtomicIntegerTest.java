package codes.JAVA并发编程的艺术.原子操作;

/**
 * # @author  chilcyWind
 * # @Time   2020/7/22 22:26
 * # @version 1.0
 * # @File : AtomicIntegerTest.java
 * # @Software: IntelliJ IDEA
 */

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerTest {
    static AtomicInteger ai = new AtomicInteger(1);

    public static void main(String[] args) {
        System.out.println(ai.getAndIncrement());
        System.out.println(ai.get());
    }
}