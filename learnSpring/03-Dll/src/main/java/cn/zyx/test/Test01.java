package cn.zyx.test;

import cn.zyx.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test01 {

   @Test
    public void testDl(){
       ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
       UserService userService = (UserService)context.getBean("userService");
       userService.addUser();

   }
}
