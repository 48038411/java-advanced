package com.soft1841.thread;

import javafx.scene.control.Alert;

import javax.swing.*;

public class ProgressBar extends Thread{
    private WordsStyle wordsStyle;
    private CarouselThread carouselThread;
    private JProgressBar progressBar;

    public ProgressBar(JProgressBar progressBar){
        this.progressBar = progressBar;
    }
    int count = 0;
    @Override
    public void run() {
        while (true){
            progressBar.setValue(++count);//设置进度条的当前值
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (count == 100){
                JOptionPane.showMessageDialog(null, "加载完毕,点击关闭系统");
                System.exit(0);
            }
        }
    }
}
