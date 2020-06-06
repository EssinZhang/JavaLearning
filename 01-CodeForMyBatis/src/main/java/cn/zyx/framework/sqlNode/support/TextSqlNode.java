package cn.zyx.framework.sqlNode.support;

import cn.zyx.framework.sqlNode.DynamicContext;
import cn.zyx.framework.sqlNode.SqlNode;
import cn.zyx.framework.utils.*;

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
        ParameterMappingTokenHandler parameterMappingTokenHandler = new ParameterMappingTokenHandler();
        //#{}中的内容被GenericTokenParser解析出来之后，需要将结果交给parameterMappingTokenHandler去处理
        GenericTokenParser genericTokenParser = new GenericTokenParser("${","}",parameterMappingTokenHandler);

        //得到最终的JDBC可以直接执行的SQL语句
        String sql = genericTokenParser.parse(sqlText);
    }

    /**
     * 用来处理${}的参数问题
     */
    class BindingTokenHandler implements TokenHandler{

        private DynamicContext context;

        //${}中的参数分两种情况返回  如果是简单类型直接返回  如果是map类型则需要特殊处理
        @Override
        public String handleToken(String content) {
            //获取入参对象
            Object parameter = context.getBindings().get("_parameter");
            //判断入参类型，如果是简单类型，则直接返回对应的值
            if (parameter == null){
                return "";
            }else if (SimpleTypeRegistry.isSimpleType(parameter.getClass())){
                //如果是简单类型
                return parameter.toString();
            }
            //如果不是简单类型，比如说是map或者user对象
            Object value = OgnlUtils.getValue(content,parameter);

            return value == null ? "":value.toString();
        }
    }
}
