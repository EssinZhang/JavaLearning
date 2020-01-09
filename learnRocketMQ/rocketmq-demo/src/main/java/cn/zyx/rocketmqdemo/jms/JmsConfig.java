package cn.zyx.rocketmqdemo.jms;

import cn.zyx.rocketmqdemo.config.TestConfiguration;
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

    @Autowired
    private TestConfiguration config;

    //public static String nameServerADDR = "39.97.232.41:9876";

    public static String nameServerAddr ;

    //public static String TOPIC = "zyx_pay_test";

    public static String topic;

    @PostConstruct
    public void readConfig(){
        nameServerAddr = config.getNameServAddr();
        topic = config.getTopic();
    }

}
