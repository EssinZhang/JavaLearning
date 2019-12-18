package cn.zyx.orderlist.service.impl;

import cn.zyx.orderlist.domain.ProductOrder;
import cn.zyx.orderlist.service.ProductOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.UUID;

/**
 * description: 订单业务接口实现类 <br>
 * date: 2019/12/18 14:59 <br>
 *
 * @author: ZhangYixin <br>
 * version: 1.0 <br>
 */
@Service
public class ProductOrderServiceImpl implements ProductOrderService {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public ProductOrder saveOrder(int userId, int productId) {
        //获取商品详情
        Object obj = restTemplate.getForObject("http://product-service/product/getById?id=" + productId, Object.class);

        System.out.println(obj);

        ProductOrder productOrder = new ProductOrder();

        productOrder.setUserId(userId);
        productOrder.setCreateTime(new Date());
        productOrder.setTradeNo(UUID.randomUUID().toString());

        return productOrder;
    }
}
