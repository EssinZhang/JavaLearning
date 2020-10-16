package chapter5;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * description: CollectorDemo01 <br>
 * date: 2020/10/14 15:23 <br>
 *
 * @author: ZhangYixin <br>
 * version: 1.0 <br>
 */
public class CollectorDemo01 {
    public static void main(String[] args) {
        // 创建list
        List<String> stringList = Arrays.asList("java", "python", "golang", "C#", "Julia", "shell");
        // 排序
        List<String> collect = stringList.stream().sorted().collect(Collectors.toList());
        // 遍历输出
        collect.forEach(System.out::println);
    }
}
