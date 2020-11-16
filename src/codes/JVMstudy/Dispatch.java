package codes.JVMstudy;

/**
 * # @author  chilcyWind
 * # @Time   2020/7/9 17:41
 * # @version 1.0
 * # @File : Dispatch.java
 * # @Software: IntelliJ IDEA
 */

/*** 单分派、多分派演示 * @author zzm */
public class Dispatch {
    static class QQ {
    }

    static class _360 {
    }

    public static class Father {
        public void hardChoice(QQ arg) {
            System.out.println("father choose qq");
        }

        public void hardChoice(_360 arg) {
            System.out.println("father choose 360");
        }
    }

    public static class Son extends Father {
        public void hardChoice(QQ arg) {
            System.out.println("son choose qq");
        }

        public void hardChoice(_360 arg) {
            System.out.println("son choose 360");
        }
    }

    public static void main(String[] args) {
        Father father = new Father();
        Father son = new Son();
        father.hardChoice(new _360());
        son.hardChoice(new QQ());
        int[][][] array = new int[1][0][-1];
    }
}
