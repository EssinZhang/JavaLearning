package cn.zyx.test;

import cn.zyx.bean.Employee;
import cn.zyx.dao.EmployeeDao;
import cn.zyx.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;


public class EmployeeTest {
    private SqlSession sqlSession;
    private EmployeeDao employeeDao;

    @Before
    public void init(){
        sqlSession = MybatisUtil.getSqlSession();
        employeeDao = sqlSession.getMapper(EmployeeDao.class);
    }

    @After
    public void closeSqlSession(){
        if (sqlSession != null){
            sqlSession.close();
        }
    }

    @Test
    public void selectUnderlingByMgr(){
        List<Employee> employeeList = employeeDao.selectUnderlingByMgr(1002);

        employeeList.forEach((employee -> {
            System.out.println(employee);
        }));
    }

    @Test
    public void selectUnderlingById(){
        List<Employee> employeeList = employeeDao.selectUnderlingById(1002);

        employeeList.forEach((employee -> {
            System.out.println(employee);
        }));
    }


}
