package chapter1.default_keyboard;

/**
 * description: Animal <br>
 * date: 2020/9/16 16:10 <br>
 *
 * @author: ZhangYixin <br>
 * version: 1.0 <br>
 */
public interface Animal {
    void run();

    void eat();

    default void breath(){
        System.out.println("呼吸氧气");
    }

    static void test(){
        System.out.println("接口中写静态方法");
        System.out.println("小狗静静站着");
    }
}
