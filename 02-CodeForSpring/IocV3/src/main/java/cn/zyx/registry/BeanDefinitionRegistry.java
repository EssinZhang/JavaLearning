package cn.zyx.registry;

import cn.zyx.ioc.BeanDefinition;

/**
 * description: BeanDefinitionRegistry 针对存储单例BeanDefinition集合提供对外的操作功能<br>
 * date: 2020/6/11 16:06 <br>
 *
 * @author: ZhangYixin <br>
 * version: 1.0 <br>
 */
public interface BeanDefinitionRegistry {

    /**
     * 获取单例beanDefinition
     * @param name
     * @return
     */
    BeanDefinition getBeanDefinition(String name);

    /**
     * 存储单例beanDefinition
     * @param name
     * @param bean
     */
    void registryBeanDefinition(String name , BeanDefinition beanDefinition);
}
