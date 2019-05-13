package cn.soft1841.gui;

import javax.swing.*;

public class HuoRongSafe {
    private JPanel mainPanel;
    private JLabel logoLabel;
    private JButton 病毒查杀Button;
    private JButton 防护中心Button;
    private JButton 家长控制Button;
    private JButton 拓展工具Button;
    private JLabel label;

    public static void main(String[] args) {
        JFrame frame = new JFrame("HuoRongSafe");
        frame.setContentPane(new HuoRongSafe().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,515);
        frame.setVisible(true);
    }
}
