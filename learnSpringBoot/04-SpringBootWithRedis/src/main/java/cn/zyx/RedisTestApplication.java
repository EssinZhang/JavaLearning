package cn.zyx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication //一个顶下面三个
//@ComponentScan("cn.zyx.controller")//("cn.zyx.mapper")controller
//@ComponentScan("cn.zyx.mapper")
public class RedisTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(RedisTestApplication.class,args);
    }
}
