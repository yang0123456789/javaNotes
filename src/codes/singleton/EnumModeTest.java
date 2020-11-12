package codes.singleton;

/**
 * # @author  chilcyWind
 * # @Time   2020/11/12 19:25
 * # @version 1.0
 * # @File : EnumModeTest.java
 * # @Software: IntelliJ IDEA
 */
public class EnumModeTest {
    public static void main(String[] args) {
        EnumMode ins=EnumMode.INSTANCE;
        System.out.println(ins.getId());

    }
}
