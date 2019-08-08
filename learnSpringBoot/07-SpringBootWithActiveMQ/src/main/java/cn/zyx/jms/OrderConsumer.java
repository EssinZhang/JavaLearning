package cn.zyx.jms;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class OrderConsumer {

    /**
     * 实时监听对应的队列信息
     * @param text
     */
    @JmsListener(destination = "order.queue")
    public void receiveQueue(String text){
        System.out.println("OrderConsumer收到的报文为："+text);
    }
}
