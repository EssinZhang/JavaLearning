package cn.zyx.framework.sqlSource.impl;

import cn.zyx.framework.sqlNode.DynamicContext;
import cn.zyx.framework.sqlNode.SqlNode;
import cn.zyx.framework.sqlSource.BoundSql;
import cn.zyx.framework.sqlSource.SqlSource;
import cn.zyx.framework.utils.GenericTokenParser;
import cn.zyx.framework.utils.ParameterMappingTokenHandler;

/**
 * @Description 封装解析出带的sqlNode信息（包含动态标签或者${}）
 * @ClassName DynamicSqlSource
 * @Author ZhangYixin
 * @date 2020.06.04 20:37
 */
public class DynamicSqlSource implements SqlSource {

    /**
     * 解析出来的所有SqlNode节点信息
     */
    private SqlNode rootSqlNode;

    public DynamicSqlSource(SqlNode rootSqlNode) {
        this.rootSqlNode = rootSqlNode;
    }

    @Override
    public BoundSql getBoundSql(Object param) {

        //解析所有的sqlNode节点信息，将sql拼接成一条完整的（这里没解析#{}）
        DynamicContext context = new DynamicContext(param);
        rootSqlNode.apply(context);
        //此时拼接成的sql语句中，可能还包含#{}，所以还要对应#{}解析
        String sqlString = context.getSql();
        ParameterMappingTokenHandler parameterMappingTokenHandler = new ParameterMappingTokenHandler();
        //#{}中的内容被GenericTokenParser解析出来之后，需要将结果交给parameterMappingTokenHandler去处理
        GenericTokenParser genericTokenParser = new GenericTokenParser("#{","}",parameterMappingTokenHandler);

        //得到最终的JDBC可以直接执行的SQL语句
        String sql = genericTokenParser.parse(sqlString);

        //将SQL语句和解析#{}产生的参数列表信息封装成BoundSql

        return new BoundSql(sql,parameterMappingTokenHandler.getParameterMappings());
    }
}
