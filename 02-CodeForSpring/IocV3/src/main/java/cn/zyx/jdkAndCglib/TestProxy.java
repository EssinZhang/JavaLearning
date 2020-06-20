package cn.zyx.jdkAndCglib;

import cn.zyx.jdkAndCglib.cglibProxy.CglibProxyFactory;
import cn.zyx.jdkAndCglib.jdkProxy.JDKProxyFactory;
import cn.zyx.jdkAndCglib.user.UserService;
import cn.zyx.jdkAndCglib.user.UserServiceImpl;
import net.sf.cglib.core.DebuggingClassWriter;
import org.junit.Test;
import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Description
 * @ClassName TestProxy
 * @Author ZhangYixin
 * @date 2020.06.18 22:34
 */
public class TestProxy {

    @Test
    public void testJDKProxy() {

        // 1、创建目标对象
        UserService service = new UserServiceImpl();
        // 2、生成代理对象
        JDKProxyFactory proxyFactory = new JDKProxyFactory(service);
        // 得到代理对象
        UserService proxy = (UserService) proxyFactory.getProxy();

        // 3、调用目标对象的方法
        service.saveUser();
        System.out.println("----------------------");
        // 4、调用代理对象的方法
        proxy.saveUser();
    }

    @Test
    public void testCgLibProxy() {

        // 创建目标对象
        UserService service = new UserServiceImpl();

        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "D://");
        // 生成代理对象
        CglibProxyFactory proxyFactory = new CglibProxyFactory();
        UserService proxy = (UserService) proxyFactory.getProxyByCglib(service.getClass());

        // 调用目标对象的方法
        service.saveUser();
        System.out.println("----------------------");
        // 调用代理对象的方法
        proxy.saveUser();
    }

}
