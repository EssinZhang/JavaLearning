package cn.zyx.test;

import cn.zyx.po.User;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
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
    private String driver = this.properties.getProperty("db.driver");

    @Test
    public void test(){
        ArrayList<Object> list = new ArrayList<>();
        list.add("1");
        list.add("kobe");
        ArrayList<User> userList = new ArrayList<>();
        userList = testJDBC("db.findSql1",list);
        for (int i = 0; i < userList.size(); i++) {
            System.out.println(userList.get(i).toString());
        }
    }

    /**
     * sql执行方法
     */
    public ArrayList<User> testJDBC(String sqlID, ArrayList list){
        Connection con = null;		//连接
        PreparedStatement pstmt = null;	//使用预编译语句
        ResultSet rs = null;	//获取的结果集
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

            ArrayList<User> userList = new ArrayList<>();
            int index = 0;

            while (rs.next()){
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setPhone(rs.getString("phone"));
                user.setBirthday(rs.getDate("birthday"));
                user.setAddress(rs.getString("address"));
                userList.add(user);
                index++;
            }
            return userList;

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
