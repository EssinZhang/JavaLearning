package cn.zyx.mybatisV3.config;

import cn.zyx.mybatisV3.sqlSource.SqlSource;

public class MappedStatement {
    private String statementId;
    private SqlSource sqlSource;

    private String statementType;

    private Class<?> parameterTypeClass;
    private Class<?> resultTypeClass;

    public MappedStatement(String statementId, Class<?> parameterTypeClass, Class<?> resultTypeClass,
                           String statementType, SqlSource sqlSource) {
        this.statementId = statementId;
        this.parameterTypeClass = parameterTypeClass;
        this.resultTypeClass = resultTypeClass;
        this.statementType = statementType;
        this.sqlSource = sqlSource;
    }

    public SqlSource getSqlSource() {
        return sqlSource;
    }

    public void setSqlSource(SqlSource sqlSource) {
        this.sqlSource = sqlSource;
    }

    public String getStatementType() {
        return statementType;
    }

    public void setStatementType(String statementType) {
        this.statementType = statementType;
    }

    public String getStatementId() {
        return statementId;
    }

    public void setStatementId(String statementId) {
        this.statementId = statementId;
    }

    public Class<?> getParameterTypeClass() {
        return parameterTypeClass;
    }

    public void setParameterTypeClass(Class<?> parameterTypeClass) {
        this.parameterTypeClass = parameterTypeClass;
    }

    public Class<?> getResultTypeClass() {
        return resultTypeClass;
    }

    public void setResultTypeClass(Class<?> resultTypeClass) {
        this.resultTypeClass = resultTypeClass;
    }
}
