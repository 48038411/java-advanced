package com.soft1841.io;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ImageFrame extends JFrame {
    private JPanel topPanel;
    private JButton[] buttons;
    private JLabel imageLabel;
    private JLabel time;
    private JLabel path;
    private JLabel length;
    private Icon icon;
    public ImageFrame(){
        init();
        setTitle("图片窗体");
        setSize(1000,600);
        //窗体自动居中
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    public void init(){
        topPanel = new JPanel();
        buttons = new JButton[5];
        for (int i = 0; i<5; i++){
           buttons[i] =  new JButton("按钮"+i+1);
            topPanel.add(buttons[i]);
        }
        add(topPanel, BorderLayout.NORTH);
        imageLabel = new JLabel("");
        //读入本地的图片到内存的字节数组
        File file = new File("F:/test.jpg");
        InputStream inputStream;
        byte[] bytes = null;
        try {
            inputStream = new FileInputStream(file);
            bytes = new byte[(int) file.length()];
            inputStream.read(bytes);
        } catch (IOException e) {
            System.out.println("IO异常");
        }
        icon = new ImageIcon(bytes);
        imageLabel.setIcon(icon);
        add(imageLabel,BorderLayout.CENTER);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        JLabel time = new JLabel("当前时间："+simpleDateFormat.format(date));
        add(time,BorderLayout.WEST);
        String pathName = file.getAbsolutePath();
        JLabel path = new JLabel("图片路径："+pathName);
        add(path,BorderLayout.EAST);
        Long length = file.length() / 1024;
        JLabel label = new JLabel("大小："+String.valueOf(length)+"K");
        add(label,BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        new ImageFrame();
    }
}
