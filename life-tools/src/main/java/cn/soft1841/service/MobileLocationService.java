package cn.soft1841.service;

import cn.soft1841.entity.Mobile;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;

import java.io.IOException;
import java.net.HttpURLConnection;

/**
 * @author 郭瑞昌
 * 手机号码归属地查询的底层服务类
 */
public class MobileLocationService {
    public static Mobile getPhone(String mobilePhone){
        Mobile mobile = new Mobile();
        HttpClient client = new HttpClient();
        GetMethod method = new GetMethod("http://apis.juhe.cn/mobile/get?phone="+mobilePhone+"&key=991bf94894ceff1b1709d9ad9a76a560");
        int code;
        String data = "";
        //执行请求
        try {
            code = client.executeMethod(method);
            //如果成功
            if (code == HttpURLConnection.HTTP_OK) {
                //将数据转成String
                data = method.getResponseBodyAsString();
                //通过fastjson将String转成Java对象
                JSONObject jsonObject = JSONObject.parseObject(data);
                Object o = jsonObject.get("result");
                JSONObject jsonObject1 = JSONObject.parseObject(o.toString());
                String province = jsonObject1.getString("province").toString();
                mobile.setProvince(province);
                String city = jsonObject1.getString("city").toString();
                mobile.setCity(city);
                int areacode = jsonObject1.getInteger("areacode");
                mobile.setAreacode(areacode);
                int zip = jsonObject1.getInteger("zip");
                mobile.setZip(zip);
                String company = jsonObject1.getString("company");
                mobile.setCompany(company);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return mobile;
    }

    public static void main(String[] args) {
        Mobile mobile = getPhone("18851853897");
        System.out.println(mobile);
    }
}
