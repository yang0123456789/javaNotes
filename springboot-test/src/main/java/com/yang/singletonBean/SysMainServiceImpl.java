package com.yang.singletonBean;

import org.springframework.stereotype.Service;

/**
 * # @author  chilcyWind
 * # @Time   2020/11/22 14:29
 * # @version 1.0
 * # @File : SysMainServiceImpl.java
 * # @Software: IntelliJ IDEA
 */
@Service
public class SysMainServiceImpl implements SysMainService {

    /** 基本类型变量亦可 */
    private MainUser user; // 非定义为static的变量

    @Override
    public void testBean(MainUser user) {
        this.user = user;
        print();
    }

    public void print() {
        try {
            Thread.sleep(2000);
            System.out.println("ThreadName: " + Thread.currentThread().getName() + ", user: " + user);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
