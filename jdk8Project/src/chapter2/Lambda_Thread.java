package chapter2;

/**
 * description: Lambda_Demo01 <br>
 * date: 2020/9/23 10:17 <br>
 *
 * @author: ZhangYixin <br>
 * version: 1.0 <br>
 */
public class Lambda_Thread {

    public static void main(String[] args) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程名："+Thread.currentThread().getName());
            }
        }).start();

        new Thread(()->{
            System.out.println("线程名："+Thread.currentThread().getName());
        }).start();
    }

}
