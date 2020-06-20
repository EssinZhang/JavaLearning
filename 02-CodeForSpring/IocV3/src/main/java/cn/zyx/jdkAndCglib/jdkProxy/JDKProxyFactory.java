package cn.zyx.jdkAndCglib.jdkProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Description
 * @ClassName JDKProxyFactory
 * @Author ZhangYixin
 * @date 2020.06.18 21:29
 */
public class JDKProxyFactory implements InvocationHandler {

    //目标对象
    private Object target;

    //通过构造方法将目标对象注入到代理对象中
    public JDKProxyFactory(Object target) {
        this.target = target;
    }

    public JDKProxyFactory() {
    }

    public Object getProxy(){
        /**
         * 参数1：目标类的类加载器
         * 参数2：目标类的接口集合
         * 参数3：代理对象被调用时的处理器
         */
        Object proxyInstance = Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new MyInvocationHandler(target));

        return proxyInstance;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("before");
        method.invoke(target, args);
        return null;
    }

}
