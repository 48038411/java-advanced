package com.soft1841.io;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * 文件选择器组件JFileChooser
 * @author 郭瑞昌
 * 2019.04.02
 */
public class JFileChooserTest extends JFrame implements ActionListener {
    private JButton chooseBtn;
    private JLabel pathLabel;
    private JFileChooser fileChooser;

    @Override
    public void actionPerformed(ActionEvent e) {
        //创建JFileChooser对象
        fileChooser = new JFileChooser();
        //设置文件选择器的默认路径
        fileChooser.setCurrentDirectory(new File("E:\\"));
        //代表从项目路径开始fileChooser.setCurrentDirectory(new File("."));
        //用户如果点击了“确定”按钮
        int result = fileChooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION){
            File file = fileChooser.getSelectedFile();
            try {
                FileInputStream inputStream = new FileInputStream(file);
                Scanner scanner = new Scanner(inputStream);
                pathLabel.setText(scanner.nextLine());
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
        }
    }

    public JFileChooserTest(){
        init();
        setTitle("JFileChooser文件选择器");
        setSize(900,600);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    private void init(){
        chooseBtn = new JButton("选择文件");
        pathLabel = new JLabel("暂无选择");
        add(chooseBtn, BorderLayout.NORTH);
        chooseBtn.addActionListener(this);
        Font font = new Font("微软雅黑",Font.BOLD,26);
        pathLabel.setFont(font);
        add(pathLabel);
    }

    public static void main(String[] args) {
        try {
            BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.osLookAndFeelDecorated;
            BeautyEyeLNFHelper.launchBeautyEyeLNF();
        }catch (Exception e){
            e.printStackTrace();
        }
        new JFileChooserTest();
    }
}
