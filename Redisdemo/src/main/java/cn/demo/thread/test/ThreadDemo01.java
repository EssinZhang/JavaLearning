package cn.demo.thread.test;

import cn.demo.thread.AlternationDemo;

/**
 * @Description  等待唤醒方式实现三个线程次序执行
 * @ClassName ThreadDemo01
 * @Author ZhangYixin
 * @date 2020.06.17 10:46
 */
public class ThreadDemo01 {
    public static void main(String[] args) {
        AlternationDemo alternationDemo = new AlternationDemo();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    alternationDemo.loopA();
                }
            }
        },"A").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    alternationDemo.loopB();
                }
            }
        },"B").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    alternationDemo.loopC();
                }
            }
        },"C").start();
    }

}
