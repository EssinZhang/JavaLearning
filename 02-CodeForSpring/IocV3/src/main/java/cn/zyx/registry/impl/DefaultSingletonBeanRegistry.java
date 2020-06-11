package cn.zyx.registry.impl;

import cn.zyx.registry.SingletonBeanRegistry;

import java.util.HashMap;
import java.util.Map;

/**
 * description: DefaultSingletonBeanRegistry <br>
 * date: 2020/6/11 16:09 <br>
 *
 * @author: ZhangYixin <br>
 * version: 1.0 <br>
 */
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {

    private Map<String,Object> singletonObjects = new HashMap<>();

    @Override
    public Object getSingleton(String name) {
        return this.singletonObjects.get(name);
    }

    @Override
    public void addSingleton(String name, Object bean) {
        //双重检查锁  这里先不写

        this.singletonObjects.put(name,bean);
    }
}
