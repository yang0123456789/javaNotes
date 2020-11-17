package codes.JAVA并发编程的艺术.lockTest.ConditionTest;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * # @author  chilcyWind
 * # @Time   2020/7/22 15:52
 * # @version 1.0
 * # @File : ConditionUseCase.java
 * # @Software: IntelliJ IDEA
 */
public class ConditionUseCase {
    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();
    Condition condition2 = lock.newCondition();

    public void conditionWait() throws InterruptedException {
        lock.lock();
        try {
            condition.await();
        } finally {
            lock.unlock();
        }
    }

    public void conditionSignal() throws InterruptedException {
        lock.lock();
        try {
            condition.signal();
        } finally {
            lock.unlock();
        }
    }
}
