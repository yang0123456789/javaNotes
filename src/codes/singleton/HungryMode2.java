package codes.singleton;

/**
 * # @author  chilcyWind
 * # @Time   2020/11/12 19:28
 * # @version 1.0
 * # @File : HungryMode2.java
 * # @Software: IntelliJ IDEA
 *
 * 方法2：静态代码块方式（线程安全）
 */
public class HungryMode2 {
    /*1.将构造方法私有化，外部无法使用new*/
    private HungryMode2() {}

    /*2.内部静态代码块中创建对象*/
    private static HungryMode2 instence;
    static {
        instence = new HungryMode2();
    }

    /*3.对外获取实例的方法*/
    public static HungryMode2 getInstence() {
        return instence;
    }
}
