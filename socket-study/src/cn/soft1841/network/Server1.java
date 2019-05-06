package cn.soft1841.network;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * 客户端向服务器发送文本数据
 */
public class Server1 {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(12580);
        System.out.println("服务器启动");
        OutputStream out;
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入您想发送的通告");
        String news = scanner.nextLine();
        while (true){
            Socket socket = ss.accept();
            System.out.println(socket.getInetAddress()+"上线了");
            //根据客户端对象获取输出流对象
            out = socket.getOutputStream();
            out.write(news.getBytes());
            out.close();
            socket.close();
        }
    }
}
