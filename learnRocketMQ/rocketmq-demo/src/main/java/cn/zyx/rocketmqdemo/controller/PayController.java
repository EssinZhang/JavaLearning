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

import java.util.HashMap;

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

    @RequestMapping("/api/v1/delayTest")
    public Object delayTest(String text ,int delayLevel) throws RemotingException, MQClientException, InterruptedException {
        Message message = new Message(JmsConfig.TOPIC,"tags",("hello RocketMQ = "+text).getBytes());

        //设置延迟时间等级
        //1s 5s 10s 30s 1m 2m 3m 4m 5m 6m 7m 8m 9m 10m 20m 30m 1h 2h
        HashMap<Integer,String> delayTimeOfLevel = new HashMap<>(18);
        String longString = "1s 5s 10s 30s 1m 2m 3m 4m 5m 6m 7m 8m 9m 10m 20m 30m 1h 2h";
        String[] strings = longString.split(" ");
        for (int i = 1 ; i <= strings.length ; i++){
            delayTimeOfLevel.put(i,strings[i-1]);
        }
        message.setDelayTimeLevel(delayLevel);

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

        String returnString = "延时等级："+delayLevel+"\t延时时间："+delayTimeOfLevel.get(delayLevel);
        return returnString;
    }

    @GetMapping("/test")
    public String configTest(){
        System.out.println(JmsConfig.NAME_SERVER_ADDR);
        System.out.println(JmsConfig.TOPIC);
        return "configTest";
    }

}
