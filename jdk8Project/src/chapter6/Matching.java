package chapter6;

/**
 * @Description Matching
 * @Author ZhangYixin
 * @Date 2020/10/20 16:50
 * @Version 1.0
 */
@FunctionalInterface
public interface Matching<R,T> {
    R matching(T t1,T t2);
}
