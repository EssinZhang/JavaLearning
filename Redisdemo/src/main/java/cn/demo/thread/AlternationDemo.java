package cn.demo.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description
 * @ClassName AlternationDemo
 * @Author ZhangYixin
 * @date 2020.06.17 10:48
 */
public class AlternationDemo  {

    /**
     * 当前执行的线程标记
     */
    private int threadNum = 1;

    private Lock lock = new ReentrantLock();

    Condition condition1 = lock.newCondition();
    Condition condition2 = lock.newCondition();
    Condition condition3 = lock.newCondition();

    public void loopA(){
        lock.lock();

        try {
            if (threadNum != 1){
                condition1.await();
            }
            System.out.println(Thread.currentThread().getName());
            threadNum = 2;
            condition2.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }

    }

    public void loopB(){
        lock.lock();

        try {
            if (threadNum != 2){
                condition2.await();
            }
            System.out.println(Thread.currentThread().getName());
            threadNum = 3;
            condition3.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }

    }

    public void loopC(){
        lock.lock();

        try {
            if (threadNum != 3){
                condition3.await();
            }
            System.out.println(Thread.currentThread().getName());
            threadNum = 1;
            condition1.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }

    }

}
