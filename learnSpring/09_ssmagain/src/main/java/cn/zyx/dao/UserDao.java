package cn.zyx.dao;

import cn.zyx.bean.User;

import java.util.List;

public interface UserDao {
    void addUser(User user);

    void deleteUserById(int id);

    void updateUser(User user);

    List<User> selectUser();

    User selectUserById(int id);
}
