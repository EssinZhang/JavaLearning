package cn.zyx.orderlist.service.impl;

import cn.zyx.orderlist.domain.ProductOrder;
import cn.zyx.orderlist.service.ProductOrderClient;
import cn.zyx.orderlist.service.ProductOrderService;
import cn.zyx.orderlist.utils.JsonUtils;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
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
    private ProductOrderClient productClient;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public ProductOrder saveOrder(int userId, int productId) {
        //获取商品详情
        String productResult = productClient.getById(productId);

        JsonNode jsonNode = JsonUtils.string2Object(productResult);

        ProductOrder productOrder = new ProductOrder();

        productOrder.setUserId(userId);
        productOrder.setCreateTime(new Date());
        productOrder.setTradeNo(UUID.randomUUID().toString());
        productOrder.setPrice(Integer.parseInt(jsonNode.get("price").toString()));
        productOrder.setProductName(jsonNode.get("name").toString());

        return productOrder;
    }
}
