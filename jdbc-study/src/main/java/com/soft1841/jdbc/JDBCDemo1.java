package com.soft1841.jdbc;

import java.sql.*;

/**
 * JDBC起步练习
 * @author admin
 */
public class JDBCDemo1 {
        //JDBC驱动名以及数据库链接URL
        static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
        static final String DB_URL = "jdbc:mysql://localhost:3306/db_jdbc";

        //数据库的用户名与密码
    static final String USER = "root";
    static final String PASS = "root";

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
       //加载JDBC驱动
       Class.forName(JDBC_DRIVER);
       //建立链接
        System.out.println("链接数据库");
        Connection conn = DriverManager.getConnection(DB_URL,USER,PASS);
        System.out.println("实例化Statement对象...");
        //实例化Statement对象
        Statement stmt = conn.createStatement();
        //向数据库发送SQL语句
        String sql = "SELECT * FROM t_student";
        //执行查询操作
        ResultSet rs = stmt.executeQuery(sql);
        //通过循环处理查询的结果集
        while (rs.next()){
            //通过字段取值
            int id = rs.getInt("id");
            String name = rs.getString("name");
            int age = rs.getInt("age");
            //输出数据
            System.out.print("ID:"+id);
            System.out.print(",姓名"+name);
            System.out.print(",年龄"+age);
            System.out.print("\n");
        }
        //关闭连接
        rs.close();
        stmt.close();
        conn.close();



    }
}
