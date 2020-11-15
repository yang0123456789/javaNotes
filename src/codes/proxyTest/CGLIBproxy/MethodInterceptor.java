package codes.proxyTest.CGLIBproxy;


//import net.sf.cglib.proxy.MethodInterceptor;
//import net.sf.cglib.proxy.MethodProxy;
//
//import java.lang.reflect.Method;
/**
 * # @author  chilcyWind
 * # @Time   2020/11/15 8:30
 * # @version 1.0
 * # @File : MethodInterceptor.java
 * # @Software: IntelliJ IDEA
 */

//2.自定义 MethodInterceptor（方法拦截器）
public class MethodInterceptor
//        implements MethodInterceptor
{
    /**
     * @param o           被代理的对象（需要增强的对象）
     * @param method      被拦截的方法（需要增强的方法）
     * @param args        方法入参
     * @param methodProxy 用于调用原始方法
     */

//    @Override
//    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
//        //调用方法之前，我们可以添加自己的操作
//        System.out.println("before method " + method.getName());
//        Object object = methodProxy.invokeSuper(o, args);
//        //调用方法之后，我们同样可以添加自己的操作
//        System.out.println("after method " + method.getName());
//        return object;
//    }
}
