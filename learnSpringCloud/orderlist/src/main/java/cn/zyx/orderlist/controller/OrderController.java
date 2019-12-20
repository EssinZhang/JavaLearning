package cn.zyx.orderlist.controller;

import cn.zyx.orderlist.domain.ProductOrder;
import cn.zyx.orderlist.service.ProductOrderService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

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
    @HystrixCommand(fallbackMethod = "saveOrderFail")
    public Object save(@RequestParam("user_id") int userId,@RequestParam("product_id") int productId){
        Map<String,Object> saveResult = new HashMap<>();
        saveResult.put("code",0);
        saveResult.put("data",productOrderService.saveOrder(userId,productId));
        return saveResult;
    }

    public Object saveOrderFail(int userId,int productId){
        Map<String,Object> failMsg = new HashMap<>();
        failMsg.put("code",-1);
        failMsg.put("msg","当前访问人数过多，请稍后重试");
        return failMsg;
    }

}
