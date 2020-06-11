package cn.zyx.resolver;

import cn.zyx.framework.factory.BeanFactory;
import cn.zyx.ioc.BeanDefinition;
import cn.zyx.ioc.RuntimeBeanReference;
import cn.zyx.ioc.TypedPropertyStringValue;

/**
 * description: ValueResolve <br>
 * date: 2020/6/11 16:37 <br>
 *
 * @author: ZhangYixin <br>
 * version: 1.0 <br>
 */
public class ValueResolver {

    private BeanFactory beanFactory;

    public ValueResolver(BeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    public Object resolveValue(Object value, BeanDefinition beanDefinition) {
        if (value instanceof RuntimeBeanReference){
            RuntimeBeanReference beanReference = (RuntimeBeanReference) value;
            String ref = beanReference.getRef();
            return beanFactory.getBean(ref);
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
}
