package cn.zyx.orderlist.fallback;

import cn.zyx.orderlist.service.ProductOrderClient;
import org.springframework.stereotype.Component;

/**
 * description: 针对商品服务做降级处理 <br>
 * date: 2019/12/20 14:04 <br>
 *
 * @author: ZhangYixin <br>
 * version: 1.0 <br>
 */
@Component
public class ProductClientFallback implements ProductOrderClient {

    @Override
    public String getById(int id) {
        System.out.println("feign 调用product-service 异常");
        return null;
    }
}
