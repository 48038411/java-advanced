package com.soft1841.swing;

import javax.swing.*;
import java.awt.*;

public class Poem extends JFrame {
    public Poem(){
        setTitle("拓展训练2");
        Container container = getContentPane();
        setLayout(new FlowLayout(FlowLayout.CENTER,10,10));
        container.add(new JLabel("下面四句诗，哪一句是描写夏天的？"));
        container.add(new JLabel("A:秋风萧瑟天气凉，草木摇荡露为霜"));
        container.add(new JLabel("B:白雪纷纷何所似，撒盐空中差可拟"));
        container.add(new JLabel("C:接天莲叶无穷碧，映日荷花别样红"));
        container.add(new JLabel("D:竹外桃花三两枝，春江水暖鸭先知"));
        setSize(400,300);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setVisible(true);

    }

    public static void main(String[] args) {
        new Poem();
    }
}
