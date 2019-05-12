package cn.soft1841.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TimLogin {
    private JPanel mainPanel;
    private JLabel bannerLabel;
    private JLabel avatarLabel;
    private JTextField textField1;
    private JTextField textField2;
    private JButton loginBtn;
    private JCheckBox 记住密码CheckBox;
    private JCheckBox 自动登录CheckBox;

    public TimLogin() {
        loginBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"登陆成功");
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("TimLogin");
        frame.setContentPane(new TimLogin().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
