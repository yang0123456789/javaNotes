

# 一。相关资源

跟着视频做的笔记，课件有的笔记都有（除了源码部分），我自己还加了很多东西。可以给后面的人当做参考!
1、csdn：https://blog.csdn.net/youth_lql/category_10959696.html      
2、电子书在线阅读：https://youthlql.gitee.io/javayouth/#/
3、博客：https://imlql.cn/categories/Netty/%E5%85%A5%E9%97%A8/

title: Netty入门-第一话 tags:

- Netty categories:
- Netty
- 入门 keywords: Netty description: 第一话对BIO和NIO进行了讲解，为后续做准备。 cover: 'https://cdn.jsdelivr.net/gh/youthlql/lqlp@master/netty/netty_logo.jpg' abbrlink: 3f9283e7 date: 2021-04-08 14:21:58

------

> - 因为学netty的过程中，发现计算机网络和操作系统蛮重要的，所以接下来会写几篇这方面的文章，希望读者不要觉得我东写一点，西写一点。
> - 比如netty中有操作系统里的IO，零拷贝。有计算机网络里的通信(因为netty本身就是一个网络应用框架)。等等

# [Netty简介netty简介)

## [Netty 的介绍netty-的介绍)

1. `Netty` 是由 `JBOSS` 提供的一个 `Java` 开源框架，现为 `Github` 上的独立项目。
2. `Netty` 是一个异步的、基于事件驱动的网络应用框架，用以快速开发高性能、高可靠性的网络 `IO` 程序。
3. `Netty` 主要针对在 `TCP` 协议下，面向 `Client` 端的高并发应用，或者 `Peer-to-Peer` 场景下的大量数据持续传输的应用。
4. `Netty` 本质是一个 `NIO` 框架，适用于服务器通讯相关的多种应用场景。
5. 要透彻理解 `Netty`，需要先学习 `NIO`，这样我们才能阅读 `Netty` 的源码。

相对简单的一个体系图

