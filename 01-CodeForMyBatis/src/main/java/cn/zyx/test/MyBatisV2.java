package cn.zyx.test;

import cn.zyx.po.User;
import org.junit.Test;

import javax.security.auth.login.Configuration;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * @Description
 * @ClassName MyBatisV2
 * @Author ZhangYixin
 * @date 2020.06.03 20:25
 */
public class MyBatisV2 {
    private Properties properties = new Properties();

    private Configuration

    @Test
    public void test(){
        loadXMl("mybatis-conf.xml");

        List<User> users = selectList("getUserById","kobe");
    }

    private <T> List<T>

    /**
     * 加载properties配置文件
     */
    public void loadProperties(String fileName) {
        try {
            InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(fileName);
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
