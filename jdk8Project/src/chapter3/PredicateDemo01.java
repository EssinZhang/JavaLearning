package chapter3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * description: PredicateDemo01 <br>
 * date: 2020/9/30 15:55 <br>
 *
 * @author: ZhangYixin <br>
 * version: 1.0 <br>
 */
public class PredicateDemo01 {

    public static void main(String[] args) {
        List<String> strings = Arrays.asList("abc", "bcd", "cde", "def", "ace");
        System.out.println(strings);
        // 第二个参数把过滤策略传入
        List<String> results = startWithAFilter(strings, obj -> obj.startsWith("a"));
        System.out.println(results);

    }

    /**
     * 做一个过滤器
     * @param list
     * @param predicate
     * @return
     */
    public static List<String> startWithAFilter (List<String> list , Predicate<String> predicate){
        ArrayList<String> result = new ArrayList<>();
        for (String str : list){
            if (predicate.test(str)) {
                result.add(str);
            }
        }
        return result;
    }
}
