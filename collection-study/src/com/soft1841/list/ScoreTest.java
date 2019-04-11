package com.soft1841.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ScoreTest {
    public static void main(String[] args) {
        List<Score> list = new ArrayList<>();
        list.add(new Score("乔丹",60));
        list.add(new Score("科比",66));
        list.add(new Score("张伯伦",100));
        //调用Collections的sort方法自动调用之前写的compareTo方法
        Collections.sort(list);
        //用for循环遍历list
        for (Score score:list
             ) {
            System.out.println("球星名字："+score.getStarName()+"，最高得分："+score.getStarScore());
        }
    }
}
