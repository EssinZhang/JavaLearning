package cn.zyx.mybatisV3.statement;

import cn.zyx.mybatisV3.config.MappedStatement;
import cn.zyx.mybatisV3.sqlSource.BoundSql;

import java.sql.Connection;
import java.sql.Statement;
import java.util.List;

/**
 * @Description
 * @ClassName StatementHandler
 * @Author ZhangYixin
 * @date 2020.06.07 21:14
 */
public interface StatementHandler {

    Statement prepare(Connection connect , String sql)throws Exception;

    void parameterize(Statement statement, Object param, BoundSql boundSql)throws Exception;

    <T> List<T> doQuery(Statement statement, MappedStatement mappedStatement)throws Exception;
}
