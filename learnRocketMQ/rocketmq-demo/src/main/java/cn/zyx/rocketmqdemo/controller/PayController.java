package cn.zyx.rocketmqdemo.controller;

import cn.zyx.rocketmqdemo.jms.JmsConfig;
import cn.zyx.rocketmqdemo.jms.PayProducer;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tinygroup.springutil.SpringUtil;

/**
 * @Description
 * @ClassName PayController
 * @Author ZhangYixin
 * @date 2020.01.07 20:22
 */
@RestController
public class PayController {

    @Autowired
    private PayProducer payProducer;

    @RequestMapping("/api/v1/mqtest")
    public Object callback(String text) throws InterruptedException, RemotingException, MQClientException, MQBrokerException {

        Message message = new Message(JmsConfig.TOPIC,"tags",("hello RocketMQ = "+text).getBytes());

        payProducer.getDefaultMQProducer().send(message, new SendCallback() {
            @Override
            public void onSuccess(SendResult sendResult) {
                System.out.printf("发送结果: %s /t msg: +%s", sendResult.getSendStatus(),sendResult);
            }

            @Override
            public void onException(Throwable e) {
                e.printStackTrace();
                //补偿机制，根据业务情况进行使用，看是否进行重试
            }
        });

        return "hahaha";

    }

    @GetMapping("/test")
    public String configTest(){
        System.out.println(JmsConfig.NAME_SERVER_ADDR);
        System.out.println(JmsConfig.TOPIC);
        return "configTest";
    }

}
