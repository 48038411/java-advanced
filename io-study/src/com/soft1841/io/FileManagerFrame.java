package com.soft1841.io;



import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class FileManagerFrame extends JFrame implements ActionListener {

    private JButton imgBtn, textBtn, copyBtn, chooseBtn;
    private JPanel topPanel, rightPanel, leftPanel;
    private JFileChooser fileChooser;
    private CardLayout cardLayout;
    private GridLayout gridLayout;
    private JLabel imgLabel, textLabel;
    private Icon icon;
    private Container leftContainer;
    private JLabel[] labels;

    public FileManagerFrame() {
        init();
        setTitle("文件管理器");
        setSize(1655, 920);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    }

    //init初始化方法
    public void init() {
        //创建卡片布局对象
        cardLayout = new CardLayout();
        //创建容器
        topPanel = new JPanel();

        copyBtn = new JButton("备份");
        copyBtn.addActionListener(this);
        copyBtn.setPreferredSize(new Dimension(80, 40));
        topPanel.add(copyBtn);

        imgBtn = new JButton("图片");
        imgBtn.addActionListener(this);
        imgBtn.setPreferredSize(new Dimension(80, 40));
        topPanel.add(imgBtn);

        textBtn = new JButton("文本");
        textBtn.addActionListener(this);
        textBtn.setPreferredSize(new Dimension(80, 40));
        topPanel.add(textBtn);

        chooseBtn = new JButton("选择");
        chooseBtn.addActionListener(this);
        chooseBtn.setPreferredSize(new Dimension(80, 40));
        topPanel.add(chooseBtn);


        //设置容器
        Container c = getContentPane();
        //将容器设为网格布局
        c.setLayout(new GridLayout(1, 2, 5, 5));
        //定义左侧容器为边界布局
        leftContainer = new Container();
        leftContainer.setLayout(new BorderLayout());
        //定义leftPanel为网格布局
        leftPanel = new JPanel(new GridLayout(5, 2, 5, 5));
        //定义右侧
        rightPanel = new JPanel();
        rightPanel.setBackground(new Color(98, 151, 85));
        leftContainer.add(leftPanel);
        leftContainer.add(topPanel, BorderLayout.NORTH);
        Font font = new Font("微软雅黑",Font.BOLD,25);
        textLabel.setFont(font);
        c.add(leftContainer);
        c.add(rightPanel);
    }

    public static void main(String[] args) {
        new FileManagerFrame();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //文件备份
        if (e.getSource() == copyBtn) {
            //创建选择器对象
            fileChooser = new JFileChooser();
            //设置文件选择器默认路径
            fileChooser.setCurrentDirectory(new File("E:/"));
            //打开对话框
            int result = fileChooser.showOpenDialog(null);
            //在控制台输出，看看用户点击按钮时控制台的result值输出情况，判断用户点击的是哪个按钮，
            // 用条件语句，点击确认执行点击取消则什么都不做
            System.out.println(result);
            //设置用户是否选择了确认按钮
            if (result == JFileChooser.APPROVE_OPTION) {
                //获取用户选择文件
                File srcFile = fileChooser.getSelectedFile();
                String sreFileStream = srcFile.getName();
                //定位"."的位置
                int position = sreFileStream.indexOf(".");
                //取得源文件的扩展名
                String suffixName = sreFileStream.substring(position + 1);
                //指定目标文件
                File destFile = new File("E:/" + sreFileStream + "副本" + "." + suffixName);
                //创建一个字节数组，大小为源文件大小
                byte[] bytes = new byte[(int) srcFile.length()];
                //创建字节输入流
                InputStream in = null;
                try {
                    in = new FileInputStream(srcFile);
                    //将源文件读入字节数组
                    in.read(bytes);
                    //创建字节输出流
                    OutputStream out = new FileOutputStream(destFile, true);
                    //将字节数组通过字节输出流写入目标文件
                    out.write(bytes);
                    //关闭输入输出流
                    in.close();
                    out.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                if (destFile.exists()) {
                    JOptionPane.showMessageDialog(null, "操作成功");
                } else {
                    JOptionPane.showMessageDialog(null, "操作失败");
                }
            }
        }
        if (e.getSource() == imgBtn) {
            //创建选择器对象
            fileChooser = new JFileChooser();
            //设置文件选择器默认路径
            fileChooser.setCurrentDirectory(new File("E:/"));
            //设置文件多选模式
            fileChooser.setMultiSelectionEnabled(true);
            //打开对话框
            int result2 = fileChooser.showOpenDialog(null);
            //在控制台输出，看看用户点击按钮时控制台的result值输出情况，判断用户点击的是哪个按钮，
            // 用条件语句，点击确认执行点击取消则什么都不做
            System.out.println(result2);
            //设置用户是否选择了确认按钮
            //用户选择了文件
            if (result2 == JFileChooser.APPROVE_OPTION) {
                //获取选中的所有文件,放到一个文件类型的数组中
                File[] files = fileChooser.getSelectedFiles();
                InputStream inputStream;
                byte[] bytes;
                gridLayout = new GridLayout((files.length / 3) + 1, 3, 5, 5);
                leftPanel.setLayout(gridLayout);
                labels = new JLabel[files.length];
                for (int i = 0; i < files.length; i++) {
                    labels[i] = new JLabel();
                    try {
                        files = fileChooser.getSelectedFiles();
                        inputStream = new FileInputStream(files[i]);
                        bytes = new byte[(int) files[i].length()];
                        inputStream.read(bytes);
                        Icon icon = new ImageIcon(bytes);
                        labels[i].setIcon(icon);
                        labels[i].addMouseListener(new MouseAdapter() {
                            @Override
                            public void mouseClicked(MouseEvent e) {
                                File[] file1= fileChooser.getSelectedFiles();
                                for (File f : file1
                                ) {
                                    //对每个f文件创建字节输入流，构建Icon，并设置给JLabel;
                                    byte[] bytes = new byte[(int) f.length()];
                                    try {
                                        InputStream inputStream = new FileInputStream(f);
                                        inputStream.read(bytes);
                                        Icon icon = new ImageIcon(bytes);
                                        JLabel imgLabel = new JLabel();
                                        imgLabel.setIcon(icon);
                                        rightPanel.add(imgLabel);
                                    } catch (IOException ex) {
                                        JOptionPane.showMessageDialog(null, "IO异常");
                                    }
                                }
                            }
                        });
                        leftPanel.add(labels[i]);
                    } catch (IOException e1) {
                        JOptionPane.showMessageDialog(null, "IO异常");
                    }
                }

            }

        }
        if (e.getSource() == textBtn) {
            //创建选择器对象
            fileChooser = new JFileChooser();
            //设置文件选择器默认路径
            fileChooser.setCurrentDirectory(new File("E:/"));
            //打开对话框
            int result3 = fileChooser.showOpenDialog(null);
            //在控制台输出，看看用户点击按钮时控制台的result值输出情况，判断用户点击的是哪个按钮，
            // 用条件语句，点击确认执行点击取消则什么都不做
            System.out.println(result3);
            //设置用户是否选择了确认按钮
            if (result3 == JFileChooser.APPROVE_OPTION) {
                File srcFile = fileChooser.getSelectedFile();
                String name = srcFile.getName();
                int position = name.indexOf(".");
                String suffixName = name.substring(position + 1);
                System.out.println(suffixName);
                if (suffixName.equals("txt")) {
                    byte[] bytes = new byte[(int) srcFile.length()];
                    InputStream in = null;
                    try {
                        in = new FileInputStream(srcFile);
                        in.read(bytes);
                        OutputStream out = new FileOutputStream(srcFile, true);
                        String s = new String(bytes);
                        System.out.println(s);
                        textLabel = new JLabel(s);
                        rightPanel.add(textLabel);
                        in.close();
                        out.close();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "请选择文本");
                }

            }
        }

        if (e.getSource() == chooseBtn) {
            //创建选择器对象
            fileChooser = new JFileChooser();
            //设置文件选择器默认路径
            fileChooser.setCurrentDirectory(new File("E:/"));
            //设置文件多选模式
            fileChooser.setMultiSelectionEnabled(true);
            //打开对话框
            int result4 = fileChooser.showOpenDialog(null);
            System.out.println(result4);
            if (result4 == JFileChooser.APPROVE_OPTION) {
                File srcFile = fileChooser.getSelectedFile();
                String name = srcFile.getName();
                int position = name.indexOf(".");
                String suffixName = name.substring(position + 1);
                System.out.println(suffixName);
                    try {
                        InputStream inputStream = new FileInputStream(srcFile);
                        byte[] bytes = new byte[(int) srcFile.length()];
                        inputStream.read(bytes);
                        icon = new ImageIcon(bytes);
                        imgLabel = new JLabel();
                        imgLabel.setIcon(icon);

                        leftPanel.setBackground(new Color(184,102,85));
                        leftPanel.add(imgLabel);
                    } catch (IOException e1) {
                        System.out.println("IO异常");
                    }
            }
        }
    }
}
//}