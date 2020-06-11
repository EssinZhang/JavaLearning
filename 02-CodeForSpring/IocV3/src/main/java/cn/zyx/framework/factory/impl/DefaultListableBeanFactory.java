package cn.zyx.framework.factory.impl;

import cn.zyx.framework.ioc.BeanDefinition;
import cn.zyx.framework.registry.BeanDefinitionRegistry;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description spring真正管理Bean和BeanDefinition的工厂
 * @ClassName DefaultListableBeanFactory
 * @Author ZhangYixin
 * @date 2020.06.11 18:51
 */
public class DefaultListableBeanFactory extends AbstractAutowireCapableBeanFactory implements BeanDefinitionRegistry {

    private Map<String,BeanDefinition> beanDefinitionMap = new HashMap<>();

    @Override
    public void registryBeanDefinition(String name, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(name,beanDefinition);
    }

    @Override
    public BeanDefinition getBeanDefinition(String beanName) {
        return beanDefinitionMap.get(beanName);
    }
}
