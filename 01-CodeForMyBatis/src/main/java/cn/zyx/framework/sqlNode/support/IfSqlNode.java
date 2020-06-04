package cn.zyx.framework.sqlNode.support;

import cn.zyx.framework.sqlNode.DynamicContext;
import cn.zyx.framework.sqlNode.SqlNode;

/**
 * @Description 存储带有if标签的sql文本信息
 * @ClassName TextSqlNode
 * @Author ZhangYixin
 * @date 2020.06.04 21:00
 */
public class IfSqlNode implements SqlNode {
    /**
     * userMapper.xml中对应的if标签中有test 还有 sql文本信息
     */
    private String test;

    private SqlNode mixedSqlNode;

    public IfSqlNode(String test, SqlNode mixedSqlNode) {
        this.test = test;
        this.mixedSqlNode = mixedSqlNode;
    }

    @Override
    public void apply(DynamicContext context) {

    }
}
