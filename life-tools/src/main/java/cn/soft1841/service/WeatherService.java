package cn.soft1841.service;

import cn.soft1841.entity.Weather;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.GetMethod;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 郭瑞昌
 * 天气预报查询的底层服务类
 */
public class WeatherService {
    public static List<Weather> getWeather(String cityName) throws UnsupportedEncodingException {
        List<Weather> weatherList = new ArrayList<Weather>();
        HttpClient client = new HttpClient();
        GetMethod method = new GetMethod("http://apis.juhe.cn/simpleWeather/query?city="+URLEncoder.encode(cityName,"utf-8")+"&key=250ddc267b8801d4b316d7ef418278e2");
        int code;
        String data = "";
        try {
            //执行请求
            code = client.executeMethod(method);
            //如果成功
            if (code == HttpURLConnection.HTTP_OK) {
                //将数据转成String
                data = method.getResponseBodyAsString();
                //通过fastjson将String转成Java对象
                JSONObject jsonObject = JSONObject.parseObject(data);
                Object o = jsonObject.get("result");
                System.out.println(o.toString());
                JSONObject jsonObject1 = JSONObject.parseObject(o.toString());
                weatherList = JSONArray.parseArray(jsonObject1.get("future").toString(), Weather.class);
                weatherList.forEach(news -> System.out.println(news));
            }
        } catch (HttpException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        method.releaseConnection();//释放连接
        return weatherList;
    }

    public static void main(String[] args) throws UnsupportedEncodingException {
        getWeather("霍州");
    }
}
