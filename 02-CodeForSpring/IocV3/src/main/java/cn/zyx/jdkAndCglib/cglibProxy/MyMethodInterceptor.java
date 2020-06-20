package cn.zyx.jdkAndCglib.cglibProxy;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Description cglib动态代理
 * @ClassName MyMethodInterceptor
 * @Author ZhangYixin
 * @date 2020.06.18 22:55
 */
public class MyMethodInterceptor implements MethodInterceptor {

    /**
     *
     * @param proxy  代理对象
     * @param method 目标对象方法
     * @param arg  参数
     * @param methodProxy  代理对象方法
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Object proxy, Method method, Object[] arg, MethodProxy methodProxy) throws Throwable {
        System.out.println("这是cglib的代理方法");

        //通过调用代理类的invokeSuper方法，去调用目标对象的方法
        Object returnValue = methodProxy.invokeSuper(proxy, arg);


        return returnValue;
    }
}
