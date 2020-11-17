package codes.JUC;

/**
 * # @author  chilcyWind
 * # @Time   2020/11/17 12:31
 * # @version 1.0
 * # @File : synSingleton.java
 * # @Software: IntelliJ IDEA
 */
public class synSingleton {
    private volatile static  synSingleton instance;
    private synSingleton(){

    }
    public static synSingleton getInstance(){
        if (synSingleton.instance==null){
            synchronized (synSingleton.class){
                if (instance==null){
                    instance=new synSingleton();
                }
            }
        }
        return instance;
    }
}
