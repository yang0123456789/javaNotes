package codes.JAVA并发编程的艺术.lockTest.ReentrantLockTest;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * # @author  chilcyWind
 * # @Time   2020/7/22 10:53
 * # @version 1.0
 * # @File : FairAndUnfairTest.java
 * # @Software: IntelliJ IDEA
 */
public class FairAndUnfairTest {
    private static Lock fairLock = new ReentrantLock2(true);
    private static Lock unfairLock = new ReentrantLock2(false);
    private static class ReentrantLock2 extends ReentrantLock {
        public ReentrantLock2(boolean fair) {
            super(fair);
        }

        public Collection<Thread> getQueuedThreads() {
            List<Thread> arrayList = new ArrayList<Thread>(super.getQueuedThreads());
            Collections.reverse(arrayList);
            return arrayList;
        }
    }

    public void fair() {
        testLock(fairLock);
    }


    public void unfair() {
        testLock(unfairLock);
    }

    private void testLock(Lock lock) {
        // 启动5个Job（略）
    }

    private static class Job extends Thread {
        private Lock lock;

        public Job(Lock lock) {
            this.lock = lock;
        }

        public void run() {
        }
// 连续2次打印当前的Thread和等待队列中的Thread（略）
    }
}

