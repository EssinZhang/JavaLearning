package cn.zyx.test;

import cn.zyx.mybatisV3.builder.SqlSessionFactoryBuilder;
import cn.zyx.mybatisV3.factory.SqlSessionFactory;
import cn.zyx.mybatisV3.io.Resource;
import cn.zyx.mybatisV3.sqlSession.SqlSession;
import cn.zyx.po.User;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

/**
 * @Description
 * @ClassName MyBatisV3
 * @Author ZhangYixin
 * @date 2020.06.07 18:34
 */
public class MyBatisV3 {

    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void init(){
        InputStream inputStream = Resource.getResourceAsStream("mybatis-conf.xml");
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void test(){
        // 调用sqlSession完成增删改查的操作
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //传参设置
        HashMap<String, Object> param = new HashMap<>();
        param.put("address","洛杉矶");
        param.put("name","kobe");

        //根据名字和地址查询信息
        List<User> users = sqlSession.selectList("test.findUserById", param);

        System.out.println(users);
    }

}
