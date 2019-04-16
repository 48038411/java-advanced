package com.soft1841.thread;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class LightsFrame extends JFrame {
    private JLabel imgLabel;
    private JPanel imgPanel;
    public LightsFrame(){
        init();
        setTitle("交通信号灯");
        setSize(1350,1080);
        setLocationRelativeTo(null);
        setResizable(true);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    public void init(){
        imgPanel = new JPanel();
        imgLabel = new JLabel();
        imgPanel.setBackground(Color.WHITE);
        imgPanel.setBorder(new TitledBorder(null, "交通灯", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        add(imgPanel);
        imgLabel.setBackground(Color.WHITE);
        ImageIcon image = new ImageIcon(this.getClass().getResource("/img/bg1.png"));
        imgLabel.setIcon(image);
        imgPanel.add(imgLabel, BorderLayout.CENTER);
        Thread thread = new TurnThread(imgLabel); // 创建线程类的子类之“改变颜色”的对象
        thread.start(); // 启用线程
    }

    public static void main(String[] args) {
        new LightsFrame();
    }
}
