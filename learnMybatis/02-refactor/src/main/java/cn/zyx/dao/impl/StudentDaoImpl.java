package cn.zyx.dao.impl;

import cn.zyx.bean.Student;
import cn.zyx.dao.StudentDao;
import cn.zyx.util.MybatisUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class StudentDaoImpl implements StudentDao {

    private SqlSession sqlSession;

    @Override
    public void insertStudent(Student student) {
        sqlSession = MybatisUtil.getSqlSession();
        //新增数据操作   第一个参数要和对应的studentMapper的id一致
        sqlSession.insert("insertStudent", student);
        //提交SqlSession
        sqlSession.commit();
        if (sqlSession != null){
            sqlSession.close();
        }
    }
}
