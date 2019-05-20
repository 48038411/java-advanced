package cn.soft1841.frame;

import cn.soft1841.entity.CodeImg;
import cn.soft1841.entity.Mobile;
import cn.soft1841.entity.Weather;
import cn.soft1841.service.CodeService;
import cn.soft1841.service.MobileLocationService;
import cn.soft1841.service.WeatherService;
import org.apache.commons.codec.binary.Base64;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
import java.util.List;

/**
 * @author 郭瑞昌
 * 工具运行窗体
 */
public class LifeTools {
    private JPanel mainPanel;
    private JPanel navPanel;
    private JButton numberBtn;
    private JButton weatherBtn;
    private JButton imgBtn;
    private JPanel centerPanel;
    private JPanel numberPanel;
    private JPanel weatherPanel;
    private JPanel imgPanel;
    private JTextField numberTextField;
    private JButton searchBtn;
    private JTextArea textArea1;
    private JTextField cityTextField;
    private JButton search1Btn;
    private JTextArea textArea2;
    private JTextField textField3;
    private JButton doBtn;
    private JLabel codeLabel;
    private JTextField textField;
    private JButton generateBtn;
    private JLabel codeImgLabel;
    CodeImg codeImg = null;
    Mobile mobile = null;
    public LifeTools(){
        CardLayout cardLayout= new CardLayout();
        centerPanel.setLayout(cardLayout);
        //将三张卡片加入面板，而且指定名称
        centerPanel.add("number",numberPanel);
        centerPanel.add("weather",weatherPanel);
        centerPanel.add("img",imgPanel);
        imgBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(centerPanel,"img");
            }
        });
        weatherBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(centerPanel, "weather");
            }
        });
        numberBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(centerPanel,"number");
            }
        });
        searchBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea1.setText("");
                String numName = numberTextField.getText().trim();
                try {
                    mobile = MobileLocationService.getPhone(numName);
                }catch (NullPointerException ex){
                    JOptionPane.showMessageDialog(null,"手机号码格式错误");
                }

                String province = mobile.getProvince();
                String city = mobile.getCity();
                int areacode = mobile.getAreacode();
                int zip = mobile.getZip();
                String company = mobile.getCompany();
                Font font = new Font(null,Font.BOLD,25);
                textArea1.setFont(font);
                textArea1.append("号码所在省份："+province+"\n");
                textArea1.append("所在城市："+city+"\n");
                textArea1.append("号码区号："+String.valueOf(areacode)+"\n");
                textArea1.append("该市邮编："+String.valueOf(zip)+"\n");
                textArea1.append("号码所属通信公司："+company+"\n");
            }
        });
        search1Btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea2.setText("");
                String cityName = cityTextField.getText().trim();
                List<Weather> weatherList = null;
                try {
                    weatherList = WeatherService.getWeather(cityName);
                } catch (NullPointerException ex) {
                    JOptionPane.showMessageDialog(null,"未查询到该城市相关信息或城市名错误");
                } catch (UnsupportedEncodingException ex) {
                    ex.printStackTrace();
                }
                for (Weather weather : weatherList) {
                  String date = "日期:"+weather.getDate();
                  String temperature = "温度:"+weather.getTemperature();
                  String weather1 = "天气:"+weather.getWeather();
                  String direct = "风向:"+weather.getDirect();
                    Font font = new Font(null,Font.BOLD,12);
                    textArea2.setFont(font);
                  textArea2.append(date+"\n");
                  textArea2.append(temperature+"\n");
                  textArea2.append(weather1+"\n");
                  textArea2.append(direct+"\n\n\n\n");
                }
            }
        });
        doBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = textField3.getText().trim();
                try {
                    codeImg = CodeService.getImage(text);
                } catch (UnsupportedEncodingException ex) {
                    ex.printStackTrace();
                }
                String base64 = codeImg.getBase64_image();
                byte[] content = base64.getBytes();
                byte[] b = Base64.decodeBase64(content);
                for (int i = 0; i < b.length; ++i){
            if (b[i] < 0){
                b[i] += 256;
            }
        }
        File file = new File("E:\\image\\"+text+".png");
                OutputStream out = null;
                try {
                    out = new FileOutputStream(file);
                    out.write(b);
                    out.flush();
                    out.close();
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                JOptionPane.showMessageDialog(null,"已生成二维码，并存储至E盘目录下image文件夹");
                ImageIcon icon = new ImageIcon(b);
                codeLabel.setIcon(icon);

            }
        });
    }

    public static void main(String[] args){
        JFrame frame = new JFrame("LifeTools");
        frame.setContentPane(new LifeTools().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000,800);
        String lookAndFeel = UIManager.getSystemLookAndFeelClassName();
        try {
            UIManager.setLookAndFeel(lookAndFeel);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        frame.setVisible(true);
    }
}
