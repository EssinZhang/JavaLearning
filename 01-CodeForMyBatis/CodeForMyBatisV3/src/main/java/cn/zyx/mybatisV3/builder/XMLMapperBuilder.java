package cn.zyx.mybatisV3.builder;

import cn.zyx.mybatisV3.config.Configuration;
import org.dom4j.Element;

import java.io.InputStream;
import java.util.List;

/**
 * @Description
 * @ClassName XMLMapperBuilder
 * @Author ZhangYixin
 * @date 2020.06.07 16:47
 */
public class XMLMapperBuilder {

    private Configuration configuration;


    public XMLMapperBuilder(Configuration configuration) {
        this.configuration = configuration;
    }

    public void parse(Element rootElement) {
        String namespace = rootElement.attributeValue("namespace");


        //获取标签
        List<Element> selectList = rootElement.elements("select");
        for (Element selectElement : selectList){
            XMLStatementBuilder xmlStatementBuilder = new XMLStatementBuilder(configuration);
            xmlStatementBuilder.parseStatementElement(namespace,selectElement);
        }
    }
}
