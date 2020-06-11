package cn.zyx.framework.ioc;

import java.util.ArrayList;
import java.util.List;

/**
 * description: BeanDefinition <br>
 * date: 2020/6/9 15:00 <br>
 *
 * @author: ZhangYixin <br>
 * version: 1.0 <br>
 */
public class BeanDefinition {
    // bean标签的class属性
    private String clazzName;
    // bean标签的class属性对应的Class对象
    private Class<?> clazzType;
    // bean标签的id属性和name属性都会存储到该属性值，id和name属性是二选一使用的
    private String beanName;
    //初始化方法
    private String initMethod;
    // 该信息是默认的配置，如果不配置就默认是singleton
    private String scope;

    /**
     * bean中的属性信息
     */
    private List<PropertyValue> propertyValues = new ArrayList<>();

    private static final String SCOPE_SINGLETON = "singleton";
    private static final String SCOPE_PROTOTYPE = "prototype";

    public BeanDefinition(String clazzName, String beanName) {
        this.beanName = beanName;
        this.clazzName = clazzName;
        this.clazzType = resolveClassName(clazzName);
    }

    private Class<?> resolveClassName(String clazzName) {
        try {
            return Class.forName(clazzName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getClazzName() {
        return clazzName;
    }

    public void setClazzName(String clazzName) {
        this.clazzName = clazzName;
    }

    public Class<?> getClazzType() {
        return clazzType;
    }

    public void setClazzType(Class<?> clazzType) {
        this.clazzType = clazzType;
    }

    public String getBeanName() {
        return beanName;
    }

    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }

    public String getInitMethod() {
        return initMethod;
    }

    public void setInitMethod(String initMethod) {
        this.initMethod = initMethod;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public List<PropertyValue> getPropertyValues() {
        return propertyValues;
    }

    public void addPropertyValue(PropertyValue propertyValue) {
        this.propertyValues.add(propertyValue);
    }

    public boolean isScopeSingleton() {
        return SCOPE_SINGLETON.equals(this.scope);
    }

    public boolean isScopePrototype() {
        return SCOPE_PROTOTYPE.equals(this.scope);
    }
}
