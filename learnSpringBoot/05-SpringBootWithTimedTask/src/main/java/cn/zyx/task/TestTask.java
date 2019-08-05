package cn.zyx.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class TestTask {

    /**
     * 定时任务
     */
    //@Scheduled(fixedRate = 2000)//2000为2秒  毫秒为单位
    public void sum(){
        System.out.println("当前时间:"+new Date());
    }
}
