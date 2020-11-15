package codes.proxyTest.reflectTest;

/**
 * # @author  chilcyWind
 * # @Time   2020/11/15 8:47
 * # @version 1.0
 * # @File : tem.java
 * # @Software: IntelliJ IDEA
 */
public class tem {
    public  String value;
    public  Integer b;

    public void test1(String str1,String str2){

    }
    public void test2(String value){
        System.out.println("====================================");
        System.out.println("调用了tem的方法并且打印了："+value);
        System.out.println("====================================");

    }
    private   void privateMethod(){
        System.out.println("调用了私有的方法，并且修改了类的值："+this.value);

    }
}
