package cn.zyx.rocketmqdemo.jms;

import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.springframework.stereotype.Component;

/**
 * @Description
 * @ClassName PayProducer
 * @Author ZhangYixin
 * @date 2020.01.07 20:02
 */
@Component
public class PayProducer {

    private String producerGroup = "pay_group";

    private String nameServerAddr = "39.97.232.41:9876";

    private DefaultMQProducer defaultMQProducer;

    public PayProducer(){
        defaultMQProducer = new DefaultMQProducer(producerGroup);

        //指定NameServer地址，多个地址以；隔开
        //如 producer.setNamesrvAddr(nameServerAddr)

        defaultMQProducer.setNamesrvAddr(nameServerAddr);

        start();

    }

    public DefaultMQProducer getDefaultMQProducer(){
        return this.defaultMQProducer;
    }

    /**
     * 对象在使用之前必须要调用一次，只能初始化一次
     */
    public void start(){
        try {
            this.defaultMQProducer.start();
        }catch (MQClientException e){
            e.printStackTrace();
        }
    }

    /**
     * 一般在应用上下文，使用上下文监听器，进行关闭
     */
    public void shutdown(){
        this.defaultMQProducer.shutdown();
    }

}
