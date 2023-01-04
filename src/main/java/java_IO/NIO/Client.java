package java_IO.NIO;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args){
        try{
            Socket socket = new Socket("127.0.0.1",8080);
            Scanner sc = new Scanner(System.in);
            String message = sc.nextLine();
            socket.getOutputStream().write(message.getBytes());
            socket.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
