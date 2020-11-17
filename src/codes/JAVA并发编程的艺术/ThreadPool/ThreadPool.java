package codes.JAVA并发编程的艺术.ThreadPool;

/**
 * # @author  chilcyWind
 * # @Time   2020/7/21 16:10
 * # @version 1.0
 * # @File : ThreadPool.java
 * # @Software: IntelliJ IDEA
 */
public interface ThreadPool<Job extends Runnable> {
    // 执行一个Job，这个Job需要实现Runnable
    void execute(Job job);

    // 关闭线程池
    void shutdown();

    // 增加工作者线程
    void addWorkers(int num);

    // 减少工作者线程
    void removeWorker(int num);

    // 得到正在等待执行的任务数量
    int getJobSize();
}
