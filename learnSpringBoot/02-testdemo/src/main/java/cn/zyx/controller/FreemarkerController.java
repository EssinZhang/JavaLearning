package cn.zyx.controller;

import cn.zyx.domain.ServerSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/freemarker")
public class FreemarkerController {

    @Autowired
    private ServerSettings serverSettings;

    @GetMapping("hello")
    public String index(ModelMap modelMap){


        //前端html页面用el表达式取值时用的是attributeName
        modelMap.addAttribute("setting",serverSettings);

        return "fm/index";//不用加后缀，在配置文件里面已经指定了后缀
    }
}
