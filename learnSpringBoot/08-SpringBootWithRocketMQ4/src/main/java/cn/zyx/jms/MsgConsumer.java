package cn.zyx.jms;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MsgConsumer {

    @Value("${apache.rocketmq.consumer.PushConsumer}")
    private String consumerGroup;

    /**
     * NameServer地址
     */
    @Value("${apache.rocketmq.namesrvAddr}")
    private String nameservAddr;

    public void initMQPushConsumer(){
        //消费者组名
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer(consumerGroup);
        //指定NameServer地址，多个地址以；号隔开
        consumer.setNamesrvAddr(nameservAddr);

        try {
            //设置consumer所订阅的topic和Tag，*代表全部Tag
            consumer.subscribe("testTopic","*");

            //CONSUME_FROM_LAST_OFFSET 默认策略，从该队列最尾开始消费，跳过历史消息
            //CONSUME_FROM_FIRST_OFFSET 从队列最开始开始消费，即历史消息（还储存在broker的）全部消费一遍
            consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_LAST_OFFSET);

            //MessageListenerOrderly 这个是有序的
            //MessageListenerConcurrently 这个是无序的,并行的方式处理，效率高很多
            consumer.registerMessageListener((MessageListenerConcurrently)(list,context)->{
                try {
                    for (MessageExt messageExt : list){
                        System.out.println("messageExt: " + messageExt);//输出消息内容

                        String messageBody = new String(messageExt.getBody(), RemotingHelper.DEFAULT_CHARSET);

                        System.out.println("消费响应：msgId： " + messageExt.getMsgId() + ", msgBody : " + messageBody);//输出消息内容
                    }
                }catch (Exception e){
                    e.printStackTrace();
                    return ConsumeConcurrentlyStatus.RECONSUME_LATER;//稍后再试
                }
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;//消费成功
            });
            consumer.start();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
