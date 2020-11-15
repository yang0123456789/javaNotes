package codes.collectionTest;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * # @author  chilcyWind
 * # @Time   2020/11/15 14:12
 * # @version 1.0
 * # @File : IteratorTest.java
 * # @Software: IntelliJ IDEA
 */
public class IteratorTest {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap();
        map.put(1, "Java");
        map.put(2, "C++");
        map.put(3, "PHP");
        Iterator<Map.Entry<Integer,String>> iterator=map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<Integer,String> entry=iterator.next();
            System.out.println(entry.getKey()+":"+entry.getValue());
        }
    }
}
