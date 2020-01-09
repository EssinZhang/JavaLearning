package cn.zyx.rocketmqdemo.controller;

import cn.zyx.rocketmqdemo.jms.JmsConfig;
import cn.zyx.rocketmqdemo.jms.PayProducer;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @ClassName PayController
 * @Author ZhangYixin
 * @date 2020.01.07 20:22
 */
@RestController
public class PayController {

    /*@Autowired
    private PayProducer payProducer;*/

    @RequestMapping("/api/v1/mqtest")
    public Object callback(String text) throws InterruptedException, RemotingException, MQClientException, MQBrokerException {

        PayProducer payProducer;

        Message message = new Message(JmsConfig.topic,"tags",("hello RocketMQ = "+text).getBytes());

        SendResult sendResult = payProducer.getDefaultMQProducer().send(message);

        System.out.println(sendResult);

        return "hahaha";

    }

    @GetMapping("/test")
    public String configTest(){
        System.out.println(JmsConfig.nameServerAddr);
        System.out.println(JmsConfig.topic);
        return "configTest";
    }

}
