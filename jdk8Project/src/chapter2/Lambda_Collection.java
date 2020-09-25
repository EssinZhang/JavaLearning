package chapter2;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * description: Lambda_Collection <br>
 * date: 2020/9/23 10:28 <br>
 *
 * @author: ZhangYixin <br>
 * version: 1.0 <br>
 */
public class Lambda_Collection {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("aaa", "bbb", "ccc", "ddd");
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });

        Collections.sort(list,(o1,o2)->o1.compareTo(o2));

        for (String str:list){
            System.out.println(str);
        }


    }

}
