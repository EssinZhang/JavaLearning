package cn.zyx.orderlist.controller;

import cn.zyx.orderlist.domain.ProductOrder;
import cn.zyx.orderlist.service.ProductOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * description: OrderController <br>
 * date: 2019/12/18 14:49 <br>
 *
 * @author: ZhangYixin <br>
 * version: 1.0 <br>
 */
@RestController
@RequestMapping("order/")
public class OrderController {

    @Autowired
    private ProductOrderService productOrderService;

    @RequestMapping("save")
    public Object save(@RequestParam("user_id") int userId,@RequestParam("product_id") int productId){
        ProductOrder productOrder = productOrderService.saveOrder(userId, productId);
        return productOrder;
    }

}
