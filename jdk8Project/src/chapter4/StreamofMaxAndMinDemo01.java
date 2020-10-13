package chapter4;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

/**
 * description: StreamofMaxAndMin <br>
 * date: 2020/10/13 10:49 <br>
 *
 * @author: ZhangYixin <br>
 * version: 1.0 <br>
 */
public class StreamofMaxAndMinDemo01 {

    public static void main(String[] args) {
        List<Person> people = Arrays.asList(new Person(3), new Person(5), new Person(6), new Person(9), new Person(10));
        // 找出年龄最大的
        Optional<Person> maxAgePerson = people.stream().max((p1, p2) -> {
            return Integer.compare(p1.getAge(), p2.getAge());
        });
        // 找出年龄最小的
        Optional<Person> minAgePerson = people.stream().min(Comparator.comparingInt(Person::getAge));

        System.out.println(maxAgePerson.get().getAge());
        System.out.println(minAgePerson.get().getAge());

    }
}
