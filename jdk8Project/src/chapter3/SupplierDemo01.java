package chapter3;

import java.util.function.Supplier;

/**
 * description: SupplierTest01 <br>
 * date: 2020/9/28 13:50 <br>
 *
 * @author: ZhangYixin <br>
 * version: 1.0 <br>
 */
public class SupplierDemo01 {

    public static void main(String[] args) {
        // 调用创建默认对象的方法去创建对象
        Person person = newPerson();
        System.out.println(person.getName());
    }

    /**
     * 创建一个创建默认对象的方法
     * @return
     */
    public static Person newPerson(){
        Supplier<Person> personSupplier = ()->{
            Person person = new Person();
            person.setName("god");
            person.setAge(99999);
            return person;
        };
        return personSupplier.get();
    }


}

/**
 * 创建一个Person类
 */
class Person {

    String name;

    int age;

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