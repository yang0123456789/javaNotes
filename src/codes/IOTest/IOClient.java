package codes.IOTest;

import java.io.IOException;
import java.net.Socket;
import java.util.Date;

/**
 * # @author  chilcyWind
 * # @Time   2020/11/15 9:27
 * # @version 1.0
 * # @File : IOClient.java
 * # @Software: IntelliJ IDEA
 */
public class IOClient {
    public static void main(String[] args) throws InterruptedException {
        // TODO 创建多个线程，模拟多个客户端连接服务端
        new Thread(() -> {
            try {
                Socket socket = new Socket("127.0.0.1", 3333);
                while (true) {
                    try {
                        socket.getOutputStream().write((new Date() + ": hello world").getBytes());
                        Thread.sleep(3000);
                    } catch (Exception e) {
                    }
                }
            } catch (IOException e) {
            }
        }).start();

        Thread.sleep(Integer.MAX_VALUE);
    }
}
