package com.soft1841.map;
/**
 * @author 郭瑞昌
 * map,list的使用
 */

import java.util.*;

public class StudentTest {
    public static void main(String[] args) {
        List<Student> list1 = new ArrayList<>();
        list1.add(new Student(1802343306,"郭瑞昌"));
        list1.add(new Student(1802343306,"侯粤嘉"));
        list1.add(new Student(1802343319,"许源"));
        list1.add(new Student(1802343302,"蔡一帆"));
        List<Student> list2 = new ArrayList<>();
        list2.add(new Student(1802343336,"姚思佳"));
        list2.add(new Student(1802343300,"很强"));
        Map<String,List<Student>> map = new HashMap<>();
        map.put("男生",list1);
        map.put("女生",list2);
        Iterator<Map.Entry<String,List<Student>>> iterator = map.entrySet().iterator();
        System.out.println("*****按性别输出的结果*****");
        while (iterator.hasNext()){
            Map.Entry<String,List<Student>> entry = iterator.next();
            System.out.println(entry.getKey());
            Iterator<Student> iterator1 = entry.getValue().iterator();
            while (iterator1.hasNext()){
                System.out.println(iterator1.next());
            }
        }
    }
}
