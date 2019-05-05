package com.soft1841.thread.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

import static sun.util.logging.LoggingSupport.log;

public class Test {
    public Test(String title) {

    }

    public static void main(String[] args) throws IOException {
        Document doc = Jsoup.connect("http://www.baidu.com").get();
        new Test(doc.title());
        Elements newsHeadlines = doc.select(".u_sp");
        for(Element headline : newsHeadlines) {
            log("%s\n\t%s",
                    headline.attr("title"), headline.absUrl("href"));
        }
    }
}
