package com.soft1841.set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Shopping {
    public static void main(String[] args) {
        Set<Book> set = new HashSet<>();
        set.add(new Book("Java从入门到精通","明日科技编著",69.8));
        set.add(new Book("Java从入门到精通实例版","明日科技编著",50.8));
        set.add(new Book("Java从web到入门到精通","明日科技编著",69.8));
        System.out.println("书名\t\t\t\t\t作者\t\t\t价格");
        double sum = 0;
        set.forEach(str-> System.out.println(str.getBookName()+"\t\t"+str.getAuthor()+
                "\t\t"+str.getPrice()));
        Iterator<Book> iterator = set.iterator();
        while (iterator.hasNext()){
            sum +=iterator.next().getPrice();
        }
        System.out.println("总价为："+sum);
    }
}
