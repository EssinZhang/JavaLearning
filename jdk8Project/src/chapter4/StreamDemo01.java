package chapter4;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * description: StreamDemo01 <br>
 * date: 2020/10/10 15:07 <br>
 *
 * @author: ZhangYixin <br>
 * version: 1.0 <br>
 */
public class StreamDemo01 {

    public static void main(String[] args) {
        List<String> strList = Arrays.asList("aaaa", "bbbb", "cccc", "dddd", "eeee");
        List<String> collect = strList.stream().map(obj -> obj + "啦啦啦").collect(Collectors.toList());
        System.out.println(collect);
    }

}
