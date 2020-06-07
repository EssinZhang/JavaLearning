package cn.zyx.mybatisV3.statement.impl;

import cn.zyx.mybatisV3.config.Configuration;
import cn.zyx.mybatisV3.config.MappedStatement;
import cn.zyx.mybatisV3.sqlSource.BoundSql;
import cn.zyx.mybatisV3.sqlSource.ParameterMapping;
import cn.zyx.mybatisV3.statement.ParameterHandler;
import cn.zyx.mybatisV3.statement.ResultsetHandler;
import cn.zyx.mybatisV3.statement.StatementHandler;
import cn.zyx.mybatisV3.utils.SimpleTypeRegistry;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Description
 * @ClassName preparedStatementHandler
 * @Author ZhangYixin
 * @date 2020.06.07 21:17
 */
public class preparedStatementHandler implements StatementHandler {

    private ParameterHandler parameterHandler;
    private ResultsetHandler resultsetHandler;

    public preparedStatementHandler(Configuration configuration) {
        this.parameterHandler = configuration.newParameterHandler();
        this.resultsetHandler = configuration.newResultsetHandler();
    }

    @Override
    public Statement prepare(Connection connect,String sql) throws Exception{
        return connect.prepareStatement(sql);
    }

    @Override
    public void parameterize(Statement statement, Object param, BoundSql boundSql)throws  Exception {
        PreparedStatement preparedStatement = (PreparedStatement) statement;

        parameterHandler.setParameter(preparedStatement,param,boundSql);


    }

    @Override
    public <T> List<T> doQuery(Statement statement, MappedStatement mappedStatement)throws Exception {
        PreparedStatement preparedStatement = (PreparedStatement) statement;

        //设置结果集
        List<T> results = new ArrayList<>();


        ResultSet resultSet = preparedStatement.executeQuery();
        resultsetHandler.handleResultset(resultSet,results,mappedStatement);

        return results;
    }
}
