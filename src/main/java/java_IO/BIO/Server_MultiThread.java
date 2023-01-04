package java_IO.BIO;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server_MultiThread {
    public static void main(String[] args){
        byte[] buffer = new byte[1024];
        try{
            ServerSocket serverSocket = new ServerSocket(8081);
            System.out.println("服务器已启动并监听8080端口");

            int link_num = 0;
            while(true) {
                System.out.println("服务器正在等待连接...");
                Socket socket = serverSocket.accept(); // 阻塞1
                System.out.println("连接" + link_num++);
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("线程：" + Thread.currentThread().getName() + "开启服务");
                        System.out.println("服务器正在等待数据...");
                        try {
                            socket.getInputStream().read(buffer); // 阻塞2
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        String content = new String(buffer);
                        System.out.println("接收到的数据:"+ content);
                        System.out.println();
                    }
                });
                thread.start();
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
