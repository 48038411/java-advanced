package com.soft1841.thread;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * 抓取网络图片
 * @author 郭瑞昌
 * 2019.4.9
 */
public class GetImageByNeT {
    public static void main(String[] args) throws IOException {
        URL url = new URL("https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1554767132&di=e1f76aea0b2941fe5cf8db6a2d20bab0&src=http://uploads.5068.com/allimg/1712/124R51434-7.jpg");
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
        inStream.close();
        byte[] date = out1.toByteArray();
        File imageFile = new File("F:\\time1.jpg");
        OutputStream out2 = new FileOutputStream(imageFile);
        out2.write(date);
        out2.close();
    }
}
