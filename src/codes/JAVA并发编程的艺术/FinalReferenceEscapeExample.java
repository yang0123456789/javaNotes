package codes.JAVA并发编程的艺术;

/**
 * # @author  chilcyWind
 * # @Time   2020/7/20 17:38
 * # @version 1.0
 * # @File : FinalReferenceEscapeExample.java
 * # @Software: IntelliJ IDEA
 */
public class FinalReferenceEscapeExample {

    final int i;

    static FinalReferenceEscapeExample obj;

    public FinalReferenceEscapeExample () {

        i = 1; // 1写final域

        obj = this; // 2 this引用在此"逸出"

    }

    public static void writer() {

        new FinalReferenceEscapeExample ();

    }

    public static void reader() {

        if (obj != null) { // 3

            int temp = obj.i; // 4

        }

    }

}

