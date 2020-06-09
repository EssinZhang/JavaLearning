package cn.zyx.test;

import cn.zyx.dao.impl.UserDaoImpl;
import cn.zyx.ioc.BeanDefinition;
import cn.zyx.ioc.PropertyValue;
import cn.zyx.ioc.RuntimeBeanReference;
import cn.zyx.ioc.TypedPropertyStringValue;
import cn.zyx.service.impl.UserServiceImpl;
import org.apache.commons.dbcp.BasicDataSource;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * description: SpringV2 <br>
 * date: 2020/6/9 13:31 <br>
 *
 * @author: ZhangYixin <br>
 * version: 1.0 <br>
 */
public class SpringV2 {

    //存储BeanDefinition的集合
    //key：beanName  value：beanDefinition
    //再解析XML或者注解的时候，去添加数据
    private Map<String, BeanDefinition> beanDefinitions = new HashMap<>();

    //存储单例Bean的集合
    //key：beanName  value：单例Bean
    //该集合的数据是在getBean的时候去添加数据
    private Map<String, Object> singletonObjects = new HashMap<>();

    @Before
    public void before(){

    }

    @Test
    public void test(){
        //使用UserService
        UserServiceImpl userService = new UserServiceImpl();
        UserDaoImpl userDao = new UserDaoImpl();
        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        basicDataSource.setUrl("jdbc:mysql://127.0.0.1:3306/learnmybatis?useSSL=false");
        basicDataSource.setUsername("root");
        basicDataSource.setPassword("123456");
        userDao.setDataSource(basicDataSource);
        userService.setUserDao(userDao);

        //查询参数
        Map<String,Object> param = new HashMap<>();
        param.put("name","wade");

        //用户查询
        userService.queryUsers(param);
    }

    public Object getBean(String beanName){
        //注意事项：
        //1.是否每次调用getBean都需要创建一个新的Bean？可以使用单例方式去管理
        //2.XML配置文件需要被解析几次，是不是每次调用getBean时才进行XML解析呢？  只需要解析一次，且在getBean之前就完成解析

        //改造思路：
        //1.先去管理Bean的集合缓存中查找对应beanName的bean实例
        Object bean = this.singletonObjects.get(beanName);
        //1.1.如果找到，则直接返回该Bean
        if (bean != null){
            return bean
        }
        //1.2.如果没有再去创建对应的Bean实例(要判断创建Bean要以单例模式创建还是原型模式创建)
        //2.1.可以使用XML配置文件的方式来配置beanName和Bean实力对应的关系，同时可以配置Bean被创建时需要依赖注入的参数
        //2.2.一次性解析XML配置文件，形成对应的配置对象(BeanDefinition集合)
        BeanDefinition beanDefinition = this.beanDefinitions.get(beanName);
        if (beanDefinition == null){
            return null;
        }

        //单例
        if (beanDefinition.isScopeSingleton()){
            //2.3.根据配置对象，来创建Bean实例
            bean = doCreateBean(beanDefinition);

            //3.将创建完成的bean实例放入管理Bean的集合缓存
            this.singletonObjects.put(beanName,bean);
        }else if (beanDefinition.isScopePrototype()){
            //原型
            bean = doCreateBean(beanDefinition);
        }

        return bean;
    }

    /**
     * 创建bean
     * @param beanDefinition
     * @return
     */
    private Object doCreateBean(BeanDefinition beanDefinition) {
        //1.bean的实例化
        Object bean = createBeanInstance(beanDefinition);
        //2.bean的依赖注入
        populateBean(bean,beanDefinition);
        //3.bean的初始化
        initializeBean(bean,beanDefinition);
        return bean;
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
            Object valueToUse = resolveValue(value,beanDefinition);

            //根据指定名称得到相应属性
            Field field = null;
            try {
                field = clazzType.getDeclaredField(name);
                field.setAccessible(true);
                field.set(bean,valueToUse);
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            }

        }
    }

    private Object resolveValue(Object value, BeanDefinition beanDefinition) {
        if (value instanceof RuntimeBeanReference){
            RuntimeBeanReference beanReference = (RuntimeBeanReference) value;
            String ref = beanReference.getRef();
            return getBean(ref);
        }else if (value instanceof TypedPropertyStringValue){
            TypedPropertyStringValue propertyStringValue = (TypedPropertyStringValue) value;
            String stringValue = propertyStringValue.getValue();
            Class<?> targetType = propertyStringValue.getTargetType();
            if (targetType == Integer.class)
        }

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


}
