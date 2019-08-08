package cn.zyx.service.impl;

import cn.zyx.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

import javax.jms.Destination;
import javax.jms.Queue;
import javax.jms.Topic;

@Service
public class ProducerServiceImpl implements ProducerService {

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;//用来发送消息到broker的对象

    @Autowired
    private Queue queue;

    /**
     * 发送消息，destination是发送到的队列，message是待发送的消息
     * @param destination
     * @param message
     */
    @Override
    public void sendMessage(Destination destination, final String message) {
        jmsMessagingTemplate.convertAndSend(destination,message);
    }

    /**
     * 发送消息，发送到默认的队列（这里默认的是在启动类里设置注入的那个），message是待发送的消息
     * @param message
     */
    @Override
    public void sendMessage(final String message) {
        jmsMessagingTemplate.convertAndSend(this.queue,message);
    }

    /**************************发布订阅·*******************************/
    @Autowired
    private Topic topic;

    /**
     * 发布消息
     * @param msg
     */
    @Override
    public void publish(String msg) {
        this.jmsMessagingTemplate.convertAndSend(this.topic,msg);
    }
}
