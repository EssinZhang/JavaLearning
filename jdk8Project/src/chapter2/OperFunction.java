package chapter2;

/**
 * description: OperFunction
 *              R返回值 T入参<br>
 * date: 2020/9/23 14:44 <br>
 *
 * @author: ZhangYixin <br>
 * version: 1.0 <br>
 */
@FunctionalInterface
public interface OperFunction<R,T> {

    R operator(T t1,T t2);

}
