package cn.zyx.framework.sqlSource.impl;

import cn.zyx.framework.sqlSource.BoundSql;
import cn.zyx.framework.sqlSource.ParameterMapping;
import cn.zyx.framework.sqlSource.SqlSource;

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
