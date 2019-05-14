package socket;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 客户端
 */
public class ClientFrame extends JFrame implements ActionListener {
    private JButton connectBtn,sendBtn;
    private JTextArea contentArea;
    private JTextField sendField;
    private JLabel jLabel;
    private JScrollPane scrollPane;
    private Socket socket;

    public ClientFrame(){
        init();
        setTitle("客户端");
        setSize(840,800);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    private void init(){
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
        connectBtn = new JButton("链接服务器");
        connectBtn.setBounds(150,250,100,40);
        connectBtn.setBackground(new Color(30,136,229));
        connectBtn.addActionListener(this);
        scrollPane = new JScrollPane(contentArea);
        scrollPane.setBorder(new TitledBorder("消息显示区"));
        scrollPane.setBounds(50,10,720,470);
        scrollPane.setVisible(false);
        jLabel = new JLabel("请输入发送的信息：");
        jLabel.setBounds(40,470,800,70);
        jLabel.setVisible(false);
        sendField = new JTextField();
        sendField.setBounds(20,530,790,100);
        sendField.setVisible(false);
        sendBtn = new JButton("发送");
        sendBtn.setBounds(660,650,100,40);
        sendBtn.setBackground(new Color(30,136,229));
        sendBtn.addActionListener(this);
        sendBtn.setVisible(false);
        c.add(connectBtn);
        c.add(scrollPane);
        c.add(jLabel);
        c.add(sendField);
        c.add(sendBtn);

    }

    public static void main(String[] args) {
        new ClientFrame();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==connectBtn){
            try {
                socket = new Socket("192.168.43.157",10606);
                JOptionPane.showMessageDialog(null,"服务器链接成功","链接成功",JOptionPane.INFORMATION_MESSAGE);
                scrollPane.setVisible(true);
                jLabel.setVisible(true);
                sendField.setVisible(true);
                sendBtn.setVisible(true);
                connectBtn.setVisible(false);
            } catch (ConnectException ex) {
                JOptionPane.showMessageDialog(null, "服务器链接失败", "连接失败", JOptionPane.ERROR_MESSAGE);
            } catch (UnknownHostException ex) {
                ex.printStackTrace();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        if (e.getSource()==sendBtn){
            OutputStream out = null;
            try {
                out = socket.getOutputStream();
            } catch (NullPointerException ex) {
                System.out.println("服务器内容获取失败");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            String message = sendField.getText();
            try {
                out.write(message.getBytes());
                out.close();
                socket.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            contentArea.append(message+"\n");
            sendField.setText("");
        }
    }
}
