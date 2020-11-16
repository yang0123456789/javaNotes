package codes.JVMstudy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * # @author  chilcyWind
 * # @Time   2020/7/10 10:52
 * # @version 1.0
 * # @File : fanxingTest.java
 * # @Software: IntelliJ IDEA
 */
public class fanxingTest {
    //    public static void method(List<String> list) {
//        System.out.println("invoke method(List<String> list)");
//    }
//
//    public static void method(List<Integer> list) {
//        System.out.println("invoke method(List<Integer> list)");
//    }


    public static void main(String[] args) {
//        method(new ArrayList<String>()); method(new ArrayList<Integer>());
        Map<String, String> map = new HashMap<String, String>();
        map.put("hello", "你好");
        map.put("how are you?", "吃了没？");
        System.out.println(map.get("hello"));
        System.out.println(map.get("how are you?"));
        ArrayList<Integer> ilist = new ArrayList<Integer>();
        ArrayList<Long> llist = new ArrayList<Long>();
        ArrayList list;
        list = ilist;
        list = llist;

//        List<Integer> list2 = Arrays.asList(1, 2, 3, 4);
//        int sum = 0;
//        for ( int j : list) {
//            sum +=j;
//        }
//        System.out.println(sum);

        Integer a = 1;
        Integer b = 2;
        Integer c = 3;
        Integer d = 3;
        Integer e = 321;
        Integer f = 321;
        Long g = 3L;
        System.out.println(c == d);
        System.out.println(e == f);
        System.out.println(c == (a + b));
        System.out.println(c.equals(a + b));
        System.out.println(g == (a + b));
        System.out.println(g.equals(a + b));
    }
}
