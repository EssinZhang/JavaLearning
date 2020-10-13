package chapter4;

import java.util.Arrays;
import java.util.List;

/**
 * description: StreamofMatch <br>
 * date: 2020/10/13 09:36 <br>
 *
 * @author: ZhangYixin <br>
 * version: 1.0 <br>
 */
public class StreamofMatch {

    public static void main(String[] args) {
        List<String> stringList = Arrays.asList("git", "es", "logstash", "kibana", "dubbo", "rocketMq");
        boolean flag = stringList.stream().allMatch(obj -> obj.length() >= 2);
        System.out.println(flag);

        boolean flag2 = stringList.stream().anyMatch(obj -> obj.length() < 2);
        System.out.println(flag2);
    }
}
