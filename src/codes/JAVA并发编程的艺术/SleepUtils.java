package codes.JAVA并发编程的艺术;

import java.util.concurrent.TimeUnit;

/**
 * # @author  chilcyWind
 * # @Time   2020/7/21 9:31
 * # @version 1.0
 * # @File : SleepUtils.java
 * # @Software: IntelliJ IDEA
 */
public class SleepUtils {
    public static final void second(long seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
        }
    }
}
