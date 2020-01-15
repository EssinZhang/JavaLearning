package cn.zyx.rocketmqdemo.jms;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.common.protocol.heartbeat.MessageModel;
import org.springframework.stereotype.Component;


/**
 * description: PayConsumer <br>
 * date: 2020/1/8 09:58 <br>
 *
 * @author: ZhangYixin <br>
 * version: 1.0 <br>
 */
@Component
public class PayConsumer {

    private DefaultMQPushConsumer consumer;

    private String consumerGroup = "pay_consumer_group";

    public PayConsumer() throws MQClientException {
        consumer = new DefaultMQPushConsumer(consumerGroup);
        consumer.setNamesrvAddr(JmsConfig.NAME_SERVER_ADDR);
        consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_LAST_OFFSET);

        //默认是集群方式，可以更改为广播，但是广播方式不支持重试
        //consumer.setMessageModel(MessageModel.CLUSTERING);

        consumer.subscribe(JmsConfig.TOPIC, "*");
        consumer.registerMessageListener((MessageListenerConcurrently) (msgs, context) -> {
            MessageExt msg = msgs.get(0);
            int reconsumeTimes = msg.getReconsumeTimes();
            try {

                        System.out.println("消费重试次数: " + reconsumeTimes);

                        System.out.printf("%s Receive New Messages: %s %n", Thread.currentThread().getName(), new String(msgs.get(0).getBody()));
                        String topic = msg.getTopic();
                        String body = new String(msg.getBody(), "utf-8");
                        String tags = msg.getTags();
                        String keys = msg.getKeys();
                        System.out.println("topic=" + topic + ", tags=" + tags + ", keys=" + keys + ", msg=" + body);
                        return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
                    } catch (Exception e) {

                        System.out.println("消费异常");
                        //如果重试2次不成功，则记录，人工介入
                        if (reconsumeTimes > 2){
                            System.out.println("重试次数大于2，记录数据库，发短信通知开发人员或者运营人员");
                            //TODO 记录数据库，发短信通知开发人员或者运营人员
                            //告诉broker，消息成功
                            return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
                        }

                        e.printStackTrace();
                        return ConsumeConcurrentlyStatus.RECONSUME_LATER;
                    }
                });
        consumer.start();

        System.out.println("consumer start ............................");
    }

}
