package cn.zyx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling//开启定时任务功能
@EnableAsync//开启异步任务功能
public class TimedTaskApplication {

    public static void main(String[] args) {
        SpringApplication.run(TimedTaskApplication.class, args);
    }

}
