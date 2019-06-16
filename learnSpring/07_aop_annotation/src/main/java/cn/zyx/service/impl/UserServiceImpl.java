package cn.zyx.service.impl;

import cn.zyx.service.UserService;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Override
    public void addUser() {
        System.out.println("执行addUser方法");
    }

    @Override
    public void selectUserById(int id) throws Exception {
        System.out.println("执行selectUserById方法");
        if (id == 0) {
            throw new Exception();
        }
    }

    @Override
    public int updateUser() {

        System.out.println("执行updateUser方法");

        return 1024;
    }

    @Override
    public void deleteUser() {
        System.out.println("执行deleteUser方法");
    }

    @Override
    public void selectUser() {
        System.out.println("执行selectUser方法");
    }
}
