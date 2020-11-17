package codes.JAVA并发编程的艺术;

/**
 * # @author  chilcyWind
 * # @Time   2020/7/20 22:11
 * # @version 1.0
 * # @File : InstanceFactory.java
 * # @Software: IntelliJ IDEA
 */
public class InstanceFactory {

    private static class InstanceHolder {

        public static Instance instance = new Instance();

    }

    public static Instance getInstance() {

        return InstanceHolder.instance ; // 这里将导致InstanceHolder类被初始化

    }

}
