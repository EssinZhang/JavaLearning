package cn.zyx.anno;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller//表示当前类是一个controller
public class Annotest {

    @RequestMapping("/test/test1.do")
    public ModelAndView test1(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        mv.addObject("hello", "test1");
        mv.setViewName("test1");
        return mv;
    }
}
