package cn.demo.controller;

import cn.demo.domain.User;
import cn.demo.mapper.UserMapper;
import cn.demo.service.UserService;
import cn.demo.utils.RedisUtils;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/redis/user")
public class UserController {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RedisUtils redisUtils;

    @Autowired
    private UserService userService;

    @GetMapping("getUser")
    public User getUser(String id){
        return userMapper.find(id);
    }

    @GetMapping("getUserCache")
    public User getUserCache(String id){

        //step1 先从redis中读取
        User user = (User) redisUtils.get(id);

        //step2 如果取值为空则从Mybatis中读
        if (user == null){
            User userMB = userMapper.find(id);
            System.out.println("fresh user from db id = " + id);
            //step3 db非空情况下存入内存
            if (userMB != null){
                redisUtils.set(id, userMB);
                return userMB;
            }
        }
        return user;
    }

    @GetMapping("getUserByCache")
    public Object getUserByCache(String id){
        return userService.findById(id);
    }
}
