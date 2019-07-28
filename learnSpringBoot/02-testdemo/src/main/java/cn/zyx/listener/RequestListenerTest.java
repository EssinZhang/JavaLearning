package cn.zyx.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class RequestListenerTest implements ServletRequestListener {

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        System.out.println("**********listener Initialized***********");
    }

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        System.out.println("**********listener Destroyed***********");
    }
}
