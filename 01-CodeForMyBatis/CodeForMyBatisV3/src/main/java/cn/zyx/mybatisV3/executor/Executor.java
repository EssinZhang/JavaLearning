package cn.zyx.mybatisV3.executor;

import cn.zyx.mybatisV3.config.Configuration;
import cn.zyx.mybatisV3.config.MappedStatement;

import java.util.List;

/**
 * @Description
 * @ClassName Executor
 * @Author ZhangYixin
 * @date 2020.06.07 20:07
 */
public interface Executor {

    <T> List<T> doQuery(Configuration configuration,MappedStatement mappedStatement, Object param);

}
