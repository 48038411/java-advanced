package com.soft1841.thread;

import javax.swing.*;
import java.awt.*;

public class DrawImageTest extends JFrame {
    public DrawImageTest(){
        this.setSize(500,300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        add(new CanvasTest());
        this.setTitle("新的方法绘制图像");
    }

    public static void main(String[] args) {
        //使窗体可见
        new DrawImageTest().setVisible(true);
    }
    class CanvasTest extends Canvas{
        public  void paint(Graphics g){
            super.paint(g);
            Graphics2D graphics2D = (Graphics2D) g;
            Image image = new ImageIcon(this.getClass().getResource("/img/time1.jpg")).getImage();
            graphics2D.drawImage(image,0,0,this);
        }
    }
}
