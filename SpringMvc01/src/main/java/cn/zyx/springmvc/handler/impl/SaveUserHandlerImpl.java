package cn.zyx.springmvc.handler.impl;

import cn.zyx.springmvc.handler.SimpleControllerHandler;
import cn.zyx.springmvc.model.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description SaveUserHandlerImpl
 * @Author ZhangYixin
 * @Date 2020/6/23 21:39
 * @Version 1.0
 */
public class SaveUserHandlerImpl implements SimpleControllerHandler {
    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/plain;charset=utf8");
        response.getWriter().write("test-添加成功！！！");

        return null;
    }
}
