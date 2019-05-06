package cn.zyx.returnValue;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 方法中返回String类型
 * 如果只希望方法执行完毕后跳转jsp或者其他资源，此时可以使用String作为方法的返回值
 */
@Controller
public class ReturnStringController {

    @RequestMapping("/welcome.do")
    public String welcome() throws Exception{
        return "welcome";
    }

    @RequestMapping("/tobaidu.do")
    public String tobaidu() throws Exception{
        //return 的值要和springmvc中外部链接的bean的id对应
        return "baidu";
    }
}
