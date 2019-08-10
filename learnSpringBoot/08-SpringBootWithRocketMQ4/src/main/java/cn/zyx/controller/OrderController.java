package cn.zyx.controller;

import cn.zyx.domain.JsonData;
import cn.zyx.jms.MsgProducer;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;

@RestController
@RequestMapping("/api/v1")
public class OrderController {

    @Autowired
    private MsgProducer msgProducer;

    @Autowired
    @Value("${test.url}")
    private String testProperties;

    @GetMapping("order")
    public Object order(String msg,String tag) throws InterruptedException, RemotingException, MQClientException, MQBrokerException, UnsupportedEncodingException {
        /*创建一个消息实例，包含topic，tag 和 消息体*/
        Message message = new Message("testTopic",tag,msg.getBytes(RemotingHelper.DEFAULT_CHARSET));

        SendResult sendResult = msgProducer.getProducer().send(message);

        System.out.println("发送响应：MsgId:"+sendResult.getMsgId()+"发送状态："+sendResult.getSendStatus());

        return JsonData.buildSuccess();
    }


    @GetMapping("appTest")
    public Object appTest(){
        return JsonData.buildSuccess(testProperties);
    }

}
