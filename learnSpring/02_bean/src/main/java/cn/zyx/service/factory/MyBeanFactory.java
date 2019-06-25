package cn.zyx.service.factory;

import cn.zyx.service.StudentService;
import cn.zyx.service.impl.StudentServiceImpl;

public class MyBeanFactory {
    public StudentService createStudentService() {
        return new StudentServiceImpl();
    }
}
