package cn.zyx.jdkAndCglib.cglibProxy;

import net.sf.cglib.proxy.Enhancer;

/**
 * @Description cglib工厂方法 使用CGLib动态代理技术实现 它是基于继承的方式实现的
 * @ClassName CglibProxyFactory
 * @Author ZhangYixin
 * @date 2020.06.18 23:05
 */
public class CglibProxyFactory {

    public Object getProxyByCglib(Class<?> clazz){
        //new一个增强类
        Enhancer enhancer = new Enhancer();
        //设置需要增强的类的对象
        enhancer.setSuperclass(clazz);
        //设置回调
        enhancer.setCallback(new MyMethodInterceptor());
        //获取增强后的代理对象
        Object object = enhancer.create();
        //将获取的增强后的代理对象返回
        return object;
    }
}
