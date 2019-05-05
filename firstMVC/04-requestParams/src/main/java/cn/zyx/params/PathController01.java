package cn.zyx.params;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * 获取url中的数据
 * PathVariable
 */
@Controller
public class PathController01 {

    @RequestMapping("/{username}/{userage}/path.do")
    public ModelAndView getPath01(@PathVariable("username") String name,@PathVariable("userage") int age) throws Exception{
        ModelAndView modelAndView = new ModelAndView();
        //方法的参数名称需要跟前端页面的name值一致
        modelAndView.addObject("username",name);
        modelAndView.addObject("userage",age);
        modelAndView.setViewName("result");

        return modelAndView;
    }
}
