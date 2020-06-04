package cn.zyx.framework.sqlNode.support;

import cn.zyx.framework.sqlNode.DynamicContext;
import cn.zyx.framework.sqlNode.SqlNode;

/**
 * @Description 存储带有${}的sql文本信息
 * @ClassName TextSqlNode
 * @Author ZhangYixin
 * @date 2020.06.04 21:00
 */
public class TextSqlNode implements SqlNode {

    private String sqlText;

    private boolean isDynimaic;

    public boolean isDynimaic(){
        //是： 则说明检测到了${}
        if (sqlText.indexOf("${") > -1){
            return true;
        }else {
            return false;
        }
    }

    public TextSqlNode(String sqlText) {
        this.sqlText = sqlText;
    }

    @Override
    public void apply(DynamicContext context) {

    }
}
