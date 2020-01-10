package cn.zyx.rocketmqdemo.jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.SmartLifecycle;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
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


    @Value("${NAME.SERVER.ADDR}")
    private String caddr;
    @Value("${TOPIC}")
    private String cTopic;

    public static String NAME_SERVER_ADDR ;

    public static String TOPIC;

    @PostConstruct
    public void readConfig(){
        NAME_SERVER_ADDR = caddr;
        TOPIC = cTopic;
    }

}
