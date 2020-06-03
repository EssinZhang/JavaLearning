package cn.zyx.test;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

/**
 * @Description
 * @ClassName MyBatisV1
 * @Author ZhangYixin
 * @date 2020.05.30 11:37
 */
public class MyBatisV1 {
    private Properties properties = new Properties();

    @Test
    public void test(){
        loadProperties("db.properties");
        //从配置文件中读取sql
        ArrayList<Object> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        ArrayList<Object> resultList = new ArrayList<>();
        //传入sql和查询信息的list
        resultList = testJDBC("db.findByIdAndName",list);
        System.out.println(resultList);
    }

    /**
     * sql执行方法
     */
    public ArrayList<Object> testJDBC(String sqlID, ArrayList list){
        Connection con = null;		//连接
        PreparedStatement pstmt = null;	//使用预编译语句
        ResultSet rs = null;	//获取的结果集

        //返回的集合
        ArrayList<Object> results = new ArrayList<>();
        try {
            loadProperties("db.properties");
            //指定驱动
            Class.forName(properties.getProperty("db.driver"));
            //获取数据库连接
            con = DriverManager.getConnection(properties.getProperty("db.url"),properties.getProperty("db.username"),properties.getProperty("db.password"));

            //创建statement对象
            pstmt = con.prepareStatement(properties.getProperty(sqlID));

            //查询条件传入
            for (int i = 1; i <= list.size(); i++) {
                pstmt.setString(i,list.get(i-1).toString());
            }
            //执行sql获取结果集
            rs = pstmt.executeQuery();

            // 获取要映射的结果类型
            String resultclassname = properties.getProperty(sqlID + ".resultClassName");
            // 加载指定类并初始化
            Class<?> resultTypeClass = Class.forName(resultclassname);

            Object result = null;
            while (rs.next()){
                //根据指定类创建对应的对象
                result = resultTypeClass.newInstance();

                ResultSetMetaData metaData = rs.getMetaData();
                //得到结果列数
                int columnCount = metaData.getColumnCount();

                for (int i = 1; i <= columnCount; i++) {
                    //拿到对应列数的列名
                    String columnName = metaData.getColumnName(i);
                    Field field = resultTypeClass.getDeclaredField(columnName);
                    //设置字段的值可以访问
                    field.setAccessible(true);
                    //根据列名设置对应的值
                    field.set(result, rs.getObject(columnName));

                }
                results.add(result);
            }
            return results;

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            // 释放资源
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            } if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            } if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                }
            }
        }
        return null;
    }

    /**
     * 加载properties配置文件
     */
    public void loadProperties(String fileName) {
        try {
            InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(fileName);
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
