package cn.zyx.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

/**
 * redis 工具类
 */
@Component
public class RedisClient {

    @Autowired
    private StringRedisTemplate redisTemplate;//jdbc Template

    /**
     * 设置key-value到redis中
     * @param key
     * @param value
     * @return
     */
    public boolean set(String key,String value){
        try {
            redisTemplate.opsForValue().set(key,value);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 通过key取缓存里面的值
     * @param key
     * @return
     *
     */
    public String get(String key){
        /*回去要查空值判断方法，这样写会有空指针，目前想法是try catch*/
        if (redisTemplate.opsForValue().get(key).equals("")){//空值判断
            return "查询结果为空，请核对传入key值";
        }else if (redisTemplate.opsForValue().get(key) == null){
            return "null,请核对key值";
        }
        else {
            return redisTemplate.opsForValue().get(key);
        }
    }

}
