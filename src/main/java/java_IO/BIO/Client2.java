package java_IO.BIO;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client2 {
    public static void main(String[] args){
        try{
            Socket socket = new Socket("127.0.0.1",8081);
            String message = null;
            Scanner sc = new Scanner(System.in);
            message = sc.nextLine();
            socket.getOutputStream().write(message.getBytes());
            socket.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
