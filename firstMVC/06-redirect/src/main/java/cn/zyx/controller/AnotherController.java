package cn.zyx.controller;

import cn.zyx.bean.School;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 跳转的Controller
 */
@Controller
public class AnotherController {

    @RequestMapping("another.do")
    public ModelAndView anotherController(School school)throws Exception{
        ModelAndView mv = new ModelAndView();
        mv.addObject("content","跳转的controller");
        mv.addObject("schoolName",school.getSchoolName());
        mv.addObject("schoolAddr",school.getSchoolAddr());
        mv.setViewName("result");

        return mv;
    }
}
