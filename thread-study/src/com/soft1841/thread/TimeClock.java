package com.soft1841.thread;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TimeClock extends JFrame {
    private JLabel timeLabel;
    private JPanel timePanel;
    private TimerTask timeTask;
    private Timer timer;
    public TimeClock(){
        init();
        setTitle("闹钟");
        setSize(757, 462);
        setLocation(500,300);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void init(){
        timeLabel = new JLabel();
        timePanel = new JPanel(){
          protected void paintComponent(Graphics g){
              try {
                  Image bg = ImageIO.read(new File("E:/time.png"));
                  g.drawImage(bg,0,0,getWidth(),getHeight(),null);
              } catch (IOException e) {
                  e.printStackTrace();
              }
          }
        };
        Font font = new Font("微软雅黑",Font.BOLD,23);
        timeLabel.setFont(font);
        timePanel.setPreferredSize(new Dimension(800, 600));
        timePanel.setLayout(new FlowLayout(FlowLayout.CENTER,200,200));
        add(timePanel, BorderLayout.EAST);
        timeTask = new TimerTask() {
            @Override
            public void run() {
                Date date = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String timeString = sdf.format(date);
                timeLabel.setText(timeString);
                if (timeString.equals("2019-04-16 09:21:30")) {
                    JOptionPane.showMessageDialog(timePanel, "09.21到了");
                }
                if (timeString.equals("2019-04-16 09:22:00")) {
                    JOptionPane.showMessageDialog(timePanel, "时间到啦");
                    this.cancel();
                }
            }
        };
        timer = new java.util.Timer();
        timer.scheduleAtFixedRate(timeTask,0,1000);
        timePanel.add(timeLabel,BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        new TimeClock();
    }
}
