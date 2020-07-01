package cn.example.demo.dieLockDemo;

/**
 * @Description DieLockDemo  死锁例子
 * @Author ZhangYixin
 * @Date 2020/7/1 15:46
 * @Version 1.0
 */
public class DieLockDemo {

    private static Object lockFlag1 = new Object();
    private static Object lockFlag2 = new Object();

    public static void main(String[] args) {
        new DieLockDemo().deadLockDemo();
    }

    public void deadLockDemo(){

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lockFlag1){
                    System.out.println("thread1 get lockFlag1 ");
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (lockFlag2){
                        System.out.println("thread1 get lockFlag2");
                    }
                }
                System.out.println("thread1 end");
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lockFlag2){
                    System.out.println("thread2 get lockFlag2 ");
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (lockFlag1){
                        System.out.println("thread2 get lockFlag1");
                    }
                }
                System.out.println("thread2 end");
            }
        });
        thread1.start();
        thread2.start();
    }
}
