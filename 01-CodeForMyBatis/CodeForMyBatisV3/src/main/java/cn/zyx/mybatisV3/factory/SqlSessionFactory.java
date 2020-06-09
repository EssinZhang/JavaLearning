package cn.zyx.mybatisV3.factory;

import cn.zyx.mybatisV3.sqlSession.SqlSession;

/**
 * @Description
 * @ClassName SqlSessionFactory
 * @Author ZhangYixin
 * @date 2020.06.07 16:22
 */
public interface SqlSessionFactory {

    SqlSession openSession();
}
