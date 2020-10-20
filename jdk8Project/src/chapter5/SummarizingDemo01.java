package chapter5;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

/**
 * description: SummarizingDemo01 <br>
 * date: 2020/10/16 15:09 <br>
 *
 * @author: ZhangYixin <br>
 * version: 1.0 <br>
 */
public class SummarizingDemo01 {

    public static void main(String[] args) {
        List<Student> students = Arrays.asList(new Student("辽宁", 18), new Student("吉林", 19),
                new Student("辽宁", 23), new Student("吉林", 20),
                new Student("辽宁", 24), new Student("吉林", 23));
        IntSummaryStatistics result = students.stream().collect(Collectors.summarizingInt(Student::getAge));
        System.out.println("人数："+result.getCount());
        System.out.println("年龄总和："+result.getSum());
        System.out.println("最小年龄："+result.getMin());
        System.out.println("最大年龄："+result.getMax());
        System.out.println("平均年龄："+result.getAverage());

    }

}