package cn.zyx.mybatisV3.sqlSource.impl;


import cn.zyx.mybatisV3.sqlNode.DynamicContext;
import cn.zyx.mybatisV3.sqlNode.SqlNode;
import cn.zyx.mybatisV3.sqlSource.BoundSql;
import cn.zyx.mybatisV3.sqlSource.SqlSource;
import cn.zyx.mybatisV3.utils.GenericTokenParser;
import cn.zyx.mybatisV3.utils.ParameterMappingTokenHandler;

/**
 * @Description 封装解析出带的sqlNode信息（包含非动态标签或者#{}）
 * #{}只需要被解析一次就可以了
 * @ClassName DynamicSqlSource
 * @Author ZhangYixin
 * @date 2020.06.04 20:37
 */
public class RawSqlSource implements SqlSource {

    private SqlSource staticSqlSource;

    public RawSqlSource(SqlNode rootSqlNode) {
        //解析#{}
        //解析所有的sqlNode节点信息，将sql拼接成一条完整的（这里没解析#{}）
        DynamicContext context = new DynamicContext(null);
        rootSqlNode.apply(context);
        //此时拼接成的sql语句中，可能还包含#{}，所以还要对应#{}解析
        String sqlString = context.getSql();
        ParameterMappingTokenHandler parameterMappingTokenHandler = new ParameterMappingTokenHandler();
        //#{}中的内容被GenericTokenParser解析出来之后，需要将结果交给parameterMappingTokenHandler去处理
        GenericTokenParser genericTokenParser = new GenericTokenParser("#{","}",parameterMappingTokenHandler);

        //得到最终的JDBC可以直接执行的SQL语句
        String sql = genericTokenParser.parse(sqlString);

        //将SQL语句和解析#{}产生的参数列表信息封装成BoundSql
        staticSqlSource = new StaticSqlSource(sql,parameterMappingTokenHandler.getParameterMappings());
    }

    @Override
    public BoundSql getBoundSql(Object param) {

        return staticSqlSource.getBoundSql(param);
    }
}
