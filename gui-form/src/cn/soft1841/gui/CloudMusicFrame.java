package cn.soft1841.gui;

import javax.swing.*;

public class CloudMusicFrame {
    private JPanel mainPanel;
    private JPanel leftPanel;
    private JButton 搜索Button;
    private JButton 发现Button;
    private JButton MVButton;
    private JButton 朋友Button;
    private JPanel centerPanel;
    private JLabel bannerLabel;
    private JPanel musicPanel;
    private JLabel img1Label;
    private JLabel img2Label;
    private JLabel img3Label;
    private JLabel img4Label;
    private JLabel img5Label;
    private JLabel bottomLabel;

    public static void main(String[] args) throws Exception {
        //根据系统设置swing的外观
        String lookAndFeel = UIManager.getSystemLookAndFeelClassName();
        UIManager.setLookAndFeel(lookAndFeel);
        JFrame frame = new JFrame("CloudMusicFrame");
        frame.setContentPane(new CloudMusicFrame().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //窗体全屏
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setVisible(true);
    }
}
