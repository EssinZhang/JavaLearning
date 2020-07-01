package cn.zyx.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 一个UserServlet类，可以处理N个请求
 */
public abstract class UserServlet extends BaseServlet {
    public void query(HttpServletRequest request,HttpServletResponse response){

    }
}
