package codes.singleton;

/**
 * # @author  chilcyWind
 * # @Time   2020/11/12 19:12
 * # @version 1.0
 * # @File : HungryMode.java
 * # @Software: IntelliJ IDEA
 *
 *
 * 饿汉式单例，就是一个私有的构造方法加一个私有的静态当前类实例对象和一个公有的静态获取实例方法组成由于类实例对象为静态变量，所以在加载类的时候我们就会创建类的实例对象，这样的话比较消耗内存，浪费性能。
 * 可以用HungryMode.fun()方法验证，在直接调用这个方法的时候，会加载HungryMode这个类到内存中，并且也会实例话静态的类实例对象。所以运行效果为
 */
//方法1：静态变量方式（线程安全）
public class HungryMode {
    private static HungryMode sHungryMode = new HungryMode();

    private HungryMode() {
        System.out.println("create " + getClass().getSimpleName());
    }

    public static void fun(){
        System.out.println("call fun in HungryMode");
    }

    public static HungryMode getInstance(){
        return sHungryMode;
    }

    public static void main(String[] args) {
        HungryMode.fun();
    }
}
