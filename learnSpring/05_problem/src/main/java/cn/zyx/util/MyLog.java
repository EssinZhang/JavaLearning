package cn.zyx.util;

public class MyLog {
    /**
     * 记录日志
     */
    public static void doLog(Class<?> clazz){
        System.out.println("记录日志："+clazz.getName());
    }
}
