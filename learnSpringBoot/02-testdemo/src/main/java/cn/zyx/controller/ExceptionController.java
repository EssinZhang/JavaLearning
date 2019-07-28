package cn.zyx.controller;

import cn.zyx.domain.MyException;
import cn.zyx.domain.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Date;

@RestController
public class ExceptionController {

    @RequestMapping(value = "/api/v1/extest")
    public Object index(){
        int ss = 1/0;
        return new User(24,"kobe","12000", new Date());
    }

    @RequestMapping(value = "/api/v1/myExptTest")
    public Object myException(){
        throw new MyException("500","抛myException异常");
    }
}
