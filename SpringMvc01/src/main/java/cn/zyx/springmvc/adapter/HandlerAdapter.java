package cn.zyx.springmvc.adapter;

import cn.zyx.springmvc.model.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description HandlerAdapter 处理器适配器接口
 * @Author ZhangYixin
 * @Date 2020/6/23 22:07
 * @Version 1.0
 */
public interface HandlerAdapter {
    
    ModelAndView handlerRequest(Object Handler, HttpServletRequest request, HttpServletResponse response) throws Exception;

    boolean supports(Object handler);
}
