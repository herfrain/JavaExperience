package java_IO.NIO;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

public class Server {
    public static void main(String[] args) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        try {
            // Java为非阻塞设置的类
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.bind(new InetSocketAddress(8080));
            // 设置为非阻塞
            serverSocketChannel.configureBlocking(false);
            while (true) {
                SocketChannel socketChannel = serverSocketChannel.accept();
                if (socketChannel == null) {
                    // 表示没人连接
                    System.out.println("正在等待客户端请求连接...");
                    Thread.sleep(5000);
                } else {
                    System.out.println("当前接收到客户端请求连接...");
                    // 设置为非阻塞
                    socketChannel.configureBlocking(false);
                    byteBuffer.flip(); // 切换模式 写-->读
                    int effective = socketChannel.read(byteBuffer);
                    if (effective != 0) {
                        String content = Charset.forName("utf-8").decode(byteBuffer).toString();
                        System.out.println(content);
                    } else {
                        System.out.println("当前未收到客户端消息");
                    }
                }
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
