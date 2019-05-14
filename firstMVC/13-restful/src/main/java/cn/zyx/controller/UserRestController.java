package cn.zyx.controller;

import cn.zyx.bean.User;
import cn.zyx.util.DataUtil;
import com.alibaba.fastjson.JSON;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

/**
 * 基于restful的增删改查实例
 */
@RestController
public class UserRestController {

    /**
     * 查询所有用户
     * @return
     * @throws Exception
     */
    @GetMapping("/users")
    public String findAll()throws Exception{
        HashMap<String, User> allUser = DataUtil.findAll();

        //返回json格式的数据
        return JSON.toJSONString(allUser);
    }

    /**
     * 根据id查找用户
     * @param id
     * @return
     * @throws Exception
     */
    @GetMapping("/users/{id}")
    public String findUserById(@PathVariable String id)throws Exception{
        User user = DataUtil.findUserByID(id);

        return JSON.toJSONString(user);
    }

    /**
     * 新增用户
     * @param user
     * @return
     */
    @PostMapping("/users")
    public String creatUser (@RequestBody User user){
        try {
            DataUtil.createUser(user);
        } catch (Exception e) {
            e.printStackTrace();
            return JSON.toJSONString("Fail");
        }
        return JSON.toJSONString("Success");
    }

    /**
     * 根据id更新用户信息
     * @param id
     * @param user
     * @return
     */
    @PutMapping("/users/{id}")
    public String updateUser(@PathVariable String id ,@RequestBody User user){
        try {
            DataUtil.update(id,user);
        } catch (Exception e) {
            e.printStackTrace();
            return JSON.toJSONString("Fail to update");
        }
        return JSON.toJSONString("Success to update");
    }

    /**
     * 删除用户
     * @param id
     * @return
     */
    @DeleteMapping("/users/{id}")
    public String deleteUser(@PathVariable String id){
        try {
            DataUtil.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
            return JSON.toJSONString("Fail to delete");
        }
        return JSON.toJSONString("Success to delete");
    }
}
