package cn.zyx.mybatisV3.statement;

import cn.zyx.mybatisV3.config.MappedStatement;

import java.sql.ResultSet;
import java.util.List;

/**
 * @Description
 * @ClassName ResultsetHandler
 * @Author ZhangYixin
 * @date 2020.06.07 21:28
 */
public interface ResultsetHandler {
    <T> void handleResultset(ResultSet resultSet, List<T> results, MappedStatement mappedStatement) throws Exception;
}
