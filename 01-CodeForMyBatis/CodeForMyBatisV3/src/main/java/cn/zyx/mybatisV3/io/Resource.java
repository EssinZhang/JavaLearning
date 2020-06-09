package cn.zyx.mybatisV3.io;

import java.io.InputStream;

/**
 * @Description
 * @ClassName Resource
 * @Author ZhangYixin
 * @date 2020.06.07 16:41
 */
public class Resource {
    public static InputStream getResourceAsStream(String resource){
        return Resource.class.getClassLoader().getResourceAsStream(resource);
    }
}
