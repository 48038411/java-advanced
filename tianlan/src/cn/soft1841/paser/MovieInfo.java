package cn.soft1841.paser;

/**
 * @author 郭瑞昌
 * 自定义封装文件
 */
public class MovieInfo {
    private String title;
    private String actor;
    private String state;
    private String year;
    private String language;
    private String type;
    private String time;
    private String imgurl1;

    public MovieInfo(String imgurl1) {
        this.imgurl1 = imgurl1;
    }

    public MovieInfo(String title, String actor, String state, String year, String language, String type, String time) {
        this.title = title;
        this.actor = actor;
        this.state = state;
        this.year = year;
        this.language = language;
        this.type = type;
        this.time = time;
    }

    public MovieInfo() {
    }

    public String getImgurl1() {
        return imgurl1;
    }

    public void setImgurl1(String imgurl1) {
        this.imgurl1 = imgurl1;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return title+"\n"+actor+
                "\n"+state+
                "\n"+year+
                "\n"+language+
                "\n"+type+
                "\n"+time+"\n";
    }
}
