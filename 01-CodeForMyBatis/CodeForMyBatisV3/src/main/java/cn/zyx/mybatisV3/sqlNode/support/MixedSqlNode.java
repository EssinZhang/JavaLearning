package cn.zyx.mybatisV3.sqlNode.support;


import cn.zyx.mybatisV3.sqlNode.DynamicContext;
import cn.zyx.mybatisV3.sqlNode.SqlNode;

import java.util.List;

/**
 * @Description 封装同一级别的sqlNode集合
 * @ClassName TextSqlNode
 * @Author ZhangYixin
 * @date 2020.06.04 21:00
 */
public class MixedSqlNode implements SqlNode {

    private List<SqlNode> sqlNodes;

    public MixedSqlNode(List<SqlNode> sqlNodes) {
        this.sqlNodes = sqlNodes;
    }

    @Override
    public void apply(DynamicContext context) {

        for (SqlNode sqlNode : sqlNodes){
            sqlNode.apply(context);
        }
    }
}
