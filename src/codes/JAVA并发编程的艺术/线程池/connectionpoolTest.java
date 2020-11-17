package codes.JAVA并发编程的艺术.线程池;

/**
 * # @author  chilcyWind
 * # @Time   2020/7/23 8:55
 * # @version 1.0
 * # @File : connectionpoolTest.java
 * # @Software: IntelliJ IDEA
 */
public class connectionpoolTest {
//    public void execute(Runnable command) {
//
//        if (command == null)
//
//            throw new NullPointerException();
//
//// 如果线程数小于基本线程数，则创建线程并执行当前任务
//
//        if (poolSize >= corePoolSize || !addIfUnderCorePoolSize(command)) {
//
//// 如线程数大于等于基本线程数或线程创建失败，则将当前任务放到工作队列中。
//
//            if (runState == RUNNING && workQueue.offer(command)) {
//
//                if (runState != RUNNING || poolSize == 0)
//
//                    ensureQueuedTaskHandled(command);
//
//            }
//
//// 如果线程池不处于运行中或任务无法放入队列，并且当前线程数量小于最大允许的线程数量，
//
//// 则创建一个线程执行任务。
//
//            else if (!addIfUnderMaximumPoolSize(command))
//
//// 抛出RejectedExecutionException异常
//
//                reject(command); // is shutdown or saturated
//
//        }
//
//    }
public static void main(String[] args) {
    int i = Runtime.getRuntime().availableProcessors();
    System.out.println(i);
}
}
