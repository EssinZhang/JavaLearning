package chapter3;

import java.util.function.Function;

/**
 * description: FunctionObj <br>
 * date: 2020/9/25 14:10 <br>
 *
 * @author: ZhangYixin <br>
 * version: 1.0 <br>
 */
public class FunctionObj implements Function {

    @Override
    public Object apply(Object o) {
        return o+"经过apply()处理拼接上了";
    }
}
