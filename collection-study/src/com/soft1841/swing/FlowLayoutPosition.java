package com.soft1841.swing;

import javax.swing.*;
import java.awt.*;

public class FlowLayoutPosition extends JFrame {
    public FlowLayoutPosition(){
        setTitle("流布局管理器");
        Container container = getContentPane();
        //设置窗体使用流布局管理器，使组件右对齐，组件间的水平间隔为10px，垂直为10px
        setLayout(new FlowLayout(FlowLayout.RIGHT,10,10));
        for (int i = 0; i<10; i++){
            container.add(new JButton("按钮"+ i));
        }
        setSize(300,200);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new FlowLayoutPosition();
    }
}
