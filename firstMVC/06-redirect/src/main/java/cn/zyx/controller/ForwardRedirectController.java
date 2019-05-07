package cn.zyx.controller;

import cn.zyx.bean.School;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * springMVC中的转发和重定向
 */
@Controller
public class ForwardRedirectController {

    /**
     * 返回modelAndView的转发
     * @return
     * @throws Exception
     */
    @RequestMapping("/forwardMAV.do")
    public ModelAndView forwardMAV()throws Exception{

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("type","返回modelAndView的转发");
        //默认使用转发进行跳转
        //modelAndView.setViewName("/result");
        //要跳转到其他controller中，此时需要forward到指定的 controller
        modelAndView.setViewName("forward:another.do");

        return modelAndView;
    }

    /**
     * 返回modelAndView的重定向
     * @return
     * @throws Exception
     */
    @RequestMapping("/redirectMAV.do")
    public ModelAndView redirectMAV()throws Exception{
        ModelAndView modelAndView = new ModelAndView();
        //只能传递基本数据类型 和 String
        modelAndView.addObject("type","返回ModelAndView对象的重定向");

        modelAndView.addObject("schoolName","tisinghua");
        modelAndView.addObject("schoolAddr","北京");
        //重定向
        //重定向和转发都会是视图解析器失效
        //modelAndView.setViewName("redirect:/jsp/result.jsp");
        modelAndView.setViewName("redirect:another.do");

        return modelAndView;
    }

    /**
     * 返回String类型的转发
     * @param school
     * @return
     * @throws Exception
     */
    @RequestMapping("/forwardStr.do")
    //方法中的参数会被自动放到request域中
    public String forwardStr(School school)throws Exception{

        //指定的转发
        return "forward:/jsp/result.jsp";
    }

    /**
     * 返回String类型的重定向
     * @param model
     * @param school
     * @return
     * @throws Exception
     */
    @RequestMapping("/redirectStr.do")
    public String redirectStr(Model model,School school)throws Exception{
        //数据会被放到url地址栏中，所以只能传递基本数据类型
        model.addAttribute("schoolName",school.getSchoolName());
        model.addAttribute("schoolAddr",school.getSchoolAddr());

        return "redirect:/jsp/result.jsp";
    }
}
