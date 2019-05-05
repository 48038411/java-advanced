package com.soft1841.thread.jsoup;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.UUID;

public class JSoupDemo2 {
    public static void main(String[] args) throws IOException {
        File file;
        InputStream in;
        OutputStream out;
        String url = "https://www.imooc.com/";
        File input = new File("D:/test.html");
        Connection connection = Jsoup.connect(url);
        System.out.println(connection.toString());
        Document document = connection.get();
        //System.out.println(document);
        Elements elements = document.getElementsByClass("course-card-top hashadow");
        for (Element e:elements
             ) {
            Element imgElement = e.child(0);
            //Elements elements1 = document.getElementsByTag("a");
            UUID uuid = UUID.randomUUID();
            String imgName = uuid + ".jpg";
            file = new File("E:\\myImage\\"+imgName);
            URL url1 = new URL("https:"+imgElement.attr("src"));
            URLConnection uc = url1.openConnection();
            in = uc.getInputStream();
            out = new FileOutputStream(file);
            int temp;
            byte[] buf = new byte[1024];
            while ((temp = in.read(buf)) != -1){
                out.write(buf,0,temp);
            }
            out.close();
            in.close();
        }
    }
}
