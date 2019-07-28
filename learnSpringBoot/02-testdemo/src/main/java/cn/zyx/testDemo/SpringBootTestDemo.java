package cn.zyx.testDemo;

import cn.zyx.DemoApplication;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)//底层用junit  SpringJunit4ClassRunner
@SpringBootTest(classes = {DemoApplication.class})//启动整个springboot工程
public class SpringBootTestDemo {

    @Test
    public void firstTest(){
        System.out.println("first test hello");
        TestCase.assertEquals(1,1);//断言
    }

    @Test
    public void secondTest(){
        System.out.println("second test goodbye");
    }

    @Before
    public void beforeFirstTest(){
        System.out.println("this is before");
    }

    @After
    public void afterFirstTest(){
        System.out.println("this is after");
    }
}
