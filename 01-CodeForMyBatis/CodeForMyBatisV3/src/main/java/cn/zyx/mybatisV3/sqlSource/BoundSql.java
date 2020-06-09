package cn.zyx.mybatisV3.sqlSource;

import java.util.List;

/**
 * @Description
 * @ClassName BoundSql
 * @Author ZhangYixin
 * @date 2020.06.04 20:29
 */
public class BoundSql {

    private String sql;

    private List<ParameterMapping> parameterMappings;

    public BoundSql(String sql, List<ParameterMapping> parameterMappings) {
        this.sql = sql;
        this.parameterMappings = parameterMappings;
    }

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

    public List<ParameterMapping> getParameterMappings() {
        return parameterMappings;
    }

    public void addParameterMapping(ParameterMapping parameterMapping) {
        this.parameterMappings.add(parameterMapping);
    }
}
