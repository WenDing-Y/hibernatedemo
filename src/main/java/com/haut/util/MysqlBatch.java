package com.haut.util;

import com.mysql.jdbc.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.Random;

/**
 * @author xxx_xx
 * @date 2017/12/21
 */
public class MysqlBatch implements Runnable {

    public static final int NUM = 100;

    public void run() {
        Connection connect = MysqlConnection.getConnection();
        Random random = new Random();
        try {
            connect.setAutoCommit(false);
            PreparedStatement Statement = connect.prepareStatement("INSERT INTO student(name,age) VALUES(?,?)");
            for (int j = 0; j < 10; j++) {
                for (int i = 0; i < NUM; i++) {
                    Statement.setString(1, RandomName.getRandomString(5));
                    Statement.setInt(2, random.nextInt(20));
                    Statement.addBatch();
                }
                Statement.executeBatch();
                connect.commit();
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }
}
