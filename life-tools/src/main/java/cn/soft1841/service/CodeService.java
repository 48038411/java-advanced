package cn.soft1841.service;

import cn.soft1841.entity.CodeImg;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URLEncoder;

/**
 * @author 郭瑞昌
 * 二维码的底层服务类
 */
public class CodeService {
    public static CodeImg getImage(String type) throws UnsupportedEncodingException {
        CodeImg codeImg = new CodeImg();
        HttpClient client = new HttpClient();
        GetMethod method = new GetMethod("http://apis.juhe.cn/qrcode/api?key=79f2353c87a5a44d38053825c978859a&type=1&fgcolor=00b7ee&w=90&m=5&text="+ URLEncoder.encode(type,"utf-8"));
        int code;
        String data = "";
        //执行请求
        try {
            code = client.executeMethod(method);
            //如果成功
            if (code == HttpURLConnection.HTTP_OK) {
                //将数据转成String
                data = method.getResponseBodyAsString();
                //System.out.println(data);
                //通过fastjson将String转成Java对象
                JSONObject jsonObject = JSONObject.parseObject(data);
                Object o = jsonObject.get("result");
                JSONObject jsonObject1 = JSONObject.parseObject(o.toString());
                //System.out.println(jsonObject1);
                String base64Image = jsonObject1.getString("base64_image");
                codeImg.setBase64_image(base64Image);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return codeImg;
    }

    public static void main(String[] args) throws UnsupportedEncodingException {
        CodeImg codeImg = getImage("测试一下");
        System.out.println(codeImg);
    }
}
