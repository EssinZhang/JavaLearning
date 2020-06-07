package cn.zyx.mybatisV3.utils;

import com.sun.org.apache.regexp.internal.RE;
import org.dom4j.Document;
import org.dom4j.io.SAXReader;

import java.io.InputStream;

/**
 * @Description
 * @ClassName DocumentUtils
 * @Author ZhangYixin
 * @date 2020.06.07 18:58
 */
public class DocumentUtils {


    public static Document createDocument(InputStream inputStream){
        try {
            SAXReader saxReader = new SAXReader();
            Document document = saxReader.read(inputStream);
            return document;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
