package cn.zyx.anno;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller//表示当前类是一个controller
@RequestMapping("/test")//表示这是一个命名空间
public class Annotest01 {

    @RequestMapping("/test2.do")
    public ModelAndView test2(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        mv.addObject("hello", "test2");
        mv.setViewName("test1");
        return mv;
    }

    @RequestMapping({"/test02.do","/hello.do"})
    public ModelAndView test02(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        mv.addObject("hello", "test02 test");
        mv.setViewName("test1");
        return mv;
    }
}
