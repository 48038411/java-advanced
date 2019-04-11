package com.soft1841.list;

import java.util.ArrayList;
import java.util.List;

public class BookTest {
    public static void main(String[] args) {
        List<Book> list = new ArrayList<>();
        list.add(new Book(1,"三国演义",22.22));
        list.add(new Book(2,"西游记",33.33));
        list.add(new Book(3,"水浒传",44.44));
        System.out.println("默认输出的格式");
        for (int i = 0; i<list.size(); i++){
            System.out.println(list.get(i).getId()+"  "+list.get(i).getName()
            +"  "+list.get(i).getPrice());
        }
        Book book = new Book();
        book.setId(4);
        book.setName("红楼梦");
        book.setPrice(55.55);
        list.add(1,book);
        System.out.println("使用add方法后：");
        for (int i = 0; i<list.size(); i++){
            System.out.println(list.get(i).getId()+"  "+list.get(i).getName()
                    +"  "+list.get(i).getPrice());
        }
        book.setId(5);
        book.setName("天才");
        book.setPrice(11.11);
        list.set(2,book);
        System.out.println("使用set方法后");
        for (int i = 0; i<list.size(); i++){
            System.out.println(list.get(i).getId()+"  "+list.get(i).getName()
                    +"  "+list.get(i).getPrice());
        }
        System.out.println("使用remove方法后");
        list.remove(2);
        for (int i = 0; i<list.size(); i++){
            System.out.println(list.get(i).getId()+"  "+list.get(i).getName()
                    +"  "+list.get(i).getPrice());
        }
        System.out.println("使用get方法后获取到的值："+list.get(2));
        System.out.println("使用indexOf方法后返回的值："+list.indexOf(4));
        System.out.println("使用lastIndexof方法后返回的值"+list.lastIndexOf(4));
    }
}
