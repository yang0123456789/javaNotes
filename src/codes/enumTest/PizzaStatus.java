package codes.enumTest;

/**
 * # @author  chilcyWind
 * # @Time   2020/11/13 20:58
 * # @version 1.0
 * # @File : PizzaStatus.java
 * # @Software: IntelliJ IDEA
 */
public enum  PizzaStatus {
    ORDERED,
    READY,
    DELIVERED;

    public static void main(String[] args) {
        System.out.println(PizzaStatus.ORDERED.name());//ORDERED
        System.out.println(PizzaStatus.ORDERED);//ORDERED
        System.out.println(PizzaStatus.ORDERED.name().getClass());//class java.lang.String
        System.out.println(PizzaStatus.ORDERED.getClass());//class shuang.kou.enumdemo.enumtest.PizzaStatus

    }
}
