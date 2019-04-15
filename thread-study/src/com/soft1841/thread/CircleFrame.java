package com.soft1841.thread;


import com.soft1841.thread.timer.CircleThread;

import javax.swing.*;
import java.awt.*;

public class CircleFrame extends JFrame {
    private Container leftContainer;
    private JPanel rightPanel,leftPanel;
    private JLabel textLabel;
    public CircleFrame(){
        init();
        setTitle("同心圆");
        setSize(1350,1080);
        setLocationRelativeTo(null);
        setResizable(true);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

   public void init(){
       //设置容器
       Container c = getContentPane();
       //将容器设为网格布局
       c.setLayout(new GridLayout(1, 2, 5, 5));
       leftPanel = new JPanel();
       //定义左侧容器为边界布局
       leftContainer = new Container();
       leftContainer.setLayout(new BorderLayout());
       leftContainer.add(leftPanel, BorderLayout.WEST);
       //定义右侧
       rightPanel = new JPanel();
       rightPanel.setBackground(new Color(98, 151, 85));
       textLabel = new JLabel();
       Font font = new Font("微软雅黑",Font.BOLD,20);
       textLabel.setFont(font);
       TextThread thread = new TextThread();
       thread.setTextLabel(textLabel);
       rightPanel.add(textLabel);
       c.add(leftContainer);
       c.add(rightPanel);
       new Thread(thread).start();

       com.soft1841.thread.timer.CircleThread circleThread = new CircleThread();
       circleThread.setFrame(this);
       new Thread(circleThread).start();
   }


    public static void main(String[] args) {
        new CircleFrame();
    }
}
