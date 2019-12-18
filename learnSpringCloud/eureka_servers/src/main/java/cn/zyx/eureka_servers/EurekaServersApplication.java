package cn.zyx.eureka_servers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 启动类
 * @author ZYX'sDay
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaServersApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServersApplication.class, args);
    }

}
