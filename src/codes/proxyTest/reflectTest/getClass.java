package codes.proxyTest.reflectTest;

import codes.proxyTest.reflectTest.tem;

/**
 * # @author  chilcyWind
 * # @Time   2020/11/15 8:43
 * # @version 1.0
 * # @File : getClass.java
 * # @Software: IntelliJ IDEA
 */
public class getClass {
    public static void main(String[] args) throws ClassNotFoundException {
        String e=new String("获取类得class对象的四种方法");

//        1.知道具体类的情况下可以使用：
//        注意，这里传入的是类，而不是类的实例
        Class eClass1 = tem.class;

//        2.通过 Class.forName()传入类的路径获取：
//        Class.forName(className)方法，内部实际调用的是一个native方法
//              forName0(className, true, ClassLoader.getClassLoader(caller), caller);
//              第2个boolean参数表示类是否需要初始化，Class.forName(className)默认是需要初始化。
//一旦初始化，就会触发目标对象的 static块代码执行，static参数也会被再次初始化。
        Class tem = Class.forName("src/codes/proxyTest/tem");

//        3.通过对象实例instance.getClass()获取：
//        注意，这里传入的是类的实例
        Class aClass = e.getClass();

//        4.通过类加载器xxxClassLoader.loadClass()传入类路径获取
//        通过类加载器获取Class对象不会进行初始化，意味着不进行包括初始化等一些列步骤，静态块和静态对象不会得到执行
//        class clazz = ClassLoader.LoadClass("src/codes/proxyTest/tem");



    }
}
