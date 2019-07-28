package cn.zyx.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebFilter(urlPatterns = "/api/*",filterName = "loginFilter")
public class LoginFilter implements Filter {
    //重写过滤器初始化
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("LoginFilter init 初始化");
    }

    //重写过滤器有请求拦截时调用
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("LoginFilter doFilter 执行");
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String username = request.getParameter("username");

        if ("zyx".equals(username)){
            filterChain.doFilter(servletRequest,servletResponse);
        }else {
            return ;
        }
    }

    //重写过滤器销毁
    @Override
    public void destroy() {
        System.out.println("LoginFilter destroy 销毁");
    }
}
