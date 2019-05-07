package cn.zyx.myException;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 自定义异常处理器
 */
public class MyExceptionResolver implements HandlerExceptionResolver {

    /**
     * 只要在程序中有异常抛出就会执行这个方法
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @param e
     * @return
     */
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("ex",e);

        //设置默认异常处理界面
        mv.setViewName("error/error");

        if (e instanceof MyException){
            //记录日志
            //设置跳转页面
            mv.setViewName("error/myerror");
        }else if (e instanceof NullPointerException){
            //记录日志
            //设置跳转页面
            //mv.setViewName("error/myerror");
        }
        return mv;
    }
}
