package cn.zyx.bean;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

/**
 * 用户
 */
public class User {
    private String name;
    private String tel;
    private String addr;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birth;

    public User() {
    }

    public User(String name, String tel, String addr, LocalDate birth) {
        this.name = name;
        this.tel = tel;
        this.addr = addr;
        this.birth = birth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public LocalDate getBirth() {
        return birth;
    }

    public void setBirth(LocalDate birth) {
        this.birth = birth;
    }
}
