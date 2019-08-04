package cn.zyx.test;

import cn.zyx.RedisTestApplication;
import cn.zyx.domain.User;
import cn.zyx.utils.JsonUtils;
import cn.zyx.utils.RedisClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {RedisTestApplication.class})
public class RedisJsonTest {

    @Autowired
    private StringRedisTemplate strTpl;

    @Autowired
    private RedisClient redis;

    @Test
    public void testOne(){
        User u = new User();
        u.setName("parker");
        u.setPhone("22222");
        u.setCreateTime(new Date());

        String str = JsonUtils.obj2String(u);
        strTpl.opsForValue().set("str", str);
        System.out.println(str);

    }

}
