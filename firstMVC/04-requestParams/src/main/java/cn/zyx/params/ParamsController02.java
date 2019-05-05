package cn.zyx.params;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * 表单参数名称和方法名不一致的情况
 *
 * 要用注解request param
 */
@Controller
@RequestMapping("/user")
public class ParamsController02 {
    @RequestMapping("/params02")
    public ModelAndView getParams02(@RequestParam(name = "username") String t_username ,@RequestParam(name = "userage") int t_userage)throws Exception{
        ModelAndView modelAndView = new ModelAndView();
        //方法的参数名称需要跟前端页面的name值一致
        modelAndView.addObject("username",t_username);
        modelAndView.addObject("userage",t_userage);
        modelAndView.addObject("params02test","params02test");
        modelAndView.setViewName("result");

        return modelAndView;
    }
}
