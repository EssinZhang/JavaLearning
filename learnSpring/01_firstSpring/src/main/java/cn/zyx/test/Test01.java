package cn.zyx.test;

import cn.zyx.service.StudentService;
import cn.zyx.service.impl.StudentServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test01 {

    //以前的写法，这种写法需要手动创建对象
    @Test
    public void oldType(){
        StudentServiceImpl studentService = new StudentServiceImpl();
        studentService.study();
    }

    @Test
    public void newType(){
        //读取spring配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        StudentService studentService = (StudentService) context.getBean("studentService");
        studentService.study();
    }
}
