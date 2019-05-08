package socket;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server7 extends JFrame implements Runnable {
    private Socket s = null;
    private ServerSocket ss = null;
    private ArrayList clients = new ArrayList();//保存客户端的线程

    public Server7() throws Exception {
        this.setTitle("服务器端");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBackground(Color.YELLOW);
        this.setSize(500, 400);
        this.setLocation(200,200);
        this.setVisible(true);
        ss = new ServerSocket(10066);//服务器端开辟端口，接收连接
        new Thread(this).start();//接收客户连接的死循环开始运行
    }

    @Override
    public void run() {
        try {
            while (true) {
                s = ss.accept();
                //s就是当前连接的socket，对应一个客户端
                // 该客户端随时可能发信息过来，必须要接收
                // 另外开辟一个线程，专门为这个s服务，负责接收信息
                ChatThread ct = new ChatThread(s);
                clients.add(ct);
                ct.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    class ChatThread extends Thread {//为某个Socket负责接收信息
        private Socket s = null;
        private BufferedReader br = null;
        public PrintStream ps = null;

        public ChatThread(Socket s) throws Exception {
            this.s = s;
            br = new BufferedReader(new InputStreamReader(s.getInputStream()));
            ps = new PrintStream(s.getOutputStream());
        }

        public void run() {
            try {
                while (true) {
                    String str = br.readLine();//读取该Socket传来的信息
                    sendMessage(str);//将str转发给所有客户端
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

        public void sendMessage(String msg) {//将信息发给所有客户端
            for (int i = 0; i < clients.size(); i++) {
            ChatThread ct = (ChatThread) clients.get(i);
            //向ct的Socket中写msg
            ct.ps.println(msg);
        }
    }

    public static void main(String[] args) throws Exception {
        Server7 server7 = new Server7();
    }
}