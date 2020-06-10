package cn.zyx.service;

import cn.zyx.po.User;

import java.util.List;
import java.util.Map;

/**
 * description: UserService <br>
 * date: 2020/6/9 09:21 <br>
 *
 * @author: ZhangYixin <br>
 * version: 1.0 <br>
 */
public interface UserService {
    List<User> queryUsers(Map<String, Object> param);
}
