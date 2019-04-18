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

public class JSoupTest {
    public static void main(String[] args) throws IOException {
        File file;
        InputStream in;
        OutputStream out;
        String url = "http://expo.bootcss.com";
        Connection connection = Jsoup.connect(url);
        Document document = connection.get();
        Element elementDiv = document.getElementById("post-list");
        Elements elements = elementDiv.getElementsByClass("col-xs-12");
        System.out.println(elements.size());
        for (Element e:elements
        ) {
            Element imgElement = e.child(0).child(1).child(0).child(0);
            UUID uuid = UUID.randomUUID();
            System.out.println(uuid);
            String imgName = uuid + ".jpg";
            file = new File("E:\\myImage\\"+imgName);
            URL url1 = new URL(imgElement.attr("src"));
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
