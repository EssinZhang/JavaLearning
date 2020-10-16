package chapter5;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * description: JoiningDemo01 <br>
 * date: 2020/10/15 14:22 <br>
 *
 * @author: ZhangYixin <br>
 * version: 1.0 <br>
 */
public class JoiningDemo01 {

    public static void main(String[] args) {
        List<String> stringList = Arrays.asList("abc", "spring", "java", "python");
        // 单纯拼接
        String result = stringList.stream().collect(Collectors.joining(""));
        System.out.println(result);

        // 拼接间加入分隔符
        String result1 = stringList.stream().collect(Collectors.joining("--"));
        System.out.println(result1);

        // 加大括号
        String result2 = stringList.stream().collect(Collectors.joining("--", "{", "}"));
        System.out.println(result2);
    }

}
