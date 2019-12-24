package cn.zyx.apigateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;

/**
 * description: 订单限流<br>
 * date: 2019/12/24 15:40 <br>
 *
 * @author: ZhangYixin <br>
 * version: 1.0 <br>
 */
@Component
public class RateLimiterFilter extends ZuulFilter {

    @Override
    public String filterType() {
        return PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return -4;
    }

    @Override
    public boolean shouldFilter() {

        RequestContext currentContext = RequestContext.getCurrentContext();
        HttpServletRequest request = currentContext.getRequest();

        if ( "/apigateway/order/order/save".equals(request.getRequestURI()) ){
            return true;
        }
        return false;
    }

    @Override
    public Object run() throws ZuulException {
        return null;
    }
}
