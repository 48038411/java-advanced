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
    private JFrame frame;
    //文本域
    private JTextArea contentArea;
    //按钮
    private JButton startBtn;
    private JPanel northPanel;
    private JScrollPane scrollPane;

    public ServerFrame() {
        init();
        setTitle("服务器");
        setLocation(660,180);
        setSize(840,800);
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
        if (e.getSource()==startBtn){
            try {
                ServerSocket ss = new ServerSocket(12012);
                System.out.println(ss);
                while (true) {
                    Socket socket = ss.accept();
                    System.out.println(socket.getInetAddress() + "上线了");
                    InputStream in = socket.getInputStream();
                    byte[] b = new byte[1024];
                    in.read(b);
                    System.out.println(socket.getInetAddress() + "发送的信息为：" + new String(b));
                    contentArea.append(new String(b));
                }
            } catch (BindException ex) {
                JOptionPane.showMessageDialog(null, "服务器开启失败：端口被占用", "服务器开启失败", JOptionPane.ERROR_MESSAGE);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
