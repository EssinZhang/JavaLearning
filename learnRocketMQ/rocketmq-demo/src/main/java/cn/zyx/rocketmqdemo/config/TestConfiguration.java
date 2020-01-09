package cn.zyx.rocketmqdemo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * description: TestConfiguration <br>
 * date: 2020/1/9 15:09 <br>
 *
 * @author: ZhangYixin <br>
 * version: 1.0 <br>
 */
@Configuration
@PropertySource("classpath:application.properties")
public class TestConfiguration {

    @Value("${NAME.SERVER.ADDR}")
    private String nameServAddr;

    @Value("${TOPIC}")
    private String topic;

    public String getNameServAddr() {
        return nameServAddr;
    }

    public void setNameServAddr(String nameServAddr) {
        this.nameServAddr = nameServAddr;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }
}
