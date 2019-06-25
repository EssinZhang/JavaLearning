package cn.zyx.util;

public class MyTransaction {
    /**
     * 事务处理
     */
    public static void doTransaction(Class<?> clazz){
        System.out.println("提交事务："+clazz.getName());
    }
}
