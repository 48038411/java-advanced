package cn.soft1841.frame;

import cn.soft1841.entity.CodeImg;
import cn.soft1841.service.CodeService;
import org.apache.commons.codec.binary.Base64;

import javax.swing.*;
import java.awt.*;
import java.io.*;

/**
 * @author 郭瑞昌
 * 关于二维码的api将Base64编码转换为图片的测试窗体
 */
public class TestFrame extends JFrame {
    CodeImg codeImg = new CodeImg();
    private JLabel imgLabel;
    private Icon icon;
    public TestFrame() throws IOException {
        init();
        setTitle("线程的暂停与恢复");
        setSize(500,400);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    public void init() throws IOException {
        try {
            codeImg = CodeService.getImage("测试");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        imgLabel = new JLabel();
        String base64Image = codeImg.getBase64_image();
        byte[] content = base64Image.getBytes();
//        byte[] b = Base64.decodeBase64(bytes);
//        for (int i = 0; i < b.length; ++i){
//            if (b[i] < 0){
//                b[i] += 256;
//            }
//        }
//        File file = new File("E:\\image\\codeImg.png");
//        OutputStream out = new FileOutputStream(file);
//        out.write(b);
//        out.flush();
//        out.close();
//        InputStream inputStream;
//        byte[] bytes1 = null;
//        try {
//            inputStream = new FileInputStream(file);
//            bytes1 = new byte[(int) file.length()];
//            inputStream.read(bytes1);
//        } catch (IOException e) {
//            System.out.println("IO异常");
//        }
//        InputStream in = new ByteArrayInputStream(content);
//        in.read(content);
        byte[] b = Base64.decodeBase64(content);
        ImageIcon icon = new ImageIcon(b);
        imgLabel.setIcon(icon);
        add(imgLabel, BorderLayout.CENTER);
    }
    public static void main(String[] args) throws IOException {
        new TestFrame();
    }
}
