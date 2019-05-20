package cn.soft1841.util;

import cn.soft1841.entity.CodeImg;
import cn.soft1841.service.CodeService;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class Base64ImgsUtil {
    static BASE64Encoder encoder = new BASE64Encoder();
    static BASE64Decoder decoder = new BASE64Decoder();
    public static void base64StringToImage(CodeImg base64String, String outPath) {
        try {
            byte[] bytes = decoder.decodeBuffer(String.valueOf(base64String));
            ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
            BufferedImage bi1 = ImageIO.read(bais);
            File file = new File(outPath);// 可以是jpg,png,gif格式
            ImageIO.write(bi1, "jpg", file);// 不管输出什么格式图片，此处不需改动
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    public static void main(String[] args) throws UnsupportedEncodingException {
//        base64StringToImage(CodeService.getImage("测试"),"E:\\");
//    }
}
