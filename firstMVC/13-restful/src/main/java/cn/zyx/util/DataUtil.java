package cn.zyx.util;

import cn.zyx.bean.User;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * 模拟生成数据的工具类
 */
public class DataUtil {

    private static HashMap<String, User> dataMap = new HashMap<>();

    //模拟初始化数据
    static {
        User kobe = new User("Kobe","8","洛杉矶", LocalDate.of(1986,04,05));
        User bryant = new User("Bryant","24","洛杉矶", LocalDate.of(1986,05,25));
        User carter = new User("Carter","4","多伦多", LocalDate.of(1983,11,24));

        dataMap.put("1",kobe);
        dataMap.put("2",bryant);
        dataMap.put("3",carter);
    }

    /**
     * 模拟查询，全部返回
     * @return
     */
    public static HashMap<String,User> findAll(){
        return dataMap;
    }

    /**
     * 模拟根据id查询
     * @param id
     * @return
     */
    public static User findUserByID(String id){
        return dataMap.get(id);
    }

    /**
     * 模拟添加操作
     * @param user
     */
    public static void createUser(User user)throws Exception{
        //遍历map以获取key的最大值
        Set<Map.Entry<String, User>> entries = dataMap.entrySet();
        Iterator<Map.Entry<String, User>> iterator = entries.iterator();

        int max = 1;

        while (iterator.hasNext()){
            Map.Entry<String,User> next = iterator.next();
            int i = Integer.parseInt(next.getKey());
            if (i > max){
                max = i;
            }
        }

        //将最大值做自增运算
        dataMap.put(++max + "",user);
    }

    /**
     * 模拟修改用户
     * @param id
     * @param user
     * @throws Exception
     */
    public static void update(String id , User user)throws Exception{
        dataMap.put(id,user);
    }

    /**
     * 模拟删除用户
     * @param id
     * @throws Exception
     */
    public static void delete(String id)throws Exception{
        dataMap.remove(id);
    }
}
