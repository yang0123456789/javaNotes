package codes.JAVA并发编程的艺术;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * # @author  chilcyWind
 * # @Time   2020/7/21 9:09
 * # @version 1.0
 * # @File : MultiThread.java
 * # @Software: IntelliJ IDEA
 */
public class MultiThread{

    public static void main(String[] args) {

// 获取Java线程管理MXBean

        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();

// 不需要获取同步的monitor和synchronizer信息，仅获取线程和线程堆栈信息

        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false, false);

// 遍历线程信息，仅打印线程ID和线程名称信息

        for (ThreadInfo threadInfo : threadInfos) {

            System.out.println("[" + threadInfo.getThreadId() + "] " + threadInfo.

                    getThreadName());

        }

    }

}