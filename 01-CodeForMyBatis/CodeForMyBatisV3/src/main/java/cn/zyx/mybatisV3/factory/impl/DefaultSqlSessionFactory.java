package cn.zyx.mybatisV3.factory.impl;

import cn.zyx.mybatisV3.config.Configuration;
import cn.zyx.mybatisV3.factory.SqlSessionFactory;
import cn.zyx.mybatisV3.sqlSession.SqlSession;
import cn.zyx.mybatisV3.sqlSession.impl.DefaultSqlSession;

/**
 * @Description
 * @ClassName DefaultSqlSessionFactory
 * @Author ZhangYixin
 * @date 2020.06.07 16:30
 */
public class DefaultSqlSessionFactory implements SqlSessionFactory {

    private Configuration configuration;

    public DefaultSqlSessionFactory(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public SqlSession openSession() {

        return new DefaultSqlSession(configuration);
    }
}
