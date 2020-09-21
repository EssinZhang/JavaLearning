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
//        Person ps = new Person();
//
//        Optional<Person> ps2 = Optional.of(ps);
//        System.out.println("ps2"+ps2);
//
//        Optional<Person> ps1 = Optional.ofNullable(ps);
//        if (ps1.isPresent()) {
//            System.out.println("optinal对象不为空");
//            System.out.println(ps1.get());
//            System.out.println(ps1.get().age+"----------"+ps1.get().name);
//        }else {
//            System.out.println("optinal对象为空");
//        }

        Person person1 = null;
        Person personDemo = new Person("xiaogui",12);

        Person person = Optional.ofNullable(person1).orElse(personDemo);
        System.out.println("name:"+person.getName()+";age:"+person.getAge());

        //lambda表达式写法
        Integer integer = Optional.ofNullable(personDemo).map(obj -> obj.getAge()).orElse(7);
        System.out.println(integer);

    }

}
