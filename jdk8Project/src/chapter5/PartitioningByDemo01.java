package chapter5;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * description: PartitioningByDemo01 <br>
 * date: 2020/10/15 16:42 <br>
 *
 * @author: ZhangYixin <br>
 * version: 1.0 <br>
 */
public class PartitioningByDemo01 {

    public static void main(String[] args) {
        List<String> stringList = Arrays.asList("abc", "spring", "java", "python");

        Map<Boolean, List<String>> result = stringList.stream().collect(Collectors.partitioningBy(obj -> obj.length() > 4));
        System.out.println(result);
    }

}
