package com.soft1841.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author  郭瑞昌
 * List接口的基础练习
 * 2019.03.19
 */
public class ListTest {
    public static void main(String[] args) {
        //1，创建一个list对象，加入元素
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        //2.通过for循环遍历集合
        int len = list.size();
        for (int i=0; i<len; i++){
            System.out.println(list.get(i));
        }
        //3，通过iterator迭代器遍历集合
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        //4，通过lanbda表达式遍历集合
        list.forEach(str-> System.out.println(str));
    }
}
