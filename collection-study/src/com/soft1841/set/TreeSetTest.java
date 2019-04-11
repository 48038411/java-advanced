package com.soft1841.set;

import java.util.Iterator;
import java.util.Set;
public class TreeSetTest {
    public static void main(String[] args) {
        Set<Integer> set = new java.util.TreeSet<>();
        //向set中添加元素
        set.add(-5);
        set.add(-3);
        set.add(0);
        set.add(5);
        //创建iterator迭代器对象
        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
