package cn.zyx.mybatisV3.builder;

import cn.zyx.mybatisV3.config.Configuration;
import cn.zyx.mybatisV3.sqlNode.SqlNode;
import cn.zyx.mybatisV3.sqlNode.support.IfSqlNode;
import cn.zyx.mybatisV3.sqlNode.support.MixedSqlNode;
import cn.zyx.mybatisV3.sqlNode.support.StaticTextSqlNode;
import cn.zyx.mybatisV3.sqlNode.support.TextSqlNode;
import cn.zyx.mybatisV3.sqlSource.SqlSource;
import cn.zyx.mybatisV3.sqlSource.impl.DynamicSqlSource;
import cn.zyx.mybatisV3.sqlSource.impl.RawSqlSource;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.Text;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description  解析sql脚本
 * @ClassName XMLScriptBuilder
 * @Author ZhangYixin
 * @date 2020.06.07 16:48
 */
public class XMLScriptBuilder {

    private boolean isDynamic;

    public SqlSource parseScriptNode(Element selectElement) {
        //解析所有的sqlNode
        MixedSqlNode mixedSqlNode = parseDynamicTags(selectElement);
        //将所有sqlnode封装到sqlsource中
        SqlSource sqlSource = null;
        //如果sql信息中包含动态标签或者${},那么DynamicSqlSource
        if (isDynamic){
            sqlSource = new DynamicSqlSource(mixedSqlNode);
        }else {
            sqlSource = new RawSqlSource(mixedSqlNode);
        }
        return sqlSource;
    }

    /**
     * 解析sqlNode调用
     * @param selectElement
     * @return
     */
    private MixedSqlNode parseDynamicTags(Element selectElement) {
        List<SqlNode> sqlNodeList = new ArrayList<>();

        int nodeCount = selectElement.nodeCount();
        for (int i = 0; i < nodeCount; i++) {
            Node node = selectElement.node(i);
            if (node instanceof Text){
                String text = node.getText().trim();
                //判断文本是否为空
                if (text == null || text.equals("")){
                    continue;
                }

                TextSqlNode textSqlNode = new TextSqlNode(text);
                if (textSqlNode.isDynamic()){
                    isDynamic = true;
                    sqlNodeList.add(textSqlNode);
                }else {
                    sqlNodeList.add(new StaticTextSqlNode(text));
                }

            }else if (node instanceof Element){
                isDynamic = true;
                Element element = (Element) node;
                String elementName = element.getName();
                //判断element标签是 if 还是 where
                if ("if".equals(elementName)){
                    String test = element.attributeValue("test");
                    MixedSqlNode mixedSqlNode = parseDynamicTags(element);

                    IfSqlNode ifSqlNode = new IfSqlNode(test,mixedSqlNode);
                    sqlNodeList.add(ifSqlNode);
                }else if("where".equals(elementName)){
                    //暂时不写
                }
            }
        }

        return new MixedSqlNode(sqlNodeList);
    }

}
