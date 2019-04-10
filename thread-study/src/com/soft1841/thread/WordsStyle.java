package com.soft1841.thread;

import javax.swing.*;
import java.awt.*;

public class WordsStyle extends Thread {

    private JLabel lblWords; // 文字标签

    public WordsStyle(JLabel lblWords) { // 以文字标签为参数的构造方法，利用构造方法初始化变量
        this.lblWords = lblWords;
    }

    @Override
    public void run() { // 线程要执行的任务
        while (true) { // 使线程处于启用状态
            try {
                Thread.sleep(3000); // 线程休眠3秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 设置字体颜色，字体样式
            lblWords.setForeground(Color.BLUE);
            lblWords.setFont(new Font("方正舒体", Font.BOLD, 28));
            try {
                Thread.sleep(3000); // 线程休眠3秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 设置字体颜色，字体样式
            lblWords.setForeground(Color.RED);
            lblWords.setFont(new Font("华文新魏", Font.BOLD | Font.ITALIC, 28));
            try {
                Thread.sleep(3000); // 线程休眠3秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 设置字体颜色，字体样式
            lblWords.setForeground(Color.GREEN);
            lblWords.setFont(new Font("华文隶书", Font.ITALIC, 28));
            try {
                Thread.sleep(3000); // 线程休眠3秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 设置字体颜色，字体样式
            lblWords.setForeground(Color.BLACK);
            lblWords.setFont(new Font("华文行楷", Font.PLAIN, 28));
        }
    }
}