![img](https://cdn.jsdelivr.net/gh/youthlql/lqlp@master/netty/introduction/chapter_001/0001.png)

## Netty 的应用场景

### 互联网行业

1. 互联网行业：在分布式系统中，各个节点之间需要远程服务调用，高性能的 `RPC` 框架必不可少，`Netty` 作为异步高性能的通信框架，往往作为基础通信组件被这些 `RPC` 框架使用。
2. 典型的应用有：阿里分布式服务框架 `Dubbo` 的 `RPC` 框 架使用 `Dubbo` 协议进行节点间通信，`Dubbo` 协议默认使用 `Netty` 作为基础通信组件，用于实现各进程节点之间的内部通信。

### 游戏行业

1. 无论是手游服务端还是大型的网络游戏，`Java` 语言得到了越来越广泛的应用。
2. `Netty` 作为高性能的基础通信组件，提供了 `TCP/UDP` 和 `HTTP` 协议栈，方便定制和开发私有协议栈，账号登录服务器。
3. 地图服务器之间可以方便的通过 `Netty` 进行高性能的通信。

### 大数据领域

1. 经典的 `Hadoop` 的高性能通信和序列化组件 `Avro` 的 `RPC` 框架，默认采用 `Netty` 进行跨界点通信。
2. 它的 `NettyService` 基于 `Netty` 框架二次封装实现。

### 其它开源项目使用到 Netty

网址：https://netty.io/wiki/related-projects.html

## Netty 的学习资料参考

![img](https://cdn.jsdelivr.net/gh/youthlql/lqlp@master/netty/introduction/chapter_001/0002.png)

# Java BIO编程

## I/O 模型

1. `I/O` 模型简单的理解：就是用什么样的通道进行数据的发送和接收，很大程度上决定了程序通信的性能。
2. `Java` 共支持 `3` 种网络编程模型 `I/O` 模式：`BIO`、`NIO`、`AIO`。
3. `Java BIO`：同步并阻塞（传统阻塞型），服务器实现模式为一个连接一个线程，即客户端有连接请求时服务器端就需要启动一个线程进行处理，如果这个连接不做任何事情会造成不必要的线程开销。【简单示意图】

![img](https://cdn.jsdelivr.net/gh/youthlql/lqlp@master/netty/introduction/chapter_001/0003.png)

1. `Java NIO`：同步非阻塞，服务器实现模式为一个线程处理多个请求（连接），即客户端发送的连接请求都会注册到多路复用器上，多路复用器轮询到连接有 `I/O` 请求就进行处理。【简单示意图】

![img](https://cdn.jsdelivr.net/gh/youthlql/lqlp@master/netty/introduction/chapter_001/0004.png)

1. `Java AIO(NIO.2)`：异步非阻塞，`AIO` 引入异步通道的概念，采用了 `Proactor` 模式，简化了程序编写，有效的请求才启动线程，它的特点是先由操作系统完成后才通知服务端程序启动线程去处理，一般适用于连接数较多且连接时间较长的应用。
2. 我们依次展开讲解。

## BIO、NIO、AIO 使用场景分析

1. `BIO` 方式适用于连接数目比较小且固定的架构，这种方式对服务器资源要求比较高，并发局限于应用中，`JDK1.4` 以前的唯一选择，但程序简单易理解。
2. `NIO` 方式适用于连接数目多且连接比较短（轻操作）的架构，比如聊天服务器，弹幕系统，服务器间通讯等。编程比较复杂，`JDK1.4` 开始支持。
3. `AIO` 方式使用于连接数目多且连接比较长（重操作）的架构，比如相册服务器，充分调用 `OS` 参与并发操作，编程比较复杂，`JDK7` 开始支持。

## Java BIO 基本介绍

1. `Java BIO` 就是传统的 `Java I/O` 编程，其相关的类和接口在 `java.io`。
2. `BIO(BlockingI/O)`：同步阻塞，服务器实现模式为一个连接一个线程，即客户端有连接请求时服务器端就需要启动一个线程进行处理，如果这个连接不做任何事情会造成不必要的线程开销，可以通过线程池机制改善（实现多个客户连接服务器）。【后有应用实例】
3. `BIO` 方式适用于连接数目比较小且固定的架构，这种方式对服务器资源要求比较高，并发局限于应用中，`JDK1.4` 以前的唯一选择，程序简单易理解。

## Java BIO 工作机制

![img](https://cdn.jsdelivr.net/gh/youthlql/lqlp@master/netty/introduction/chapter_001/0005.png)

对 `BIO` 编程流程的梳理

1. 服务器端启动一个 `ServerSocket`。
2. 客户端启动 `Socket` 对服务器进行通信，默认情况下服务器端需要对每个客户建立一个线程与之通讯。
3. 客户端发出请求后，先咨询服务器是否有线程响应，如果没有则会等待，或者被拒绝。
4. 如果有响应，客户端线程会等待请求结束后，再继续执行。

# Java NIO编程

## Java NIO 基本介绍

1. `Java NIO` 全称 `Java non-blocking IO`，是指 `JDK` 提供的新 `API`。从 `JDK1.4` 开始，`Java` 提供了一系列改进的输入/输出的新特性，被统称为 `NIO`（即 `NewIO`），是同步非阻塞的。
2. `NIO` 相关类都被放在 `java.nio` 包及子包下，并且对原 `java.io` 包中的很多类进行改写。【基本案例】
3. `NIO` 有三大核心部分：**`Channel`（通道）、`Buffer`（缓冲区）、`Selector`（选择器）** 。
4. `NIO` 是**面向缓冲区，或者面向块编程**的。数据读取到一个它稍后处理的缓冲区，需要时可在缓冲区中前后移动，这就增加了处理过程中的灵活性，使用它可以提供非阻塞式的高伸缩性网络。
5. `Java NIO` 的非阻塞模式，使一个线程从某通道发送请求或者读取数据，但是它仅能得到目前可用的数据，如果目前没有数据可用时，就什么都不会获取，而不是保持线程阻塞，所以直至数据变的可以读取之前，该线程可以继续做其他的事情。非阻塞写也是如此，一个线程请求写入一些数据到某通道，但不需要等待它完全写入，这个线程同时可以去做别的事情。【后面有案例说明】
6. 通俗理解：`NIO` 是可以做到用一个线程来处理多个操作的。假设有 `10000` 个请求过来,根据实际情况，可以分配 `50` 或者 `100` 个线程来处理。不像之前的阻塞 `IO` 那样，非得分配 `10000` 个。
7. `HTTP 2.0` 使用了多路复用的技术，做到同一个连接并发处理多个请求，而且并发请求的数量比 `HTTP 1.1` 大了好几个数量级。
8. 案例说明 `NIO` 的 `Buffer`

```java
package com.atguigu.nio;

import java.nio.IntBuffer;

public class BasicBuffer {

    public static void main(String[] args) {

        //举例说明 Buffer 的使用(简单说明)
        //创建一个 Buffer，大小为 5，即可以存放 5 个 int
        IntBuffer intBuffer = IntBuffer.allocate(5);

        //向buffer存放数据
        //intBuffer.put(10);
        //intBuffer.put(11);
        //intBuffer.put(12);
        //intBuffer.put(13);
        //intBuffer.put(14);
        for (int i = 0; i < intBuffer.capacity(); i++) {
            intBuffer.put(i * 2);
        }
        //如何从 buffer 读取数据
        //将 buffer 转换，读写切换(!!!)
        intBuffer.flip();
        while (intBuffer.hasRemaining()) {
            System.out.println(intBuffer.get());
        }
    }
}Copy to clipboardErrorCopied
```

## NIO 和 BIO 的比较

1. `BIO` 以流的方式处理数据，而 `NIO` 以块的方式处理数据，块 `I/O` 的效率比流 `I/O` 高很多。
2. `BIO` 是阻塞的，`NIO` 则是非阻塞的。
3. `BIO` 基于字节流和字符流进行操作，而 `NIO` 基于 `Channel`（通道）和 `Buffer`（缓冲区）进行操作，数据总是从通道读取到缓冲区中，或者从缓冲区写入到通道中。`Selector`（选择器）用于监听多个通道的事件（比如：连接请求，数据到达等），因此使用单个线程就可以监听多个客户端通道。
4. Buffer和Channel之间的数据流向是双向的

![img](https://cdn.jsdelivr.net/gh/youthlql/lqlp@master/netty/introduction/chapter_001/0007.png)

## NIO 三大核心原理示意图

一张图描述 `NIO` 的 `Selector`、`Channel` 和 `Buffer` 的关系。

### Selector、Channel 和 Buffer 关系图（简单版）

关系图的说明:

![img](https://cdn.jsdelivr.net/gh/youthlql/lqlp@master/netty/introduction/chapter_001/0008.png)

1. 每个 `Channel` 都会对应一个 `Buffer`。
2. `Selector` 对应一个线程，一个线程对应多个 `Channel`（连接）。
3. 该图反应了有三个 `Channel` 注册到该 `Selector` //程序
4. 程序切换到哪个 `Channel` 是由事件决定的，`Event` 就是一个重要的概念。
5. `Selector` 会根据不同的事件，在各个通道上切换。
6. `Buffer` 就是一个内存块，底层是有一个数组。
7. 数据的读取写入是通过 `Buffer`，这个和 `BIO`是不同的，`BIO` 中要么是输入流，或者是输出流，不能双向，但是 `NIO` 的 `Buffer` 是可以读也可以写，需要 `flip` 方法切换 `Channel` 是双向的，可以返回底层操作系统的情况，比如 `Linux`，底层的操作系统通道就是双向的。

## 缓冲区（Buffer）

### [基本介绍基本介绍)

缓冲区（`Buffer`）：缓冲区本质上是一个**可以读写数据的内存块**，可以理解成是一个**容器对象（含数组）**，该对象提供了一组方法，可以更轻松地使用内存块，，缓冲区对象内置了一些机制，能够跟踪和记录缓冲区的状态变化情况。`Channel` 提供从文件、网络读取数据的渠道，但是读取或写入的数据都必须经由 `Buffer`，如图:【后面举例说明】

![img](https://cdn.jsdelivr.net/gh/youthlql/lqlp@master/netty/introduction/chapter_001/0009.png)

### [Buffer 类及其子类buffer-类及其子类)

1. 在 `NIO` 中，`Buffer` 是一个顶层父类，它是一个抽象类，类的层级关系图：

![img](https://cdn.jsdelivr.net/gh/youthlql/lqlp@master/netty/introduction/chapter_001/0010.png)

1. `Buffer` 类定义了所有的缓冲区都具有的四个属性来提供关于其所包含的数据元素的信息：

![img](https://cdn.jsdelivr.net/gh/youthlql/lqlp@master/netty/introduction/chapter_001/0011.png)

1. `Buffer` 类相关方法一览

![img](https://cdn.jsdelivr.net/gh/youthlql/lqlp@master/netty/introduction/chapter_001/0013.png)

### [ByteBufferbytebuffer)

从前面可以看出对于 `Java` 中的基本数据类型（`boolean` 除外），都有一个 `Buffer` 类型与之相对应，最常用的自然是 `ByteBuffer` 类（二进制数据），该类的主要方法如下：

![img](https://cdn.jsdelivr.net/gh/youthlql/lqlp@master/netty/introduction/chapter_001/0014.png)

## [通道（Channel）通道（channel）)

### [基本介绍基本介绍-1)

1. ```
   NIO
   ```

    

   的通道类似于流，但有些区别如下：

   - 通道可以同时进行读写，而流只能读或者只能写
   - 通道可以实现异步读写数据
   - 通道可以从缓冲读数据，也可以写数据到缓冲:

2. `BIO` 中的 `Stream` 是单向的，例如 `FileInputStream` 对象只能进行读取数据的操作，而 `NIO` 中的通道（`Channel`）是双向的，可以读操作，也可以写操作。

3. `Channel` 在 `NIO` 中是一个接口 `public interface Channel extends Closeable{}`

4. 常用的 `Channel` 类有：**`FileChannel`、`DatagramChannel`、`ServerSocketChannel` 和 `SocketChannel`**。【`ServerSocketChanne` 类似 `ServerSocket`、`SocketChannel` 类似 `Socket`】

5. `FileChannel` 用于文件的数据读写，`DatagramChannel` 用于 `UDP` 的数据读写，`ServerSocketChannel` 和 `SocketChannel` 用于 `TCP` 的数据读写。

6. 图示

![img](https://cdn.jsdelivr.net/gh/youthlql/lqlp@master/netty/introduction/chapter_001/0015.png)

### [FileChannel 类filechannel-类)

`FileChannel` 主要用来对本地文件进行 `IO` 操作，常见的方法有

- `public int read(ByteBuffer dst)`，从通道读取数据并放到缓冲区中
- `public int write(ByteBuffer src)`，把缓冲区的数据写到通道中
- `public long transferFrom(ReadableByteChannel src, long position, long count)`，从目标通道中复制数据到当前通道
- `public long transferTo(long position, long count, WritableByteChannel target)`，把数据从当前通道复制给目标通道

### 应用实例1 - 本地文件写数据

实例要求：

1. 使用前面学习后的 `ByteBuffer`（缓冲）和 `FileChannel`（通道），将 "hello,尚硅谷" 写入到 `file01.txt` 中
2. 文件不存在就创建
3. 代码演示

```java
package com.atguigu.nio;

import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NIOFileChannel01 {

    public static void main(String[] args) throws Exception {
        String str = "hello,尚硅谷";
        //创建一个输出流 -> channel
        FileOutputStream fileOutputStream = new FileOutputStream("d:\\file01.txt");

        //通过 fileOutputStream 获取对应的 FileChannel
        //这个 fileChannel 真实类型是 FileChannelImpl
        FileChannel fileChannel = fileOutputStream.getChannel();

        //创建一个缓冲区 ByteBuffer
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        //将 str 放入 byteBuffer
        byteBuffer.put(str.getBytes());

        //对 byteBuffer 进行 flip
        byteBuffer.flip();

        //将 byteBuffer 数据写入到 fileChannel
        fileChannel.write(byteBuffer);
        fileOutputStream.close();
    }
}Copy to clipboardErrorCopied
```

### 应用实例2 - 本地文件读数据

1. 使用前面学习后的 `ByteBuffer`（缓冲）和 `FileChannel`（通道），将 `file01.txt` 中的数据读入到程序，并显示在控制台屏幕
2. 假定文件已经存在
3. 代码演示

```java
package com.atguigu.nio;

import java.io.File;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NIOFileChannel02 {

    public static void main(String[] args) throws Exception {

        //创建文件的输入流
        File file = new File("d:\\file01.txt");
        FileInputStream fileInputStream = new FileInputStream(file);
        
        //通过 fileInputStream 获取对应的 FileChannel -> 实际类型 FileChannelImpl
        FileChannel fileChannel = fileInputStream.getChannel();
        
        //创建缓冲区
        ByteBuffer byteBuffer = ByteBuffer.allocate((int)file.length());
        
        //将通道的数据读入到 Buffer
        fileChannel.read(byteBuffer);
        
        //将 byteBuffer 的字节数据转成 String
        System.out.println(new String(byteBuffer.array()));
        fileInputStream.close();
    }
}Copy to clipboardErrorCopied
```

### 应用实例3 - 使用一个 Buffer 完成文件读取、写入

实例要求：

1. 使用 `FileChannel`（通道）和方法 `read、write`，完成文件的拷贝
2. 拷贝一个文本文件 `1.txt`，放在项目下即可
3. 代码演示

![img](https://cdn.jsdelivr.net/gh/youthlql/lqlp@master/netty/introduction/chapter_001/0016.png)

```java
package com.atguigu.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NIOFileChannel03 {

    public static void main(String[] args) throws Exception {

        FileInputStream fileInputStream = new FileInputStream("1.txt");
        FileChannel fileChannel01 = fileInputStream.getChannel();
        FileOutputStream fileOutputStream = new FileOutputStream("2.txt");
        FileChannel fileChannel02 = fileOutputStream.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate(512);
        
        while (true) { //循环读取

            //这里有一个重要的操作，一定不要忘了
            /*
            public final Buffer clear() {
                position = 0;
                limit = capacity;
                mark = -1;
                return this;
            }
            */
            byteBuffer.clear(); //清空 buffer
            int read = fileChannel01.read(byteBuffer);
            System.out.println("read = " + read);
            if (read == -1) { //表示读完
                break;
            }

            //将 buffer 中的数据写入到 fileChannel02--2.txt
            byteBuffer.flip();
            fileChannel02.write(byteBuffer);
        }

        //关闭相关的流
        fileInputStream.close();
        fileOutputStream.close();
    }
}Copy to clipboardErrorCopied
```

### 应用实例4 - 拷贝文件 transferFrom 方法

1. 实例要求：
2. 使用 `FileChannel`（通道）和方法 `transferFrom`，完成文件的拷贝
3. 拷贝一张图片
4. 代码演示

```java
package com.atguigu.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;

public class NIOFileChannel04 {

    public static void main(String[] args) throws Exception {

        //创建相关流
        FileInputStream fileInputStream = new FileInputStream("d:\\a.jpg");
        FileOutputStream fileOutputStream = new FileOutputStream("d:\\a2.jpg");
        
        //获取各个流对应的 FileChannel
        FileChannel sourceCh = fileInputStream.getChannel();
        FileChannel destCh = fileOutputStream.getChannel();

        //使用 transferForm 完成拷贝
        destCh.transferFrom(sourceCh, 0, sourceCh.size());

        //关闭相关通道和流
        sourceCh.close();
        destCh.close();
        fileInputStream.close();
        fileOutputStream.close();
    }
}Copy to clipboardErrorCopied
```

### 关于 Buffer 和 Channel 的注意事项和细节

1. `ByteBuffer` 支持类型化的 `put` 和 `get`，`put` 放入的是什么数据类型，`get` 就应该使用相应的数据类型来取出，否则可能有 `BufferUnderflowException` 异常。【举例说明】

```java
package com.atguigu.nio;

import java.nio.ByteBuffer;

public class NIOByteBufferPutGet {

    public static void main(String[] args) {
        
        //创建一个 Buffer
        ByteBuffer buffer = ByteBuffer.allocate(64);

        //类型化方式放入数据
        buffer.putInt(100);
        buffer.putLong(9);
        buffer.putChar('尚');
        buffer.putShort((short) 4);

        //取出
        buffer.flip();
        
        System.out.println();
        
        System.out.println(buffer.getInt());
        System.out.println(buffer.getLong());
        System.out.println(buffer.getChar());
        System.out.println(buffer.getShort());
    }
}Copy to clipboardErrorCopied
```

1. 可以将一个普通 `Buffer` 转成只读 `Buffer`【举例说明】

```java
package com.atguigu.nio;

import java.nio.ByteBuffer;

public class ReadOnlyBuffer {

    public static void main(String[] args) {

        //创建一个 buffer
        ByteBuffer buffer = ByteBuffer.allocate(64);

        for (int i = 0; i < 64; i++) {
            buffer.put((byte) i);
        }

        //读取
        buffer.flip();

        //得到一个只读的 Buffer
        ByteBuffer readOnlyBuffer = buffer.asReadOnlyBuffer();
        System.out.println(readOnlyBuffer.getClass());

        //读取
        while (readOnlyBuffer.hasRemaining()) {
            System.out.println(readOnlyBuffer.get());
        }

        readOnlyBuffer.put((byte) 100); //ReadOnlyBufferException
    }
}Copy to clipboardErrorCopied
```

1. `NIO` 还提供了 `MappedByteBuffer`，可以让文件直接在内存（堆外的内存）中进行修改，而如何同步到文件由 `NIO` 来完成。【举例说明】

```java
package com.atguigu.nio;

import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 说明 1.MappedByteBuffer 可让文件直接在内存（堆外内存）修改,操作系统不需要拷贝一次
 */
public class MappedByteBufferTest {

    public static void main(String[] args) throws Exception {

        RandomAccessFile randomAccessFile = new RandomAccessFile("1.txt", "rw");
        //获取对应的通道
        FileChannel channel = randomAccessFile.getChannel();

        /**
         * 参数 1:FileChannel.MapMode.READ_WRITE 使用的读写模式
         * 参数 2：0：可以直接修改的起始位置
         * 参数 3:5: 是映射到内存的大小（不是索引位置），即将 1.txt 的多少个字节映射到内存
         * 可以直接修改的范围就是 0-5
         * 实际类型 DirectByteBuffer
         */
        MappedByteBuffer mappedByteBuffer = channel.map(FileChannel.MapMode.READ_WRITE, 0, 5);

        mappedByteBuffer.put(0, (byte) 'H');
        mappedByteBuffer.put(3, (byte) '9');
        mappedByteBuffer.put(5, (byte) 'Y');//IndexOutOfBoundsException

        randomAccessFile.close();
        System.out.println("修改成功~~");
    }
}Copy to clipboardErrorCopied
```

1. 前面我们讲的读写操作，都是通过一个 `Buffer` 完成的，`NIO` 还支持通过多个 `Buffer`（即 `Buffer`数组）完成读写操作，即 `Scattering` 和 `Gathering`【举例说明】

```java
package com.atguigu.nio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Arrays;

/**
 * Scattering：将数据写入到 buffer 时，可以采用 buffer 数组，依次写入 [分散]
 * Gathering：从 buffer 读取数据时，可以采用 buffer 数组，依次读
 */
public class ScatteringAndGatheringTest {

    public static void main(String[] args) throws Exception {
        
        //使用 ServerSocketChannel 和 SocketChannel 网络
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        InetSocketAddress inetSocketAddress = new InetSocketAddress(7000);

        //绑定端口到 socket，并启动
        serverSocketChannel.socket().bind(inetSocketAddress);

        //创建 buffer 数组
        ByteBuffer[] byteBuffers = new ByteBuffer[2];
        byteBuffers[0] = ByteBuffer.allocate(5);
        byteBuffers[1] = ByteBuffer.allocate(3);

        //等客户端连接 (telnet)
        SocketChannel socketChannel = serverSocketChannel.accept();

        int messageLength = 8; //假定从客户端接收 8 个字节

        //循环的读取
        while (true) {
            int byteRead = 0;

            while (byteRead < messageLength) {
                long l = socketChannel.read(byteBuffers);
                byteRead += l; //累计读取的字节数
                System.out.println("byteRead = " + byteRead);
                //使用流打印,看看当前的这个 buffer 的 position 和 limit
                Arrays.asList(byteBuffers).stream().map(buffer -> "position = " + buffer.position() + ", limit = " + buffer.limit()).forEach(System.out::println);
            }

            //将所有的 buffer 进行 flip
            Arrays.asList(byteBuffers).forEach(buffer -> buffer.flip());
            //将数据读出显示到客户端
            long byteWirte = 0;
            while (byteWirte < messageLength) {
                long l = socketChannel.write(byteBuffers);//
                byteWirte += l;
            }
            
            //将所有的buffer进行clear
            Arrays.asList(byteBuffers).forEach(buffer -> {
                buffer.clear();
            });
            
            System.out.println("byteRead = " + byteRead + ", byteWrite = " + byteWirte + ", messagelength = " + messageLength);
        }
    }
}Copy to clipboardErrorCopied
```

## Selector（选择器）

1. `Java` 的 `NIO`，用非阻塞的 `IO` 方式。可以用一个线程，处理多个的客户端连接，就会使用到 `Selector`（选择器）。
2. `Selector` 能够检测多个注册的通道上是否有事件发生（注意：多个 `Channel` 以事件的方式可以注册到同一个 `Selector`），如果有事件发生，便获取事件然后针对每个事件进行相应的处理。这样就可以只用一个单线程去管理多个通道，也就是管理多个连接和请求。
3. 只有在连接/通道真正有读写事件发生时，才会进行读写，就大大地减少了系统开销，并且不必为每个连接都创建一个线程，不用去维护多个线程。
4. 避免了多线程之间的上下文切换导致的开销。

### Selector 示意图和特点说明![img](https://cdn.jsdelivr.net/gh/youthlql/lqlp@master/netty/introduction/chapter_001/0017.png)

说明如下：

1. `Netty` 的 `IO` 线程 `NioEventLoop` 聚合了 `Selector`（选择器，也叫多路复用器），可以同时并发处理成百上千个客户端连接。
2. 当线程从某客户端 `Socket` 通道进行读写数据时，若没有数据可用时，该线程可以进行其他任务。
3. 线程通常将非阻塞 `IO` 的空闲时间用于在其他通道上执行 `IO` 操作，所以单独的线程可以管理多个输入和输出通道。
4. 由于读写操作都是非阻塞的，这就可以充分提升 `IO` 线程的运行效率，避免由于频繁 `I/O` 阻塞导致的线程挂起。
5. 一个 `I/O` 线程可以并发处理 `N` 个客户端连接和读写操作，这从根本上解决了传统同步阻塞 `I/O` 一连接一线程模型，架构的性能、弹性伸缩能力和可靠性都得到了极大的提升。

### Selector 类相关方法

![img](https://cdn.jsdelivr.net/gh/youthlql/lqlp@master/netty/introduction/chapter_001/0018.png)

### [注意事项注意事项)

1. `NIO` 中的 `ServerSocketChannel` 功能类似 `ServerSocket`、`SocketChannel` 功能类似 `Socket`。

2. ```
   Selector
   ```

    

   相关方法说明

   - `selector.select();` //阻塞
   - `selector.select(1000);` //阻塞 1000 毫秒，在 1000 毫秒后返回
   - `selector.wakeup();` //唤醒 selector
   - `selector.selectNow();` //不阻塞，立马返还

## NIO 非阻塞网络编程原理分析图

`NIO` 非阻塞网络编程相关的（`Selector`、`SelectionKey`、`ServerScoketChannel` 和 `SocketChannel`）关系梳理图

![img](https://cdn.jsdelivr.net/gh/youthlql/lqlp@master/netty/introduction/chapter_001/0019.png)

对上图的说明：

1. 当客户端连接时，会通过 `ServerSocketChannel` 得到 `SocketChannel`。
2. `Selector` 进行监听 `select` 方法，返回有事件发生的通道的个数。
3. 将 `socketChannel` 注册到 `Selector` 上，`register(Selector sel, int ops)`，一个 `Selector` 上可以注册多个 `SocketChannel`。
4. 注册后返回一个 `SelectionKey`，会和该 `Selector` 关联（集合）。
5. 进一步得到各个 `SelectionKey`（有事件发生）。
6. 在通过 `SelectionKey` 反向获取 `SocketChannel`，方法 `channel()`。
7. 可以通过得到的 `channel`，完成业务处理。
8. 直接看后面代码吧

## [NIO 非阻塞网络编程快速入门nio-非阻塞网络编程快速入门)

案例：

1. 编写一个 `NIO` 入门案例，实现服务器端和客户端之间的数据简单通讯（非阻塞）
2. 目的：理解 `NIO` 非阻塞网络编程机制

```java
package com.atguigu.nio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

public class NIOServer {
    public static void main(String[] args) throws Exception{

        //创建ServerSocketChannel -> ServerSocket

        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

        //得到一个Selecor对象
        Selector selector = Selector.open();

        //绑定一个端口6666, 在服务器端监听
        serverSocketChannel.socket().bind(new InetSocketAddress(6666));
        //设置为非阻塞
        serverSocketChannel.configureBlocking(false);

        //把 serverSocketChannel 注册到  selector 关心 事件为 OP_ACCEPT       pos_1
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        System.out.println("注册后的selectionkey 数量=" + selector.keys().size()); // 1



        //循环等待客户端连接
        while (true) {

            //这里我们等待1秒，如果没有事件发生, 返回
            if(selector.select(1000) == 0) { //没有事件发生
                System.out.println("服务器等待了1秒，无连接");
                continue;
            }

            //如果返回的>0, 就获取到相关的 selectionKey集合
            //1.如果返回的>0， 表示已经获取到关注的事件
            //2. selector.selectedKeys() 返回关注事件的集合
            //   通过 selectionKeys 反向获取通道
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            System.out.println("selectionKeys 数量 = " + selectionKeys.size());

            //遍历 Set<SelectionKey>, 使用迭代器遍历
            Iterator<SelectionKey> keyIterator = selectionKeys.iterator();

            while (keyIterator.hasNext()) {
                //获取到SelectionKey
                SelectionKey key = keyIterator.next();
                //根据key 对应的通道发生的事件做相应处理
                if(key.isAcceptable()) { //如果是 OP_ACCEPT, 有新的客户端连接
                    //该该客户端生成一个 SocketChannel
                    SocketChannel socketChannel = serverSocketChannel.accept();
                    System.out.println("客户端连接成功 生成了一个 socketChannel " + socketChannel.hashCode());
                    //将  SocketChannel 设置为非阻塞
                    socketChannel.configureBlocking(false);
                    //将socketChannel 注册到selector, 关注事件为 OP_READ， 同时给socketChannel
                    //关联一个Buffer
                    socketChannel.register(selector, SelectionKey.OP_READ, ByteBuffer.allocate(1024));

                    System.out.println("客户端连接后 ，注册的selectionkey 数量=" + selector.keys().size()); //2,3,4..


                }
                if(key.isReadable()) {  //发生 OP_READ

                    //通过key 反向获取到对应channel
                    SocketChannel channel = (SocketChannel)key.channel();

                    //获取到该channel关联的buffer
                    ByteBuffer buffer = (ByteBuffer)key.attachment();
                    channel.read(buffer);
                    System.out.println("form 客户端 " + new String(buffer.array()));

                }

                //手动从集合中移动当前的selectionKey, 防止重复操作
                keyIterator.remove();

            }

        }

    }
}
Copy to clipboardErrorCopied
```

> pos1：
>
> 1、对操作系统有一定了解的同学，就会大概知道这里监听的是一个Accept通道。这个通道的 作用就是监听，实际建立连接了还会有一个通道。 2、简单说一下为什么。因为客户端发请求的时候，服务器这边是肯定要先有一个监听通道， 监听某个端口是否有客户端要建立链接，如果有客户端想要建立链接，那么会再创建一个和 客户端真正通信的通道。 3、如果有其它客户端还想要建立链接，这个Accept监听端口监听到了，就会再创建几个真正 的通信通道。 4、也就是Server的一个端口可以建立多个TCP连接，因为IP层协议通过 目标地址+端口+源地址+源端口四个信息识别一个上下文
>
> **顺便插一句嘴：因为学netty的过程中，发现计算机网络和操作系统蛮重要的，所以接下来会写几篇这方面的文章**

```java
package com.atguigu.nio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class NIOClient {
    public static void main(String[] args) throws Exception{

        //得到一个网络通道
        SocketChannel socketChannel = SocketChannel.open();
        //设置非阻塞
        socketChannel.configureBlocking(false);
        //提供服务器端的ip 和 端口
        InetSocketAddress inetSocketAddress = new InetSocketAddress("127.0.0.1", 6666);
        //连接服务器
        if (!socketChannel.connect(inetSocketAddress)) {

            while (!socketChannel.finishConnect()) {
                System.out.println("因为连接需要时间，客户端不会阻塞，可以做其它工作..");
            }
        }

        //...如果连接成功，就发送数据
        String str = "hello, 尚硅谷~";
        //Wraps a byte array into a buffer
        ByteBuffer buffer = ByteBuffer.wrap(str.getBytes());
        //发送数据，将 buffer 数据写入 channel
        socketChannel.write(buffer);
        System.in.read();

    }
}Copy to clipboardErrorCopied
```

实际执行效果可以复制代码去试下

### [SelectionKeyselectionkey)

1. ```
   SelectionKey
   ```

   ，表示

    

   ```
   Selector
   ```

    

   和网络通道的注册关系，共四种：

   - `int OP_ACCEPT`：有新的网络连接可以 `accept`，值为 `16`
   - `int OP_CONNECT`：代表连接已经建立，值为 `8`
   - `int OP_READ`：代表读操作，值为 `1`
   - `int OP_WRITE`：代表写操作，值为 `4`

源码中：

```java
public static final int OP_READ = 1 << 0;
public static final int OP_WRITE = 1 << 2;
public static final int OP_CONNECT = 1 << 3;
public static final int OP_ACCEPT = 1 << 4;Copy to clipboardErrorCopied
```

1. `SelectionKey` 相关方法

![img](https://cdn.jsdelivr.net/gh/youthlql/lqlp@master/netty/introduction/chapter_001/0020.png)

### [ServerSocketChannelserversocketchannel)

1. `ServerSocketChannel` 在服务器端监听新的客户端 `Socket` 连接，负责监听，不负责实际的读写操作
2. 相关方法如下

![img](https://cdn.jsdelivr.net/gh/youthlql/lqlp@master/netty/introduction/chapter_001/0021.png)

### [SocketChannelsocketchannel)

1. `SocketChannel`，网络 `IO` 通道，**具体负责进行读写操作**。`NIO` 把缓冲区的数据写入通道，或者把通道里的数据读到缓冲区。
2. 相关方法如下

![img](https://cdn.jsdelivr.net/gh/youthlql/lqlp@master/netty/introduction/chapter_001/0022.png)



## [NIO网络编程应用实例 - 群聊系统nio网络编程应用实例-群聊系统)