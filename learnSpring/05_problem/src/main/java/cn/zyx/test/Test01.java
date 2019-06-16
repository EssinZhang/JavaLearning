package cn.zyx.test;

import cn.zyx.Dao.UserDao;
import cn.zyx.Dao.impl.UserDaoImpl;
import cn.zyx.proxy.MyInvocationHandler;
import org.junit.Test;

import java.lang.reflect.Proxy;

public class Test01 {

   @Test
   public void testTransaction(){
      //创建目标类的对象
      UserDaoImpl userDao = new UserDaoImpl();
      //创建代理
      UserDao userDaoProxy = (UserDao) Proxy.newProxyInstance(userDao.getClass().getClassLoader(), userDao.getClass().getInterfaces(), new MyInvocationHandler(userDao));

      userDaoProxy.addUser();

   }
}
