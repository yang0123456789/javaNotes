package codes.JAVA并发编程的艺术.lockTest;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * # @author  chilcyWind
 * # @Time   2020/7/21 21:20
 * # @version 1.0
 * # @File : LockUseCase.java
 * # @Software: IntelliJ IDEA
 */
public class LockUseCase {
    void lockdemo() {
        Lock lock = new ReentrantLock();
        lock.lock();
        try {
        } finally {
            lock.unlock();
        }
    }
}
