package cn.zyx.controller;

import cn.zyx.bean.User;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.util.Date;

@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/addUser.do")
    //public ModelAndView addUser(String name, int age ,@DateTimeFormat(pattern = "yyyy-MM-dd") Date birthday)throws Exception{
    public ModelAndView addUser(User user)throws Exception{
        ModelAndView mv = new ModelAndView();
        mv.addObject("name",user.getName());
        mv.addObject("age",user.getAge());
        mv.addObject("birthday",user.getBirthday());

        mv.setViewName("user");
        return mv;
    }
}
