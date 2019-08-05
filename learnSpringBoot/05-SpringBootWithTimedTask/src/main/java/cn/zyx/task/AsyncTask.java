package cn.zyx.task;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 异步任务类
 */
@Component
@Async
public class AsyncTask {


    public void task1() throws InterruptedException {
        long begin = System.currentTimeMillis();
        Thread.sleep(1000L);
        long end = System.currentTimeMillis();
        System.out.println("任务1耗时="+(end-begin));
        System.out.println("任务完成时间:"+new Date());
    }

    public void task2() throws InterruptedException {
        long begin = System.currentTimeMillis();
        Thread.sleep(2000L);
        long end = System.currentTimeMillis();
        System.out.println("任务2耗时="+(end-begin));
        System.out.println("任务完成时间:"+new Date());
    }

    public void task3() throws InterruptedException {
        long begin = System.currentTimeMillis();
        Thread.sleep(3000L);
        long end = System.currentTimeMillis();
        System.out.println("任务3耗时="+(end-begin));
        System.out.println("任务完成时间:"+new Date());
    }
}
