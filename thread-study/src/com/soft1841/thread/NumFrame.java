package com.soft1841.thread;

import javax.swing.*;
import java.awt.*;

public class NumFrame extends JFrame{
    private JLabel numberLabel;
    private JLabel timeLabel;
    private JPanel backPanel;
    public NumFrame(){
        init();
        setTitle("登陆窗体");
        setSize(1350,1080);
        setLocationRelativeTo(null);
        setResizable(true);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    public void init(){
        numberLabel = new JLabel();
        timeLabel = new JLabel();
        backPanel = new JPanel();
        Font font = new Font("微软雅黑",Font.BOLD,40);
        numberLabel.setFont(font);
        timeLabel.setFont(font);
        add(numberLabel,BorderLayout.NORTH);
        add(timeLabel,BorderLayout.EAST);
        add(backPanel,BorderLayout.CENTER);
        NumThread numThread = new NumThread();
        numThread.setNumberLabel(numberLabel);
        numThread.start();
        TimeThread timeThread = new TimeThread();
        timeThread.setTimeLabel(timeLabel);
        timeThread.start();
        BackGroundThread backGroundThread = new BackGroundThread();
        backGroundThread.setBackPanel(backPanel);
        backGroundThread.start();
    }
    public static void main(String[] args) {
        new NumFrame();
    }
}
