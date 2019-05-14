package cn.soft1841.network;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server3 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(10086);
        System.out.println("服务器启动");
        int count = 0;
        while (true){
            Socket socket = serverSocket.accept();
            ServerThread1 server = new ServerThread1(socket);
            new Thread(server).start();
            count++;
            System.out.println("当前客户端连接的数量为："+count);
        }
    }
}
