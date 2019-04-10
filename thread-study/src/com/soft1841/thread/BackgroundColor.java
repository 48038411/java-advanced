package com.soft1841.thread;

import javax.swing.*;
import java.awt.*;

public class BackgroundColor extends Thread {
    private JPanel contentPane; // 内容面板

    public BackgroundColor(JPanel contentPane) { // 以图像标签为参数的构造方法，利用构造方法初始化变量
        this.contentPane = contentPane;
    }

    @Override
    public void run() { // 线程要执行的任务
        while (true) { // 使线程处于启用状态
            try {
                Thread.sleep(3000); // 线程休眠3秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            contentPane.setBackground(Color.YELLOW); // 面板的背景色为黄色
            try {
                Thread.sleep(3000); // 线程休眠3秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            contentPane.setBackground(Color.CYAN); // 面板的背景色为黑色
            try {
                Thread.sleep(3000); // 线程休眠3秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            contentPane.setBackground(Color.MAGENTA); // 面板的背景色为紫红色
            try {
                Thread.sleep(3000); // 线程休眠3秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            contentPane.setBackground(Color.WHITE); // 面板的背景色为白色
        }
    }
}
