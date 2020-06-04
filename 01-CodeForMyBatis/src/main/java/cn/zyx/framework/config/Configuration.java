package cn.zyx.framework.config;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * 用来封装整个xml配置文件的信息
 */
public class Configuration {
    private DataSource dataSource;

    private Map<String,MappedStatement> mappedStatements = new HashMap<>();

    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public MappedStatement getMappedStatementById(String statementId) {
        return mappedStatements.get(statementId);
    }

    public void addMappedStatement(String statementId, MappedStatement mappedStatement) {
        this.mappedStatements.put(statementId, mappedStatement);
    }

}
