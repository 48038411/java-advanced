package socket;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client7 extends JFrame implements ActionListener,Runnable {
    private JTextArea taMsg = new JTextArea("以下是聊天记录\n");
    private JTextField tfMsg = new JTextField();
    private Socket s = null;
    private String nickName = null;
    public Client7(){
        this.setTitle("客户端");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(taMsg, BorderLayout.CENTER);
        tfMsg.setBackground(Color.yellow);
        this.add(tfMsg,BorderLayout.SOUTH);
        tfMsg.addActionListener(this);
        this.setSize(500,600);
        this.setLocation(400,400);
        this.setVisible(true);
        nickName = JOptionPane.showInputDialog("输入昵称");
        try {
            s = new Socket("192.168.43.157",10066);//连接不同的局域网IP地址要改变
            JOptionPane.showMessageDialog(this,"连接成功");
            this.setTitle("客户端："+nickName);
            new Thread(this).start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            OutputStream os = s.getOutputStream();
            PrintStream ps = new PrintStream(os);
            ps.println(nickName + "说："+tfMsg.getText());
            tfMsg.setText("");
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            while (true){
                InputStream is = s.getInputStream();
                BufferedReader br = new BufferedReader(new InputStreamReader(is));
                String str = br.readLine();//读
                taMsg.append(str + "\n");//添加内容
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception{
        Client7 client7 = new Client7();
    }
}
