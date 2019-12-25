package cn.zyx.configservers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ConfigServersApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigServersApplication.class, args);
    }

}
