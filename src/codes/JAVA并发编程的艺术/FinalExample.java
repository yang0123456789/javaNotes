package codes.JAVA并发编程的艺术;

import com.sun.org.apache.xpath.internal.FoundIndex;
import jdk.nashorn.internal.runtime.FindProperty;
import sun.applet.Main;

/**
 * # @author  chilcyWind
 * # @Time   2020/7/20 16:29
 * # @version 1.0
 * # @File : FinalExample.java
 * # @Software: IntelliJ IDEA
 */
public class FinalExample {
    int i; // 普通变量
    final int j; // final变量
    static FinalExample obj;

    public FinalExample() { // 构造函数
        i = 1; // 写普通域
        j = 2; // 写final域
       String s = "1";
        s = "2";


    }

    public static void writer() { // 写线程A执行

        obj = new FinalExample();

    }

    public static void reader() { // 读线程B执行

        FinalExample object = obj; // 读对象引用

        int a = object.i; // 读普通域

        int b = object.j; // 读final域

    }

    public static void main(String[] args) {
        FinalExample finalExample=new FinalExample();
    }

}
