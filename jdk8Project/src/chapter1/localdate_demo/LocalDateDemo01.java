package chapter1.localdate_demo;

import java.time.LocalDate;

/**
 * description: LocalDateDemo01 <br>
 * date: 2020/9/17 15:50 <br>
 *
 * @author: ZhangYixin <br>
 * version: 1.0 <br>
 */
public class LocalDateDemo01 {

    public static void main(String[] args) {
        LocalDate localDate = LocalDate.now();
        System.out.println("今天日期："+localDate);
        // 获取年月日星期等
        System.out.println("现在是哪年："+localDate.getYear());
        System.out.println("现在是哪月："+localDate.getMonth());
        System.out.println("现在是哪月（数字）："+localDate.getMonthValue());
        System.out.println("现在是几号："+localDate.getDayOfMonth());
        System.out.println("现在是周几："+localDate.getDayOfWeek());
        // 日期计算
        LocalDate plusYears = localDate.plusYears(2);
        System.out.println("加2后年份："+plusYears.getYear());
        System.out.println("isAfter:"+plusYears.isBefore(localDate));
    }

}
