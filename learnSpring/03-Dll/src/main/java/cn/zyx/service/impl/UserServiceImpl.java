package cn.zyx.service.impl;

import cn.zyx.Dao.UserDao;
import cn.zyx.Dao.impl.UserDaoImpl;
import cn.zyx.service.UserService;

public class UserServiceImpl implements UserService {

    private UserDao userDao;

    //通过set方法注入
/*    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }*/

    //构造方法注入
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void addUser() {
        //以前需要手动创建对象
        //userDao = new UserDaoImpl();
        userDao.addUser();
    }
}
