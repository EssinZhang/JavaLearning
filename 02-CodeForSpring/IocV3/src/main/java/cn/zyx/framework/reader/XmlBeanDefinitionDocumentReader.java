package cn.zyx.framework.reader;

import cn.zyx.framework.ioc.BeanDefinition;
import cn.zyx.framework.ioc.PropertyValue;
import cn.zyx.framework.ioc.RuntimeBeanReference;
import cn.zyx.framework.ioc.TypedPropertyStringValue;
import cn.zyx.framework.registry.BeanDefinitionRegistry;
import cn.zyx.framework.utils.ReflectUtils;
import org.dom4j.Element;

import java.lang.reflect.Field;
import java.util.List;

/**
 * @Description 是使用Spring的语义来解析document对象
 * @ClassName XmlBeanDefinitionDocumentReader
 * @Author ZhangYixin
 * @date 2020.06.11 19:21
 */
public class XmlBeanDefinitionDocumentReader {
    private BeanDefinitionRegistry beanDefinitionRegistry;

    public XmlBeanDefinitionDocumentReader(BeanDefinitionRegistry beanDefinitionRegistry) {
        this.beanDefinitionRegistry = beanDefinitionRegistry;
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

            Class<?> targetType = ReflectUtils.getTypeByFieldName(beanDefinition.getClazzName(), name);
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



    public void loadBeanDefinitons(Element rootElement) {
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
            beanDefinitionRegistry.registryBeanDefinition(beanName,beanDefinition);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
