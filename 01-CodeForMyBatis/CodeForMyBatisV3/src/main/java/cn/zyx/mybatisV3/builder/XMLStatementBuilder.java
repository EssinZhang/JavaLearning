package cn.zyx.mybatisV3.builder;

import cn.zyx.mybatisV3.config.Configuration;
import cn.zyx.mybatisV3.config.MappedStatement;
import cn.zyx.mybatisV3.sqlSource.SqlSource;
import cn.zyx.mybatisV3.utils.ReflectUtils;
import org.dom4j.Element;


/**
 * @Description
 * @ClassName XMLStatementBuilder
 * @Author ZhangYixin
 * @date 2020.06.07 16:48
 */
public class XMLStatementBuilder {

    private Configuration configuration;


    public XMLStatementBuilder(Configuration configuration) {
        this.configuration = configuration;
    }



    /**
     * 解析 crud 的标签 也就是statement标签
     * @param nameSpace
     * @param selectElement
     */
    public void parseStatementElement(String nameSpace, Element selectElement) {
        //这里就获取到了select标签的id属性值   因为前面获取的标签就是select标签 所以这个是select标签的id属性值
        String statementID = selectElement.attributeValue("id");
        if (statementID == null || statementID.equals("")){
            return;
        }

        //一个crud标签对应一个mappedStatement对象
        //一个mappedStatement对象由一个statementId来标识，来保证唯一
        //statementId = namespace + “.” + crud标签的id属性
        statementID = nameSpace + "." + statementID;

        // 注意：parameterType参数可以不设置也可以不解析
        String parameterType = selectElement.attributeValue("parameterType");
        Class<?> parameterClass = ReflectUtils.resolveType(parameterType);

        //结果类型的获取
        String resultType = selectElement.attributeValue("resultType");
        Class<?> resultTypeClass = ReflectUtils.resolveType(resultType);

        String statementType = selectElement.attributeValue("statementType");
        statementType =  (statementType == null) || (statementType.equals("")) ? "prepared" : statementType ;

        //sqlSource 的封装
        SqlSource sqlSource = createSqlSource(selectElement);

        // TODO 建议使用构建者模式去优化
        MappedStatement mappedStatement = new MappedStatement(statementID, parameterClass, resultTypeClass, statementType, sqlSource);
        configuration.addMappedStatement(statementID, mappedStatement);
    }

    private SqlSource createSqlSource(Element selectElement) {
        XMLScriptBuilder xmlScriptBuilder = new XMLScriptBuilder();
        SqlSource sqlSource = xmlScriptBuilder.parseScriptNode(selectElement);

        return sqlSource;
    }
}
