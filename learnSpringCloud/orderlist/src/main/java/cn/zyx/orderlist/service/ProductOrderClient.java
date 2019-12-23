package cn.zyx.orderlist.service;

import cn.zyx.orderlist.fallback.ProductClientFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * description: 商品服务客户端 <br>
 * date: 2019/12/19 15:22 <br>
 *
 * @author: ZhangYixin <br>
 * version: 1.0 <br>
 */
@FeignClient(name = "product-service",fallback = ProductClientFallback.class)
public interface ProductOrderClient {

    @GetMapping("/product/getById")
    String getById(@RequestParam(value = "id") int id);
}
