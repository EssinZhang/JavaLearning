package cn.zyx.controller;

import cn.zyx.domain.JsonData;
import cn.zyx.task.AsyncTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/api/v1")
public class TimerTestController {

    @Autowired
    private AsyncTask task;

    /**
     * 异步任务测试controller
     * @return
     * @throws InterruptedException
     */
    @GetMapping("async_task")
    public JsonData asyncTest() throws InterruptedException {
        long begin = System.currentTimeMillis();

        task.task1();
        task.task2();
        task.task3();

        long end = System.currentTimeMillis();

        long localtime = end-begin;
        System.out.println("总执行时间："+localtime);
        System.out.println("当前时间："+new Date());

        return JsonData.buildSuccess(localtime);
    }
}
