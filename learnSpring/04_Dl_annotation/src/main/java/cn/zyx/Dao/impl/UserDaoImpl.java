package cn.zyx.Dao.impl;

import cn.zyx.Dao.UserDao;
import org.springframework.stereotype.Repository;

@Repository("userDao")
public class UserDaoImpl implements UserDao {
    @Override
    public void addUser() {
        System.out.println("添加用户");
    }
}
