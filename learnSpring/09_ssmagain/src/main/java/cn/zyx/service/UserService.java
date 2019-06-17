package cn.zyx.service;

import cn.zyx.bean.User;

import java.util.List;

public interface UserService {
    void addUser(User user);

    void deleteUserById(int id);

    void updateUser(User user);

    List<User> selectUser();

    User selectUserById(int id);
}
