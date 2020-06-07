package cn.zyx.mybatisV3.executor.impl;

import cn.zyx.mybatisV3.config.Configuration;
import cn.zyx.mybatisV3.config.MappedStatement;
import cn.zyx.mybatisV3.sqlSource.BoundSql;
import cn.zyx.mybatisV3.sqlSource.SqlSource;
import cn.zyx.mybatisV3.statement.StatementHandler;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @ClassName SimpleExecutor
 * @Author ZhangYixin
 * @date 2020.06.07 20:24
 */
public class SimpleExecutor extends BaseExecutor {

    @Override
    public <T> List<T> queryFromDataSource(Configuration configuration, MappedStatement mappedStatement, Object param, BoundSql boundSql) {
        Connection con = null;		//连接


        //返回的集合
        List<T> results = new ArrayList<>();
        try {

            //获取连接
            Connection connect = getConnection(configuration);

            //判断 sqlNode crud标签的statement
            String statementType = mappedStatement.getStatementType();

            StatementHandler statementHandler = configuration.newStatementHandler(statementType);

            Statement statement = statementHandler.prepare(connect,boundSql.getSql());
            statementHandler.parameterize(statement,param,boundSql);
            results  = statementHandler.doQuery(statement,mappedStatement);


            return results;

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
//            // 释放资源
//            if (rs != null) {
//                try {
//                    rs.close();
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
//            } if (preparedStatement != null) {
//                try {
//                    preparedStatement.close();
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
//                }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                }
            }
        }
        return null;
    }


    /**
     * 用于获取数据库连接
     * @return
     */
    private Connection getConnection(Configuration configuration) {

        try {
            DataSource dataSource = configuration.getDataSource();
            Connection conn = dataSource.getConnection();
            return conn;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

}
