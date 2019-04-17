package com.soft1841.thread.jsoup;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class JSoupDemo {
    public static void main(String[] args) throws IOException {
        String url = "https://www.qidian.com/xuanhuan";
        Connection connection = Jsoup.connect(url);
        Document document = connection.get();
        Elements elements = document.getElementsByClass("book-info");
        System.out.println(elements.size());
        for (Element element:elements
             ) {
            Element link = element.child(0).child(0);
            String title = link.text();
            System.out.println(title);
        }


    }
}
