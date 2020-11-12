package codes.singleton;

/**
 * # @author  chilcyWind
 * # @Time   2020/11/12 19:19
 * # @version 1.0
 * # @File : DoubleCheckMode.java
 * # @Software: IntelliJ IDEA
 *
 *  多线程的单例模式，使用双重校验机制
 *  这样的写法就能够做到效率和安全的双重保证。
 *  但是有个问题，禁止指令重排优化这条语义直到jdk1.5以后才能正确工作。
 *  此前的JDK中即使将变量声明为volatile也无法完全避免重排序所导致的问题。
 *  所以，在jdk1.5版本前，双重检查锁形式的单例模式是无法保证线程安全的。不过现在的jdk环境大多数都是1.5之后的了，
 *  这个问题我们有个印象就行了。
 */

public class DoubleCheckMode {
    private volatile static DoubleCheckMode sDoubleCheckMode ;

    public DoubleCheckMode() {
        System.out.println(" created " + getClass().getSimpleName());
    }

    public static DoubleCheckMode getInstance() {
        if (sDoubleCheckMode == null)
            synchronized (DoubleCheckMode.class) {
                if (sDoubleCheckMode == null) {
                    sDoubleCheckMode = new DoubleCheckMode();
                }
            }
        return sDoubleCheckMode;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread() {
                @Override
                public void run() {
                    super.run();
                    System.out.println("thread" + getId());
                    DoubleCheckMode.getInstance();
                }
            }.start();
        }
    }
}
