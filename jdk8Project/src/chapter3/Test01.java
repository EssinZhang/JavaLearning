package chapter3;

import java.util.function.Function;

/**
 * description: Test01 <br>
 * date: 2020/9/25 14:14 <br>
 *
 * @author: ZhangYixin <br>
 * version: 1.0 <br>
 */
public class Test01 {

    public static void main(String[] args) {
        // 直接调用自己写的实现方法
        test("aBc",new FunctionObj());

        // lambda方式重写apply方法，再调用
        Function<Integer,Integer> func = p->p*100;
        System.out.println(func.apply(3));
    }

    public static void test(String input,FunctionObj func){
        String upperCase = input.toUpperCase();
        System.out.println(func.apply(upperCase));
    }

}
