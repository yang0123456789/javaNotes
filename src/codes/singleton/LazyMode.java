package codes.singleton;

/**
 * # @author  chilcyWind
 * # @Time   2020/11/12 19:14
 * # @version 1.0
 * # @File : LazyMode.java
 * # @Software: IntelliJ IDEA
 */
//方法3：简单判断非空（多线程并发不安全，单线程无影响）
public class LazyMode {
    private static LazyMode sLazyMode;

    private LazyMode() {
        System.out.println("create " + getClass().getSimpleName());
    }

    public static LazyMode getInstance(){
        if (sLazyMode == null) {
            sLazyMode = new LazyMode();
        }
        return sLazyMode;
    }

    public static void main(String[] args) {
        LazyMode.getInstance();
    }
}
