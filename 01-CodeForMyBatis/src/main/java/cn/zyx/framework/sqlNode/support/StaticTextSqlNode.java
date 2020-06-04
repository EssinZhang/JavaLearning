package cn.zyx.framework.sqlNode.support;

import cn.zyx.framework.sqlNode.DynamicContext;
import cn.zyx.framework.sqlNode.SqlNode;

/**
 * @Description 存储不带有${}的sql文本信息
 * @ClassName TextSqlNode
 * @Author ZhangYixin
 * @date 2020.06.04 21:00
 */
public class StaticTextSqlNode implements SqlNode {

    private String sqlText;

    public StaticTextSqlNode(String sqlText) {
        this.sqlText = sqlText;
    }

    @Override
    public void apply(DynamicContext context) {

    }
}
