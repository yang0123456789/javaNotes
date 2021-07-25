package com.yang.singletonBean;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * # @author  chilcyWind
 * # @Time   2020/11/22 14:49
 * # @version 1.0
 * # @File : BeanController.java
 * # @Software: IntelliJ IDEA
 * 解决方式一：
 *
 * 在对应的类名上加上该注解@Scope("prototype")，表示每次调用该接口都会生成一个新的Bean。
 */
@RestController
//@Scope("prototype")
public class BeanController {

    private int content = 0;  //基本类型  线程不安全
    private String test = null;//引用类型  线程不安全

    @RequestMapping("testBean")
    public Object getSercurity() {
        System.out.println(content);
        System.out.println(test);
        content = 20;
        test = "单例模式是不安全的";
        return test;
    }
}
