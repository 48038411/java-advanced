package com.soft1841.thread;

import javax.swing.*;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class CarouselThread implements Runnable {
    private String[] imgs = {"http://gss0.baidu.com/94o3dSag_xI4khGko9WTAnF6hhy/zhidao/pic/item/bd3eb13533fa828b3644b1d6fa1f4134970a5a9b.jpg",
            "http://pic.3h3.com/up/2015-1/20151117170929097384.jpg",
            "http://pic1.win4000.com/wallpaper/2017-11-23/5a163f6d5feb6.jpg"};
    private JLabel bgLabel;
    public void setBgLabel(JLabel bgLabel){
        this.bgLabel = bgLabel;
    }
    @Override
    public void run() {
        int i = 0;
        //这样才可以轮播数组中的所有图片
        int length = imgs.length;
        while (true){
            //通过路径构造File对象
            try {
                URL url = new URL(imgs[i]);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn .setRequestMethod("GET");
                conn.setConnectTimeout(5*1000);
                InputStream inStream = conn.getInputStream();
                ByteArrayOutputStream out1 = new ByteArrayOutputStream();
                byte[] buffer = new byte[1024];
                int len = 0;
                while ((len = inStream.read(buffer) ) != -1){
                    out1.write(buffer,0,len);
                }
                byte[] date = out1.toByteArray();
                inStream.read(date);
                Icon icon = new ImageIcon(date);
                bgLabel.setIcon(icon);
                Thread.sleep(1000);
                inStream.close();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                System.out.println("IO异常");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            i++;
            if (i == length){
                i = 0;
            }
        }
    }
}
