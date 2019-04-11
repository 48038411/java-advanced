package com.soft1841.io;

import com.sun.org.apache.xml.internal.security.Init;
import sun.plugin.javascript.JSContext;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 网格布局
 * @author 郭瑞昌
 * 2019.3.27
 */
public class GridLayoutTest extends JFrame {
    private  JPanel[] panels;
    private JLabel content;
    private JLabel imgLabel;
    private Icon icon;
    private JTextField textField;
    private GridLayoutTest(){
        init();
        setTitle("GridLayout网格布局管理器");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public void init(){
        getContentPane().setBackground(new Color(255,255,255));
        GridLayout gridLayout = new GridLayout(3,3,50,30);
        setLayout(gridLayout);
        panels = new JPanel[9];
        for (int  i = 0 ;i<9;i++){
            panels[i]= new JPanel();
            panels[i].setBorder(BorderFactory.createTitledBorder("面板"+(i+1)));
            add(panels[i]);
        }
        //第一个
        panels[0].setBackground(new Color(123,121,121));
        for (int i = 0; i < 5; i++) {
            panels[0].add(new JButton("Java"));
        }
        //第二个
        panels[1].setLayout(new BorderLayout(20, 20));
        panels[1].setBackground(new Color(122, 179, 123));
        panels[1].add(new JButton("北"), BorderLayout.NORTH);
        panels[1].add(new JButton("南"), BorderLayout.SOUTH);
        panels[1].add(new JButton("东"), BorderLayout.EAST);
        panels[1].add(new JButton("西"), BorderLayout.WEST);
        panels[1].add(new JButton("中"), BorderLayout.CENTER);
        //第三个
        panels[2].setLayout(new GridLayout(3, 3, 10, 10));
        panels[2].setBackground(new Color(177, 192, 172));
        //依次加入9个按钮
        for (int i = 0; i < 9; i++) {
            panels[2].add(new JButton(String.valueOf(i + 1)));
        }
        //第四个
        panels[3].setBackground(new Color(223,221,232));
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String date = format.format(new Date());
        content = new JLabel(date);
        panels[3].add(content);
        //第四个
        panels[4].setBackground(new Color(13,221,232));
        imgLabel = new JLabel();//可以为空
        //读入本地的图片到字节数组
        File srcFile = new File("E:/test.jpg");
        byte[] bytes = null;
        InputStream inputStream;
        try {
            //图片到bytes
            inputStream = new FileInputStream(srcFile);
            bytes= new byte[(int) srcFile.length()];
            inputStream.read(bytes);
            inputStream.close();
        } catch (IOException e) {
            System.out.println("IO异常");
        }
        icon = new ImageIcon(bytes);
        imgLabel.setIcon(icon);
        panels[4].add(imgLabel);

        //第五个
        panels[5].setBackground(new Color(223,221,232));
        textField = new JTextField("第五个面板---");
        panels[5].add(textField);

        //第六个
        panels[6].setBackground(new Color(113,21,232));
        JComboBox<String> comboBox = new JComboBox<String>();
        comboBox.setBounds(110,11,80,21);
        comboBox.addItem("100");
        comboBox.addItem("200");
        comboBox.addItem("500");
        comboBox.addItem("1000");
        getContentPane().add(comboBox);
        JLabel label = new JLabel("");
        label.setBounds(77,57,146,15);
        getContentPane().add(label);
        JButton bt = new JButton("确定");
        bt.setBounds(200,10,67,23);
        getContentPane().add(bt);
        textField = new JTextField("选择您要取款的金额");
        panels[6].add(textField);
        panels[6].add(comboBox);
        panels[6].add(label);
        panels[6].add(bt);
        //第七个
        panels[7].setBackground(new Color(223,221,232));
        String[] contents ={"面板1","面板2","面板3","面板4","面板5"};
        JList<String> jList = new JList<>(contents);
        JScrollPane jScrollPane = new JScrollPane(jList);
        jScrollPane.setBounds(100,10,109,100);
        panels[7].add(jScrollPane);
        //第八个
        panels[8].setBackground(new Color(132,21,222));
        JCheckBox comboBox1 = new JCheckBox("1");
        JCheckBox comboBox2 = new JCheckBox("2");
        JCheckBox comboBox3 = new JCheckBox("3");
        panels[8].add(comboBox1);
        panels[8].add(comboBox2);
        panels[8].add(comboBox3);

    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        new GridLayoutTest();
    }
}
