package cn.zyx.service.poxy;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import sun.java2d.pipe.SpanIterator;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("执行before");
        //这里要将bean返回
        return bean;

    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if ("studyService".equals(beanName)){
            //创建invocationHandler对象
            InvocationHandler invocationHandler = ((Object p, Method method, Object[] args) -> {
                //调用study方法是使用动态代理对其进行增强
                if ("study".equals(method.getName())){
                    System.out.println("*********目标方法开始**********");
                    //执行目标方法
                    Object result = method.invoke(bean,args);
                    System.out.println("*********目标方法结束**********");
                    return result;
                }
                return method.invoke(bean,args);
            });
            //增强bean
            Object proxy = Proxy.newProxyInstance(
                    bean.getClass().getClassLoader(),
                    bean.getClass().getInterfaces(),
                    invocationHandler
            );
            System.out.println("postProcessAfterInitialization执行");
            return proxy;
        }
        return bean;
    }
}
