package com.soft1841.thread;

import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class ShadePanel1 extends JPanel{
    public ShadePanel1(){
        java.util.Timer timer = new Timer();
        timer.schedule(timerTask,0,1000);

    }
    TimerTask timerTask = new TimerTask() {
        @Override
        public void run() {
            repaint();
        }
    };
    @Override
    protected void paintComponent(Graphics g2) {
        Graphics2D g = (Graphics2D) g2;
        super.paintComponent(g);
        int width = getWidth();
        int height = getHeight();
        Color[] color = {Color.CYAN,Color.MAGENTA,Color.BLUE};
        Random r = new Random();
        int i = r.nextInt(2);
        int j = r.nextInt(2);
        //创建填充模式对象
        GradientPaint paint = new GradientPaint(i, j, color[i], 0, height,color[j]);
        g.setPaint(paint);
        g.fillRect(i, j, width, height);
    }
}
