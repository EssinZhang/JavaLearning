package cn.zyx.service.impl;

import cn.zyx.Dao.UserDao;
import cn.zyx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

@Service("userService")
public class UserServiceImpl implements UserService {

/*    @Autowired
    @Qualifier("userDao")
    private UserDao userDao;*/
    @Resource(name = "userDao")
    private UserDao userDao;

    @Override
    public void addUser() {
        //以前需要手动创建对象
        //userDao = new UserDaoImpl();
        userDao.addUser();
    }

    @PostConstruct
    public void before(){
        System.out.println("开始");
    }
    @PreDestroy
    public void after(){
        System.out.println("结束");
    }
}
