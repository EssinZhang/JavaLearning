package cn.zyx.springmvc.handler;

import cn.zyx.springmvc.model.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description SaveUserHandler
 * @Author ZhangYixin
 * @Date 2020/6/23 21:46
 * @Version 1.0
 */
public interface SimpleControllerHandler {

        /**
         * 处理完请求之后，可以通过返回值封装的处理结果和视图进行二次处理
         * @param request
         * @param response
         * @return
         */
        public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException;

}
