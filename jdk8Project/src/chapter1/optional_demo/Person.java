package chapter1.optional_demo;

/**
 * description: Person <br>
 * date: 2020/9/18 16:55 <br>
 *
 * @author: ZhangYixin <br>
 * version: 1.0 <br>
 */
public class Person {

    String name;

    int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

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
}
