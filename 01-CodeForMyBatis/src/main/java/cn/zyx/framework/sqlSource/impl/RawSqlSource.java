package cn.zyx.framework.sqlSource.impl;

import cn.zyx.framework.sqlNode.SqlNode;
import cn.zyx.framework.sqlSource.BoundSql;
import cn.zyx.framework.sqlSource.SqlSource;

/**
 * @Description 封装解析出带的sqlNode信息（包含非动态标签或者#{}）
 * #{}只需要被解析一次就可以了
 * @ClassName DynamicSqlSource
 * @Author ZhangYixin
 * @date 2020.06.04 20:37
 */
public class RawSqlSource implements SqlSource {

    public RawSqlSource(SqlNode rootSqlNode) {

    }

    @Override
    public BoundSql getBoundSql(Object param) {
        return null;
    }
}
