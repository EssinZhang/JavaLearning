package cn.zyx.controller;

import cn.zyx.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    //@validate 不能加在String类型或者基本数据类型的前面
    //BindingResult可以获得所有验证异常的信息
    @RequestMapping("/register.do")
    public ModelAndView register(@Validated User user, BindingResult br)throws Exception{

        ModelAndView mv = new ModelAndView();
        List<ObjectError> allErrors = br.getAllErrors();
        //如果数据校验失败，就提示错误信息
        if (allErrors != null && allErrors.size() > 0 ) {
            FieldError nameError = br.getFieldError("name");
            FieldError ageError = br.getFieldError("age");
            FieldError telError = br.getFieldError("tel");

            if (nameError != null){
                mv.addObject("nameError",nameError.getDefaultMessage());
            }
            if (ageError != null){
                mv.addObject("ageError",ageError.getDefaultMessage());
            }
            if (telError != null){
                mv.addObject("telError",telError.getDefaultMessage());
            }

            mv.setViewName("register");
            return mv;
        }

        mv.addObject("name",user.getName());
        mv.addObject("msg","注册成功");
        mv.setViewName("success");

        return mv;
    }
}
