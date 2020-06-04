package cn.zyx.framework.sqlSource.impl;

import cn.zyx.framework.sqlNode.SqlNode;
import cn.zyx.framework.sqlSource.BoundSql;
import cn.zyx.framework.sqlSource.SqlSource;

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
        return null;
    }
}
