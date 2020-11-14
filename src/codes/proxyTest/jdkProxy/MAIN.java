package codes.proxyTest.jdkProxy;

/**
 * # @author  chilcyWind
 * # @Time   2020/11/15 0:18
 * # @version 1.0
 * # @File : MAIN.java
 * # @Software: IntelliJ IDEA
 */
public class MAIN {
    public static void main(String[] args) {
        SmsService smsService = (SmsService) JdkProxyFactory.getProxy(new SmsServiceImpl());
        smsService.send("java");
    }
}
