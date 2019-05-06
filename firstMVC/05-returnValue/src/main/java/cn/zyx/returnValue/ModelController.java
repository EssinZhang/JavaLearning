package cn.zyx.returnValue;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * model接口，可以用来传递数据
 */
@Controller
public class ModelController {

    @RequestMapping("/modeldata01.do")
    public String modeldata01(Model model , String name)throws Exception{
        model.addAttribute("username",name);
        model.addAttribute(name);//类似于model.addAttribute("String",name);

        return "welcome";
    }
}
