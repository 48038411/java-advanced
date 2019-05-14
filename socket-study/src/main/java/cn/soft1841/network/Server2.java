package cn.soft1841.network;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server2 {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(12000);
        System.out.println("服务器启动");
        while (true) {
            Socket socket = ss.accept();
            System.out.println(socket.getInetAddress()+"上线了");
            InputStream in = socket.getInputStream();
            byte[] b = new byte[1024];
            in.read(b);
            System.out.println(socket.getInetAddress() +"发送的信息为："+ new String(b));
        }
    }
}
