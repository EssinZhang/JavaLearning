package cn.zyx.anno;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller//表示当前类是一个controller
@RequestMapping("/test")//表示这是一个命名空间
public class Annotest02 {

    @RequestMapping(value="/requestPost.do",method = RequestMethod.POST)
    public ModelAndView reqPost(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        mv.addObject("method", "只支持post请求");
        mv.setViewName("post");
        return mv;
    }

    @RequestMapping(value = "/requestGet.do",method = RequestMethod.GET)
    public ModelAndView reqGet(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        mv.addObject("method", "只支持get请求");
        mv.setViewName("get");
        return mv;
    }
}
