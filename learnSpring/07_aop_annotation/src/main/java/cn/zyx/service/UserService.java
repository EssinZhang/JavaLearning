package cn.zyx.service;

public interface UserService {

    void addUser();

    void selectUserById(int id) throws Exception;

    int updateUser();

    void deleteUser();

    void selectUser();


}
