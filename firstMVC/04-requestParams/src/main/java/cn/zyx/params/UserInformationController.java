package cn.zyx.params;

import cn.zyx.bean.UserInformation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 用户信息相关Controller
 */
@Controller
@RequestMapping("/User")
public class UserInformationController {

    @RequestMapping("/userInfo1")
    public ModelAndView getUserInfo1(UserInformation userInfo)throws Exception{
        ModelAndView view = new ModelAndView();
        view.addObject("username",userInfo.getUsername());
        view.addObject("userage",userInfo.getUserage());

        view.setViewName("userInfo");
        return view;
    }

    //增加了地区属性
    @RequestMapping("/userInfo2")
    public ModelAndView getUserInfo2(UserInformation userInfo)throws Exception{
        ModelAndView view = new ModelAndView();
        view.addObject("username",userInfo.getUsername());
        view.addObject("userage",userInfo.getUserage());
        view.addObject("country",userInfo.getRegion().getCountry());
        view.addObject("province",userInfo.getRegion().getProvince());

        view.setViewName("userInfo");
        return view;
    }
}
