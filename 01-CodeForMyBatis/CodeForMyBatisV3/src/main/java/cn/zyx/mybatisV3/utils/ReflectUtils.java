package cn.zyx.mybatisV3.utils;

/**
 * @Description
 * @ClassName ReflectUtils
 * @Author ZhangYixin
 * @date 2020.06.07 19:24
 */
public class ReflectUtils {

    public static Class<?> resolveType(String parameterType){
        try {
            Class<?> clazz = Class.forName(parameterType);
            return clazz;
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        return null;
    }

}
