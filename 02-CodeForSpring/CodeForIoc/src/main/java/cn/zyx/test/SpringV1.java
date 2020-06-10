package cn.zyx.test;

import cn.zyx.dao.impl.UserDaoImpl;
import cn.zyx.service.impl.UserServiceImpl;
import org.apache.commons.dbcp.BasicDataSource;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * description: SpringV1 <br>
 * date: 2020/6/9 09:32 <br>
 *
 * @author: ZhangYixin <br>
 * version: 1.0 <br>
 */
public class SpringV1 {


    @Test
    public void test(){
        //使用UserService
        UserServiceImpl userService = new UserServiceImpl();
        UserDaoImpl userDao = new UserDaoImpl();
        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        basicDataSource.setUrl("jdbc:mysql://127.0.0.1:3306/learnmybatis?useSSL=false");
        basicDataSource.setUsername("root");
        basicDataSource.setPassword("123456");
        userDao.setDataSource(basicDataSource);
        userService.setUserDao(userDao);

        //查询参数
        Map<String,Object> param = new HashMap<>();
        param.put("name","wade");

        //用户查询
        userService.queryUsers(param);
    }
}
