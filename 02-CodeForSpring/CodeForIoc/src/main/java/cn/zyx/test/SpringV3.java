package cn.zyx.test;

import cn.zyx.framework.factory.BeanFactory;
import cn.zyx.framework.factory.impl.DefaultListableBeanFactory;
import cn.zyx.framework.reader.XmlBeanDefinitionReader;
import cn.zyx.framework.registry.BeanDefinitionRegistry;
import cn.zyx.framework.resource.Resource;
import cn.zyx.framework.resource.impl.ClassPathResource;
import cn.zyx.po.User;
import cn.zyx.service.UserService;
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


    private DefaultListableBeanFactory beanFactory;

    @Before
    public void before(){
        //完成XML解析，就是完成BeanDefinition的注册
        //XML解析，将结果放入BeanDefinition中
        String location = "bean01.xml";
        //获取流对象
        Resource resource  = new ClassPathResource(location);
        InputStream inputStream = resource.getResource();

        //按照Spring定义的标签语义去解析Document
        beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);
        xmlBeanDefinitionReader.registerBeanDefinitions(inputStream);

    }

    @Test
    public void test(){

        UserService userService = (UserService) beanFactory.getBean("userService");

        //查询参数
        Map<String,Object> param = new HashMap<>();
        param.put("name","wade");

        //用户查询
        List<User> users = userService.queryUsers(param);
        System.out.println(users);
    }
}
