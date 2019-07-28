package cn.zyx.testDemo;

import cn.zyx.domain.MyException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

//如果是返回json数据 则用 RestControllerAdvice,就可以不加 @ResponseBody
@RestControllerAdvice
public class ExceptionTestDemo {

    //获取全局异常，处理所有不可知异常
    @ExceptionHandler(value = Exception.class)
    public Object exceptionTest(Exception e, HttpServletRequest request){
        Map<String,Object> map = new HashMap<>();
        map.put("code",100);
        map.put("msg",e.getMessage());
        map.put("url",request.getRequestURL());

        return map;
    }


    //处理自定义异常   跳转异常页
    @ExceptionHandler(value = MyException.class)
    Object handleMyException(Exception e){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("error.html");
        modelAndView.addObject("msg",e.getMessage());

        return modelAndView;
    }
}
