package com.soft1841.list;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 *
 *
 */
public class ArticleListTest {
    public static void main(String[] args) throws ParseException {
        List<Article> list = new ArrayList<>();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        list.add(new Article(1,"腾讯视频爱奇艺优酷会员免费看","郭瑞昌",simpleDateFormat.parse("2019-03-18 20:10:50")));
        list.add(new Article(2,"相见恨晚相见恨晚相见恨晚","hihuzi",simpleDateFormat.parse("2019-03-18 20:13:50")));
        list.add(new Article(3,"开发你想不到的超级技巧","阿里云",simpleDateFormat.parse("2019-03-18 21:14:50")));
        System.out.println("id    标题                    作者          时间");
        Iterator<Article>  iterator = list.iterator();
        while (iterator.hasNext()){
            Article article = iterator.next();
            String result;
            result = timeCal(simpleDateFormat.format(article.getWriteTime()));
            System.out.println(article.getId()+"  "+article.getTitle().substring(0,10)+"..."+
                    article.getAuthor()+"  "+result);
        }
    }
    private static String timeCal(String time) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date d1;
        long diff = 0;
        try {
            d1 = format.parse(time);
            Date now = new Date();
            diff = now.getTime() - d1.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        long seconds = diff / 1000;
        long minutes = seconds / 60;
        long hours = minutes / 60;
        long days = hours / 24;
        if (seconds < 60) {
            return "刚刚";
        } else if (minutes < 60) {
            return minutes + "分钟前";
        } else if (hours < 24) {
            return hours + "小时前";
        } else {
            return days + "天前";
        }
    }


}
