package cn.zyx.framework.registry.impl;

import cn.zyx.framework.ioc.BeanDefinition;
import cn.zyx.framework.registry.BeanDefinitionRegistry;

/**
 * description: DefaultBeanDefinitionRegistry <br>
 * date: 2020/6/11 16:14 <br>
 *
 * @author: ZhangYixin <br>
 * version: 1.0 <br>
 */
public class DefaultBeanDefinitionRegistry implements BeanDefinitionRegistry {
    /**
     * 获取单例beanDefinition
     *
     * @param name
     * @return
     */
    @Override
    public BeanDefinition getBeanDefinition(String name) {
        return null;
    }

    /**
     * 存储单例beanDefinition
     *
     * @param name
     * @param beanDefinition
     */
    @Override
    public void registryBeanDefinition(String name, BeanDefinition beanDefinition) {

    }
}
