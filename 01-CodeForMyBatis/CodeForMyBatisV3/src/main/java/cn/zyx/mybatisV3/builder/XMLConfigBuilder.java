package cn.zyx.mybatisV3.builder;

import cn.zyx.mybatisV3.config.Configuration;
import cn.zyx.mybatisV3.io.Resource;
import cn.zyx.mybatisV3.utils.DocumentUtils;
import org.apache.commons.dbcp.BasicDataSource;
import org.dom4j.Document;
import org.dom4j.Element;

import java.io.InputStream;
import java.util.List;
import java.util.Properties;

/**
 * @Description  解析全局配置文件的类
 * @ClassName XMLConfigBuilder
 * @Author ZhangYixin
 * @date 2020.06.07 16:38
 */
public class XMLConfigBuilder {

    private Configuration configuration;



    public XMLConfigBuilder() {
        this.configuration = new Configuration();
    }

    public Configuration parse(InputStream inputStream) {

        //将流对象，转换成document对象
        Document document = DocumentUtils.createDocument(inputStream);
        //针对Document对象，按照mybaits的语义去解析document
        //document.getRootElement()获取文档的根节点
        parseConfiguration(document.getRootElement());
        return configuration;
    }

    private void parseConfiguration(Element rootElement) {
        //获取environments节点的内容
        Element environments = rootElement.element("environments");
        parseEnvironments(environments);
        //获取mapper节点的内容
        Element mappers = rootElement.element("mappers");
        parseMappers(mappers);
    }

    /**
     * 解析 mappers标签
     * @param mappers
     */
    private void parseMappers(Element mappers) {
        List<Element> mapperList = mappers.elements("mapper");
        for (Element element: mapperList){
            String resource = element.attributeValue("resource");
            //根据配置文件路径获取对应的输入流
            InputStream inputStream = Resource.getResourceAsStream(resource);
            //将流对象，转换成document对象
            Document document = DocumentUtils.createDocument(inputStream);
            //针对Document对象，按照mybaits的语义去解析document
            //document.getRootElement()获取文档的根节点
            XMLMapperBuilder mapperBuilder = new XMLMapperBuilder(configuration);
            mapperBuilder.parse(document.getRootElement());
        }
    }

    /**
     * 解析 environments标签
     * @param environments
     */
    private void parseEnvironments(Element environments) {
        //获取标签的default对应的value
        String aDefault = environments.attributeValue("default");
        List<Element> environmentList = environments.elements("environment");
        for (Element element : environmentList){
            String id = element.attributeValue("id");
            //这两个 标签 的对应 属性名 的 值相等再继续处理
            if (id.equals(aDefault)){
                Element dataSource = element.element("dataSource");
                parseDataSource(dataSource);
            }
        }
    }

    /**
     * 解析 DataSource 标签
     * @param dataSource
     */
    private void parseDataSource(Element dataSource) {
        String type = dataSource.attributeValue("type");
        //这里相当于写死 指定数据源为DBCP 其他的数据源类型不进行处理
        if ("DBCP".equals(type)){
            BasicDataSource basicDataSource = new BasicDataSource();
            Properties properties = parseProperty(dataSource);
            //根据name拿到驱动信息传入
            basicDataSource.setDriverClassName(properties.getProperty("driver"));
            //根据name拿到数据库url信息传入
            basicDataSource.setUrl(properties.getProperty("url"));
            //根据name拿到数据库username信息传入
            basicDataSource.setUsername(properties.getProperty("username"));
            //根据name拿到数据库password信息传入
            basicDataSource.setPassword(properties.getProperty("password"));
            configuration.setDataSource(basicDataSource);
        }
    }

    /**
     * 解析 property 标签
     * @param dataSource
     * @return
     */
    private Properties parseProperty(Element dataSource) {
        //创建一个propertis用于返回propertis数据
        Properties properties = new Properties();

        List<Element> elementsList = dataSource.elements("property");
        for (Element element: elementsList){
            String name = element.attributeValue("name");
            String value = element.attributeValue("value");
            properties.put(name,value);
        }
        return properties;
    }


}
