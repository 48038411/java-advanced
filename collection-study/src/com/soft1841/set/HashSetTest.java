package com.soft1841.set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Set接口基础程序
 */
public class HashSetTest {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("A");
        set.add("B");
        set.add("C");
        set.add("A");
        System.out.println(set);
//        String s1 = new String("A");
//        String s2 = new String("B");
//        String s3 = new String("C");
//        String s4 = new String("A");
//        set.add(s1);
//        set.add(s2);
//        set.add(s3);
//        set.add(s4);
        //用for循环遍历set集合
        int length = set.size();
        Object[] array = set.toArray();
        System.out.println("用for循环遍历set集合");
        for (int i = 0; i<array.length;i++){
           System.out.print(array[i]+" ");
        }
        System.out.println();
        //用迭代器遍历
        System.out.println("用迭代器遍历");
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.print(iterator.next()+"  ");
        }
        System.out.println(" ");
        //用lambda表达式遍历
        System.out.println("用lambda表达式遍历");
        set.forEach(str-> System.out.print(str));
    }
}
