package socket;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 服务端
 */

public class ServerFrame extends JFrame implements ActionListener {
    //文本域
    private static JTextArea contentArea;
    //按钮
    private JButton startBtn;
    private JPanel northPanel;
    private JScrollPane scrollPane;

    public ServerFrame() {
        init();
        setTitle("服务器端");
        setSize(840, 800);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private void init() {
        //创建一个容器
        Container c = getContentPane();
        //设置空布局
        this.setLayout(null);
        //多行文本域
        contentArea = new JTextArea();
        //设置文本域为不可编辑
        Font font = new Font(null,Font.BOLD,25);
        contentArea.setFont(font);
        contentArea.setEditable(false);
        contentArea.setForeground(Color.BLUE);
        contentArea.setBackground(Color.WHITE);
        scrollPane = new JScrollPane(contentArea);
        scrollPane.setBorder(new TitledBorder("消息显示区"));
        scrollPane.setBounds(50, 80, 720, 550);
        northPanel = new JPanel();
        northPanel.setBounds(0, 0, 840, 70);
        northPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 50, 25));
        startBtn = new JButton("启动");
        startBtn.setSize(100, 40);
        startBtn.setBackground(new Color(30, 136, 229));
        startBtn.addActionListener(this);
        northPanel.add(startBtn);
        c.add(northPanel);
        c.add(scrollPane);
    }

    public static void main(String[] args) {
        new ServerFrame();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == startBtn) {
            //点击启动按钮，执行线程
            ServerFrameThread serverFrameThread = new ServerFrameThread();
            new Thread(serverFrameThread).start();
        }
    }
     class ServerFrameThread implements Runnable {
        private  ServerSocket serverSocket;
        private Socket socket;
        public void setSocket(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                serverSocket = new ServerSocket(10606);
                contentArea.setText("服务器启动"+"\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
            while (true) {
                try {
                    socket = serverSocket.accept();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println(socket.getInetAddress() + "上线了");
                InputStream in = null;
                try {
                    in = socket.getInputStream();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                byte[] b = new byte[1024];
                try {
                    in.read(b);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                contentArea.append(socket.getInetAddress()+"发送的消息为："+new String(b)+"\n");
            }
        }
    }
}
