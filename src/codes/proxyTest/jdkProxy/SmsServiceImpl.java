package codes.proxyTest.jdkProxy;

/**
 * # @author  chilcyWind
 * # @Time   2020/11/15 0:02
 * # @version 1.0
 * # @File : SmsServiceImpl.java
 * # @Software: IntelliJ IDEA
 *
 */
//1.定义一个接口及其实现类；
public class SmsServiceImpl implements SmsService {
    public String send(String message) {
        System.out.println("send message:" + message);
        return message;
    }
}
