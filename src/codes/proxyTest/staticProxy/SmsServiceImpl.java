package codes.proxyTest.staticProxy;

/**
 * # @author  chilcyWind
 * # @Time   2020/11/14 23:49
 * # @version 1.0
 * # @File : SmsServiceImpl.java
 * # @Software: IntelliJ IDEA
 */
public class SmsServiceImpl implements SmsService {
    @Override
    public String send(String message) {
        System.out.println("send message:" + message);
        return message;
    }
}
