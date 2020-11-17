package codes.JAVA并发编程的艺术;

/**
 * # @author  chilcyWind
 * # @Time   2020/9/16 11:27
 * # @version 1.0
 * # @File : Buffer.java
 * # @Software: IntelliJ IDEA
 */
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


class Buffer {
    private  final Lock lock;
    private  final Condition notFull;
    private  final Condition notEmpty;
    private int	maxSize;
    private List<Date> storage;
    Buffer(int size){
        //使用锁lock，并且创建两个condition，相当于两个阻塞队列
        lock=new ReentrantLock();
        notFull=lock.newCondition();
        notEmpty=lock.newCondition();
        maxSize=size;
        storage=new LinkedList<>();
    }
    public void put()  {
        lock.lock();
        try {
            while (storage.size() ==maxSize ){//如果队列满了
                System.out.print(Thread.currentThread().getName()+": wait \n");;
                notFull.await();//阻塞生产线程
            }
            storage.add(new Date());
            System.out.print(Thread.currentThread().getName()+": put:"+storage.size()+ "\n");
            Thread.sleep(1000);
            notEmpty.signalAll();//唤醒消费线程
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            lock.unlock();
        }
    }

    public	void take() {
        lock.lock();
        try {
            while (storage.size() ==0 ){//如果队列kongle
                System.out.print(Thread.currentThread().getName()+": wait \n");;
                notEmpty.await();//阻塞消费线程
            }
            Date d=((LinkedList<Date>)storage).poll();
            System.out.print(Thread.currentThread().getName()+": take:"+storage.size()+ "\n");
            Thread.sleep(1000);
            notFull.signalAll();//唤醒生产线程

        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            lock.unlock();
        }
    }
}

class Producer implements Runnable{
    private Buffer buffer;
    Producer(Buffer b){
        buffer=b;
    }
    @Override
    public void run() {
        while(true){
            buffer.put();
        }
    }
}
class Consumer implements Runnable{
    private Buffer buffer;
    Consumer(Buffer b){
        buffer=b;
    }
    @Override
    public void run() {
        while(true){
            buffer.take();
        }
    }
}
public class Main{
    public static void main(String[] arg){
        Buffer buffer=new Buffer(10);
        Producer producer=new Producer(buffer);
        Consumer consumer=new Consumer(buffer);
        for(int i=0;i<3;i++){
            new Thread(producer,"producer-"+i).start();
        }
        for(int i=0;i<3;i++){
            new Thread(consumer,"consumer-"+i).start();
        }
    }
}

