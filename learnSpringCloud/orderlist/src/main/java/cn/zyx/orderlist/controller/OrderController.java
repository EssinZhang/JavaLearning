package cn.zyx.orderlist.controller;

import cn.zyx.orderlist.service.ProductOrderService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

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

    @Autowired
    private RedisTemplate redisTemplate;

    @RequestMapping("save")
    @HystrixCommand(fallbackMethod = "saveOrderFail")
    public Object save(@RequestParam("user_id") int userId,@RequestParam("product_id") int productId, HttpServletRequest request){
        //获取token和cookie
        String token = request.getHeader("token");
        String cookie = request.getHeader("cookie");
        System.out.println("token:"+token);
        System.out.println("cookie:"+cookie);


        Map<String,Object> saveResult = new HashMap<>();
        saveResult.put("code",0);
        saveResult.put("data",productOrderService.saveOrder(userId,productId));
        return saveResult;
    }

    //注意，方法签名一定要和api方法一致
    public Object saveOrderFail(int userId, int productId, HttpServletRequest request){

        //监控报警
        String saveOrder = "save-order";
        String saveOrderValue = (String) redisTemplate.opsForValue().get(saveOrder);
        String ip = request.getRemoteAddr();
        new Thread( ()->{

            if (StringUtils.isEmpty(saveOrderValue)){
                System.out.println("紧急，用户下单失败，请检查原因;ip为"+ip);
                redisTemplate.opsForValue().set("save-order","save-order-fail", 20,TimeUnit.SECONDS);
            }else {
                System.out.println("已发送过短信，请20s后重试");
            }

        } ).start();


        Map<String,Object> failMsg = new HashMap<>();
        failMsg.put("code",-1);
        failMsg.put("msg","当前访问人数过多，请稍后重试........");
        return failMsg;
    }

}
