package cn.zyx.mybatisV3.sqlSource.impl;


import cn.zyx.mybatisV3.sqlSource.BoundSql;
import cn.zyx.mybatisV3.sqlSource.ParameterMapping;
import cn.zyx.mybatisV3.sqlSource.SqlSource;

import java.util.List;

/**
 * @Description  封装DynamicSqlSource和rawSqlSource解析之后的结果
 * @ClassName StaticSqlSource
 * @Author ZhangYixin
 * @date 2020.06.06 22:57
 */
public class StaticSqlSource implements SqlSource {

    private String sql;

    private List<ParameterMapping> parameterMappings;

    public StaticSqlSource(String sql, List<ParameterMapping> parameterMappings) {
        this.sql = sql;
        this.parameterMappings = parameterMappings;
    }

    @Override
    public BoundSql getBoundSql(Object param) {
        return new BoundSql(sql,parameterMappings);
    }
}
