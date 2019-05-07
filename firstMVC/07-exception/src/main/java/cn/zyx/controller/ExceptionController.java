package cn.zyx.controller;

import cn.zyx.myException.MyException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 异常处理Controller
 */
@Controller
public class ExceptionController {

    @RequestMapping("/myException.do")
    public ModelAndView myException(String name)throws Exception{

        ModelAndView mv = new ModelAndView();

        if("kobe".equals(name)){
            throw new MyException("我的自定义异常");
        }

        if (!"kobe".equals(name)){
            throw new Exception("默认异常");
        }
        return mv;
    }
}
