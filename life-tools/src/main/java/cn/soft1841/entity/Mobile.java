package cn.soft1841.entity;

/**
 * @author 郭瑞昌
 * 手机号码归属地查询的实体类
 */
public class Mobile {
    private String province;//省份
    private String city;//城市名
    private Integer areacode;//区号
    private Integer zip;//邮编
    private String company;//所属公司

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getAreacode() {
        return areacode;
    }

    public void setAreacode(Integer areacode) {
        this.areacode = areacode;
    }

    public Integer getZip() {
        return zip;
    }

    public void setZip(Integer zip) {
        this.zip = zip;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "Mobile{" +
                "province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", areacode=" + areacode +
                ", zip=" + zip +
                ", company='" + company + '\'' +
                '}';
    }
}
