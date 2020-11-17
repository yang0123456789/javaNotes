package codes.JAVA并发编程的艺术;

/**
 * # @author  chilcyWind
 * # @Time   2020/7/20 17:18
 * # @version 1.0
 * # @File : test2.java
 * # @Software: IntelliJ IDEA
 */
public class test2 {
    private test2 test;
    public test2(){
        test =new test2();

    }

    public static void main(String[] args) {
        test2 test2=new test2();
    }
}
