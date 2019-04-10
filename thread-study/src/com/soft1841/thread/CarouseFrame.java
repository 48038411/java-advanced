package com.soft1841.thread;

import javax.swing.*;
import java.awt.*;

public class CarouseFrame extends JFrame {
    private JProgressBar progressBar;
    private JLabel bgLabel;
    private JPanel contentPane;
    private JLabel lblWords;
    public CarouseFrame(){
        init();
        setTitle("大图轮播欣赏");
        setSize(1350,1080);
        setLocationRelativeTo(null);
        setResizable(true);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    public void init(){
        progressBar = new JProgressBar();
        add(progressBar,BorderLayout.EAST);
        progressBar.setStringPainted(true);
        bgLabel = new JLabel();
        bgLabel.setSize(new Dimension(300,300));
        add(bgLabel, BorderLayout.CENTER);
        contentPane = new JPanel();
        lblWords = new JLabel("1 · 8 · 4 · 1");
        lblWords.setHorizontalAlignment(SwingConstants.CENTER);
        lblWords.setFont(new Font("华文行楷", Font.PLAIN, 28));
        Thread progress = new ProgressBar(progressBar);
        progress.start();
        Thread styleThread = new WordsStyle(lblWords); // 创建线程类的子类之“字体样式”的对象
        styleThread.start(); // 启用“字体样式”线程
        contentPane.add(lblWords, BorderLayout.CENTER);
        add(contentPane,BorderLayout.NORTH);
        CarouselThread carouselThread = new CarouselThread();
        carouselThread.setBgLabel(bgLabel);
       new Thread(carouselThread).start();
    }

    public static void main(String[] args) {
        new CarouseFrame();
    }
}
