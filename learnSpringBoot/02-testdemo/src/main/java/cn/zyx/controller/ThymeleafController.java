package cn.zyx.controller;

import cn.zyx.domain.ServerSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/thymeleaf")
public class ThymeleafController {

    @Autowired
    private ServerSettings serverSettings;

    @GetMapping("hello")
    public String index(){

        return "tl/index";//不需要写文件后缀 在配置文件中已经指定了后缀为.html
    }

    @GetMapping("info")
    public String info(ModelMap modelMap){
        modelMap.addAttribute("setting",serverSettings);

        return "tl/admin/info";
    }
}
