package cn.zyx.mybatisV3.executor.impl;

import cn.zyx.mybatisV3.config.Configuration;
import cn.zyx.mybatisV3.config.MappedStatement;
import cn.zyx.mybatisV3.executor.Executor;
import cn.zyx.mybatisV3.sqlSource.BoundSql;
import cn.zyx.mybatisV3.sqlSource.SqlSource;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description
 * @ClassName BaseExecutor
 * @Author ZhangYixin
 * @date 2020.06.07 20:13
 */
public abstract class BaseExecutor  implements Executor {

    private Map<String,List> oneLevelCache = new HashMap<>();

    @Override
    public <T> List<T> doQuery(Configuration configuration,MappedStatement mappedStatement, Object param) {
        SqlSource sqlSource = mappedStatement.getSqlSource();
        BoundSql boundSql = sqlSource.getBoundSql(param);
        String sql = boundSql.getSql();
        //一级缓存处理
        List<Object> list = oneLevelCache.get(sql);

        if (list == null){
            list = queryFromDataSource(configuration,mappedStatement,param,boundSql);
        }
        oneLevelCache.put(sql,list);
        return (List<T>) list;
    }

    public abstract <T> List<T> queryFromDataSource(Configuration configuration, MappedStatement mappedStatement, Object param, BoundSql boundSql);

}
