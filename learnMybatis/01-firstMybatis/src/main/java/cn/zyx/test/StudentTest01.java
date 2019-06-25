package cn.zyx.test;

import cn.zyx.bean.Student;
import cn.zyx.dao.StudentDao;
import cn.zyx.dao.impl.StudentDaoImpl;
import org.junit.Test;

public class StudentTest01 {

    @Test
    public void insertStudent(){
        StudentDao studentDao = new StudentDaoImpl();
        Student student = new Student("科比",24,81);

        studentDao.insertStudent(student);
    }
}
