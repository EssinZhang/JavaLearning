package cn.zyx.framework.factory;

/**
 * description: BeanFactory 顶级接口<br>
 * date: 2020/6/11 14:49 <br>
 *
 * @author: ZhangYixin <br>
 * version: 1.0 <br>
 */
public interface BeanFactory {
    /**
     * 根据bean的name从Bean工厂中获取指定名称的bean实例
     * @param name
     * @return
     */
    Object getBean(String name);
}
