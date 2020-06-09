package cn.zyx.mybatisV3.config;

import cn.zyx.mybatisV3.executor.Executor;
import cn.zyx.mybatisV3.executor.impl.CachingExecutor;
import cn.zyx.mybatisV3.executor.impl.SimpleExecutor;
import cn.zyx.mybatisV3.statement.ParameterHandler;
import cn.zyx.mybatisV3.statement.ResultsetHandler;
import cn.zyx.mybatisV3.statement.StatementHandler;
import cn.zyx.mybatisV3.statement.impl.DefaultParameterHandler;
import cn.zyx.mybatisV3.statement.impl.DefaultResultsetHandler;
import cn.zyx.mybatisV3.statement.impl.preparedStatementHandler;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * 用来封装整个xml配置文件的信息
 */
public class Configuration {
    private DataSource dataSource;

    //是否使用缓存
    private boolean useCache = true;

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

    public Executor newExecutor(String type) {
        Executor executor = null;

        type = type == null ? "simple" : type;
        //执行器需要通过制定类配置 默认是simpleExecutor

        if (type.equals("simple")){
            executor = new SimpleExecutor();
        }

        if (useCache){
            executor = new CachingExecutor(executor);
        }
        return executor;
    }

    public StatementHandler newStatementHandler(String statementType) {

        StatementHandler statementHandler = null;

        if (statementType.equals("prepared")){
            statementHandler = new preparedStatementHandler(this);
        }

        return statementHandler;
    }

    public ParameterHandler newParameterHandler() {
        return new DefaultParameterHandler();
    }

    public ResultsetHandler newResultsetHandler() {
        return new DefaultResultsetHandler();
    }
}
