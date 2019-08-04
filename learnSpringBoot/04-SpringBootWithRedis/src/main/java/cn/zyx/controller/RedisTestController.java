package cn.zyx.controller;

import cn.zyx.domain.JsonData;
import cn.zyx.domain.User;
import cn.zyx.utils.JsonUtils;
import cn.zyx.utils.RedisClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/api/v1/redis")
public class RedisTestController {

    @Autowired
    private StringRedisTemplate redisTemplate;//redis的一个模板

    @Autowired
    private RedisClient redisClient;

    @GetMapping(value = "add")
    public Object add(){
       // redisTemplate.opsForValue().set("name","kobe24");//key value 的形式
        redisClient.set("redisName","2redis");

        return JsonData.buildSuccess("ok");
    }

    @GetMapping(value = "get")
    public Object get(){
        //String result = redisTemplate.opsForValue().get("name");
        String result = redisClient.get("redisName");

        return JsonData.buildSuccess(result);
    }

    @GetMapping(value = "save_user")
    public Object saveUser(){
        User user = new User("Duncan","21",new Date());
        //对象转换成字符串
        String userStr = JsonUtils.obj2String(user);
        boolean flag = redisClient.set("basketball:team:spx",userStr);

        return JsonData.buildSuccess(flag);
    }

    @GetMapping(value = "find_user")
    public Object findUser(){

        String userStr = redisClient.get("basketball:team:spx");
        User user = JsonUtils.string2Obj(userStr,User.class);

        return JsonData.buildSuccess(user);

    }

}
