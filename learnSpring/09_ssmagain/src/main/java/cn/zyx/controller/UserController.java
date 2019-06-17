package cn.zyx.controller;

import cn.zyx.bean.User;
import cn.zyx.service.UserService;
import com.alibaba.fastjson.JSON;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 查询全部用户
     * @return
     */
    @GetMapping("/users")
    public String selectUser(){
        List<User> users = userService.selectUser();

        return JSON.toJSONString(users);
    }

    /**
     * 根据id查询用户
     * @param id
     * @return
     */
    @GetMapping("/users/{id}")
    public String selectUserById(@PathVariable int id){
        User user = userService.selectUserById(id);

        return JSON.toJSONString(user);
    }

    /**
     * 添加用户
     * @param user
     * @return
     */
    @PostMapping("/users")
    public String addUser(@RequestBody User user){
        try {
            userService.addUser(user);
            return JSON.toJSONString("Success");//成功
        }catch (Exception e){
            e.printStackTrace();
            return JSON.toJSONString("Fail");//失败
        }
    }

    /**
     * 修改用户信息
     * @param id
     * @param user
     * @return
     */
    @PutMapping("/users/{id}")
    public String updateUser(@PathVariable int id , @RequestBody User user){
        try {
            user.setId(id);
            userService.updateUser(user);

            return JSON.toJSONString("Success");//成功
        }catch (Exception e){
            e.printStackTrace();

            return JSON.toJSONString("Fail");//失败
        }
    }

    @DeleteMapping("/users/{id}")
    public String deleteUser(@PathVariable int id){
        try {
            userService.deleteUserById(id);

            return JSON.toJSONString("Success");//成功
        }catch (Exception e){
            e.printStackTrace();

            return JSON.toJSONString("Fail");//失败
        }
    }
}
