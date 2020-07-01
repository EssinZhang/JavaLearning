package cn.zyx.springmvc.adapter.impl;

import cn.zyx.springmvc.adapter.HandlerAdapter;
import cn.zyx.springmvc.handler.HttpRequestHandler;
import cn.zyx.springmvc.model.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description HttpRequestHandlerAdapterImpl 适配并执行HttpRequestHandler处理器
 * @Author ZhangYixin
 * @Date 2020/6/23 22:10
 * @Version 1.0
 */
public class HttpRequestHandlerAdapterImpl implements HandlerAdapter {

    @Override
    public boolean supports(Object handler) {
        return (handler instanceof HttpRequestHandler);
    }

    @Override
    public ModelAndView handlerRequest(Object handler, HttpServletRequest request, HttpServletResponse response) throws Exception {
        ((HttpRequestHandler)handler).handleRequest(request,response);
        return null;
    }

}
