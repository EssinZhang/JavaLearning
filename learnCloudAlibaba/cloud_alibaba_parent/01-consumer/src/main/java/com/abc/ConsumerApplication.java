package com.abc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class, args);
    }

    /**
     * 注入RestTemplate模板对象，用来发送请求
     * 作用相当于：<bean id='' class='org.springframework.web.client.RestTemplate'></bean>
     */
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
