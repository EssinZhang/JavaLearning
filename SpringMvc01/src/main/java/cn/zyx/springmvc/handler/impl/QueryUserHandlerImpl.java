package cn.zyx.springmvc.handler.impl;

import cn.zyx.springmvc.handler.HttpRequestHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description QueryUserHandlerImpl
 * @Author ZhangYixin
 * @Date 2020/6/23 21:37
 * @Version 1.0
 */
public class QueryUserHandlerImpl implements HttpRequestHandler {

    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        response.setContentType("text/plain;charset=utf8");
        response.getWriter().write("test-id : "+ id +"  test-name : "+name);
    }
}
