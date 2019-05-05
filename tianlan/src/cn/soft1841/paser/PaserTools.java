package cn.soft1841.paser;
import org.eclipse.swt.SWT;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author 郭瑞昌
 * 爬取电影资源主程序界面（爬取网址为迅雷仓：https://www.xunleicang.com/）
 * 2019.04.28
 */
public class PaserTools extends JFrame implements ActionListener {
    private JPanel topPanel,centerPanel,bottomPanel;
    private JList list;
    private DefaultListModel listModel;
    private JLabel tipLabel,photoLabel;
    private JTextField inputTextField;
    private JButton submitBtn;
    private JTextArea text;
    private JLabel imgLabel;
    public PaserTools(){
        init();
        setTitle("天蓝影音");
        setSize(600,800);
        setLocationRelativeTo(null);
        setResizable(true);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    public void init(){
        photoLabel = new JLabel();
        tipLabel = new JLabel("电影名称：");
        topPanel = new JPanel();
        FlowLayout f = new FlowLayout();
        f.setVgap(30);
        f.setHgap(30);
        centerPanel = new JPanel();
        centerPanel.setLayout(f);
        bottomPanel = new JPanel();
        bottomPanel.setBackground(new Color(28, 162, 97));
        imgLabel = new JLabel();
        ImageIcon image = new ImageIcon(this.getClass().getResource("/img/banner1.jpg"));
        imgLabel.setIcon(image);
        text = new JTextArea();
        text.setLineWrap(true);
        text.setWrapStyleWord(true);
        text.setBackground(new Color(28, 162, 97));
        //启动首页banner轮播
        Thread thread = new ImageThread(imgLabel);
        thread.start();
        topPanel.setPreferredSize(new Dimension(400,200));
        centerPanel.setPreferredSize(new Dimension(400,80));
        bottomPanel.setPreferredSize(new Dimension(400,300));
        centerPanel.setBackground(new Color(28, 162, 97));
        submitBtn = new JButton("确认");
        submitBtn.setBackground(new Color(199, 84, 80));
        submitBtn.setPreferredSize(new Dimension(100,40));
        submitBtn.addActionListener(this);
        inputTextField = new JTextField("请输入你想查看的电影");
        inputTextField.setPreferredSize(new Dimension(200,40));
        topPanel.add(imgLabel);
        centerPanel.add(tipLabel);
        centerPanel.add(inputTextField);
        centerPanel.add(submitBtn);
        photoLabel.setBounds(400,400,147,205);
        text.setBounds(400,400,147,205);
        add(topPanel,BorderLayout.NORTH);
        add(centerPanel,BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);
    }
    public static void main(String[] args){
        new PaserTools();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==submitBtn){
            //当用户点击确认时，清除组件内容
            bottomPanel.removeAll();
            bottomPanel.revalidate();
            bottomPanel.repaint();
            //拼接url，根据用户输入的电影名称进行搜索
            String url = "https://www.xunleicang.com/vod-search?wd="+inputTextField.getText().trim();
            Connection connection = Jsoup.connect(url);
            Document document = null;
            try {
                document = connection.get();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            //检索该网页所有的标签
            Elements h1 = document.getElementsByClass("movList4");
            System.out.println("共检索出"+h1.size()+"个资源");
            //遍历h1，解析url中的标签
            for (Element link : h1) {
                //确认标签位置，获取a标签中href属性的值
                Element element = link.child(0).child(0).child(0);
                String url1 = "https://www.xunleicang.com"+element.attr("href");
                Connection connection1 = Jsoup.connect(url1);
                Document document1 = null;
                try {
                    document1 = connection1.get();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                //将获取到的href属性链接解析并遍历(准确电影地址)
                Elements newJianjie = document1.getElementsByClass("moviecont");
                for (Element description:newJianjie
                     ) {
                    //解析标签，获取值
                    Element element1 = description.child(0).child(2).child(0);
                    //获取演员名称
                    String actor = element1.text();
                    Element element2 = description.child(0).child(1);
                    //获取电影名称
                    String title = element2.text();
                    //创建JList列表，在遍历中可循环生成，用于搜索结果为多个时展示全面
                    listModel = new DefaultListModel();
                    //将遍历到的电影名称加入到list列中
                    listModel.addElement(title);
                    list = new JList(listModel);
                    list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                    list.setSelectedIndex(0);
                    list.setVisibleRowCount(5);
                    list.setBackground(new Color(28, 162, 97));
                    list.setPreferredSize(new Dimension(100,60));
                    //将list加入滑动面板中
                    JScrollPane listScrollPane = new JScrollPane(list);
                    //将面板添加至底部
                    bottomPanel.add(listScrollPane);
                    Element element3 = description.child(0).child(3).child(0);
                    //获取当前电影状态
                    String state = element3.text();
                    Element element4 = description.child(0).child(4).child(0);
                    //获取电影年份
                    String year = element4.text();
                    Element element5 = description.child(0).child(4).child(1);
                    //获取电影语言
                    String language = element5.text();
                    Element element6 = description.child(0).child(5).child(0);
                    //获取电影类型
                    String type = element6.text();
                    Element element7 = description.child(0).child(5).child(1);
                    //获取当前电影更新时间
                    String time = element7.text();
                    //获取当前电影的展示图
                    Element img = description.child(0).child(0).child(0);
                    //自定义封装的MovieInfo类，使用方便
                    MovieInfo movieInfo = new MovieInfo(title,actor,state,year,type,language,time);
                    System.out.println(movieInfo);
                    //将查询到的界面保存至E盘目录下（原本想爬取网站风格）
                    String log = movieInfo.toString();
                    File file = new File("E:/log.txt");
                    Writer out = null;
                    try {
                        out = new FileWriter(file,true);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    try {
                        out.write(log);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    //给list添加监听事件，单击后打开新窗体，展示全面的电影信息
                    list.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            JFrame frame = new JFrame(title);
                            frame.setLocation(100,50);
                            frame.setSize(500,500);
                            frame.setVisible(true);
                            //获取当前页面中，img标签中的src属性，从而得到图片地址
                            URL imgurl= null;
                            try {
                                imgurl = new URL(img.attr("src"));
                            } catch (MalformedURLException ex) {
                                ex.printStackTrace();
                            }
                            //将图片地址打开并存入ByTeArray字节中，以便展示
                            BufferedInputStream bis= null;
                            try {
                                bis = new BufferedInputStream(imgurl.openStream());
                            } catch (IOException ex) {
                                ex.printStackTrace();
                            }
                            ByteArrayOutputStream baos=new ByteArrayOutputStream();
                            int i = 0;
                            while(true){
                                try {
                                    if (!((i=bis.read())!=-1)) break;
                                } catch (IOException ex) {
                                    ex.printStackTrace();
                                }
                                baos.write(i);
                            }

                            try {
                                bis.close();
                            } catch (IOException ex) {
                                ex.printStackTrace();
                            }
                            //设置电影展示图
                            ImageIcon imgIcon = new ImageIcon(baos.toByteArray());
                            JLabel imgLabel = new JLabel();
                            JButton btn = new JButton("观看");
                            //给观看按钮添加点击事件，应用了SWTBrowser第三方浏览器，需加库
                            btn.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    Display display=new Display();
                                    Shell shell = new Shell(display);
                                    shell.setLayout(new FillLayout());
                                    final Browser browser = new Browser(shell, SWT.NONE);
                                    browser.setLayoutData(BorderLayout.CENTER);
                                    System.out.println(url1);
                                    browser.setUrl(url1);
                                    shell.setText(title+"-天蓝影音");
                                    browser.setVisible(true);
                                    shell.open();
                                    //关闭释放内存操作
                                    while (!shell.isDisposed()) {
                                        if (!display.readAndDispatch()) display.sleep();
                                    }
                                    display.dispose();
                                }
                            });
                            imgLabel.setIcon(imgIcon);
                            frame.add(imgLabel,BorderLayout.NORTH);
                            JTextArea text = new JTextArea();
                            text.setText(String.valueOf(movieInfo));
                            text.setEditable(false);
                            frame.add(text,BorderLayout.CENTER);
                            frame.add(btn,BorderLayout.SOUTH);
                            frame.setBackground(new Color(238, 238, 238));
                        }
                    });
                    try {
                        out.close();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        }
    }
}
