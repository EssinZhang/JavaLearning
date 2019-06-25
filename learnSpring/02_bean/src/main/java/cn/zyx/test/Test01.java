package cn.zyx.test;

import cn.zyx.service.StudentService;
import cn.zyx.service.impl.StudentServiceImpl;
import javafx.application.Application;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test01 {

    @Test
    public void newType(){
        //读取spring配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        StudentService studentService = (StudentService) context.getBean("studentService");
        studentService.study();
    }

    /**
     * 实例工厂的方式
     */
    @Test
    public void newTypeByFactory(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        StudentService studentService = (StudentService) context.getBean("studentService");
        studentService.study();
    }

    /**
     *  作用域  单例模式singleton
     *  默认为单例模式，只创建了一个对象
     *  prototype通过在apring的xml文件中配置，scope属性
     */
    @Test
    public void testSingleton(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        StudentService studentService = (StudentService) context.getBean("studentService");
        StudentService studentService1 = (StudentService) context.getBean("studentService");
        System.out.println(studentService);
        System.out.println(studentService1);
        System.out.println(studentService == studentService1);
    }

    /**
     * beanPostProsessor 测试
     */
    @Test
    public void testBeanPostProsessor(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        //从spring中获取对象
        StudentService studentService = (StudentService) context.getBean("studentService");
        studentService.study();

        //将context关闭，此时会执行destroy方法
        ((ClassPathXmlApplicationContext)context).close();
    }
}
