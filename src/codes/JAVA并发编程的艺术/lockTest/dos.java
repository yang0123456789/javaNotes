package codes.JAVA并发编程的艺术.lockTest;//package com.JAVA并发编程的艺术.lockTest;
//
//import java.util.concurrent.locks.LockSupport;
////import java.util.concurrent.locks.Node;
//
///**
// * # @author  chilcyWind
// * # @Time   2020/7/21 22:57
// * # @version 1.0
// * # @File : dos.java
// * # @Software: IntelliJ IDEA
// */
//public class dos {
//    private boolean doAcquireNanos(int arg, long nanosTimeout)
//
//            throws InterruptedException {
//
//        long lastTime = System.nanoTime();final Node node = addWaiter(Node.EXCLUSIVE);
//
//        boolean failed = true;
//
//        try {
//
//            for (;;) {
//
//                final Node p = node.predecessor();
//
//                if (p == head && tryAcquire(arg)) {
//
//                    setHead(node);
//
//                    p.next = null; // help GC
//
//                    failed = false;
//
//                    return true;
//
//                }
//
//                if (nanosTimeout <= 0)
//
//                    return false;
//
//                if (shouldParkAfterFailedAcquire(p, node)
//
//                        && nanosTimeout > spinForTimeoutThreshold)
//
//                    LockSupport.parkNanos(this, nanosTimeout);
//
//                long now = System.nanoTime();
//
////计算时间，当前时间now减去睡眠之前的时间lastTime得到已经睡眠
//
////的时间delta，然后被原有超时时间nanosTimeout减去，得到了
//
////还应该睡眠的时间
//
//                nanosTimeout -= now - lastTime;
//
//                lastTime = now;
//
//                if (Thread.interrupted())
//
//                    throw new InterruptedException();
//
//            }
//
//        } finally {
//
//            if (failed)
//
//                cancelAcquire(node);
//
//        }
//
//    }
//}
