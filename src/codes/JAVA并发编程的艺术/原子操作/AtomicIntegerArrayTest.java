package codes.JAVA并发编程的艺术.原子操作;

import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * # @author  chilcyWind
 * # @Time   2020/7/22 22:45
 * # @version 1.0
 * # @File : AtomicIntegerArrayTest.java
 * # @Software: IntelliJ IDEA
 */
public class AtomicIntegerArrayTest {
    static int[] value = new int[]{1, 2};
    static AtomicIntegerArray ai = new AtomicIntegerArray(value);

    public static void main(String[] args) {
        ai.getAndSet(0, 3);
        System.out.println(ai.get(0));
        System.out.println(value[0]);
    }
}
