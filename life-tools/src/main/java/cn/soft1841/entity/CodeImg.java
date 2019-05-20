package cn.soft1841.entity;

/**
 * @author 郭瑞昌
 * 二维码的实体类
 */
public class CodeImg {
    //用驼峰式命名的话获取不到内容
    private String base64_image;

    public String getBase64_image() {
        return base64_image;
    }

    public void setBase64_image(String base64_image) {
        this.base64_image = base64_image;
    }

    @Override
    public String toString() {
        return "CodeImg{" +
                "base64_image='" + base64_image + '\'' +
                '}';
    }
}
