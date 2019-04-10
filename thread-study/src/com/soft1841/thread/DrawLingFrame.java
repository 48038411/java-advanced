package com.soft1841.thread;

import com.sun.org.apache.xml.internal.security.Init;

import javax.swing.*;
import java.awt.*;

public class DrawLingFrame extends JFrame {
    public DrawLingFrame(){
        Init();
        setTitle("彩绘彩色线段");
        setSize(900,600);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    private void Init(){
        getContentPane().setBackground(new Color(0,0,0));
        DrawLineThread drawLineThread = new DrawLineThread();
        drawLineThread.setFrame(this);
        new Thread(drawLineThread).start();
    }

    public static void main(String[] args) {
        new DrawLingFrame();
    }
}
