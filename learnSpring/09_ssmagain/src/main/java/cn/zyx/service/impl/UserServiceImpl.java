package cn.zyx.service.impl;

import cn.zyx.bean.User;
import cn.zyx.dao.UserDao;
import cn.zyx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    //注入
    @Autowired
    private UserDao userDao;

    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Override
    public void deleteUserById(int id) {
        userDao.deleteUserById(id);
    }

    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    @Override
    public List<User> selectUser() {
        return userDao.selectUser();
    }

    @Override
    public User selectUserById(int id) {
        return userDao.selectUserById(id);
    }
}
