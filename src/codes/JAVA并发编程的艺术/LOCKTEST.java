package codes.JAVA并发编程的艺术;

import java.util.concurrent.locks.ReentrantLock;

import static sun.misc.VM.getState;

/**
 * # @author  chilcyWind
 * # @Time   2020/7/20 15:42
 * # @version 1.0
 * # @File : LOCK.java
 * # @Software: IntelliJ IDEA
 */
public class LOCKTEST {

}

class ReentrantLockExample {
    int a = 0;
    ReentrantLock lock = new ReentrantLock();

    public void writer() {
        lock.lock(); // 获取锁
        try {
            a++;
        } finally {
            lock.unlock(); // 释放锁
        }
    }

    public void reader() {
        lock.lock(); // 获取锁
        try {
            int i = a;
//……
        } finally {
            lock.unlock(); // 释放锁
        }
    }

//    protected final boolean tryAcquire(int acquires) {
//
//        final Thread current = Thread.currentThread();
//
//        int c = getState(); // 获取锁的开始，首先读volatile变量state
//
//        if (c == 0) {
//
//            if (isFirst(current) &&
//
//                    compareAndSetState(0, acquires)) {
//
//                setExclusiveOwnerThread(current);
//
//                return true;
//
//            }
//
//        }
//
//        else if (current == getExclusiveOwnerThread()) {
//
//            int nextc = c + acquires;
//
//            if (nextc < 0)
//
//                throw new Error("Maximum lock count exceeded");
//
//            setState(nextc);
//
//            return true;
//
//        }
//
//        return false;
//
//    }





}