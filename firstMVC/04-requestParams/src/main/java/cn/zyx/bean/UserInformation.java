package cn.zyx.bean;

public class UserInformation {

    private String username;
    private int userage;
    private Region region;

    //将地区作为用户信息的一个属性
    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getUserage() {
        return userage;
    }

    public void setUserage(int userage) {
        this.userage = userage;
    }
}
