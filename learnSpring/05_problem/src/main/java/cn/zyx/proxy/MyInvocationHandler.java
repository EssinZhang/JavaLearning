package cn.zyx.proxy;

import cn.zyx.util.MyLog;
import cn.zyx.util.MyTransaction;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 动态代理
 */
public class MyInvocationHandler implements InvocationHandler {
    private Object target;

    /**
     * 通过构造方法将要增强的类的对象传入
     * @param target
     */
    public MyInvocationHandler(Object target) {
        this.target = target;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //记录日志
        MyLog.doLog(target.getClass());

        //业务处理
        Object invoke = method.invoke(target, args);

        //处理事务
        MyTransaction.doTransaction(target.getClass());

        return invoke;
    }
}
