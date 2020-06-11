package cn.zyx.framework.utils;

import cn.zyx.framework.ioc.BeanDefinition;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @Description
 * @ClassName ReflectUtils
 * @Author ZhangYixin
 * @date 2020.06.11 18:23
 */
public class ReflectUtils {

    public static void setProperty(Object bean,String name,Object valueToUse,Class clazzType){
        //根据指定名称得到相应属性
        Field field = null;
        try {
            field = clazzType.getDeclaredField(name);
            field.setAccessible(true);
            field.set(bean,valueToUse);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static void invokeMethod(Object bean, Class clazzType ,String initMethod){
        Method method = null;
        try {
            method = clazzType.getDeclaredMethod(initMethod);
            method.invoke(bean,null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Object createInstance(Class clazzType){
        Object bean = null;
        try {
            bean = clazzType.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return bean;
    }

    public static Class<?> getTypeByFieldName(String clazzName, String name) {
        try {
            Class<?> clazz = Class.forName(clazzName);
            Field field = clazz.getDeclaredField(name);
            return field.getType();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
