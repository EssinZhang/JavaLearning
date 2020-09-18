package chapter1.localdate_demo;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * description: DateFormatDemo01 <br>
 * date: 2020/9/18 09:52 <br>
 *
 * @author: ZhangYixin <br>
 * version: 1.0 <br>
 */
public class DateFormatDemo01 {

    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        long startTime = System.nanoTime();
        System.out.println("处理前："+now);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        String format = now.format(dateTimeFormatter);
        System.out.println("处理后："+format);

        LocalDateTime setTime = LocalDateTime.of(2020, 4, 1, 8, 42, 21);
        System.out.println("设置的时间："+setTime);
        String format1 = setTime.format(dateTimeFormatter);
        System.out.println("设置的时间处理后："+format1);
        LocalDateTime lastTime = LocalDateTime.now();

        Duration duration = Duration.between( lastTime,now);//第二个参数减第一个参数
        System.out.println(duration.toDays());//两个时间差的天数
        System.out.println(duration.toHours());//两个时间差的⼩小时数
        System.out.println(duration.toMinutes());//两个时间差的分钟数
        System.out.println(duration.toMillis());//两个时间差的毫秒数
        System.out.println(duration.toNanos());//两个时间差的纳秒数
    }

}
