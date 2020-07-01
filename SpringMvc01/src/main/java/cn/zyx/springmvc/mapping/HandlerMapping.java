package cn.zyx.springmvc.mapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description HandlerMapping接口是对外提供查找处理的功能的
 *                接口的实现类需要维护处理器和请求的映射关系
 * @Author ZhangYixin
 * @Date 2020/6/23 22:24
 * @Version 1.0
 */
public interface HandlerMapping {
    Object getHandler(HttpServletRequest request);
}
