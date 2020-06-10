package cn.zyx.service.impl;

import cn.zyx.dao.UserDao;
import cn.zyx.po.User;
import cn.zyx.service.UserService;

import java.util.List;
import java.util.Map;

/**
 * description: UserServiceImpl <br>
 * date: 2020/6/9 09:23 <br>
 *
 * @author: ZhangYixin <br>
 * version: 1.0 <br>
 */
public class UserServiceImpl implements UserService {
    // 依赖注入UserDao
    private UserDao userDao;

    // setter方法注入UserDao
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> queryUsers(Map<String, Object> param) {
        return userDao.queryUserList(param);
    }
}
