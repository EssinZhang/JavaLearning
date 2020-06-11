package cn.zyx.framework.utils;

import org.dom4j.Document;
import org.dom4j.io.SAXReader;

import java.io.InputStream;

/**
 * @Description
 * @ClassName DocumentUtils
 * @Author ZhangYixin
 * @date 2020.06.11 19:13
 */
public class DocumentUtils {

    public static Document createDocument(InputStream inputStream){
        Document document = null;

        try {
            SAXReader saxReader = new SAXReader();
            document = saxReader.read(inputStream);
            return document;
        }catch (Exception e){
            e.printStackTrace();
        }
        return document;
    }
}
