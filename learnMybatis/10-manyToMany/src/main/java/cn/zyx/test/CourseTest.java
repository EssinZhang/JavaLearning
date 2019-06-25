package cn.zyx.test;

import cn.zyx.bean.Course;
import cn.zyx.dao.CourseDao;
import cn.zyx.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class CourseTest {
    private SqlSession sqlSession;
    private CourseDao courseDao;

    @Before
    public void init(){
        sqlSession = MybatisUtil.getSqlSession();
        courseDao = sqlSession.getMapper(CourseDao.class);
    }

    @After
    public void closeSqlSession(){
        if (sqlSession != null){
            sqlSession.close();
        }
    }

    @Test
    public void selectCourseStudentById(){
        Course course = courseDao.selectCourseStudentById(1001);
        System.out.println(course);
    }
}
