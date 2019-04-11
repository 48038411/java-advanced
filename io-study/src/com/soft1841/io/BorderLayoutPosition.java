package com.soft1841.io;

import javax.swing.*;
import java.awt.*;

public class BorderLayoutPosition extends JFrame {
    public BorderLayoutPosition(){
        setTitle("Border边界布局");
        //定义容器
        Container c = getContentPane();
        //设置边界管理布局
        setLayout(new BorderLayout());
        //中部添加按钮
        JButton centerBtn = new JButton("中神通");
        JButton northBtn = new JButton("北丐");
        JButton westBtn = new JButton("西毒");
        JButton southBtn = new JButton("南帝");
        JButton eastBtn = new JButton("东邪");
        c.add(centerBtn,BorderLayout.CENTER);
        c.add(northBtn,BorderLayout.NORTH);
        c.add(westBtn,BorderLayout.WEST);
        c.add(eastBtn,BorderLayout.EAST);
        c.add(southBtn,BorderLayout.SOUTH);
        setSize(350,300);
        //窗体可见
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

    public static void main(String[] args) {
        new BorderLayoutPosition();
    }
}