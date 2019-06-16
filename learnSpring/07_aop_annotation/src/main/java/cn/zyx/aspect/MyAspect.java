package cn.zyx.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 切面
 */
@Aspect
@Component
public class MyAspect {
    @Before("execution (* *..UserServiceImpl.addUser())")
    public void before(){
        System.out.println("*********前置通知*********");
    }

    @AfterReturning(value = "execution (* *..UserServiceImpl.updateUser())", returning = "result")
    public void afterReturning(int result){
        System.out.println("*********后置通知*********"+result);
    }


    @After("execution (* *..UserServiceImpl.selectUser())")
    public void after(){
        System.out.println("*********最终通知*********");
    }

    @AfterThrowing(value = "execution (* *..UserServiceImpl.selectUserById(..))",throwing = "e")
    public void afterThrowing(Exception e){
        System.out.println("*********异常通知*********"+e);
    }

    @Around("execution (* *..UserServiceImpl.deleteUser())")
    public Object around(ProceedingJoinPoint p)throws Throwable{
        System.out.println("*********环绕通知前*********");
        Object proceed = p.proceed();
        System.out.println("*********环绕通知后*********");

        return proceed;
    }
}
