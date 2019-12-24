package cn.zyx.apigateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;

/**
 * description: 过滤器实现鉴权 <br>
 * date: 2019/12/24 14:06 <br>
 *
 * @author: ZhangYixin <br>
 * version: 1.0 <br>
 */
@Component
public class LoginFilter extends ZuulFilter {

    /**
     * 过滤器类型，前置过滤
     * @return
     */
    @Override
    public String filterType() {
        return PRE_TYPE;
    }

    /**
     * 过滤器执行顺序，越小越优先
     * @return
     */
    @Override
    public int filterOrder() {
        return 4;
    }

    /**
     * 过滤器是否生效
     * @return
     */
    @Override
    public boolean shouldFilter() {

        RequestContext currentContext = RequestContext.getCurrentContext();
        HttpServletRequest request = currentContext.getRequest();

        //  /apigateway/order/order/save
        //System.out.println(request.getRequestURI());
        //  http://localhost:9000/apigateway/order/order/save
        //System.out.println(request.getRequestURL());

        if ( "/apigateway/order/order/save".equals(request.getRequestURI()) ){
            return true;
        }

        return false;
    }

    /**
     * 业务逻辑
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {

        //jwt
        RequestContext currentContext = RequestContext.getCurrentContext();
        HttpServletRequest request = currentContext.getRequest();

        //获得touken对象
        String token = request.getHeader("token");
        //再次获取 从参数中获取
        if (StringUtils.isEmpty(token)){
            request.getParameter("token");
        }

        //登陆校验token
        if (StringUtils.isEmpty(token)){

            currentContext.setSendZuulResponse(false);
            currentContext.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
        }
        return null;
    }
}
