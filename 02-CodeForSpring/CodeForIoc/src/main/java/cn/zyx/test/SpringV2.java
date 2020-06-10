package cn.zyx.test;

import cn.zyx.ioc.BeanDefinition;
import cn.zyx.ioc.PropertyValue;
import cn.zyx.ioc.RuntimeBeanReference;
import cn.zyx.ioc.TypedPropertyStringValue;
import cn.zyx.po.User;
import cn.zyx.service.UserService;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
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
        //完成XML解析，就是完成BeanDefinition的注册
        //XML解析，将结果放入BeanDefinition中
        String location = "bean01.xml";
        //获取流对象
        InputStream inputStream = getInputStream(location);
        //创建文本对象
        Document document = createDocument(inputStream);

        //按照Spring定义的标签语义去解析Document
        parseBeanDefinitions(document.getRootElement());

    }

    /**
     * 解析bean
     * @param rootElement
     */
    private void parseBeanDefinitions(Element rootElement) {
        //获取 bean 和自定义标签
        List<Element> elements = rootElement.elements();
        for (Element element : elements) {
            //获取标签名称
            String name = element.getName();
            if (name.equals("bean")){
                //解析bean标签
                parseDefaultElement(element);
            }else {
                //解析自定义标签
                parseCustomElement(element);
            }

        }
    }

    /**
     * 解析自定义标签暂时先不写
     * @param element
     */
    private void parseCustomElement(Element element) {
    }

    /**
     * 解析 bean 标签
     * @param beanElement
     */
    private void parseDefaultElement(Element beanElement) {
        try {
            if (beanElement == null){
                return;
            }
            //获取id属性值
            String id = beanElement.attributeValue("id");

            //获取name属性值
            String name = beanElement.attributeValue("name");

            //获取class属性值
            String className = beanElement.attributeValue("class");
            if (className == null || "".equals(className)){
                return;
            }

            //获取init-method属性值
            String initMethodValue = beanElement.attributeValue("init-method");

            //获取scope属性值
            String scope = beanElement.attributeValue("scope");
            scope = scope != null && !scope.equals("") ? scope:"singleton";

            //获取beanName
            //判断 id，name属性有没有值，没有就赋一个className 对应的类型值
            String beanName = id == null ? name:id;
            Class<?> classType = Class.forName(className);
            beanName = beanName == null ? classType.getSimpleName():beanName;

            //创建BeanDefinition对象
            //此次可以使用构建者模式进行优化
            BeanDefinition beanDefinition = new BeanDefinition(className, beanName);
            beanDefinition.setInitMethod(initMethodValue);
            beanDefinition.setScope(scope);

            //获取property自标签集合
            List<Element> propertyElements = beanElement.elements();
            for (Element propertyElement : propertyElements) {
                parsePropertyElement(beanDefinition,propertyElement);
            }

            //注册BeanDefinition信息
            this.beanDefinitions.put(beanName,beanDefinition);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     *
     * @param beanDefinition
     * @param propertyElement
     */
    private void parsePropertyElement(BeanDefinition beanDefinition, Element propertyElement) {
        if (propertyElement == null){return;}

        //获取name属性值
        String name = propertyElement.attributeValue("name");
        //获取value属性值
        String value = propertyElement.attributeValue("value");
        //获取ref属性值
        String ref = propertyElement.attributeValue("ref");

        // 如果value和ref都有值，则返回
        if (value != null && !value.equals("") && ref != null && !ref.equals("")) {
            return;
        }

        //PropertyValue就封装着一个property标签的信息
        PropertyValue pv = null;

        if (value != null && !value.equals("")) {
            // 因为spring配置文件中的value是String类型，而对象中的属性值是各种各样的，所以需要存储类型
            TypedPropertyStringValue typeStringValue = new TypedPropertyStringValue(value);

            Class<?> targetType = getTypeByFieldName(beanDefinition.getClazzName(), name);
            typeStringValue.setTargetType(targetType);

            pv = new PropertyValue(name, typeStringValue);
            beanDefinition.addPropertyValue(pv);
        } else if (ref != null && !ref.equals("")) {

            RuntimeBeanReference reference = new RuntimeBeanReference(ref);
            pv = new PropertyValue(name, reference);
            beanDefinition.addPropertyValue(pv);
        } else {
            return;
        }

    }


    private Class<?> getTypeByFieldName(String clazzName, String name) {
        try {
            Class<?> clazz = Class.forName(clazzName);
            Field field = clazz.getDeclaredField(name);
            return field.getType();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 创建Document文本对象
     * @param inputStream
     * @return
     */
    private Document createDocument(InputStream inputStream) {
        Document document = null;
        try {
            SAXReader saxReader = new SAXReader();
            document = saxReader.read(inputStream);
            return document;
        } catch (Exception e) {
            e.printStackTrace();
        }
        //如果这个方法返回为null,则说明inputstream没读到东西或其他原因
        return document;
    }


    /**
     * 获取流对象
     * @param location
     * @return
     */
    private InputStream getInputStream(String location) {
        return this.getClass().getClassLoader().getResourceAsStream(location);
    }

    @Test
    public void test(){

        UserService userService = (UserService)getBean("userService");

        //查询参数
        Map<String,Object> param = new HashMap<>();
        param.put("name","wade");

        //用户查询
        List<User> users = userService.queryUsers(param);
        System.out.println(users);
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
            return bean;
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
            } catch (NoSuchFieldException | IllegalAccessException e) {
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
            if (targetType == Integer.class){
                return Integer.parseInt(stringValue);
            }else if (targetType == String.class){
                return stringValue;
            }
        }
        return null;
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
