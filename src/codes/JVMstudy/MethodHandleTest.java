package codes.JVMstudy;

/**
 * # @author  chilcyWind
 * # @Time   2020/7/9 21:05
 * # @version 1.0
 * # @File : MethodHandleTest.java
 * # @Software: IntelliJ IDEA
 */

/*** JSR 292 MethodHandle基础用法演示 * @author zzm */

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;

import static java.lang.invoke.MethodHandles.lookup;

/**
 * \* JSR 292 MethodHandle基础用法演示
 * <p>
 * \* @author zzm
 */

public class MethodHandleTest {

    static class ClassA {

        public void println(String s) {

            System.out.println(s);

        }

    }

    public static void main(String[] args) throws Throwable {

        Object obj = System.currentTimeMillis() % 2 == 0 ? System.out : new ClassA();

// 无论obj最终是哪个实现类，下面这句都能正确调用到println方法。
        System.out.println(obj.getClass());

        getPrintlnMH(obj).invokeExact("icyfenix");

    }

    private static MethodHandle getPrintlnMH(Object reveiver) throws Throwable {

// MethodType：代表“方法类型”，包含了方法的返回值（methodType()的第一个参数）和

//        具体参数（methodType()第二个及以后的参数）。

        MethodType mt = MethodType.methodType(void.class, String.class);

// lookup()方法来自于MethodHandles.lookup，这句的作用是在指定类中查找符合给定的方法名称、方法类型，并且符合调用权限的方法句柄。
// 因为这里调用的是一个虚方法，按照Java语言的规则，方法第一个参数是隐式的，代表该方法的接收者，也即this指向的对象，这个参数以
// 前是放在参数列表中进行传递，现在提供了bindTo()方法来完成这件事情。

        return lookup().findVirtual(reveiver.getClass(), "println", mt).bindTo(reveiver);

    }

}