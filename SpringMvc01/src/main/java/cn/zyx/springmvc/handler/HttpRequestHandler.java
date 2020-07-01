package cn.zyx.springmvc.handler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description HttpRequestHandler制定一种处理类的编写规范
 * @Author ZhangYixin
 * @Date 2020/6/23 21:43
 * @Version 1.0
 */

public interface HttpRequestHandler {

    public void handleRequest(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException;
}
