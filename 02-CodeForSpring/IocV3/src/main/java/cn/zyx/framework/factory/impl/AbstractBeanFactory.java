package cn.zyx.framework.factory.impl;

import cn.zyx.framework.factory.BeanFactory;
import cn.zyx.ioc.BeanDefinition;
import cn.zyx.registry.impl.DefaultSingletonBeanRegistry;

/**
 * description: AbstractBeanFactory 对beanFactory的方法进行了实现，但是只是定义了getBean的步骤，而细节部分需要交给子类去实现 <br>
 * date: 2020/6/11 15:52 <br>
 *
 * @author: ZhangYixin <br>
 * version: 1.0 <br>
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {

    @Override
    public Object getBean(String beanName) {
        //注意事项：
        //1.是否每次调用getBean都需要创建一个新的Bean？可以使用单例方式去管理
        //2.XML配置文件需要被解析几次，是不是每次调用getBean时才进行XML解析呢？  只需要解析一次，且在getBean之前就完成解析

        //改造思路：
        //1.先去管理Bean的集合缓存中查找对应beanName的bean实例
        Object bean = getSingleton(beanName);
        //1.1.如果找到，则直接返回该Bean
        if (bean != null){
            return bean;
        }
        //1.2.如果没有再去创建对应的Bean实例(要判断创建Bean要以单例模式创建还是原型模式创建)
        //2.1.可以使用XML配置文件的方式来配置beanName和Bean实力对应的关系，同时可以配置Bean被创建时需要依赖注入的参数
        //2.2.一次性解析XML配置文件，形成对应的配置对象(BeanDefinition集合)
        BeanDefinition beanDefinition = getBeanDefinitions(beanName);
        if (beanDefinition == null){
            return null;
        }

        //单例
        if (beanDefinition.isScopeSingleton()){
            //2.3.根据配置对象，来创建Bean实例
            bean = doCreateBean(beanDefinition);

            //3.将创建完成的bean实例放入管理Bean的集合缓存
            addSingleton(beanName,bean);
        }else if (beanDefinition.isScopePrototype()){
            //原型
            bean = doCreateBean(beanDefinition);
        }

        return bean;
    }

    /**
     * 用抽象方法将Bean创建的功能交给子类去做
     * @param beanDefinition
     * @return
     */
    protected abstract Object doCreateBean(BeanDefinition beanDefinition);

    /**
     * 用抽象方法将获取BeanDefinition的功能交给子类去做
     * @param beanName
     * @return
     */
    protected abstract BeanDefinition getBeanDefinitions(String beanName);
}
