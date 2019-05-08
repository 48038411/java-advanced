package cn.soft1841.network;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server5 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(10086);
        System.out.println("服务器启动...");
        while (true) {
            Socket socket = serverSocket.accept();
            ServerThread4 server = new ServerThread4(socket);
            new Thread(server).start();
        }
    }

    static class ServerThread4 implements Runnable {
        private Socket socket;
        public ServerThread4(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            System.out.println("客户端"+ socket.getInetAddress() + "连接成功！");
            try {
                File file = new File("E:/1.jpg");
                InputStream inputStream = new FileInputStream(file);
                byte[] bytes = new byte[1024];
                inputStream.read(bytes);
                OutputStream outputStream = socket.getOutputStream();
                outputStream.write(bytes);
                inputStream.close();
                outputStream.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}

