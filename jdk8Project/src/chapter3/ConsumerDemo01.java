package chapter3;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * description: ConsumerTest01 <br>
 * date: 2020/9/28 10:16 <br>
 *
 * @author: ZhangYixin <br>
 * version: 1.0 <br>
 */
public class ConsumerDemo01 {

    public static void main(String[] args) {
        sendMsg("发送信息测试",obj->{
            System.out.println(obj);
            System.out.println("消息发送完成");
        });

        List<String> stringList = Arrays.asList("aaa", "bbb", "ccc");
        stringList.forEach(obj->{
            System.out.println(obj);
        });
    }

    public static void sendMsg (String msg, Consumer<String> consumer){
        consumer.accept(msg);
    }

}
