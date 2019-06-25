package cn.zyx.test;

import cn.zyx.bean.Student;
import cn.zyx.dao.StudentDao;
import cn.zyx.dao.impl.StudentDaoImpl;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class StudentTest01 {

    private StudentDao studentDao;
    @Before
    public void initStudentDao(){
        studentDao = new StudentDaoImpl();
    }

    @Test
    //插入数据 并得到自增主键
    public void insertStudent(){
        Student student = new Student("韦德",3,58);

        System.out.println(student.getId());
        studentDao.insertStudent(student);
        System.out.println(student.getId());
    }

    @Test
    //根据id删除
    public void deleteStudent(){
        studentDao.deleteStudent(2);
    }

    @Test
    //根据id更新数据
    public void updateStudent(){
        Student student = new Student(3,"Kobe",24,81);

        studentDao.updateStudent(student);
    }

    @Test
    //查询所有数据
    public void selectAllStudent(){
        List<Student> studentList = studentDao.selectAllStudent();

        //lambda表达式遍历
        studentList.forEach((s -> {
            System.out.println(s);
        }));
    }

    @Test
    //根据id查询数据
    public void selectStudentById(){
        Student student = studentDao.selectStudentById(3);

        System.out.println(student);
    }

    @Test
    //根据名字模糊查询
    public void selectStudentByName(){
        List<Student> students = studentDao.selectStudentByName("Ko");

        students.forEach((student -> {
            System.out.println(student);
        }));
    }

    @Test
    //根据id查询 添加了password字段 和字段名和属性名不一致的情况
    public void selectStudentPwd(){
        Student student = studentDao.selectStudentPwd(3);
        System.out.println(student);
    }
}
