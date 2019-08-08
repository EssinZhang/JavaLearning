package cn.zyx.controller;

import cn.zyx.domain.JsonData;
import cn.zyx.service.ProducerService;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.Destination;

/**
 * 模拟微信支付回调
 */
@RestController
@RequestMapping("/api/v1")
public class OrderController {

    @Autowired
    private ProducerService producerService;

    /**
     * 模拟微信支付回调接口
     * @param msg
     * @return
     */
    @GetMapping("order")
    public Object order(String msg){
        //生成消息队列地址
        Destination destination = new ActiveMQQueue("order.queue");

        producerService.sendMessage(destination,msg);
        return JsonData.buildSuccess();
    }

    @GetMapping("common")
    public Object common(String msg){
        producerService.sendMessage(msg);

        return JsonData.buildSuccess();
    }

    @GetMapping("topic")
    public Object topic(String msg){
        producerService.publish(msg);

        return JsonData.buildSuccess();
    }

}
