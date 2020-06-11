package cn.zyx.test;

import cn.zyx.po.User;
import cn.zyx.service.UserService;
import org.dom4j.Document;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * description: SpringV3 <br>
 * date: 2020/6/11 14:42 <br>
 *
 * @author: ZhangYixin <br>
 * version: 1.0 <br>
 */
public class SpringV3 {


    @Before
    public void before(){
        //完成XML解析，就是完成BeanDefinition的注册
        //XML解析，将结果放入BeanDefinition中
        String location = "bean01.xml";
        //获取流对象
        InputStream inputStream = getInputStream(location);
        //创建文本对象
        Document document = createDocument(inputStream);

        //按照Spring定义的标签语义去解析Document
        parseBeanDefinitions(document.getRootElement());

    }

    @Test
    public void test(){

        UserService userService = (UserService)getBean("userService");

        //查询参数
        Map<String,Object> param = new HashMap<>();
        param.put("name","wade");

        //用户查询
        List<User> users = userService.queryUsers(param);
        System.out.println(users);
    }
}
