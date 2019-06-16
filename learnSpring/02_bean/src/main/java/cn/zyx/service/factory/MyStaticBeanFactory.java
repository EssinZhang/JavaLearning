package cn.zyx.service.factory;

import cn.zyx.service.StudentService;
import cn.zyx.service.impl.StudentServiceImpl;

public class MyStaticBeanFactory {
    public static StudentService createStudentService(){
        return new StudentServiceImpl();
    }
}
