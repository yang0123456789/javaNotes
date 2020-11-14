package codes.proxyTest.jdkProxy;

/**
 * # @author  chilcyWind
 * # @Time   2020/11/15 0:02
 * # @version 1.0
 * # @File : SmsService.java
 * # @Software: IntelliJ IDEA
 */
//1.定义发送短信的接口
public interface SmsService {
    String send(String message);
}
