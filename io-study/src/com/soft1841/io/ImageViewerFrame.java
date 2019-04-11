package com.soft1841.io;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
/**
 * 使用卡片布局实现多图浏览功能
 * @author admin
 * 2019.04.02
 */
public class ImageViewerFrame extends JFrame implements ActionListener {
    private JButton chooseBtn,preBtn,nextBtn,firstBtn,lastBtn;
    private JFileChooser fileChooser;
    private JPanel centerPanel,bottomPanel;
    private CardLayout cardLayout;

    public ImageViewerFrame(){
        init();
        setTitle("多图浏览");
        setSize(1200,600);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    private void init(){
        //底部按钮面板，放置三个按钮
        bottomPanel = new JPanel();
        chooseBtn = new JButton("选择图片");
        chooseBtn.addActionListener(this);
        preBtn = new JButton("前一张");
        nextBtn = new JButton("后一张");
        firstBtn = new JButton("第一张");
        lastBtn = new JButton("最后一张");
        bottomPanel.add(chooseBtn);
        bottomPanel.add(firstBtn);
        bottomPanel.add(preBtn);
        bottomPanel.add(nextBtn);
        bottomPanel.add(lastBtn);
        preBtn.addActionListener(this);
        nextBtn.addActionListener(this);
        firstBtn.addActionListener(this);
        lastBtn.addActionListener(this);
        add(bottomPanel,BorderLayout.SOUTH);
        centerPanel = new JPanel();
        cardLayout = new CardLayout();
        centerPanel.setLayout(cardLayout);
        centerPanel.setBackground(new Color(40,44,52));
        add(centerPanel);
    }

    public static void main(String[] args) {
        try {
            BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.osLookAndFeelDecorated;
            BeautyEyeLNFHelper.launchBeautyEyeLNF();
        }catch (Exception e){
            e.printStackTrace();
        }
        new ImageViewerFrame();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //getSource方法，获取用户点击的哪个按钮，getCommand是获取按钮上的字。
        if (e.getSource() == chooseBtn){
            fileChooser = new JFileChooser();
            fileChooser.setCurrentDirectory(new File("E:\\myImage"));
            //设置文件为多选模式
            fileChooser.setMultiSelectionEnabled(true);
            //打开对话框,阻塞模式（其他窗口无法打开）
            int result = fileChooser.showOpenDialog(null);
            //用户选择了文件
            if (result == JFileChooser.APPROVE_OPTION) {
                //获取选中的所有文件,放入一个文件类型的数组中
                File[] files = fileChooser.getSelectedFiles();
                //遍历文件数组
                for (File f : files
                ) {
                    //对每个f文件创建字节输入流，构建Icon，并设置给JLabel;
                    byte[] bytes = new byte[(int) f.length()];
                    try {
                        InputStream inputStream = new FileInputStream(f);
                        inputStream.read(bytes);
                        Icon icon = new ImageIcon(bytes);
                        JLabel imgLabel = new JLabel();
                        imgLabel.setIcon(icon);
                        imgLabel.addMouseListener(new MouseAdapter() {
                            @Override
                            public void mouseClicked(MouseEvent e) {
                                super.mouseClicked(e);
                            }
                        });
                        centerPanel.add(imgLabel);
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(null, "IO异常");
                    }
                }
            }
        }
        if (e.getSource() == preBtn){
            cardLayout.previous(centerPanel);
        }
        if (e.getSource() == nextBtn){
            cardLayout.next(centerPanel);
        }
        if (e.getSource() == firstBtn){
            cardLayout.first(centerPanel);
        }
        if (e.getSource() == lastBtn){
            cardLayout.last(centerPanel);
        }
    }
}
