package cn.soft1841.network;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class Client1 {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("10.40.203.82",12580);
        InputStream in = socket.getInputStream();
        byte[] b = new byte[1024];
        in.read(b);
        System.out.println("服务端发送的信息为："+new String(b));
        in.close();
        socket.close();
    }
}
