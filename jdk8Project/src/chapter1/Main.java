package chapter1;

import chapter1.default_keyboard.Animal;
import chapter1.default_keyboard.impl.Dog;

/**
 * description: Main <br>
 * date: 2020/9/16 16:21 <br>
 *
 * @author: ZhangYixin <br>
 * version: 1.0 <br>
 */
public class Main {

    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.eat();
        dog.run();
        dog.breath();

        Animal.test();
    }

}
