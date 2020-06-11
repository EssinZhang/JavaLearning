package cn.zyx.framework.resource.impl;

import cn.zyx.framework.resource.Resource;

import java.io.InputStream;

/**
 * @Description 存储了classpath路径下的资源信息
 * @ClassName ClassPahResource
 * @Author ZhangYixin
 * @date 2020.06.11 19:06
 */
public class ClassPathResource implements Resource {

    private String resource;

    public ClassPathResource(String resource){
        this.resource = resource;
    }

    @Override
    public InputStream getResource() {
        return this.getClass().getClassLoader().getResourceAsStream(resource);
    }
}
