package chapter5;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * description: GroupByDemo01 <br>
 * date: 2020/10/16 09:37 <br>
 *
 * @author: ZhangYixin <br>
 * version: 1.0 <br>
 */
public class GroupingByDemo01 {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(new Student("辽宁", 18), new Student("吉林", 19),
                new Student("辽宁", 23), new Student("吉林", 20),
                new Student("辽宁", 24), new Student("吉林", 23));

        Map<String, List<Student>> result = students.stream().collect(Collectors.groupingBy(obj -> obj.getProvince()));

        // 结果遍历
        result.forEach((key,value)->{
            System.out.println("--------------------");
            System.out.println(key);
            value.forEach(obj->{
                System.out.println(obj.getAge());
            });
        });
        // 分组统计
        Map<String, Long> results = students.stream().collect(Collectors.groupingBy(Student::getProvince, Collectors.counting()));
        results.forEach((key,value)->{
            System.out.println(key+"省 学生人数："+value);
        });
    }
}
