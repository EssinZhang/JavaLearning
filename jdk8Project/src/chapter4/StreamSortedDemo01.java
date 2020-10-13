package chapter4;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * description: StreamSortedDemo01 <br>
 * date: 2020/10/12 15:27 <br>
 *
 * @author: ZhangYixin <br>
 * version: 1.0 <br>
 */
public class StreamSortedDemo01 {

    public static void main(String[] args) {

        List<String> stringList = Arrays.asList("git", "es", "logstash", "kibana", "dubbo", "rocketMq");
        List<String> collect = stringList.stream().sorted().collect(Collectors.toList());
        System.out.println(collect);

        // 根据长度进行排序
        // 升序
        List<String> collect1 = stringList.stream().sorted(Comparator.comparing(obj -> obj.length())).collect(Collectors.toList());
        // 降序
        List<String> collect2 = stringList.stream()
                .sorted(Comparator.comparing(obj -> obj.length(), Comparator.reverseOrder()))
                .collect(Collectors.toList());
        // 用 双引号 静态方法引用 的方式做降序排序
        List<String> collect3 = stringList.stream().sorted(Comparator.comparing(String::length).reversed()).collect(Collectors.toList());
        System.out.println(collect1);
        System.out.println(collect2);
        System.out.println(collect3);

        // 只要前三个
        List<String> collect4 = stringList.stream().sorted(Comparator.comparing(String::length).reversed()).limit(3).collect(Collectors.toList());
        List<String> collect5 = stringList.stream()
                .sorted(Comparator.comparing(obj -> obj.length(), Comparator.reverseOrder()))
                .limit(4)
                .collect(Collectors.toList());
        System.out.println(collect4);
        System.out.println(collect5);

    }

}
