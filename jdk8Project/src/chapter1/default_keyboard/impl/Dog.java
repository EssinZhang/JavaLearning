package chapter1.default_keyboard.impl;

import chapter1.default_keyboard.Animal;

/**
 * description: Dog <br>
 * date: 2020/9/16 16:18 <br>
 *
 * @author: ZhangYixin <br>
 * version: 1.0 <br>
 */
public class Dog implements Animal {

    @Override
    public void run() {
        System.out.println("小狗在跑");
    }

    @Override
    public void eat() {
        System.out.println("小狗在啃骨头");
    }
}
