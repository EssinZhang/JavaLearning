package cn.zyx.test;

import cn.zyx.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {
    @Test
    public void testAOP(){
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-aop.xml");
        UserService userService = (UserService) context.getBean("userService");

        //userService.addUser();
        //userService.updateUser();
        /*try {
            userService.selectUserById(0);
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        //userService.selectUser();
        userService.deleteUser();
    }
}
