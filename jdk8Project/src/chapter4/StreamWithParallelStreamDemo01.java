package chapter4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * description: StreamWithParallelStreamDemo01 <br>
 * date: 2020/10/13 14:57 <br>
 *
 * @author: ZhangYixin <br>
 * version: 1.0 <br>
 */
public class StreamWithParallelStreamDemo01 {

    public static void main(String[] args) {
        // stream串行流
//        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
//        numbers.stream().forEach(System.out::println);
//        System.out.println("-------------------分割线----------------------");
//        // parallelStream并行流
//        numbers.parallelStream().forEach(System.out::println);

//        for (int i=0;i<10;i++){
//            CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
//            IntStream.range(0,100).parallel().forEach(copyOnWriteArrayList::add);
//            System.out.println(copyOnWriteArrayList.size());
//        }

        Integer integer = Stream.of(1, 2, 3, 4, 5).reduce((num1, num2) -> num1 + num2).get();
        System.out.println(integer);

        Integer sum2 = Stream.of(1, 2, 3, 4, 5).reduce(100, (num1, num2) -> num1 + num2);
        System.out.println(sum2);

        Integer max1 = Stream.of(1, 21, 424, 233, 124, 3525, 21412).reduce((num1, num2) -> num1 > num2 ? num1 : num2).get();
        System.out.println(max1);
    }
}
