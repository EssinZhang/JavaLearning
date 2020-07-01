package cn.zyx.springmvc.servlet;

import cn.zyx.springmvc.adapter.HandlerAdapter;
import cn.zyx.springmvc.adapter.impl.HttpRequestHandlerAdapterImpl;
import cn.zyx.springmvc.adapter.impl.SimpleControllerHandlerAdapterImpl;
import cn.zyx.springmvc.mapping.HandlerMapping;
import cn.zyx.springmvc.mapping.impl.BeanNameUrlHandlerMappingImpl;
import cn.zyx.springmvc.mapping.impl.SimpleUrlHandlerMappingImpl;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * springmvc使用DispatcherServlet类统一处理所有Servlet请求
 */
public class DispatcherServlet extends AbstractServlet {

    private List<HandlerAdapter> handlerAdapters = new ArrayList<>();
    private List<HandlerMapping> handlerMappings = new ArrayList<>();

    /**
     * Servlet生命周期中的初始化方法
     * @param config
     * @throws ServletException
     */
    @Override
    public void init(ServletConfig config) throws ServletException {
        handlerAdapters.add(new HttpRequestHandlerAdapterImpl());
        handlerAdapters.add(new SimpleControllerHandlerAdapterImpl());
        handlerMappings.add(new BeanNameUrlHandlerMappingImpl());
        handlerMappings.add(new SimpleUrlHandlerMappingImpl());
    }

    @Override
    protected void doDispatch(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            // 根据请求查找对应的处理类（要求该处理器不需要继承或事项Servlet相关的类或接口。如何编写处理类？）
            Object handler = getHandler(request);
            if (handler == null) {return;}

            //调用处理方法
            /*if(handler instanceof HttpRequestHandler){
                ((HttpRequestHandler)handler).handleRequest(request,response);
            }else if (handler instanceof SimpleControllerHandler){
                ((SimpleControllerHandler)handler).handleRequest(request,response);
            }*/

            // 先要查找对应的处理器适配器
            HandlerAdapter hadler = getHandlerAdapter(handler);
            if (hadler == null) {return;}
            // 调用处理类的方法去处理请求
            // 将处理结果响应给浏览器
            hadler.handlerRequest(handler,request,response);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private HandlerAdapter getHandlerAdapter(Object handler) {
        if (handlerAdapters != null){
            for (HandlerAdapter ha : handlerAdapters) {
                if (ha.supports(handler)){
                    return ha;
                }
            }
        }
        return null;
    }

    private Object getHandler(HttpServletRequest request) {
        if (handlerMappings != null){
            for (HandlerMapping hm : handlerMappings) {
                Object handler = hm.getHandler(request);
                if (handler != null){
                    return handler;
                }
            }
        }
        return null;
    }
}
