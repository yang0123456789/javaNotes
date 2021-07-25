package codes.collectionTest;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * # @author  chilcyWind
 * # @Time   2020/11/25 11:18
 * # @version 1.0
 * # @File : fanixng2.java
 * # @Software: IntelliJ IDEA
 */
public class fanixng2 {
    public static void main(String[] args) throws Exception {
        ArrayList<Integer> list = new ArrayList<>();

        list.add(12);
//这里直接添加会报错
//        list.add("a");
        Class<? extends List> clazz = list.getClass();
        Method add = clazz.getDeclaredMethod("add", Object.class);
//但是通过反射添加，是可以的
        add.invoke(list, "kl");

        System.out.println(list);
    }
}
