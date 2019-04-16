package com.soft1841.thread;

import javax.swing.*;

public class TurnThread extends Thread {
    private JLabel imgLabel;

    public TurnThread(JLabel imgLabel){
        this.imgLabel = imgLabel;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            imgLabel.setIcon(new ImageIcon(LightsFrame.class.getResource("/img/Yellow.png"))); // 黄灯
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            imgLabel.setIcon(new ImageIcon(LightsFrame.class.getResource("/img/btn.png"))); // 红灯
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            imgLabel.setIcon(new ImageIcon(LightsFrame.class.getResource("/img/bg1.png"))); // 绿灯
        }
    }
}
