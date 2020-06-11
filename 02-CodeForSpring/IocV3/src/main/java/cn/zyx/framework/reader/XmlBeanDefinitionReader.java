package cn.zyx.framework.reader;

import cn.zyx.framework.registry.BeanDefinitionRegistry;
import cn.zyx.framework.utils.DocumentUtils;
import org.dom4j.Document;


import java.io.InputStream;

/**
 * @Description
 * @ClassName XmlBeanDefinitionReader
 * @Author ZhangYixin
 * @date 2020.06.11 19:17
 */
public class XmlBeanDefinitionReader {

    private BeanDefinitionRegistry beanDefinitionRegistry;

    public XmlBeanDefinitionReader(BeanDefinitionRegistry beanDefinitionRegistry) {
        this.beanDefinitionRegistry = beanDefinitionRegistry;
    }

    public void registerBeanDefinitions(InputStream inputStream){
        Document document = DocumentUtils.createDocument(inputStream);

        XmlBeanDefinitionDocumentReader documentReader = new XmlBeanDefinitionDocumentReader(beanDefinitionRegistry);
        documentReader.loadBeanDefinitons(document.getRootElement());

    }
}
