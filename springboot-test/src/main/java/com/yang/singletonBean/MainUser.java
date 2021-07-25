package com.yang.singletonBean;

import lombok.Builder;
import lombok.Data;

/**
 * # @author  chilcyWind
 * # @Time   2020/11/22 14:10
 * # @version 1.0
 * # @File : MainUser.java
 * # @Software: IntelliJ IDEA
 */
@Data
@Builder
public class MainUser {

    private String id;

    private String sex;

    private String userName;

}