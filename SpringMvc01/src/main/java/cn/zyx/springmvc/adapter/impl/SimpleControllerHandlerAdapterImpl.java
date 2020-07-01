package cn.zyx.springmvc.adapter.impl;

import cn.zyx.springmvc.adapter.HandlerAdapter;
import cn.zyx.springmvc.handler.SimpleControllerHandler;
import cn.zyx.springmvc.model.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description SimpleControllerHandlerAdapterImpl
 * @Author ZhangYixin
 * @Date 2020/6/23 22:12
 * @Version 1.0
 */
public class SimpleControllerHandlerAdapterImpl implements HandlerAdapter {
    @Override
    public boolean supports(Object handler) {
        return (handler instanceof SimpleControllerHandler);
    }

    @Override
    public ModelAndView handlerRequest(Object handler, HttpServletRequest request, HttpServletResponse response) throws Exception {
        return ((SimpleControllerHandler)handler).handleRequest(request,response);
    }
}
