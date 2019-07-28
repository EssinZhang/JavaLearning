package cn.zyx.intecepter;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginIntecepter implements HandlerInterceptor {

    //进入controller方法之前
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("LoginIntecepter ------------------- perHandle");

        return HandlerInterceptor.super.preHandle(request,response,handler);
    }

    //调用完controller之后，视图渲染之前
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

        System.out.println("LoginIntecepter ------------------- postHandle");

        HandlerInterceptor.super.postHandle(request,response,handler,modelAndView);
    }

    //整个完成之后通常用于资源清理
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

        System.out.println("LoginIntecepter ------------------- afterHandle");

        HandlerInterceptor.super.afterCompletion(request,response,handler,ex);
    }
}
