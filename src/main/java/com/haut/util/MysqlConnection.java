package com.haut.util;

import com.mysql.jdbc.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author xxx_xx
 * @date 2017/12/21
 */
public class MysqlConnection {

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception e) {
            System.out.print("加载驱动失败!");
            e.printStackTrace();
        }
        Connection connect;
        try {
            connect = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/hibernate", "root", "123456");

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return connect;
    }
}
