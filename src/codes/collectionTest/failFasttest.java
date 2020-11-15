package codes.collectionTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * # @author  chilcyWind
 * # @Time   2020/11/15 15:30
 * # @version 1.0
 * # @File : failFasttest.java
 * # @Software: IntelliJ IDEA
 */
public class failFasttest {

    public static void main(String[] args) {
        List<Integer> array = new ArrayList<>();
        array.add(1);
        array.add(2);
        array.add(3);

//        array.removeIf(i -> i == 2);

        Iterator<Integer> iterator = array.iterator();
        while (iterator.hasNext()) {
            Integer i = iterator.next();
            if (i == 3) {
                iterator.remove();
            }

        }

//
//        for (Integer i:array
//             ) {
//                if (3==i){
//                    array.remove(i);
//                }
//
//        }
        System.out.println(array);
    }
}
