package codes.proxyTest.jdkProxy;

import java.lang.reflect.Proxy;

/**
 * # @author  chilcyWind
 * # @Time   2020/11/15 0:07
 * # @version 1.0
 * # @File : JdkProxyFactory.java
 * # @Software: IntelliJ IDEA
 * Proxy 类中使用频率最高的方法是：newProxyInstance() ，这个方法主要用来生成一个代理对象。
 */
//4.获取代理对象的工厂类
public class JdkProxyFactory {
    /**
     *
     * @param target 被代理的类
     * @return 生成一个代理对象
     * getProxy() ：主要通过Proxy.newProxyInstance（）方法获取某个类的代理对象
     */
    public static Object getProxy(Object target) {
        /**
         * ClassLoader  loader :类加载器，用于加载代理对象。
         * Class<?>[] interfaces : 被代理类实现的一些接口；
         * InvocationHandler  h : 实现了 InvocationHandler 接口的对象；
         */
        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(), // 目标类的类加载
                target.getClass().getInterfaces(),  // 代理需要实现的接口，可指定多个
                new DebugInvocationHandler(target)   // 代理对象对应的自定义 InvocationHandler
        );
    }
}
