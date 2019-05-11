package cn.zyx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class InterceptorController {

    @RequestMapping("/test.do")
    public ModelAndView interceptorTest01()throws Exception{
        ModelAndView mv = new ModelAndView();
        System.out.println("test方法");
        mv.setViewName("result");

        return mv;
    }
}
