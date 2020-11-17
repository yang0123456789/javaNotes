package codes.JAVA并发编程的艺术.原子操作;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * # @author  chilcyWind
 * # @Time   2020/7/22 23:05
 * # @version 1.0
 * # @File : AtomicIntegerFieldUpdaterTest.java
 * # @Software: IntelliJ IDEA
 */
public class AtomicIntegerFieldUpdaterTest {

// 创建原子更新器，并设置需要更新的对象类和对象的属性

    private static AtomicIntegerFieldUpdater<User> a = AtomicIntegerFieldUpdater.newUpdater(User.class, "old");
//    private static AtomicIntegerFieldUpdater<User> b = AtomicIntegerFieldUpdater.

//            newUpdater(User.class, "name");

    public static void main(String[] args) {

// 设置柯南的年龄是10岁

        User conan = new User("conan", 10);

// 柯南长了一岁，但是仍然会输出旧的年龄
        System.out.println(a.getAndIncrement(conan));


// 输出柯南现在的年龄
        System.out.println(a.get(conan));

    }

    public static class User {

        private String name;

        public volatile int old;

        public User(String name, int old) {

            this.name = name;

            this.old = old;

        }

        public String getName() {

            return name;

        }

        public int getOld() {

            return old;

        }

    }

}

