package codes.proxyTest.CGLIBproxy;

/**
 * # @author  chilcyWind
 * # @Time   2020/11/15 8:28
 * # @version 1.0
 * # @File : AliSmsService.java
 * # @Software: IntelliJ IDEA
 * 导入依赖的的包
 * <dependency>
 *   <groupId>cglib</groupId>
 *   <artifactId>cglib</artifactId>
 *   <version>3.3.0</version>
 * </dependency>
 *
 */

//1.实现一个使用阿里云发送短信的类
public class AliSmsService {
    public String send(String message) {
        System.out.println("send message:" + message);
        return message;
    }
}
