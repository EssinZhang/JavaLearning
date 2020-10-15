package chapter4;

import java.util.Arrays;
import java.util.List;

/**
 * description: StreamofForeachDemo01 <br>
 * date: 2020/10/14 11:02 <br>
 *
 * @author: ZhangYixin <br>
 * version: 1.0 <br>
 */
public class StreamofForeachDemo01 {

    public static void main(String[] args) {
        List<String> stringList = Arrays.asList("kobe", "wade", "o'neal", "tracy", "gogogo", "believe");
        stringList.forEach(obj-> {
            System.out.println(obj);
        });
    }

}
