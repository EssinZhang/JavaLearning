package cn.zyx;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication //一个顶下面三个
//@ComponentScan("cn.zyx.controller")//("cn.zyx.mapper")controller
@MapperScan("cn.zyx.mapper")
//@ComponentScan("cn.zyx.mapper")
public class TestApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestApplication.class,args);
    }
}
