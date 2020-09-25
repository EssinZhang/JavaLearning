package chapter2;

/**
 * description: Lambda_Demo01 <br>
 * date: 2020/9/23 16:01 <br>
 *
 * @author: ZhangYixin <br>
 * version: 1.0 <br>
 */
public class Lambda_Demo01 {

    public static void main(String[] args) {
        System.out.println(operatorTest(8,9,(x,y)->x+y));
        System.out.println(operatorTest(8,9,(x,y)->x-y));
        System.out.println(operatorTest(8,9,(x,y)->x*y));
        System.out.println(operatorTest(8,9,(x,y)->x/y));
    }

    public static Integer operatorTest(Integer x,Integer y,OperFunction<Integer,Integer> operFunction){
        return operFunction.operator(x,y);
    }

}
