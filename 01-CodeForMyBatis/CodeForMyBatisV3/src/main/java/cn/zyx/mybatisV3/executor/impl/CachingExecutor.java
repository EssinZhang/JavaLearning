package cn.zyx.mybatisV3.executor.impl;

import cn.zyx.mybatisV3.config.Configuration;
import cn.zyx.mybatisV3.config.MappedStatement;
import cn.zyx.mybatisV3.executor.Executor;

import java.util.List;

/**
 * @Description
 * @ClassName CachingExecutor
 * @Author ZhangYixin
 * @date 2020.06.07 20:11
 */
public class CachingExecutor implements Executor {

    private Executor delegate;

    public CachingExecutor(Executor delegate) {
        this.delegate = delegate;
    }

    @Override
    public <T> List<T> doQuery(Configuration configuration,MappedStatement mappedStatement, Object param) {
        //二级缓存处理
        return delegate.doQuery(configuration,mappedStatement,param);
    }
}
