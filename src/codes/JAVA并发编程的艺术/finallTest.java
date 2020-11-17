package codes.JAVA并发编程的艺术;

/**
 * # @author  chilcyWind
 * # @Time   2020/7/20 16:39
 * # @version 1.0
 * # @File : finallTest.java
 * # @Software: IntelliJ IDEA
 */
public class finallTest {

//    https://www.cnblogs.com/Xieyang-blog/p/8306480.html

    public static void main(String[] args) {

        final byte a1=1,b1=1,b11;
        final char a2='a',b2='a',b22;
        final short a3=3,b3=3,b33;
        final int a4=4,b4=4,b44;
        final long a5=5,b5=5,b55;
        final float a6=6,b6=6,b66;
        final double a7=7,b7=7,b77;

        //等号右边，被final修饰的为byte,short,char,int中的任何一种；等号左边可以为byte、short、char、int、long、float、double中的任何一种都不会出错
//        b11=a1+a2;
        b11=a2+a3;
        b22=a3+a3;
        b33=a4+a3;
        b44=a2+a3;
        b55=a1+a3;
        b66=a2+a3;
        b77=a4+a3;

//        //等号右边，被final修饰的为long、float、double中的任何一种；等号左边类型必须等于或者高于等号右边类型才不会出错，否则出错。
//        b11=a4+a5;   //编译时出错 类型不匹配：不能从 long 转换为 byte
//        b22=a5+a5;   //编译时出错 类型不匹配：不能从 long 转换为 char
//        b33=a5+a5;   //编译时出错 类型不匹配：不能从 long 转换为 short
//        b44=a5+a5;   //编译时出错 类型不匹配：不能从 long 转换为 int
//        b55=a6+a6;   //编译时出错 类型不匹配：不能从 float 转换为 long
//        b66=a5+a6;
//        b77=a7+a2;
//        final int a=0;
//        a=5;
    }
}