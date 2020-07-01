package cn.zyx.springmvc.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * springmvc使用DispatcherServlet类统一处理所有Servlet请求
 */
public abstract class AbstractServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //请求分发
        doDispatch(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    protected abstract void doDispatch(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
