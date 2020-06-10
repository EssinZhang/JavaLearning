package cn.zyx.dao;

import cn.zyx.po.User;

import java.util.List;
import java.util.Map;

/**
 * description: UserDao <br>
 * date: 2020/6/9 09:22 <br>
 *
 * @author: ZhangYixin <br>
 * version: 1.0 <br>
 */
public interface UserDao {
    List<User> queryUserList(Map<String, Object> param);
}
