package cn.zyx.test;

import cn.zyx.bean.Student;
import cn.zyx.dao.StudentDao;
import cn.zyx.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


public class StudentTest01 {

    private StudentDao studentDao;
    private SqlSession sqlSession;
    @Before
    public void init(){
        sqlSession = MybatisUtil.getSqlSession();
        //获取studentDao对象
        //mapper动态代理
        studentDao = sqlSession.getMapper(StudentDao.class);
    }

    /**
     * 方法执行完成后关闭sqlsession
     */
    @After
    public void closeSqlsession(){
        if (sqlSession != null){
            sqlSession.close();
        }
    }

    @Test
    public void selectIf(){
        Student student = new Student("Ko", 2, 89);
        List<Student> students = studentDao.selectIf(student);
        students.forEach((stu ->{
            System.out.println(stu);
        }));
    }

    @Test
    public void selectWhere(){
        Student student = new Student("艾",2,40);
        List<Student> students = studentDao.selectWhere(student);
        students.forEach((stu ->{
            System.out.println(stu);
        }));
    }

    @Test
    public void selectChoose(){
        Student student = new Student("",1,2);
        List<Student> students = studentDao.selectChoose(student);
        students.forEach((stu ->{
            System.out.println(stu);
        }));
    }

    @Test
    public void selectForEachArray(){
        int[] ids = {1,3};
        List<Student> students = studentDao.selectForEachArray(ids);
        students.forEach((stu ->{
            System.out.println(stu);
        }));
    }

    @Test
    public void selectForEachList(){
        List<Integer> ids = new ArrayList<>();
        ids.add(1);
        ids.add(4);
        List<Student> students = studentDao.selectForEachList(ids);
        students.forEach((stu ->{
            System.out.println(stu);
        }));
    }

    @Test
    public void selectForEachStuList(){
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student(3,"Ko", 2, 89));
        studentList.add(new Student(2,"ss", 2, 89));

        List<Student> students = studentDao.selectForEachStuList(studentList);
        students.forEach((stu ->{
            System.out.println(stu);
        }));
    }

    @Test
    public void selectWarn(){
        Student student = new Student("Ko", 2, 89);
        List<Student> students = studentDao.selectIf(student);
        students.forEach((stu ->{
            System.out.println(stu);
        }));
    }

}
