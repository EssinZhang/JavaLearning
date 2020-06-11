package cn.zyx.framework.factory.impl;

import cn.zyx.ioc.BeanDefinition;
import cn.zyx.ioc.PropertyValue;
import cn.zyx.ioc.RuntimeBeanReference;
import cn.zyx.ioc.TypedPropertyStringValue;
import cn.zyx.resolver.ValueResolver;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

/**
 * description: AbstractAutowireCapableBeanFactory <br>
 * date: 2020/6/11 16:29 <br>
 *
 * @author: ZhangYixin <br>
 * version: 1.0 <br>
 */
public class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory{

    /**
     * 继承父类方法去做Bean创建的功能
     *
     * @param beanDefinition
     * @return
     */
    @Override
    protected Object doCreateBean(BeanDefinition beanDefinition) {
        Object bean = null;
        try {
            //1.bean的实例化
            bean = createBeanInstance(beanDefinition);
            //2.bean的依赖注入
            populateBean(bean,beanDefinition);
            //3.bean的初始化
            initializeBean(bean,beanDefinition);
        }catch (Exception e){
            e.printStackTrace();
        }

        return bean;
    }


    /**
     * 创建bean实例
     * @param beanDefinition
     * @return
     */
    private Object createBeanInstance(BeanDefinition beanDefinition) {
        Class<?> clazzType = beanDefinition.getClazzType();
        Object bean = null;
        try {
            bean = clazzType.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return bean;

    }

    /**
     * 依赖注入的bean
     * @param bean
     * @param beanDefinition
     */
    private void populateBean(Object bean, BeanDefinition beanDefinition) {
        Class<?> clazzType = beanDefinition.getClazzType();
        List<PropertyValue> propertyValues = beanDefinition.getPropertyValues();
        for (PropertyValue propertyValue : propertyValues) {
            String name = propertyValue.getName();
            Object value = propertyValue.getValue();
            //已经处理之后的了
            ValueResolver valueResolver = new ValueResolver(this);
            Object valueToUse = valueResolver.resolveValue(value, beanDefinition);

            //根据指定名称得到相应属性
            Field field = null;
            try {
                field = clazzType.getDeclaredField(name);
                field.setAccessible(true);
                field.set(bean,valueToUse);
            } catch (NoSuchFieldException | IllegalAccessException e) {
                e.printStackTrace();
            }

        }
    }



    private void initializeBean(Object bean, BeanDefinition beanDefinition) {
        // 对Aware接口进行处理


        invokeInitMethod(bean,beanDefinition);

    }

    private void invokeInitMethod(Object bean, BeanDefinition beanDefinition) {
        // 对实现了Initializebean接口的类进行处理

        //对配置了init-method标签属性的方法进行调用
        String initMethod = beanDefinition.getInitMethod();
        Class<?> clazzType = beanDefinition.getClazzType();
        if (initMethod == null || initMethod.equals("")){
            return;
        }
        Method method = null;
        try {
            method = clazzType.getDeclaredMethod(initMethod);
            method.invoke(bean,null);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
