package cn.zyx;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTempTopic;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;

import javax.jms.ConnectionFactory;
import javax.jms.Queue;
import javax.jms.Topic;


@SpringBootApplication
@EnableJms//开启支持JMS
public class ActiveMQTestApplication {

    /**
     * 交给spring进行管理，方便后续进行注入
     * @return
     */
    @Bean
    public Queue queue(){
        return new ActiveMQQueue("common.queue");
    }

    /**
     * 主题对象交给spring管理
     * @return
     */
    @Bean
    public Topic topic(){
        return new ActiveMQTempTopic("video.topic");
    }

    //需要给topic定义独立的JmsListenerContainer
    //同时支持发布订阅和点对点
    @Bean
    public JmsListenerContainerFactory<?> jmsListenerContainerTopic(ConnectionFactory activeMQConnectionFactory) {
        DefaultJmsListenerContainerFactory bean = new DefaultJmsListenerContainerFactory();
        bean.setPubSubDomain(true);
        bean.setConnectionFactory(activeMQConnectionFactory);
        return bean;
    }

    public static void main(String[] args) {
        SpringApplication.run(ActiveMQTestApplication.class, args);
    }

}
