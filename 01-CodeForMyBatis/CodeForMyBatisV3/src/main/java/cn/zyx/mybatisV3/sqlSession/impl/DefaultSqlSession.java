package cn.zyx.mybatisV3.sqlSession.impl;

import cn.zyx.mybatisV3.config.Configuration;
import cn.zyx.mybatisV3.config.MappedStatement;
import cn.zyx.mybatisV3.executor.Executor;
import cn.zyx.mybatisV3.sqlSession.SqlSession;

import java.util.List;

/**
 * @Description
 * @ClassName DefaultSqlSession
 * @Author ZhangYixin
 * @date 2020.06.07 16:28
 */
public class DefaultSqlSession implements SqlSession {

    private Configuration configuration;

    public DefaultSqlSession(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public <T> List<T> selectList(String statementId, Object param) {
        MappedStatement mappedStatement = configuration.getMappedStatementById(statementId);
        // jdbc操作 给executor完成
        Executor executor = configuration.newExecutor(null);
        return executor.doQuery(configuration,mappedStatement,param);

    }

    @Override
    public <T> T selectOne(String statementId, Object param) {
        List<Object> list = this.selectList(statementId,param);
        if (list != null && list.size() == 1 ){
            return (T) list.get(0);
        }else {
            //抛出异常
        }
        return null;
    }
}
