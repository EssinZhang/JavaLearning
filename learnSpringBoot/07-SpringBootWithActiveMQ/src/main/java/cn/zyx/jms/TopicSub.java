package cn.zyx.jms;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class TopicSub {

    @JmsListener(destination = "video.topic")
    public void receive(String text){
        System.out.println("video.topic消费者:receive:"+text);
    }
}
