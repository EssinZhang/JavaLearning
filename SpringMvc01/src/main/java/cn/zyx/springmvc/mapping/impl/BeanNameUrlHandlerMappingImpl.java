package cn.zyx.springmvc.mapping.impl;

import cn.zyx.springmvc.handler.impl.QueryUserHandlerImpl;
import cn.zyx.springmvc.mapping.HandlerMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description BeanNameUrlHandlerMappingImpl 通过xml中的bean标签进行映射关系的维护的
 * @Author ZhangYixin
 * @Date 2020/6/23 22:25
 * @Version 1.0
 */
public class BeanNameUrlHandlerMappingImpl implements HandlerMapping {

    private Map<String,Object> urlHandlers = new HashMap<>();

    public BeanNameUrlHandlerMappingImpl(){
        //需要读取XML来获取映射关系
        urlHandlers.put("/queryUser",new QueryUserHandlerImpl());
    }

    @Override
    public Object getHandler(HttpServletRequest request) {
        String uri = request.getRequestURI();
        return urlHandlers.get(uri);

    }
}
