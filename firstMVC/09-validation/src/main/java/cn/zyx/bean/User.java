package cn.zyx.bean;

import javax.validation.constraints.*;

/**
 * 用户对象
 */
public class User {
    @NotEmpty(message = "姓名不能为空")
    @Size(min = 4,max = 20 , message = "长度为{min}到{max}个字符")
    private String name;

    @Min(value = 0,message = "年龄不能小于{value}")
    @Max(value = 120,message = "年龄不能大于{value}")
    private int age;

    @Pattern(regexp = "^1([358][0-9]|4[579]|66|7[0135678]|9[89])[0-9]{8}$", message = "手机号码不正确")
    private String tel;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}
