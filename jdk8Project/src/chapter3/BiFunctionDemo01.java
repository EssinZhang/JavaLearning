package chapter3;

import java.util.function.BiFunction;

/**
 * description: BiFunctionTest01 <br>
 * date: 2020/9/28 09:33 <br>
 *
 * @author: ZhangYixin <br>
 * version: 1.0 <br>
 */
public class BiFunctionDemo01 {

    public static void main(String[] args) {

        System.out.println(CaculateFunction(6,3,(a,b)->a+b));
        System.out.println(CaculateFunction(6,3,(a,b)->a-b));
        System.out.println(CaculateFunction(6,3,(a,b)->a*b));
        System.out.println(CaculateFunction(6,3,(a,b)->a/b));

    }

    // 实现类 应用入口
    public static Integer CaculateFunction(Integer numA, Integer numB, BiFunction<Integer,Integer,Integer> biFunction ){
        return biFunction.apply(numA,numB);
    }

}
