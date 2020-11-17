package codes.JAVA并发编程的艺术;

/**
 * # @author  chilcyWind
 * # @Time   2020/7/20 22:00
 * # @version 1.0
 * # @File : Auxiliaryclass.java
 * # @Software: IntelliJ IDEA
 */
public class Instance {

    private  int i;
    private  final int j=0;
    private final void setI(int i){
        this.i=i;
    }
    private final void test(){}
    class InstaceSon extends Instance{

        private void test(){}
    }


}
