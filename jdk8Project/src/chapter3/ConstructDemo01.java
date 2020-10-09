package chapter3;

import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * description: ConstructDemo01 <br>
 * date: 2020/10/9 13:52 <br>
 *
 * @author: ZhangYixin <br>
 * version: 1.0 <br>
 */
public class ConstructDemo01 {

    public static void main(String[] args) {

        // 用双冒号来构造 静态函数引用  字符串转integer
        Function<String,Integer> fun = Integer::parseInt;
        Integer value = fun.apply("2048");
        System.out.println(value);

        // 用双冒号来构造 非静态函数引用  字符串剪切
        String str1 = "123测试字符串";
        Function<Integer,String> fun2 = str1::substring;
        String result1 = fun2.apply(2);
        System.out.println(result1);

        // 构造函数引用多个参数 这个每次调用apply就相当于new了一个User对象，如果要做一个User的list方便创建插入
        BiFunction<String,Integer,User> biFunction1 = User::new;
        User user1 = biFunction1.apply("kakaka1", 15);
        System.out.println(user1);

        // 构造函数引用单个参数
        Function<String,User> addFunction = User::new;
        User user2 = addFunction.apply("zouzouzou");
        System.out.println(user2);

        // 函数引用也是一种函数式接口，可以将函数引用作为方法的参数
        sayHello("大家好，我是sayHello",String::toUpperCase);
    }

    private static void sayHello(String param , Function<String,String> function){
        String result = function.apply(param);
        System.out.println(result);
    }
}
class User{
    private String name;

    private Integer age;

    public User() {
    }

    public User(String name) {
        this.name = name;
    }

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}