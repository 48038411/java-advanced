package socket;

import java.io.IOException;
import java.net.Socket;

/**
 * 客户端程序
 */
public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost",10066);
        System.out.println(socket.getRemoteSocketAddress()+"连接成功");
    }
}
