package cn.zyx.rocketmqdemo.jms;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.SmartLifecycle;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * description: JmsConfig <br>
 * date: 2020/1/8 10:00 <br>
 *
 * @author: ZhangYixin <br>
 * version: 1.0 <br>
 */
@Component
@PropertySource("classpath:application.properties")
public class JmsConfig {

    public static String nameServerADDR;

    //public static String nameServerADDR ;

    public static String TOPIC;

    //public static String TOPIC;

    @Value("${NAME.SERVER.ADDR}")
    public String nameServerAddr;

    @Value("${TOPIC}")
    public String topic;

    @PostConstruct
    public void init(){
        nameServerADDR = nameServerAddr;
        TOPIC = topic;
    }

}
