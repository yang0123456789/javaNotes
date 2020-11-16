package codes.JVMstudy;

/**
 * # @author  chilcyWind
 * # @Time   2020/9/1 10:28
 * # @version 1.0
 * # @File : Finalizer.java
 * # @Software: IntelliJ IDEA
 */
public class Finalizer {

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Finalizer-->finalize()");
    }

    public static void main(String[] args) throws Throwable {
        Finalizer f = new Finalizer();
        f = null;

        System.gc();//手动请求gc
       f.finalize();
    }
}
//输出 Finalizer-->finalize()
