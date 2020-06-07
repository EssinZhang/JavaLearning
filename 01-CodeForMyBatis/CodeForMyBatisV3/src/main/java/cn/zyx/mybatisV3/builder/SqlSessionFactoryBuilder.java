package cn.zyx.mybatisV3.builder;

import cn.zyx.mybatisV3.config.Configuration;
import cn.zyx.mybatisV3.factory.SqlSessionFactory;
import cn.zyx.mybatisV3.factory.impl.DefaultSqlSessionFactory;

import java.io.InputStream;
import java.io.Reader;

/**
 * @Description
 * @ClassName SqlSessionFactoryBuilder
 * @Author ZhangYixin
 * @date 2020.06.07 16:32
 */
public class SqlSessionFactoryBuilder {


    public SqlSessionFactory build(InputStream inputStream){
        Configuration configuration = null;
        XMLConfigBuilder configBuilder = new XMLConfigBuilder();
        configuration = configBuilder.parse(inputStream);
        return build(configuration);
    }

    public SqlSessionFactory build(Reader reader){
        return null;
    }

    private SqlSessionFactory build(Configuration configuration){
        return  new DefaultSqlSessionFactory(configuration);
    }
}
