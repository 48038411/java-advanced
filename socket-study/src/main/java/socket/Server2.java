package socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.UUID;

public class Server2 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(10010);
        System.out.println("服务器启动...");
        Socket socket;
        while (true) {
            socket = serverSocket.accept();
            ServerThread2 serverThread2 = new ServerThread2(socket);
            new Thread(serverThread2).start();
        }
    }
}

class ServerThread2 implements Runnable {
    private Socket socket;

    public ServerThread2(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        System.out.println("客户端"+socket.getInetAddress()+"链接成功");
        try {
            InputStream inputStream = socket.getInputStream();
            BufferedInputStream bis = new BufferedInputStream(inputStream);
            String Path=System.getProperty("user.dir");
            File file = new File(Path+"\\socket-study\\src\\img\\"+ UUID.randomUUID().toString() + ".jpg");
            OutputStream os = new FileOutputStream(file);
            BufferedOutputStream bos = new BufferedOutputStream(os);
            byte[] data = new byte[1024];
            int temp;
            while ((temp = bis.read(data)) != -1){
                bos.write(data,0,temp);
            }
            bos.close();
            bis.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
