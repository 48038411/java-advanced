package cn.soft1841.service;

import cn.soft1841.entity.Menus;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import cn.soft1841.entity.Menus;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.util.HttpURLConnection;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 请求聚合的菜谱数据的service类
 */
public class MenusService {
    public static List<Menus> getMenus(String menu, String dtype, String pn, String rn){
        List<Menus> menusList = new ArrayList<>();
        List<Menus> menusList1 = new ArrayList<>();

        HttpClient client = new HttpClient();
        //请求的url，服务器返回的将是json数据
        GetMethod method = new GetMethod("http://apis.juhe.cn/cook/query?key=bf63083d38a603ea9bea79d9eb5c29db&menu="+menu+"&rn="+rn+"&pn=" +pn +"dtype="+dtype);
        int code;
        String data = "";
        try {
            //执行请求
            code = client.executeMethod(method);
            //如果成功
            if (code == HttpURLConnection.HTTP_OK){
                //将数据转成String
                data = method.getResponseBodyAsString();
                //通过fastjson 将String转成Java对象
                JSONObject jsonObject =JSONObject.parseObject(data);
                Object o = jsonObject.get("result");
                JSONObject jsonObject1 = JSONObject.parseObject(o.toString());
                menusList = JSONArray.parseArray(jsonObject1.get("data").toString(),Menus.class);
                menusList.forEach(menus -> System.out.println(menus));
                String img = String.valueOf(jsonObject1.get("data"));
                JSONArray j = JSONArray.parseArray(img);
                Object o1 = j.get(1);
                JSONObject j1 = JSONObject.parseObject(o1.toString());
                menusList1 = JSONArray.parseArray(j1.get("albums").toString(),Menus.class); }
            System.out.println(menusList1);
        } catch (HttpException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //释放连接
        method.releaseConnection();
        return  menusList;
    }

    public static void main(String[] args) {
        getMenus("%E7%BA%A2%E7%83%A7%E8%82%89","json","0","30");
    }
}



























