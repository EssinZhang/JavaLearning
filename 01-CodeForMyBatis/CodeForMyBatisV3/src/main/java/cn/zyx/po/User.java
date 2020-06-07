package cn.zyx.po;

import java.util.Date;

/**
 * @Description
 * @ClassName user
 * @Author ZhangYixin
 * @date 2020.05.30 09:04
 */
public class User {

    /**
     * id int(11) NOT NULL
     * name varchar(45) NULL
     * phone varchar(20) NULL
     * address varchar(45) NULL
     * birthday date NULL
     */

    private int id;
    private String name;
    private String phone;
    private String address;
    private Date birthday;

    public User() {
    }

    public User(int id, String name, String phone, String address, Date birthday) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.birthday = birthday;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "user{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}
