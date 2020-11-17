package codes.JAVA并发编程的艺术.notifyTest;

/**
 * # @author  chilcyWind
 * # @Time   2020/7/21 16:56
 * # @version 1.0
 * # @File : AbstractStorage.java
 * # @Software: IntelliJ IDEA
 */
//抽象仓库类
public interface AbstractStorage {
    void consume(int num);
    void produce(int num);
}
