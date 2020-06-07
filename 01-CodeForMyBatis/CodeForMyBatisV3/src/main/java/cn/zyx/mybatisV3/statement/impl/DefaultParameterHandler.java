package cn.zyx.mybatisV3.statement.impl;

import cn.zyx.mybatisV3.sqlSource.BoundSql;
import cn.zyx.mybatisV3.sqlSource.ParameterMapping;
import cn.zyx.mybatisV3.statement.ParameterHandler;
import cn.zyx.mybatisV3.utils.SimpleTypeRegistry;

import java.sql.PreparedStatement;
import java.util.List;
import java.util.Map;

/**
 * @Description
 * @ClassName DefaultParameterHandler
 * @Author ZhangYixin
 * @date 2020.06.07 21:28
 */
public class DefaultParameterHandler implements ParameterHandler {

    @Override
    public void setParameter(PreparedStatement preparedStatement, Object param, BoundSql boundSql) throws Exception{
        if(SimpleTypeRegistry.isSimpleType(param.getClass())){
            preparedStatement.setObject(1,param);
        }else if (param instanceof Map){
            //传参为map
            Map map = (Map) param;

            //根据映射取值并传入
            List<ParameterMapping> parameterMappings = boundSql.getParameterMappings();
            for (int i = 0; i < parameterMappings.size(); i++) {
                ParameterMapping parameterMapping = parameterMappings.get(i);
                Object value = map.get(parameterMapping.getName());
                preparedStatement.setObject(i+1,value);
            }

        }else {

        }
    }
}
