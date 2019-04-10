package com.soft1841.thread;

import javax.swing.*;
import java.awt.*;

public class NumFrame2 extends JFrame {
    private JLabel numberLabel;
    private JLabel timeLabel;
    private JPanel backPanel;
    private  JPanel[] panels;
    public NumFrame2(){
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
        GridLayout gridLayout = new GridLayout(3,3,50,30);
        setLayout(gridLayout);
        panels = new JPanel[9];
        for (int  i = 0 ;i<8;i++){
            panels[i]= new JPanel();
            panels[i].setBorder(BorderFactory.createTitledBorder("面板"+(i+1)));
            add(panels[i]);
        }
        Font font = new Font("微软雅黑",Font.BOLD,25);
        numberLabel.setFont(font);
        timeLabel.setFont(font);
        NumThread numThread = new NumThread();
        numThread.setNumberLabel(numberLabel);
        numThread.start();
        panels[0].add(numberLabel);
        TimeThread timeThread = new TimeThread();
        timeThread.setTimeLabel(timeLabel);
        timeThread.start();
        panels[1].add(timeLabel);
        BackGroundThread backGroundThread = new BackGroundThread();
        backGroundThread.setBackPanel(backPanel);
        backGroundThread.start();
        panels[2].add(backPanel);
    }

    public static void main(String[] args) {
        new NumFrame2();
    }
}
