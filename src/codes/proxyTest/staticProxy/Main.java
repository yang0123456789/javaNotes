package codes.proxyTest.staticProxy;

import codes.proxyTest.staticProxy.SmsProxy;
import codes.proxyTest.staticProxy.SmsService;
import codes.proxyTest.staticProxy.SmsServiceImpl;

/**
 * # @author  chilcyWind
 * # @Time   2020/11/14 23:57
 * # @version 1.0
 * # @File : Main.java
 * # @Software: IntelliJ IDEA
 */
public class Main {
    public static void main(String[] args) {
        codes.proxyTest.staticProxy.SmsService smsService = new SmsServiceImpl();
        SmsService smsProxy = new SmsProxy(smsService);
        smsProxy.send("java");
    }
}
