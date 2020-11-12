package codes.singleton;

/**
 * # @author  chilcyWind
 * # @Time   2020/11/12 19:22
 * # @version 1.0
 * # @File : EnumMode.java
 * # @Software: IntelliJ IDEA
 * 利用枚举的方式实现单例，Android不推荐
 */
public enum EnumMode {
    INSTANCE;

    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
