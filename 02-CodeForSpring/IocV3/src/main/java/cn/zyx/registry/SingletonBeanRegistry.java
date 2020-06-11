package cn.zyx.registry;

/**
 * description: SingletonBeanRegistry 针对存储单例Bean集合提供对外的操作功能<br>
 * date: 2020/6/11 16:03 <br>
 *
 * @author: ZhangYixin <br>
 * version: 1.0 <br>
 */
public interface SingletonBeanRegistry {

    /**
     * 获取单例bean
     * @param name
     * @return
     */
    Object getSingleton(String name);

    /**
     * 存储单例bean
     * @param name
     * @param bean
     */
    void addSingleton(String name , Object bean);

}
