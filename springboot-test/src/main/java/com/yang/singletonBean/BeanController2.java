package com.yang.singletonBean;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * # @author  chilcyWind
 * # @Time   2020/11/22 14:52
 * # @version 1.0
 * # @File : BeanController2.java
 * # @Software: IntelliJ IDEA
 * 解决方案二  ThreadLocal解决问题
 */
@RestController
//@Scope("prototype")
public class BeanController2 {
    private static ThreadLocal<Integer> content = new ThreadLocal<Integer>() {
        @Override
        protected Integer initialValue() {
            return (int)(Math.random()*10+100);
        }
    };
    private static ThreadLocal<String> test = new ThreadLocal<String>() {
        @Override
        protected String initialValue() {
            return "单例模式是不安全的"+(int)(Math.random()*10+100);
        }
    };

    @RequestMapping("testBean")
    public Object getSercurity(){
        System.out.println(content.get());
        System.out.println(test.get());		System.out.println();
        return test.get();
    }
}