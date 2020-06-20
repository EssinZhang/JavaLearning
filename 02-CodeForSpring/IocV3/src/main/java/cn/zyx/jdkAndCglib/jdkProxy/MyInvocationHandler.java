package cn.zyx.jdkAndCglib.jdkProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Description 代理对象方法调用处理器
 * @ClassName MyInvocationHandler
 * @Author ZhangYixin
 * @date 2020.06.18 21:34
 */
public class MyInvocationHandler implements InvocationHandler {

    // 目标对象
    private Object target;

    //通过构造方法将目标对象注入到代理对象中
    public MyInvocationHandler(Object target) {
        this.target = target;
    }

    public Object invoke(Object proxy, Method method,Object[] args) throws Throwable{
        Method targetMethod = target.getClass().getMethod("saveUser");

        System.out.println("目标方法:"+targetMethod.toString());
        System.out.println("目标接口:"+method.toString());

        System.out.println("这是JDK的代理方法");

        //利用反射调用目标对象的方法
        Object returnValue = method.invoke(target, args);

        return returnValue;

    }

}
