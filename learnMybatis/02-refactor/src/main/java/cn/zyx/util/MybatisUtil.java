package cn.zyx.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * dcl的单例模式
 */
public class MybatisUtil {

    //无需构造方法私有化，因为这里面只要保证创建一个sqlSessionFactory的对象
    private static volatile SqlSessionFactory sqlSessionFactory;

    public static SqlSession getSqlSession(){
        try {
            if (sqlSessionFactory == null){
                ///读取主配置文件
                InputStream input = Resources.getResourceAsStream("mybatis.xml");
                synchronized (MybatisUtil.class){
                    if (sqlSessionFactory == null){
                        sqlSessionFactory = new SqlSessionFactoryBuilder().build(input);
                    }
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }

        return sqlSessionFactory.openSession();
    }

}
