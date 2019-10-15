package cn.demo.controller;

import cn.demo.domain.User;
import cn.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/redis/demo")
public class TestController {

    @Autowired
    private RedisTemplate redisTemplate;


    @RequestMapping("/redis1")
    public Object redisTest1(){
        redisTemplate.opsForValue().set("name","pp");

        Object name = redisTemplate.opsForValue().get("name");

        System.out.println(name);
        return "ss";
    }

}
