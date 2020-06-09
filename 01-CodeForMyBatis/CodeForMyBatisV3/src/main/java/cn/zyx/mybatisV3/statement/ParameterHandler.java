package cn.zyx.mybatisV3.statement;

import cn.zyx.mybatisV3.sqlSource.BoundSql;

import java.sql.PreparedStatement;

/**
 * @Description
 * @ClassName ParameterHandler
 * @Author ZhangYixin
 * @date 2020.06.07 21:27
 */
public interface ParameterHandler {
    void setParameter(PreparedStatement preparedStatement, Object param, BoundSql boundSql) throws Exception;
}
