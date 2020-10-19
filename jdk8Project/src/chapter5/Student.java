package chapter5;

/**
 * description: Student <br>
 * date: 2020/10/16 16:13 <br>
 *
 * @author: ZhangYixin <br>
 * version: 1.0 <br>
 */
public class Student {
    private String province;
    private int age;

    public Student(String province, int age) {
        this.province = province;
        this.age = age;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
