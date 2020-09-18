package chapter1.optional_demo;


import java.util.Optional;

/**
 * description: OptionalDemo01 <br>
 * date: 2020/9/18 14:55 <br>
 *
 * @author: ZhangYixin <br>
 * version: 1.0 <br>
 */
public class OptionalDemo01 {

    public static void main(String[] args) {
        Person ps = null;

        //Optional<Person> opt = Optional.of(ps);

        Optional<Person> ps1 = Optional.ofNullable(ps);
        System.out.println(ps1);
    }

}
