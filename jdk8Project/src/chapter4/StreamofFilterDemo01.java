package chapter4;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * description: StreamofFilterDemo01 <br>
 * date: 2020/10/10 16:28 <br>
 *
 * @author: ZhangYixin <br>
 * version: 1.0 <br>
 */
public class StreamofFilterDemo01 {

    public static void main(String[] args) {
        List<String> stringList = Arrays.asList("spring", "springboot", "springcloud", "alibabacloud", "dubbo", "springMvc", "mybatis", "rocketMq");

        List<String> collect = stringList.stream().filter(obj -> obj.length() > 5).collect(Collectors.toList());
        System.out.println(collect);
    }

}
