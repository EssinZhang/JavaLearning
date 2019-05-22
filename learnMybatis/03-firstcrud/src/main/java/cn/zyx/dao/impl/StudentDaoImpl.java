package cn.zyx.dao.impl;

import cn.zyx.bean.Student;
import cn.zyx.dao.StudentDao;
import cn.zyx.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class StudentDaoImpl implements StudentDao {

    private SqlSession sqlSession = MybatisUtil.getSqlSession();

    @Override
    //插入数据 并得到自增主键
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

    //根据id删除
    public void deleteStudent(int id) {
        sqlSession = MybatisUtil.getSqlSession();
        sqlSession.delete("deleteStudent",id);
        sqlSession.commit();

        if (sqlSession != null){
            sqlSession.close();
        }
    }

    //根据id更新数据
    public void updateStudent(Student student){
        sqlSession = MybatisUtil.getSqlSession();
        sqlSession.update("updateStudent",student);

        sqlSession.commit();
        if (sqlSession != null){
            sqlSession.close();
        }
    }

    //查询所有数据
    public List<Student> selectAllStudent(){
        List<Student> studentsResult = null;
        try (SqlSession sqlSession = MybatisUtil.getSqlSession()) {//自动化关闭
            studentsResult = sqlSession.selectList("selectAllStudent");
        }

        return studentsResult;
    }

    //根据id查询数据
    public Student selectStudentById(int id){
        Student student = null;
        try (SqlSession sqlSession = MybatisUtil.getSqlSession()) {
            student = sqlSession.selectOne("selectStudentById",id);
        }

        return student;
    }

    //根据名字模糊查询
    public List<Student> selectStudentByName(String name){
        List<Student> students = null;
        try (SqlSession sqlSession = MybatisUtil.getSqlSession()) {
            students = sqlSession.selectList("selectStudentByName",name);
        }

        return students;
    }

    //根据id查询 添加了password字段 和字段名和属性名不一致的情况
    public Student selectStudentPwd(int id){
        Student student = null;
        try (SqlSession sqlSession = MybatisUtil.getSqlSession()) {
            student = sqlSession.selectOne("selectStudentPwd",id);
        }
        return student;
    }

}
