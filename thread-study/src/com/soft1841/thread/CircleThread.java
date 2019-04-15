package com.soft1841.thread;

import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class CircleThread implements Runnable {
    int x = 600;
    int y = 600;
    int i = 0;
    private JFrame frame;

    public void setFrame(JFrame frame) {

        this.frame = frame;
    }

    @Override
    public void run() {
//        Random random = new Random();
////        while (true) {
////            try {
////                Thread.sleep(1000);
////            } catch (InterruptedException e) {
////                e.printStackTrace();
////            }
//            Graphics graphics = frame.getGraphics();
//            i = random.nextInt(20);
//            graphics.drawOval(x / 2 - (i +1) * 10,y / 2 - (i+1) * 10,10+20*i,10+20*i);
//        }
            TimerTask timerTask = new TimerTask() {
                @Override
                public void run() {
                    Random random = new Random();
                    while (true) {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        Graphics graphics = frame.getGraphics();
                        i = random.nextInt(20);
                        graphics.drawOval(x / 2 - (i + 1) * 10, y / 2 - (i + 1) * 10, 10 + 20 * i, 10 + 20 * i);
                    }
                }
            };
            Timer timer = new Timer();
            timer.schedule(timerTask,5,1000);

    }
}
