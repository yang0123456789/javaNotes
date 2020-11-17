package codes.JAVA并发编程的艺术.notifyTest;

/**
 * # @author  chilcyWind
 * # @Time   2020/7/21 16:56
 * # @version 1.0
 * # @File : Producer.java
 * # @Software: IntelliJ IDEA
 */
//生产者
public class Producer extends Thread{
    //每次生产的数量
    private int num ;

    //所属的仓库
    public AbstractStorage abstractStorage;

    public Producer(AbstractStorage abstractStorage){
        this.abstractStorage = abstractStorage;
    }

    public void setNum(int num){
        this.num = num;
    }

    // 线程run函数
    @Override
    public void run()
    {
        produce(num);
    }

    // 调用仓库Storage的生产函数
    public void produce(int num)
    {
        abstractStorage.produce(num);
    }
}