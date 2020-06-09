package cn.zyx.test;


import org.junit.Test;

import java.sql.*;

/**
 * @Description
 * @ClassName JdbcDemo
 * @Author ZhangYixin
 * @date 2020.05.30 09:10
 */
public class JdbcDemo {

    @Test
    public void test(){
        testJDBC();
    }

    /**
     * sql执行方法
     */
    public void testJDBC(){
        String driverClassName = "com.mysql.jdbc.Driver";	//启动驱动
        String url = "jdbc:mysql://127.0.0.1:3306/learnmybatis?useSSL=false";	//设置连接路径
        String username = "root";	//数据库用户名
        String password = "123456";	//数据库连接密码
        Connection con = null;		//连接
        PreparedStatement pstmt = null;	//使用预编译语句
        ResultSet rs = null;	//获取的结果集
        try {
            //指定驱动
            Class.forName(driverClassName);
            //获取数据库连接
            con = DriverManager.getConnection(url,username,password);

            //预编译格式查询SQL
            String sql = "SELECT * FROM t_user WHERE name = ?";

            //创建statement对象来执行sql
            pstmt = con.prepareStatement(sql);

            //查询条件传入
            pstmt.setString(1,"kobe");

            //执行sql获取结果集
            rs = pstmt.executeQuery();

            while (rs.next()){
                System.out.println("id:"+rs.getString("id")+" name:"+rs.getString("name")+
                        " phone:"+rs.getString("phone")+" address:"+rs.getString("address")+
                        " birthday:"+rs.getString("birthday"));
            }

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
    }
}
