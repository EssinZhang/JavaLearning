package cn.zyx.mybatisV3.statement.impl;

import cn.zyx.mybatisV3.config.MappedStatement;
import cn.zyx.mybatisV3.statement.ResultsetHandler;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.List;

/**
 * @Description
 * @ClassName DefaultResultsetHandler
 * @Author ZhangYixin
 * @date 2020.06.07 21:29
 */
public class DefaultResultsetHandler implements ResultsetHandler {

    @Override
    public <T> void handleResultset(ResultSet resultSet, List<T> results, MappedStatement mappedStatement) throws Exception{
        //遍历查询结果集
        // 获取要映射的结果类型
        Class<?> resultTypeClass = mappedStatement.getResultTypeClass();

        Object result = null;
        while (resultSet.next()){
            //根据指定类创建对应的对象
            result = resultTypeClass.newInstance();

            ResultSetMetaData metaData = resultSet.getMetaData();
            //得到结果列数
            int columnCount = metaData.getColumnCount();

            for (int i = 1; i <= columnCount; i++) {
                //拿到对应列数的列名
                String columnName = metaData.getColumnName(i);
                Field field = resultTypeClass.getDeclaredField(columnName);
                //设置字段的值可以访问
                field.setAccessible(true);
                //根据列名设置对应的值
                field.set(result, resultSet.getObject(i));

            }
            results.add((T) result);
        }
    }
}
