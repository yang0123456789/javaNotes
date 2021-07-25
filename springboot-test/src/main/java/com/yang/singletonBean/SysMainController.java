package com.yang.singletonBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * # @author  chilcyWind
 * # @Time   2020/11/22 14:28
 * # @version 1.0
 * # @File : SysMainController.java
 * # @Software: IntelliJ IDEA
 */
@RequestMapping("/main")
@Controller
public class SysMainController {

    @Autowired
    private SysMainService mainService;

    @RequestMapping(value = "/test")
    public void mainMethod() {

        // thread-1
        new Thread(() -> {
            MainUser user = MainUser.builder()
                    .id("1")
                    .sex("男")
                    .userName("张三")
                    .build();
            mainService.testBean(user);
        }).start();

        // thread-2
        new Thread(() -> {
            MainUser user = MainUser.builder()
                    .id("2")
                    .sex("女")
                    .userName("小芳")
                    .build();
            mainService.testBean(user);
        }).start();

    }

}
