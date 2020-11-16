package codes.JVMstudy;

/**
 * # @author  chilcyWind
 * # @Time   2020/9/1 21:40
 * # @version 1.0
 * # @File : ClassLoaderDemo.java
 * # @Software: IntelliJ IDEA
 */
public class ClassLoaderDemo {
    public static void main(String[] args) {
        System.out.println("ClassLodarDemo's ClassLoader is " + ClassLoaderDemo.class.getClassLoader());
        System.out.println("The Parent of ClassLodarDemo's ClassLoader is " + ClassLoaderDemo.class.getClassLoader().getParent());
        System.out.println("The GrandParent of ClassLodarDemo's ClassLoader is " + ClassLoaderDemo.class.getClassLoader().getParent().getParent());
    }
}
