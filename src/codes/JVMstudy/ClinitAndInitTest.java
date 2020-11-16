package codes.JVMstudy;

/**
 * # @author  chilcyWind
 * # @Time   2020/9/1 21:18
 * # @version 1.0
 * # @File : ClinitAndInitTest.java
 * # @Software: IntelliJ IDEA
 */


public class ClinitAndInitTest {

    static ClinitAndInitTest test = new ClinitAndInitTest();

    // 静态语句块
    static {
        System.out.println("static statements block");
        // 注意 test 与 s 的声明位置
        System.out.println(test); // 调用类变量test, 未出现编译错误
//        System.out.println(s);    // 调用类变量s, 出现编译错误illegal forward reference
    }
    static String s = "string";


    public static void main(String[] args) {
        test.toString();
    }

}