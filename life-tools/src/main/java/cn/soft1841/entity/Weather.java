package cn.soft1841.entity;

/**
 * @author 郭瑞昌
 * 天气预报的实体类
 */
public class Weather {
    private String date;//日期
    private String temperature;//温度
    private String weather;//天气
    private String direct;//风向

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public String getDirect() {
        return direct;
    }

    public void setDirect(String direct) {
        this.direct = direct;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "date='" + date + '\'' +
                ", temperature='" + temperature + '\'' +
                ", weather='" + weather + '\'' +
                ", direct='" + direct + '\'' +
                '}';
    }
}
